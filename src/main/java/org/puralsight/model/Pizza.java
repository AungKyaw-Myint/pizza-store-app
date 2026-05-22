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

    @Override
    public double getTotalPrice() {
//        double pizzaPrice= pizzaSize.getBasePrice();

        double toppingPriceBaseOnSize= pizzaSize.getToppingPriceMultiplier();

        double toppingPrice = toppingList.stream()
                .reduce(0.0, (x,y) ->
                (x + (toppingPriceBaseOnSize * y.getBasePrice())), Double::sum);

        return (toppingPrice+pizzaSize.getBasePrice())* getQuantity();
    }
}
