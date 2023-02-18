package com.example.taylormanagement.entity;

import java.util.List;

public class OrderInput {
    private String fullName;
    private String address;
    private String contactNumber;
    private String alternateContactNumber;
    private List<OrderProductQuantity> orderProductQuantities; //to buy multiple products

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAlternateContactNumber() {
        return alternateContactNumber;
    }

    public void setAlternateContactNumber(String alternateContactNumber) {
        this.alternateContactNumber = alternateContactNumber;
    }

    public List<OrderProductQuantity> getOrderProductQuantities() {
        return orderProductQuantities;
    }

    public void setOrderProductQuantities(List<OrderProductQuantity> orderProductQuantities) {
        this.orderProductQuantities = orderProductQuantities;
    }
}
