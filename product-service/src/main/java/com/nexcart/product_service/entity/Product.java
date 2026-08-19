package com.nexcart.product_service.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    @Column(nullable=false,precision = 19,scale=2)
    private BigDecimal productPrice;
    private String productDescription;

    public Product(){

    }

    public Product(String productName,BigDecimal productPrice,String productDescription){
        this.productName=productName;
        this.productPrice=productPrice;
        this.productDescription=productDescription;
    }


    //Setters
    public void setProductId(int productId){
        this.productId=productId;
    }

    public void setProductName(String productName){
        this.productName=productName;
    }

    public void setProductPrice(BigDecimal productPrice){
        this.productPrice=productPrice;
    }

    public void setProductDescription(String productDescription){
        this.productDescription=productDescription;
    }

    //Getters
    public int getProductId(){
        return this.productId;
    }

    public String getProductName(){
        return this.productName;
    }

    public BigDecimal getProductPrice(){
        return this.productPrice;
    }

    public String getProductDescription(){
        return this.productDescription;
    }




}
