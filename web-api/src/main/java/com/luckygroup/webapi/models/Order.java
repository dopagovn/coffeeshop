package com.luckygroup.webapi.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "customer_information")
    private String customerInformation;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "total_order_amount")
    private double totalOrderAmount;

    @Column(name = "order_status")
    private String orderStatus;

    // Constructors
    public Order() {

    }

    public Order(String customerInformation, Date orderDate, double totalOrderAmount, String orderStatus) {
        this.customerInformation = customerInformation;
        this.orderDate = orderDate;
        this.totalOrderAmount = totalOrderAmount;
        this.orderStatus = orderStatus;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerInformation() {
        return customerInformation;
    }

    public void setCustomerInformation(String customerInformation) {
        this.customerInformation = customerInformation;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalOrderAmount() {
        return totalOrderAmount;
    }

    public void setTotalOrderAmount(double totalOrderAmount) {
        this.totalOrderAmount = totalOrderAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
