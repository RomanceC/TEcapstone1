package com.techelevator.view;

import com.techelevator.inventory;

public class Gum extends inventory {

    public Gum (String name, String cost, int inventory){
        super(name,cost,inventory);

        }
    public String getSound () {
        System.out.println("Glug Glug, Yum!");
        return "Glug Glug, Yum!";
    }
}