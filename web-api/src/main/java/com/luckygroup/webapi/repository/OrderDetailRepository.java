package com.luckygroup.webapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luckygroup.webapi.models.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    Optional<OrderDetail> findById(int id);
    Optional<OrderDetail> findByOrderId(Integer orderId);
    Optional<OrderDetail> deleteById(int id);
}

