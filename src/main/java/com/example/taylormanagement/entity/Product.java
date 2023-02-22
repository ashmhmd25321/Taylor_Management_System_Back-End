package com.example.taylormanagement.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;

    private String productName;

    @Column(length = 20000)
    private String productDescription;

    private String category;

    private double discountedPrice;

    private double productPrice;

    private String productStatus;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "product_images",
        joinColumns = {
            @JoinColumn(name = "product_id")
        },
            inverseJoinColumns = {
            @JoinColumn(name = "image_id")
            }
    )
    private Set<ImageModel> productImages;
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public Set<ImageModel> getProductImages() {
        return productImages;
    }

    public void setProductImages(Set<ImageModel> productImages) {
        this.productImages = productImages;
    }
}
