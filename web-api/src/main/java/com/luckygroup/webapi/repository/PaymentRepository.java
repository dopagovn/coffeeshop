package com.luckygroup.webapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luckygroup.webapi.models.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findById(int id);
    Optional<Payment> findByOrderId(int orderId);
    Optional<Payment> deleteById(int id);
}
