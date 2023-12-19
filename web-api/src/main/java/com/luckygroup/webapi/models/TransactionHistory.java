package com.luckygroup.webapi.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;

@Entity
public class TransactionHistory {

    /**
     *
     */
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public TransactionHistory(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    private String transactionType;
    private String description;
    private Date transactionDate;

    // getters and setters
}

