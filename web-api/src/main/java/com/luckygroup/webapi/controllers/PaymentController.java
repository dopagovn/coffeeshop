package com.luckygroup.webapi.controllers;

import com.luckygroup.webapi.models.Payment;
import com.luckygroup.webapi.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/api/v1/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<?> getAllPayments() {
        Optional<List<Payment>> payments = paymentService.getAllPayments();
        if (payments.isPresent()) {
            return ResponseEntity.ok(payments.get());
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Payments not found");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPaymentById(@PathVariable Integer id) {
        Optional<Payment> payment = paymentService.findById(id);

        if (payment.isPresent()) {
            return ResponseEntity.ok(payment.get());
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Payment not found");
        }
    }

    @PostMapping
    public ResponseEntity<String> savePayment(@RequestBody Payment payment) {
        paymentService.savePayment(payment);
        return ResponseEntity.ok("Payment saved successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Integer id) {
        paymentService.deletePayment(id);
        return ResponseEntity.ok("Payment deleted successfully");
    }

    // Bổ sung các phương thức khác tại đây

    @GetMapping("/by-orderId")
    public ResponseEntity<?> getPaymentByOrderId(@RequestParam Integer orderId) {
        Optional<Payment> payment = paymentService.getPaymentByOrderId(orderId);
        if (payment.isPresent()) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Payment not found for the given order ID");
        }
    }
}
