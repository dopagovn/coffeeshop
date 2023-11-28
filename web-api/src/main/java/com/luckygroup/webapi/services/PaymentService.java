package com.luckygroup.webapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.luckygroup.webapi.repository.PaymentRepository;

import jakarta.transaction.Transactional;

import com.luckygroup.webapi.models.Payment;

@Service
@Transactional
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Optional<Payment> findPaymentsByOrderId(int orderId) {
        return paymentRepository.findByOrderId(orderId);
    }

    public List<Payment> findPaymentsByPaymentDate(Date paymentDate) {
        return paymentRepository.findByPaymentDate(paymentDate);
    }

    public List<Payment> findByPaymentDateBetween(Date startDate, Date endDate) {
        return paymentRepository.findByPaymentDateBetween(startDate, endDate);
    }

    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

}
