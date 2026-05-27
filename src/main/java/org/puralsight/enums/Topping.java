package org.puralsight.enums;

/**
 * Pizza topping customization related with topping type.
 */
public enum Topping {

    PEPPERONI(ToppingType.MEATS, 1.00),
    SAUSAGE(ToppingType.MEATS, 1.00),
    HAM(ToppingType.MEATS, 1.00),
    BACON(ToppingType.MEATS, 1.00),
    CHICKEN(ToppingType.MEATS, 1.00),
    MEATBALL(ToppingType.MEATS, 1.00),

    MOZZARELLA(ToppingType.CHEESE, 0.75),
    PARMESAN_CHEESE(ToppingType.CHEESE, 0.75),
    RICOTTA(ToppingType.CHEESE, 0.75),
    GOAT_CHEESE(ToppingType.CHEESE, 0.75),
    BUFFALO_CHEESE(ToppingType.CHEESE, 0.75),

    EXTRA_MEATS(ToppingType.EXTRA_MEATS, 0.5),
    EXTRA_CHEESE(ToppingType.EXTRA_CHEESE, 0.3),

    ONIONS(ToppingType.REGULAR, 0.00),
    MUSHROOMS(ToppingType.REGULAR, 0.00),
    BELL_PEPPERS(ToppingType.REGULAR, 0.00),
    OLIVES(ToppingType.REGULAR, 0.00),
    TOMATOES(ToppingType.REGULAR, 0.00),
    SPINACH(ToppingType.REGULAR, 0.00),
    BASIL(ToppingType.REGULAR, 0.00),
    PINEAPPLE(ToppingType.REGULAR, 0.00),
    ANCHOVIES(ToppingType.REGULAR, 0.00),

    MARINARA(ToppingType.SAUCES, 0.00),
    ALFREDO(ToppingType.SAUCES, 0.00),
    PESTO(ToppingType.SAUCES, 0.00),
    BBQ(ToppingType.SAUCES, 0.00),
    BUFFALO(ToppingType.SAUCES, 0.00),
    OLIVE_OIL(ToppingType.SAUCES, 0.00),

    RED_PEPPER(ToppingType.SIDES, 0.00),
    PARMESAN_SIDE(ToppingType.SIDES, 0.00);



    private final ToppingType type;
    private final double basePrice;

    Topping(ToppingType type, double basePrice) {
        this.type = type;
        this.basePrice = basePrice;
    }

    public ToppingType getType() {
        return type;
    }

    public double getBasePrice() {
        return basePrice;
    }

}
