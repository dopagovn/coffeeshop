package com.luckygroup.webapi.models;

public class PlaceOrderRequest {
    private Long accountId;
    private Long orderAmount;

    public PlaceOrderRequest() {
        // Default constructor
    }

    public PlaceOrderRequest(Long accountId, Long orderAmount) {
        this.accountId = accountId;
        this.orderAmount = orderAmount;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }
}
