package org.puralsight.model;

import org.puralsight.enums.Topping;
import org.puralsight.service.FileWritable;

import java.util.stream.Collectors;

/**
 * Margherita Pizza class that inherits from Pizza.
 * This is same features with the Regular Pizza (no customization topping)
 * It also supports file writing for order generation.
 */
public class VeggiePizza extends Pizza {

    private String specialNote;

    public String getSpecialNote() {
        return specialNote;
    }

    public void setSpecialNote(String specialNote) {
        this.specialNote = specialNote;
    }

    @Override
    public String toFileString() {
        StringBuilder sb = new StringBuilder();

        sb.append("PIZZA|")
                .append(getName()).append("|")
                .append(getQuantity()).append("|")
                .append(getPizzaSize()).append("|")
                .append(getCrustType()).append("|")
                .append(isStuffedCrust());

        // toppings (only if exist)
        if (getToppingList() != null && !getToppingList().isEmpty()) {
            String toppings = getToppingList().stream()
                    .map(Topping::name)
                    .collect(Collectors.joining(","));
            sb.append("|TOPPINGS:").append(toppings);
        }


        // notes (optional)
        if (specialNote != null && !specialNote.isEmpty()) {
            sb.append("|NOTES:").append(specialNote);
        }

        return sb.toString();
    }
}
