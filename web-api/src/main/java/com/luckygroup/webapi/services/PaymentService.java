package com.luckygroup.webapi.services;

import com.luckygroup.webapi.models.Payment;
import com.luckygroup.webapi.repository.PaymentRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Optional<Payment> findById(Integer id) {
        return paymentRepository.findById(id);
    }

    public Optional<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return Optional.ofNullable(payments);
    }

    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public void deletePayment(Integer id) {
        paymentRepository.deleteById(id);
    }

    // Bổ sung thêm các phương thức cần thiết tại đây

    public Optional<Payment> getPaymentByOrderId(Integer orderId) {
        return paymentRepository.findByOrderId(orderId);
    }
}
