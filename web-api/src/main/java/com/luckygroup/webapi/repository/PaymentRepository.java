package com.luckygroup.webapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.luckygroup.webapi.models.Payment;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByOrderId(int orderId);

    List<Payment> findByPaymentDate(Date paymentDate);

    @Query("SELECT p FROM Payment p WHERE p.paymentDate >= :startDate AND p.paymentDate <= :endDate")
    List<Payment> findByPaymentDateRange(Date startDate, Date endDate);

    @Modifying
    @Query("UPDATE Payment p SET p.paymentStatus = 'PAID' WHERE p.id = :paymentId")
    void makePaymentById(int paymentId);

}

