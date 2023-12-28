package com.luckygroup.webapi.services.impl;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luckygroup.webapi.models.Payment;
import com.luckygroup.webapi.repository.PaymentRepository;
import com.luckygroup.webapi.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    ModelMapper modelMapper;

    @Override
    public Payment getPaymentById(Long id) {
        try {
            Payment payment = paymentRepository
                    .findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Not Found Payment"));
            return modelMapper.map(payment, Payment.class);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Not found account", e);
        }
    }

}
