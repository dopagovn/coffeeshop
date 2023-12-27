package com.luckygroup.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luckygroup.webapi.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    Order findByAccountId(Long accountId);
}
