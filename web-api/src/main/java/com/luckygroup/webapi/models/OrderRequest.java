package com.luckygroup.webapi.models;

public class OrderRequest {
    private Long status;
    private Long orderAmount;
    public OrderRequest() {
    }

    public OrderRequest(Long status, Long orderAmount) {
        this.status = status;
        this.orderAmount = orderAmount;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }
}
