package org.puralsight.view;

import org.puralsight.enums.CrustType;
import org.puralsight.enums.PizzaSize;
import org.puralsight.enums.Topping;
import org.puralsight.enums.ToppingType;
import org.puralsight.model.Item;
import org.puralsight.model.MargheritaPizza;
import org.puralsight.model.Pizza;
import org.puralsight.model.VeggiePizza;
import org.puralsight.util.Helpers;
import org.puralsight.view.enums.HomeViewOption;
import org.puralsight.view.enums.PizzaViewOption;

import java.util.*;
import java.util.stream.Collectors;

import static org.puralsight.util.Helpers.displayFooter;
import static org.puralsight.util.Helpers.displayHeader;

/**
 * Ordering Pizza cmd page, select pizza type, topping and customization pizza.
 */
public class PizzaOrderPage {

    public void pizzaOrdering(List<Item> itemList){

        PizzaViewOption pizzaViewOption;
        do {
            Pizza pizza = null;
            displayHeader();
            displayPizzaMenu();
            displayFooter();
            int choice = Helpers.readInt("Choose an option: ");
            pizzaViewOption = PizzaViewOption.fromCode(choice).orElse(null);
            pizza = handlePizzaViewChoice(pizzaViewOption);
            if(pizza!= null) {
                System.out.println(pizza);
                boolean isOrder = Helpers.readBoolean("Would you like to add Order (y/n)?");
                if (isOrder) {
                    itemList.add(pizza);
                }
            }
        } while (pizzaViewOption != PizzaViewOption.GO_BACK);
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

    private void displayPizzaMenu() {
        for (PizzaViewOption option : PizzaViewOption.values()) {
            System.out.printf("      %d) %s%n", option.getCode(), option.getLabel());
        }
    }

    private Pizza handlePizzaViewChoice(PizzaViewOption option) {
        if (option == null) {
            System.out.println("Invalid option. Please try again.");
            return null;
        }
        switch (option) {
            case REGULAR_PIZZA : return getOrginalPizza();
            case MARGHERITA_PIZZA : return getMargheritaPizza();
            case VEGGIE_PIZZA : return getVeggiePizza();
            case GO_BACK: {
            }
        }
        return null;
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

    private Pizza getOrginalPizza(){
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


        pizza.setName(PizzaViewOption.REGULAR_PIZZA.getLabel());
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

        return pizza;
    }

    private Pizza getMargheritaPizza(){

        MargheritaPizza pizza= new MargheritaPizza();
        List<Topping> toppingList= new ArrayList<>();

        pizza.setName(PizzaViewOption.MARGHERITA_PIZZA.getLabel());
        pizza.setPizzaSize(PizzaSize.MEDIUM);
        pizza.setCrustType(CrustType.REGULAR);

        toppingList.add(Topping.MOZZARELLA);
        toppingList.add(Topping.TOMATOES);
        toppingList.add(Topping.BASIL);
        toppingList.add(Topping.MARINARA);
        toppingList.add(Topping.OLIVE_OIL);
        pizza.addTopping(toppingList);
        pizza.setQuantity(1);

        System.out.println(pizza);
        String specialNote= Helpers.readString("Adding special Note? :");
        pizza.setSpecialNote(specialNote);
        int quantity=Helpers.readPositiveInt("Total quantity:");
        pizza.setQuantity(quantity);

        return pizza;
    }

    private Pizza getVeggiePizza(){

        VeggiePizza pizza= new VeggiePizza();
        List<Topping> toppingList= new ArrayList<>();

        pizza.setName(PizzaViewOption.VEGGIE_PIZZA.getLabel());
        pizza.setPizzaSize(PizzaSize.SMALL);
        pizza.setCrustType(CrustType.REGULAR);

        toppingList.add(Topping.BELL_PEPPERS);
        toppingList.add(Topping.SPINACH);
        toppingList.add(Topping.OLIVES);
        toppingList.add(Topping.ONIONS);
        toppingList.add(Topping.MARINARA);
        toppingList.add(Topping.MOZZARELLA);
        pizza.addTopping(toppingList);
        pizza.setQuantity(1);

        System.out.println(pizza);
        String specialNote= Helpers.readString("Adding special Note? :");
        pizza.setSpecialNote(specialNote);
        int quantity=Helpers.readPositiveInt("Total quantity:");
        pizza.setQuantity(quantity);

        return pizza;
    }
}
