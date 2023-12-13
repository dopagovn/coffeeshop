package com.luckygroup.webapi.controllers;

import com.luckygroup.webapi.common.ResponseHandler;
import com.luckygroup.webapi.models.Accounts;
import com.luckygroup.webapi.models.OrderDetail;
import com.luckygroup.webapi.services.AccountsService;
import com.luckygroup.webapi.services.OrderDetailService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/v1")
public class OrderDetailController {

  @Autowired
  private OrderDetailService orderDetailService;

  @Autowired
  public OrderDetailController(OrderDetailService orderDetailService) {
    this.orderDetailService = orderDetailService;
  }

  @GetMapping(path = "/order-details")
  public ResponseEntity<Object> getAllOrderDetails() {
    List<OrderDetail> orderDetails = orderDetailService.getAllOrder();
    if (orderDetails.isEmpty()) {
      return ResponseHandler.generateResponse(
        HttpStatus.NOT_FOUND,
        "Không có dữ liệu nào!",
        null
      );
    } else {
      return ResponseHandler.generateResponse(
        HttpStatus.OK,
        "Thành công",
        orderDetails
      );
    }
  }

  @GetMapping(path = "/order-detail/{id}")
  public ResponseEntity<Object> getOrderDetailById(@PathVariable Long id) {
    try {
      OrderDetail orderDetail = orderDetailService.getOrderDetailById(id);
      if (orderDetail == null) {
        return ResponseHandler.generateResponse(
          HttpStatus.NOT_FOUND,
          "Don't have any order",
          null
        );
      }
      return ResponseHandler.generateResponse(
        HttpStatus.OK,
        "Successful",
        orderDetail
      );
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
        HttpStatus.NOT_FOUND,
        "Failed",
        null
      );
    }
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
