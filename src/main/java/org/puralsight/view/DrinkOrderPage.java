package org.puralsight.view;

import org.puralsight.enums.*;
import org.puralsight.model.Drink;
import org.puralsight.model.Item;
import org.puralsight.util.Helpers;

import java.util.List;

import static org.puralsight.util.Helpers.displayFooter;
import static org.puralsight.util.Helpers.displayHeader;

/**
 * Drink Order cmd page, including adding drink, choosing item and confirmation
 */
public class DrinkOrderPage {

    public void drinkOrdering(List<Item> itemList){

        Drink drink= new Drink();
        String name= Helpers.readRequiredString("What would you like to drink today? :");
        DrinkSize drinkSize = getDrinkSize();
        int quantity=Helpers.readPositiveInt("Total quantity:");

        drink.setName(name);
        drink.setSize(drinkSize);
        drink.setQuantity(quantity);

        System.out.println(drink);
        boolean isOrder=Helpers.readBoolean("Would you like to add Order (y/n)?");
        if(isOrder){
            itemList.add(drink);
        }

    }

    private DrinkSize getDrinkSize(){
        while (true) {
            displayHeader();
            displaySizes();
            displayFooter();
            int choice = Helpers.readInt("Choose the Size: ");
            if (choice >= 1 && choice <= DrinkSize.values().length) {
                return DrinkSize.values()[choice - 1];
            }
            System.out.println("❌ Invalid option. Please select 1 - "
                    + PizzaSize.values().length);
        }
    }

    private void displaySizes() {
        for (DrinkSize size : DrinkSize.values()) {
            System.out.printf(
                    "      %d) %-15s ($%.2f)%n",
                    (size.ordinal() + 1),
                    size.name(),
                    size.getPrice()
            );
        }
    }
}
