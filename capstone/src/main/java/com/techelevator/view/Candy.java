package com.techelevator.view;

import com.techelevator.inventory;

public class Candy extends inventory {

    public Candy(String name) { super(name, Menu.CANDY); }

    public int getCurrentStock() { return 5; }


}