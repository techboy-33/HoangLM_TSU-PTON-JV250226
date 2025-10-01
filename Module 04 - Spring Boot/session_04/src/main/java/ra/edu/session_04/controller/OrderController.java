package ra.edu.session_04.controller;

import ra.edu.session_04.model.dto.OrderDTO;
import ra.edu.session_04.model.entity.Order;
import ra.edu.session_04.model.entity.OrderDetail;
import ra.edu.session_04.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getOrders(){
        return orderService.findAll();
    }

    @PostMapping("/add")
    public String addOrder(@RequestBody OrderDTO orderDTO){
        return orderService.save(orderDTO);
    }

    @PutMapping("/changeStatus/{id}")
    public String changeStatus(@PathVariable int id){
        return orderService.changeStatus(id);
    }

    @PatchMapping("/cancel/{id}")
    public String cancel(@PathVariable int id){
        return orderService.cancelOrder(id);
    }
}
