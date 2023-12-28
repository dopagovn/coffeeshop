package com.luckygroup.webapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luckygroup.webapi.common.ResponseHandler;
import com.luckygroup.webapi.models.Accounts;
import com.luckygroup.webapi.models.Payment;
import com.luckygroup.webapi.services.PaymentService;

import jakarta.transaction.Transactional;

@Controller
@Transactional
@RequestMapping(path = "/api/v1")
public class PaymentController {
    @Autowired
    PaymentService paymentService;


  @GetMapping(path = "/payment/{id}")
  public ResponseEntity<Object> getPaymentById(@PathVariable Long id) {
    try {
      Payment payment = paymentService.getPaymentById(id);
      return ResponseHandler.generateResponse(
        HttpStatus.OK,
        "Successful",
        payment
      );
    } catch (Exception e) {
      return ResponseHandler.generateResponse(
        HttpStatus.NOT_FOUND,
        "Failed",
        null
      );
    }
  }


}
