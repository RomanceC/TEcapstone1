package com.techelevator.view;

import com.techelevator.inventory;

public class Gum extends inventory {

    public Gum(String name) {

        super(name, inventory.GUM);
    }

    public int getCurrentStock(){
        return 5;
    }
}