package com.luckygroup.webapi.controllers;

import com.luckygroup.webapi.common.ResponseHandler;
import com.luckygroup.webapi.models.Accounts;
import com.luckygroup.webapi.models.OrderDetail;
import com.luckygroup.webapi.services.OrderDetailService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/v1")
public class OrderDetailController {

    private OrderDetailService orderDetailService;

    @Autowired
    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }
  }

    @GetMapping(path = "/order-detail/{id}")
    public ResponseEntity<Object> getOrderDetailById(@PathVariable int id) {
        try {
            OrderDetail orderDetail = orderDetailService.findById(id);
            return ResponseHandler.generateResponse(
                    HttpStatus.OK,
                    "Successful",
                    orderDetail
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Failed",
                    null
            );
        }
    }

    @GetMapping(path = "/order-details")
    public ResponseEntity<Object> getAllOrderDetails() {
        try {
            List<OrderDetail> orderDetails = orderDetailService.getAllOrderDetails();
            return ResponseHandler.generateResponse(
                    HttpStatus.OK,
                    "Successful",
                    orderDetails
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Failed",
                    null
            );
        }
    }
  }
  // @PostMapping(path = "/order-detail")
  // public ResponseEntity<String> saveOrderDetail(@RequestBody OrderDetail orderDetail) {
  //     orderDetailService.saveOrderDetail(orderDetail);
  //     return ResponseEntity.ok("Order detail saved successfully");
  // }

    @PostMapping("/order-detail")
    public ResponseEntity<Object> saveOrderDetail(@RequestBody OrderDetail orderDetail) {
        try {
            OrderDetail savedOrderDetail = orderDetailService.saveOrderDetail(orderDetail);
            return ResponseHandler.generateResponse(
                    HttpStatus.OK,
                    "Order detail saved successfully",
                    savedOrderDetail
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Cannot save order detail",
                    null
            );
        }
    }

    @DeleteMapping("/order-detail/{id}")
    public ResponseEntity<Object> deleteOrderDetail(@PathVariable int id) {
        try {
            orderDetailService.deleteOrderDetail(id);
            return ResponseHandler.generateResponse(
                    HttpStatus.OK,
                    "Order detail deleted successfully",
                    null
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Cannot delete order detail",
                    null
            );
        }
    }

    // Add other methods as needed

    // Example:
    @GetMapping(path = "/order-details-by-order/{orderId}")
    public ResponseEntity<Object> getOrderDetailsByOrderId(@PathVariable int orderId) {
        try {
            List<OrderDetail> orderDetails = orderDetailService.findOrderDetailsByOrderId(orderId);
            return ResponseHandler.generateResponse(
                    HttpStatus.OK,
                    "Successful",
                    orderDetails
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Failed",
                    null
            );
        }
    }
}
