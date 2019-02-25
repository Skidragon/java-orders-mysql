package com.lambdaschool.ordersmysql.controllers;

import com.lambdaschool.ordersmysql.models.Order;
import com.lambdaschool.ordersmysql.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/orders", produces= MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @Autowired
    OrderRepository orderRepo;

    @GetMapping("")
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @GetMapping("ordernum/{ordernum}")
    public Order getOrderByOrderNumber(@PathVariable long ordernum) {
        return orderRepo.findOrderByOrderNumber(ordernum);
    }

    @PostMapping("")
    public Order newOrder(@RequestBody Order newOrder) throws URISyntaxException {
        return orderRepo.save(newOrder);
    }
    @PutMapping("ordernum/{ordernum}")
    public Order updateOrder(@RequestBody Order updatedOrder, @PathVariable long ordernum) throws URISyntaxException {
        Optional<Order> foundOrder = orderRepo.findById(ordernum);
        if(foundOrder.isPresent()) {
            updatedOrder.setOrdernum(ordernum);
            orderRepo.save(updatedOrder);
            return updatedOrder;
        }
        return null;
    }
    @DeleteMapping("ordernum/{ordernum}")
    public Order deleteOrder(@PathVariable long ordernum) {
        Order foundOrder = orderRepo.findOrderByOrderNumber(ordernum);
        if(foundOrder != null) {
            orderRepo.deleteById(ordernum);
            return foundOrder;
        }
        return null;
    }
}
