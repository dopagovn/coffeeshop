package com.luckygroup.webapi.services;

import com.luckygroup.webapi.models.TransactionHistory;

public interface TransactionHistoryService {
    TransactionHistory findTransactionHistoryById(Long id);
}
