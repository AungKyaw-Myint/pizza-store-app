package org.puralsight.view.enums;

import java.util.Arrays;
import java.util.Optional;

public enum HomeViewOption {

    NEW_ORDER(1, "New Order"),
    EXIT(0, "Exit");

    private final int code;
    private final String label;

    HomeViewOption(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static Optional<HomeViewOption> fromCode(int code) {
        return Arrays.stream(values())
                .filter(option -> option.code == code)
                .findFirst();
    }
}
