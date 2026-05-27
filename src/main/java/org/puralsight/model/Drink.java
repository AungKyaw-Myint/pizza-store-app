package org.puralsight.model;

import org.puralsight.enums.DrinkSize;
import org.puralsight.service.FileWritable;

public class Drink extends Item {

    private DrinkSize size;

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

    @Override
    public double getPrice() {
        return size.getPrice();
    }

    @Override
    public String toString() {
        int drinkQuantity= getQuantity();
        double price= getSize().getPrice();
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(
                "🥤   %-3s %-14s %-10s $%-8.2f Total: $%-8.2f%n",
                drinkQuantity,
                getName(),
                getSize().name(),
                price,
                drinkQuantity * price
        ));
        return sb.toString();
    }

    @Override
    public String toFileString() {
        return "";
    }
}
