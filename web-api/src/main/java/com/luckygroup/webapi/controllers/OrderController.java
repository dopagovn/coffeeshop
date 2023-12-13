package com.luckygroup.webapi.controllers;

import com.luckygroup.webapi.models.Order;
import com.luckygroup.webapi.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer orderId) {
        Optional<Order> order = orderService.findByOrderId(orderId);
        return order.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        Optional<List<Order>> orders = orderService.getAllOrders();
        return orders.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
        return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<String> updateOrder(@PathVariable Integer orderId, @RequestBody Order order) {
        Optional<Order> existingOrder = orderService.findByOrderId(orderId);
        if (existingOrder.isPresent()) {
            orderService.saveOrder(order);
            return new ResponseEntity<>("Order updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Integer orderId) {
        Optional<Order> existingOrder = orderService.findByOrderId(orderId);
        if (existingOrder.isPresent()) {
            orderService.deleteOrder(orderId);
            return new ResponseEntity<>("Order deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{orderId}/place")
    public ResponseEntity<String> placeOrder(@PathVariable Integer orderId) {
        Optional<Order> existingOrder = orderService.findByOrderId(orderId);
        if (existingOrder.isPresent()) {
            orderService.placeOrder(existingOrder.get());
            return new ResponseEntity<>("Order placed successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{orderId}/complete")
    public ResponseEntity<String> completeOrder(@PathVariable Integer orderId) {
        orderService.completeOrder(orderId);
        return new ResponseEntity<>("Order completed successfully", HttpStatus.OK);
    }
}
