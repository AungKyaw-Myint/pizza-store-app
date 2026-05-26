package org.puralsight.model;

import org.puralsight.service.Priceable;

public abstract class Item {

    private String name;
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract double getTotalPrice();

    public abstract double getPrice();

}
