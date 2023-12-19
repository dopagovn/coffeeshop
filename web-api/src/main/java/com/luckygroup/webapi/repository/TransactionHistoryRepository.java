package com.luckygroup.webapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luckygroup.webapi.models.TransactionHistory;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {
    // Additional query methods can be added if needed
}

