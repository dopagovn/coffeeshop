package com.luckygroup.webapi.services.impl;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

import com.luckygroup.webapi.models.TransactionHistory;
import com.luckygroup.webapi.repository.TransactionHistoryRepository;
import com.luckygroup.webapi.services.TransactionHistoryService;

public class TransactionHistoryServiceImpl implements TransactionHistoryService {

    @Autowired
    TransactionHistoryRepository transactionHistoryRepository;
    ModelMapper modelMapper;

    @Override
    public TransactionHistory findTransactionHistoryById(Long id) throws ResourceAccessException {
        try {
            TransactionHistory transactionHistory = transactionHistoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found Transaction History"));
            return modelMapper.map(transactionHistory, TransactionHistory.class);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Not Found Transaction History", e);
        }
    }
    
}
