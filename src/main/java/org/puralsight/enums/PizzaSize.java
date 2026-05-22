package org.puralsight.enums;

public enum PizzaSize {

    SMALL(8, 8.50, 1),
    MEDIUM(12, 12.00, 2),
    LARGE(16, 16.50, 3);

    private final int diameter;
    private final double basePrice;
    private final int toppingPriceMultiplier;

    PizzaSize(int diameter, double basePrice, int toppingPriceMultiplier) {
        this.diameter = diameter;
        this.basePrice = basePrice;
        this.toppingPriceMultiplier = toppingPriceMultiplier;
    }

    public int getDiameter() {
        return diameter;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public int getToppingPriceMultiplier() {
        return toppingPriceMultiplier;
    }
}
