package com.luckygroup.webapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.luckygroup.webapi.services.PaymentService;

import jakarta.transaction.Transactional;
import com.luckygroup.webapi.models.Payment;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/{orderId}")
    public ResponseEntity<Payment> getPaymentsByOrderId(@PathVariable int orderId) {
        Optional<Payment> payments = paymentService.findPaymentsByOrderId(orderId);
        return ResponseEntity.of(payments);
    }

    // @GetMapping("/payment/{paymentDate}")
    // public ResponseEntity<List<Payment>> getPaymentsByPaymentDate(@PathVariable Date paymentDate) {
    //     List<Payment> payments = paymentService.findPaymentsByPaymentDate(paymentDate);
    //     return ResponseEntity.ok(payments);
    // }

    // @GetMapping("/date-range/{startDate}/{endDate}")
    // public ResponseEntity<List<Payment>> getPaymentsByPaymentDateRange(
    //         @PathVariable Date startDate,
    //         @PathVariable Date endDate) {
    //     List<Payment> payments = paymentService.findPaymentsByPaymentDateRange(startDate, endDate);
    //     return ResponseEntity.ok(payments);
    // }

    @PostMapping("/payment")
    public ResponseEntity<String> savePayment(@RequestBody Payment payment) {
        paymentService.savePayment(payment);
        return ResponseEntity.ok("Payment successfully made for payment with ID: " + payment);
    }
}
