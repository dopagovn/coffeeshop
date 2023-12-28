package com.luckygroup.webapi.controllers;

import jakarta.transaction.Transactional;

import java.util.List;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.luckygroup.webapi.common.ResponseHandler;
import com.luckygroup.webapi.models.Accounts;
import com.luckygroup.webapi.models.Order;
import com.luckygroup.webapi.models.OrderRequest;
import com.luckygroup.webapi.models.PlaceOrderRequest;
import com.luckygroup.webapi.repository.OrderRepository;
import com.luckygroup.webapi.services.OrderService;

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
            return ResponseHandler.generateResponse(HttpStatus.OK, "Hoàn Thành", order);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "Failed", null);
        }
    }

    @GetMapping(path = "/orders")
    public ResponseEntity<Object> getAllOrders() {
        try {
            List<Order> orders = orderService.getAllOrders();
            if(!orders.isEmpty()){
                return ResponseHandler.generateResponse(HttpStatus.OK, "Danh sách đơn hàng", orders);
            }
            else{
                return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "Không tìm thấy danh sách đơn hàng", null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Không thể lấy danh sách đơn hàng", null);
        }
    }


    @PostMapping("/order/create")
    public ResponseEntity<Object> createOrder(@RequestBody Order order) {
        try {
            Order orderData = orderService.createOrder(order);
            return ResponseHandler.generateResponse(HttpStatus.OK, "Tạo đơn hàng thành công!", orderData);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Không thể tạo đơn hàng", null);
        }
    }

    @PutMapping("/order/update/{id}")
    public ResponseEntity<Object> updateOrder(@RequestBody OrderRequest orderRequest, @PathVariable Long id) {

            try {
                    Order order = orderService.findOrderById(id);
                    orderService.updateOrder(orderRequest, id);
                    return ResponseHandler.generateResponse(HttpStatus.OK, "Cập nhật order thành công",order );     
            
            } catch (Exception e) {
                return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Không thể cập nhật order", null);
            }
        
    }

    @DeleteMapping("/order/delete/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable Long id) {
        try {
            orderService.deleteOrder(id);
            return ResponseHandler.generateResponse(HttpStatus.OK, "Đã hủy đơn hàng thành công!", null);
        } catch (ResourceNotFoundException e) {
            return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, e.getMessage(), null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Không thể xóa order", null);
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

}
