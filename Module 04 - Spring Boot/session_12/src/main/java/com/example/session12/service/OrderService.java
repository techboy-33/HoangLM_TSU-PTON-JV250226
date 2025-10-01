package com.example.session12.service;

import com.example.session12.model.dto.request.OrderDTO;
import com.example.session12.model.dto.response.DataResponse;
import com.example.session12.model.dto.response.OrderResponse;
import com.example.session12.model.entity.*;
import com.example.session12.repository.OrderFoodDetailRepository;
import com.example.session12.repository.OrderRepository;
import com.example.session12.repository.OrderTicketDetailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderTicketDetailRepository orderTicketDetailRepository;
    @Autowired
    private OrderFoodDetailRepository orderFoodDetailRepository;
    private final Logger log = LoggerFactory.getLogger(OrderService.class);

    public ResponseEntity<DataResponse<Page<Order>>> findAll(Pageable pageable){
        DataResponse<Page<Order>> dataResponse = DataResponse
                .<Page<Order>>builder()
                .message("Get all orders successful")
                .data(orderRepository.findAll(pageable))
                .status(200)
                .build();
        return ResponseEntity.status(200).body(dataResponse);
    }

    public ResponseEntity<DataResponse<?>> createOrder(OrderDTO orderDTO, Account account){
        double totalPriceFood = 0;
        double totalPriceTicket = 0;
        for (Map.Entry<Long, Integer> entry : orderDTO.getFoodIds().entrySet()) {
            Food food = foodService.findById(entry.getKey());
            totalPriceFood += food.getPrice() * entry.getValue();
        }
        for (Map.Entry<Long, Integer> entry : orderDTO.getTicketIds().entrySet()) {
            Ticket ticket = ticketService.findById(entry.getKey());
            totalPriceTicket += ticket.getPrice() * entry.getValue();
        }
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setSalesAgent(account);
        order.setTotalAmount(totalPriceFood + totalPriceTicket);
        try {
            Order newOrder = orderRepository.save(order);
            for (Map.Entry<Long, Integer> entry : orderDTO.getFoodIds().entrySet()) {
                Food food = foodService.findById(entry.getKey());
                OrderFoodDetail orderFoodDetail = new OrderFoodDetail();
                orderFoodDetail.setOrder(newOrder);
                orderFoodDetail.setFood(food);
                orderFoodDetail.setQuantity(entry.getValue());
                orderFoodDetail.setPriceBuy(food.getPrice());
                orderFoodDetailRepository.save(orderFoodDetail);
            }

            for (Map.Entry<Long, Integer> entry : orderDTO.getTicketIds().entrySet()) {
                Ticket ticket = ticketService.findById(entry.getKey());
                OrderTicketDetail orderTicketDetail = new OrderTicketDetail();
                orderTicketDetail.setOrder(newOrder);
                orderTicketDetail.setTicket(ticket);
                orderTicketDetail.setQuantity(entry.getValue());
                orderTicketDetail.setPriceBuy(ticket.getPrice());
                orderTicketDetailRepository.save(orderTicketDetail);
            }
            DataResponse<Order> dataResponse = DataResponse
                    .<Order>builder()
                    .message("Create order successful")
                    .data(newOrder)
                    .status(201)
                    .build();
            return ResponseEntity.status(201).body(dataResponse);
        } catch (Exception e) {
            log.error(e.getMessage());
            DataResponse<?> dataResponse = DataResponse
                    .builder()
                    .message("Create order failed: " + e.getMessage())
                    .status(400)
                    .build();
            return ResponseEntity.status(400).body(dataResponse);
        }
    }

    public Order findById(Long id){
        return orderRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Order not found"));
    }

    public ResponseEntity<DataResponse<?>> findOrderById(Long orderId){
        Order order = findById(orderId);
        if (order != null){
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setId(order.getId());
            orderResponse.setSalesAgent(order.getSalesAgent().getFullName());
            orderResponse.setTotalAmount(order.getTotalAmount());
            orderResponse.setOrderDate(order.getOrderDate());
            List<OrderFoodDetail> orderFoodDetails = orderFoodDetailRepository.findByOrderId(orderId);
            List<OrderTicketDetail> orderTicketDetails = orderTicketDetailRepository.findByOrderId(orderId);
            Map<String, Integer> foods = orderFoodDetails.stream().collect(Collectors.toMap(ofd -> ofd.getFood().getFoodName(), OrderFoodDetail::getQuantity));
            Map<String, Integer> tickets = orderTicketDetails.stream().collect(Collectors.toMap(otd -> otd.getTicket().getTicketName(), OrderTicketDetail::getQuantity));
            orderResponse.setFoods(foods);
            orderResponse.setTickets(tickets);
            DataResponse<DataResponse<OrderResponse>> dataResponse = DataResponse
                    .<DataResponse<OrderResponse>>builder()
                    .message("Get order by id successful")
                    .data(DataResponse.<OrderResponse>builder()
                            .data(orderResponse)
                            .message("Success")
                            .status(200)
                            .build())
                    .status(200)
                    .build();
            return ResponseEntity.status(200).body(dataResponse);
        }else {
            DataResponse<DataResponse<OrderResponse>> dataResponse = DataResponse
                    .<DataResponse<OrderResponse>>builder()
                    .message("Order not found with id: " + orderId)
                    .status(404)
                    .build();
            return ResponseEntity.status(404).body(dataResponse);
        }
    }
}
