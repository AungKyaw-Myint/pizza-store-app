package org.puralsight.model;

import org.puralsight.enums.DrinkSize;
import org.puralsight.service.Priceable;

public class Drink extends Item implements Priceable {

//    private String name;
    private DrinkSize size;
//    private int quantity;
//    private


    public DrinkSize getSize() {
        return size;
    }

    public void setSize(DrinkSize size) {
        this.size = size;
    }

    @Override
    public double getTotalPrice() {
        return size.getPrice()*getQuantity();
    }
}
