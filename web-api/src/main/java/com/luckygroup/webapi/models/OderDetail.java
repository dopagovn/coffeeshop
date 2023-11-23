package com.luckygroup.webapi.models;
import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class OderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "oder_id")
    private int oderId;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "product_price")
    private double productPrice;
    //contructer
    public OderDetail() {
        
    };
    public OderDetail(int orderDetailId,int oderId, int productId, int quantity,double productPrice) {
        
        this.oderId = oderId;
        this.productId = productId;
        this.quantity = quantity;
        this.productPrice = productPrice;
    };


    
    // getters and setters

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getOderId() {
        return oderId;
    }
    public void setOderId(int oderId) {
        this.oderId = oderId;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
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
