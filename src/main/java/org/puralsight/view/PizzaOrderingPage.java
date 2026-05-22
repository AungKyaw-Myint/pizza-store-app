package org.puralsight.view;

import org.puralsight.enums.CrustType;
import org.puralsight.enums.PizzaSize;
import org.puralsight.enums.Topping;
import org.puralsight.enums.ToppingType;
import org.puralsight.model.Item;
import org.puralsight.model.Pizza;
import org.puralsight.util.Helpers;

import java.util.*;
import java.util.stream.Collectors;

import static org.puralsight.util.Helpers.displayFooter;
import static org.puralsight.util.Helpers.displayHeader;

public class PizzaOrderingPage {

    public void pizzaOrdering(List<Item> itemList){

        Pizza pizza= new Pizza();
        PizzaSize pizzaSize = getPizzaSize();
        CrustType crustType= getCrustType();
        List<Topping> regularTopping  =  getToppingList(ToppingType.REGULAR, pizzaSize.getToppingPriceMultiplier());
        List<Topping> meatTooping     =  getToppingList(ToppingType.MEATS,   pizzaSize.getToppingPriceMultiplier());
        List<Topping> cheeseTopping   =  getToppingList(ToppingType.CHEESE,  pizzaSize.getToppingPriceMultiplier());
        List<Topping> sauceTooping    =  getToppingList(ToppingType.SAUCES,  pizzaSize.getToppingPriceMultiplier());
        List<Topping> sideTooping     =  getToppingList(ToppingType.SIDES,   pizzaSize.getToppingPriceMultiplier());

        boolean isExtraMeat = Helpers.readBoolean(
                String.format(
                        "Extra meat $%.2f (y/n): ",
                        pizzaSize.getToppingPriceMultiplier() * Topping.EXTRA_MEATS.getBasePrice()
                )
        );
        boolean isExtraCheese =Helpers.readBoolean(
                String.format(
                        "Extra cheese $%.2f (y/n): ",
                        pizzaSize.getToppingPriceMultiplier() * Topping.EXTRA_CHEESE.getBasePrice()
                ));

        int quantity=Helpers.readPositiveInt("Total quantity:");


        pizza.setPizzaSize(pizzaSize);
        pizza.setCrustType(crustType);
        pizza.addTopping(regularTopping);
        pizza.addTopping(meatTooping);
        pizza.addTopping(cheeseTopping);
        pizza.addTopping(sauceTooping);
        pizza.addTopping(sideTooping);
        pizza.setQuantity(quantity);

        if (isExtraCheese) {
            pizza.addTopping(Topping.EXTRA_CHEESE);
        }
        if(isExtraMeat){
            pizza.addTopping(Topping.EXTRA_MEATS);
        }
//        pizza
        System.out.println(pizza);
        boolean isOrder=Helpers.readBoolean("Would you like to add Order (y/n)?");
        if(isOrder){
            itemList.add(pizza);
        }


    }

    private PizzaSize getPizzaSize(){
        while (true) {
            displayHeader();
            displayPizzaSizes();
            displayFooter();
            int choice = Helpers.readInt("Choose Pizza Size: ");
            if (choice >= 1 && choice <= PizzaSize.values().length) {
                return PizzaSize.values()[choice - 1];
            }
            System.out.println("❌ Invalid option. Please select 1 - "
                    + PizzaSize.values().length);
        }
    }

    private CrustType getCrustType(){
        while (true) {
            displayHeader();
            displayCrustType();
            displayFooter();
            int choice = Helpers.readInt("Choose Crust Type: ");
            if (choice >= 1 && choice <= CrustType.values().length) {
                return CrustType.values()[choice - 1];
            }
            System.out.println("❌ Invalid option. Please select 1 - "
                    + CrustType.values().length);
        }
    }

    public List<Topping> getToppingList(ToppingType toppingType, int toppingRate){
        while (true) {
            displayHeader();
            Set<Topping> regularToppingSet = Arrays.stream(Topping.values())
                    .filter(topping -> topping.getType() == toppingType)
                    .collect(Collectors.toSet());
            List<Topping> regularTopping=new ArrayList<>(regularToppingSet);
            displayToppingList(regularTopping, toppingRate);
            displayFooter();
            String input = Helpers.readString("Choose " +toppingType.name()+ " Topping (e.g. 1,3,5): ");
            List<Topping> selectedToppings = new ArrayList<>();
            if (input.equals("0")) {
                break;
            }

            String[] parts = input.split(",");
            boolean hasError = false;

            for (String part : parts) {

                try {
                    int choice = Integer.parseInt(part.trim());
                    if (choice >= 1 && choice <= regularTopping.size()) {
                        Topping topping = regularTopping.get(choice - 1);
                        if (!selectedToppings.contains(topping)) {
                            selectedToppings.add(topping);
                        }
                    } else {
                        System.out.println("❌ Invalid Topping: " + choice);
                        hasError = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid Topping: " + part.trim());
                    hasError = true;
                }
            }
            if (!hasError) {
                return selectedToppings; // ✅ valid input → exit loop
            }
        }
        return new ArrayList<>();
    }

    private void displayPizzaSizes() {
        for (PizzaSize size : PizzaSize.values()) {
            System.out.printf(
                    "      %d) %-10s (%d inch, $%.2f)%n",
                    (size.ordinal() + 1),
                    size.name(),
                    size.getDiameter(),
                    size.getBasePrice()
            );
        }
    }

    private void displayCrustType() {
        for (CrustType crustType : CrustType.values()) {
            System.out.printf(
                    "      %d) %-15s%n",
                    (crustType.ordinal() + 1),
                    crustType.name()
            );
        }
    }

    private void displayToppingList(List<Topping> toppingList, int toppingRate) {
        for (int i = 0; i < toppingList.size(); i++){
            Topping topping = toppingList.get(i);

            System.out.printf(
                    "      %d) %-15s ($%.2f)%n",
                    (i + 1),
                    topping.name(),
                    topping.getBasePrice() * toppingRate
            );
        }
        System.out.println("      0) Skip");
    }
}
