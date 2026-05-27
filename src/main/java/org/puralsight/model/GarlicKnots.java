package org.puralsight.model;

public class GarlicKnots extends Item{

    private static final double price=1.5;

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

    @Override
    public String toFileString() {
        StringBuilder sb = new StringBuilder();

        sb.append("GARLIC|")
                .append(getName()).append("|")
                .append(getQuantity()).append("|")
                .append("|")
                .append("|");
        return sb.toString();
    }
}
