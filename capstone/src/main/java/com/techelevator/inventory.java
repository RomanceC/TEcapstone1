package com.techelevator;

import java.io.Serializable;

public abstract class inventory implements Serializable, Comparable {
    public static final String GUM = "Gum";
    public static final String CANDY = "Candy";
    public static final String BEVERAGE = "Beverage";
    public static final String CHIPS = "Chips";

    // instance variables
    private String name;
    private String price;
    private String catchPhrase;
    private int initialStock = 5;

    //constructor
    public inventory (String name, String price) {
        this.name = name;
        this.price = price;
    }