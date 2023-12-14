package com.luckygroup.webapi.controllers;

import com.luckygroup.webapi.common.ResponseHandler;
import com.luckygroup.webapi.models.OrderDetail;
import com.luckygroup.webapi.services.AccountsService;
import com.luckygroup.webapi.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/api/v1")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;


      @Autowired
    public OrderDetailController(OrderDetailService orderDetailService) {
            this.orderDetailService = orderDetailService;
    }

    // @GetMapping(path = "/order-details")
    // public ResponseEntity<?> getAllOrderDetails() {
    //     Optional<List<OrderDetail>> orderDetails = orderDetailService.getAllOrderDetails();
    //     if (orderDetails.isPresent()) {
    //         return ResponseEntity.ok(orderDetails.get());
    //     } else {
    //         return ResponseEntity
    //                 .status(HttpStatus.NOT_FOUND)
    //                 .body("Order details not found");
    //     }
    // }

    @GetMapping(path = "/order-detail")
    public ResponseEntity<Object> getOrderDetailById(@RequestParam Integer id) {
        OrderDetail orderDetail = orderDetailService.findById(id);

        if (orderDetail != null) {
            return ResponseHandler.generateResponse(HttpStatus.OK, "Successful", orderDetail);
        }
         return ResponseHandler.generateResponse(HttpStatus.NOT_FOUND, "Not found", orderDetail);
    }

    // @PostMapping(path = "/order-detail")
    // public ResponseEntity<String> saveOrderDetail(@RequestBody OrderDetail orderDetail) {
    //     orderDetailService.saveOrderDetail(orderDetail);
    //     return ResponseEntity.ok("Order detail saved successfully");
    // }

    // @DeleteMapping(path = "/order-detail")
    // public ResponseEntity<String> deleteOrderDetail(@RequestParam Integer id) {
    //     orderDetailService.deleteOrderDetail(id);
    //     return ResponseEntity.ok("Order detail deleted successfully");
    // }

    // // Bổ sung các phương thức khác tại đây

    // // Ví dụ:
    // @GetMapping(path = "/order-detail-by-orderId")
    // public ResponseEntity<?> getOrderDetailsByOrderId(@RequestParam Integer orderId) {
    //     Optional<OrderDetail> orderDetails = orderDetailService.getOrderDetailsByOrderId(orderId);
    //     if (!orderDetails.isEmpty()) {
    //         return ResponseEntity.ok(orderDetails);
    //     } else {
    //         return ResponseEntity
    //                 .status(HttpStatus.NOT_FOUND)
    //                 .body("Order details not found for the given order ID");
    //     }
    // }
}
