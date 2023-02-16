package com.techelevator.view;

import com.techelevator.inventory;

public  class Chips extends inventory {

    public Chips(String name) {
        super(name, inventory.CHIPS);
    }

    public int getCurrentStock() { return 5;}

}