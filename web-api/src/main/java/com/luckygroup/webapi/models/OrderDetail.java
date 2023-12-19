package com.luckygroup.webapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "order_id")
  private Long orderId;

  @Column(name = "product_id")
  private Long productId;

  @Column(name = "quantity")
  private int quantity;

  @Column(name = "product_price")
  private double productPrice;

  //contructer
  public OrderDetail() {
    super();
  }

  public OrderDetail(
    Long id,
    Long orderId,
    Long productId,
    int quantity,
    double productPrice
  ) {
    this.id = id;
    this.productId = productId;
    this.quantity = quantity;
    this.productPrice = productPrice;
  }

  // getters and setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public double getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(double productPrice) {
    this.productPrice = productPrice;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
