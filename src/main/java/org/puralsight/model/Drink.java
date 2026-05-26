package org.puralsight.model;

import org.puralsight.enums.DrinkSize;
import org.puralsight.service.Priceable;

public class Drink extends Item {

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

    @Override
    public double getPrice() {
        return size.getPrice();
    }

    @Override
    public String toString() {
        int drinkQuantity= getQuantity();
        double price= getSize().getPrice();
        StringBuilder sb = new StringBuilder();
//        sb.append("\n🥤 DRINKS:\n");

//        sb.append(String.format("🥤   %-1s %s- %-15s $%-10.2f Total: $%3.2f%n",
//                drinkQuantity,
//                getName(),
//                getSize().name(),
//                price,
//                drinkQuantity * price
//        ));
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
}
