package com.luckygroup.webapi.controllers;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luckygroup.webapi.common.ResponseHandler;
import com.luckygroup.webapi.models.Accounts;
import com.luckygroup.webapi.models.Order;
import com.luckygroup.webapi.models.PlaceOrderRequest;
import com.luckygroup.webapi.services.OrderService;

import jakarta.transaction.Transactional;

@Controller
@Transactional
@RequestMapping(path = "/api/v1")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "/order/{id}")
    public ResponseEntity<Object> getOrderById(@PathVariable Long id) {
        try {
            Order order = orderService.findOrderById(id);
            return ResponseHandler.generateResponse(HttpStatus.OK, "Successful", order);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "Failed", null);
        }
    }

    @PostMapping("/order/create")
    public ResponseEntity<Object> createOrder(@RequestBody Order order) {
        try {
            Order orderData = orderService.createOrder(order);
            return ResponseHandler.generateResponse(HttpStatus.OK, "Khởi tạo order thành công!", orderData);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Không thể tạo order", null);
        }
    }

    @PostMapping("/order/place")
    public ResponseEntity<Object> placeOrder(@RequestBody PlaceOrderRequest placeOrderRequest) {
        try {
            orderService.placeOrder(placeOrderRequest.getAccountId(), placeOrderRequest.getOrderAmount());
            return ResponseHandler.generateResponse(HttpStatus.OK, "Đặt hàng thành công!", null);
        } catch (IllegalArgumentException e) {
            return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, e.getMessage(), null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Không thể đặt hàng", null);
        }
    }

    @PutMapping("/order/update")
    public ResponseEntity<Object> updateOrder(@RequestBody Order order) {
        try {
            orderService.updateOrder(order);
            return ResponseHandler.generateResponse(HttpStatus.OK, "Cập nhật order thành công!", null);
        } catch (ResourceNotFoundException e) {
            return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, e.getMessage(), null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Không thể cập nhật order", null);
        }
    }

    @DeleteMapping("/order/delete/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable Long id) {
        try {
            orderService.deleteOrder(id);
            return ResponseHandler.generateResponse(HttpStatus.OK, "Xóa order thành công!", null);
        } catch (ResourceNotFoundException e) {
            return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, e.getMessage(), null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Không thể xóa order", null);
        }
    }
}
