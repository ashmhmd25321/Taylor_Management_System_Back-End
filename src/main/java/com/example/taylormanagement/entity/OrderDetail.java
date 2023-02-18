package com.example.taylormanagement.entity;

import jakarta.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    private String buyerFullName;
    private String buyerAddress;
    private String buyerContactNumber;
    private String buyerAlternateNumber;
    private String orderStatus;
    private double orderAmount;

    @OneToOne
    private Product product;
    @OneToOne
    private User user;

    public OrderDetail(String buyerFullName, String buyerAddress, String buyerContactNumber, String buyerAlternateNumber, String orderStatus, double orderAmount, Product product, User user) {
        this.buyerFullName = buyerFullName;
        this.buyerAddress = buyerAddress;
        this.buyerContactNumber = buyerContactNumber;
        this.buyerAlternateNumber = buyerAlternateNumber;
        this.orderStatus = orderStatus;
        this.orderAmount = orderAmount;
        this.product = product;
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getBuyerFullName() {
        return buyerFullName;
    }

    public void setBuyerFullName(String buyerFullName) {
        this.buyerFullName = buyerFullName;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getBuyerContactNumber() {
        return buyerContactNumber;
    }

    public void setBuyerContactNumber(String buyerContactNumber) {
        this.buyerContactNumber = buyerContactNumber;
    }

    public String getBuyerAlternateNumber() {
        return buyerAlternateNumber;
    }

    public void setBuyerAlternateNumber(String buyerAlternateNumber) {
        this.buyerAlternateNumber = buyerAlternateNumber;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }
}
