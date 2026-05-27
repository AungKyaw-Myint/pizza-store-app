package org.puralsight.view.enums;

import java.util.Arrays;
import java.util.Optional;

public enum PizzaViewOption {
    REGULAR_PIZZA(1, "Regular Pizza (Custom)"),
    MARGHERITA_PIZZA(2, "Margherita Pizza"),
    VEGGIE_PIZZA(3, "Veggie Pizza"),
    GO_BACK(0, "Go Back");

    private final int code;
    private final String label;

    PizzaViewOption(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static Optional<PizzaViewOption> fromCode(int code) {
        return Arrays.stream(values())
                .filter(option -> option.code == code)
                .findFirst();
    }
}
