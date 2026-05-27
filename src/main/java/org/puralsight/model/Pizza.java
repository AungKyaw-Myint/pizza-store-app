package org.puralsight.model;

import org.puralsight.enums.CrustType;
import org.puralsight.enums.PizzaSize;
import org.puralsight.enums.PizzaType;
import org.puralsight.enums.Topping;
import org.puralsight.service.FileWritable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza extends Item {

    private PizzaSize pizzaSize;
    private CrustType crustType;
    private List<Topping> toppingList;
    private boolean isStuffedCrust;
    private PizzaType pizzaType;

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

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
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
    public double getPrice() {
        double toppingPriceBaseOnSize= pizzaSize.getToppingPriceMultiplier();

        double toppingPrice = toppingList.stream()
                .reduce(0.0, (x,y) ->
                        (x + (toppingPriceBaseOnSize * y.getBasePrice())), Double::sum);

        return (toppingPrice+pizzaSize.getBasePrice());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n🍕 PIZZAS:\n");
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

        sb.append(String.format(
                "🍕   %-3s %-14s %-10s $%-8.2f Total: $%-8.2f%n",
                getQuantity(),
                "Pizza",
                "",
                getPrice(),
                getTotalPrice()
        ));
        return sb.toString();
    }

    @Override
    public String toFileString() {
        StringBuilder sb = new StringBuilder();

        sb.append("PIZZA|")
                .append(pizzaType).append("|")
                .append(pizzaSize).append("|")
                .append(crustType).append("|")
                .append(isStuffedCrust);

        // toppings (only if exist)
        if (toppingList != null && !toppingList.isEmpty()) {
            String toppings = toppingList.stream()
                    .map(Topping::name)
                    .collect(Collectors.joining(","));
            sb.append("|TOPPINGS:").append(toppings);
        }

        /*
        // notes (optional)
        if (notes != null && !notes.isEmpty()) {
            sb.append("|NOTES:").append(notes);
        }

         */

        return sb.toString();
    }
}
