package com.techelevator.view;

import com.techelevator.inventory;

public class Drink extends inventory {

    public Drink(String name) {
        super(name, inventory.Drink );
    }

    public int getCurrentStock() {
        return 5;
    }

}

