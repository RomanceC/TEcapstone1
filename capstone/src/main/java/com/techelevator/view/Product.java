package com.techelevator.view;

import com.techelevator.VendingMachineCLI;

public class Product {

  private   String code;//0
private String name;//index 1
private double  price;//2
private String category;//3
private int quantity;//4

public Product(){

}
public Product(String code,String name,double price,String category,int quantity){
    this.code=code;
    this.name=name;
    this.price=price;
    this.category=category;
    this.quantity=quantity;

}



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCateogry() {
        return category;
    }

    public void setCateogry(String cateogry) {
        this.category = cateogry;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
