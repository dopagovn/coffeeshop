package com.luckygroup.webapi.services;

import com.luckygroup.webapi.models.Payment;

public interface PaymentService {
    Payment getPaymentById(Long id);
}
