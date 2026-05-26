package org.puralsight.model;

import org.puralsight.service.Priceable;

public class GarlicKnots extends Item{

    private static final double price=1.5;
//    private int quantity;

    @Override
    public double getPrice(){
        return price;
    }

    @Override
    public double getTotalPrice() {
        return price*getQuantity();
    }

    @Override
    public String toString() {
        int knotsQuantity= getQuantity();
        StringBuilder sb = new StringBuilder();
//        sb.append("\n🧄 GARLIC KNOTS:\n");

//        sb.append(String.format("🧄   %-1s %-15s $%-10.2f Total: $%3.2f%n",
//                knotsQuantity,
//                getName(),
//                price,
//                knotsQuantity * price
//        ));
        sb.append(String.format(
                "🧄   %-3s %-14s %-10s $%-8.2f Total: $%-8.2f%n",
                knotsQuantity,
                getName(),
                "",
                price,
                knotsQuantity * price
        ));
        return sb.toString();
    }
}
