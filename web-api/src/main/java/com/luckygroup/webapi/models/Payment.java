package com.luckygroup.webapi.models;

import java.util.*;
import jakarta.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int orderId;

    private String paymentMethod;

    private double totalPaymentAmount;

    private Date paymentDate;

    private String paymentStatus;

    // Constructors
    public Payment() {
        // Default constructor
    }

    public Payment(int orderId, String paymentMethod, double totalPaymentAmount, Date paymentDate) {
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.totalPaymentAmount = totalPaymentAmount;
        this.paymentDate = paymentDate;
    }

    // Getters and setters
    public int getid() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(double totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
