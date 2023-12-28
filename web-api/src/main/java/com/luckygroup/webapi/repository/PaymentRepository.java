package com.luckygroup.webapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luckygroup.webapi.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
