package org.puralsight.model;

import org.puralsight.enums.CrustType;
import org.puralsight.enums.PizzaSize;
import org.puralsight.enums.Topping;
import org.puralsight.enums.ToppingType;
import org.puralsight.service.Priceable;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends Item implements Priceable {

    private PizzaSize pizzaSize;
    private CrustType crustType;
    private List<Topping> toppingList;
    private boolean isStuffedCrust;

    public Pizza() {
        toppingList= new ArrayList<>();
        isStuffedCrust= false;
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public CrustType getCrustType() {
        return crustType;
    }

    public void setCrustType(CrustType crustType) {
        this.crustType = crustType;
    }

    public List<Topping> getToppingList() {
        return toppingList;
    }

    public void setToppingList(List<Topping> toppingList) {
        this.toppingList = toppingList;
    }

    public boolean isStuffedCrust() {
        return isStuffedCrust;
    }

    public void setStuffedCrust(boolean stuffedCrust) {
        isStuffedCrust = stuffedCrust;
    }

    public void addTopping(Topping topping){
        toppingList.add(topping);
    }

    public void addTopping(List<Topping> toppingList){

        this.toppingList.addAll(toppingList);
    }


    @Override
    public double getTotalPrice() {
//        double pizzaPrice= pizzaSize.getBasePrice();

        double toppingPriceBaseOnSize= pizzaSize.getToppingPriceMultiplier();

        double toppingPrice = toppingList.stream()
                .reduce(0.0, (x,y) ->
                (x + (toppingPriceBaseOnSize * y.getBasePrice())), Double::sum);

        return (toppingPrice+pizzaSize.getBasePrice())* getQuantity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        double pizzaPrice= getTotalPrice();
        // PIZZAS
        sb.append("\n🍕 PIZZAS:\n" + getQuantity());
        sb.append(String.format("Size          : %s%n", pizzaSize));
        sb.append(String.format("Crust         : %s%n", crustType));
        sb.append(String.format("Stuffed Crust : %s%n", isStuffedCrust ? "YES" : "NO"));

        sb.append("\nToppings:\n");

        if (toppingList == null || toppingList.isEmpty()) {
            sb.append("      None\n");
        } else {
            for (int i = 0; i < toppingList.size(); i++) {

                Topping topping = toppingList.get(i);

                sb.append(String.format(
                        "      %d) %-15s ($%.2f)%n",
                        (i + 1),
                        topping.name(),
                        topping.getBasePrice()
                ));
            }
        }

        sb.append("───────────────────────────────────────────────\n");
//        sb.append(String.format("TOTAL: $%.2f%n", getTotalPrice()));
//        sb.append(String.format(
//                "🍕   %-1s %-15s $%-10.2f  Total: $%3.2f%n",
//                getQuantity(),
//                "Pizza",
//                pizzaPrice,
//                pizzaPrice * getQuantity()
//        ));

        sb.append(String.format(
                "🍕   %-3s %-14s %-10s $%-8.2f Total: $%-8.2f%n",
                getQuantity(),
                "Pizza",
                "",
                pizzaPrice,
                pizzaPrice * getQuantity()
        ));
        /*
        // DRINKS
        sb.append("\n🥤 DRINKS:\n");

        if (drinks == null || drinks.isEmpty()) {
            sb.append("      None\n");
        } else {
            for (int i = 0; i < drinks.size(); i++) {
                Drink d = drinks.get(i);
                sb.append(String.format("      %d) %-15s $%.2f%n",
                        (i + 1),
                        d.getName(),
                        d.getPrice()
                ));
            }
        }

        // GARLIC KNOTS
        sb.append("\n🧄 GARLIC KNOTS:\n");
        if (garlicKnotsCount <= 0) {
            sb.append("      None\n");
        } else {
            sb.append("      Quantity: ").append(garlicKnotsCount).append("\n");
        }

        // TOTAL
        sb.append("\n───────────────────────────────────────────────\n");
        sb.append(String.format("TOTAL: $%.2f%n", calculateTotal()));
        sb.append("───────────────────────────────────────────────\n");


         */
        return sb.toString();
    }
}
