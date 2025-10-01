package com.example.session12.controller;

import com.example.session12.model.dto.request.OrderDTO;
import com.example.session12.model.dto.response.DataResponse;
import com.example.session12.model.entity.Order;
import com.example.session12.security.AccountPrincipal;
import com.example.session12.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<DataResponse<Page<Order>>> findAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size
    ){
        return orderService.findAll(PageRequest.of(page, size));
    }

    @PostMapping("/create")
    public ResponseEntity<DataResponse<?>> createOrder(@RequestBody OrderDTO orderDTO,
                                                       @AuthenticationPrincipal AccountPrincipal accountPrincipal){
        return orderService.createOrder(orderDTO,accountPrincipal.getAccount());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponse<?>> getOrderById(@PathVariable long id){
        return orderService.findOrderById(id);
    }
}
