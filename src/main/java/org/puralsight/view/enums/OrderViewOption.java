package org.puralsight.view.enums;

import java.util.Arrays;
import java.util.Optional;

public enum OrderViewOption {
    ADD_PIZZA(1, "Add Pizza"),
    ADD_DRINK(2, "Add Drink"),
    ADD_GARLIC_KNOTS(3, "Add Garlic Knots"),
    CHECKOUT(4, "Checkout"),
    CANCEL_ORDER(0, "Cancel Order");

    private final int code;
    private final String label;

    OrderViewOption(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static Optional<OrderViewOption> fromCode(int code) {
        return Arrays.stream(values())
                .filter(option -> option.code == code)
                .findFirst();
    }
}
