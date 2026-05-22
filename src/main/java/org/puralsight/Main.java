package org.puralsight;

import org.puralsight.enums.CrustType;
import org.puralsight.enums.DrinkSize;
import org.puralsight.enums.PizzaSize;
import org.puralsight.enums.Topping;
import org.puralsight.model.Drink;
import org.puralsight.model.GarlicKnots;
import org.puralsight.model.Item;
import org.puralsight.model.Pizza;
import org.puralsight.view.HomePage;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        HomePage userInterface= new HomePage();
        userInterface.starter();

        List<Item> item= new ArrayList<>();
        Pizza pizza= new Pizza();
        pizza.setPizzaSize(PizzaSize.LARGE);
        pizza.setCrustType(CrustType.REGULAR);
        pizza.setStuffedCrust(true);
        pizza.addTopping(Topping.ONIONS);
        pizza.addTopping(Topping.TOMATOES);

        pizza.addTopping(Topping.HAM);
        pizza.addTopping(Topping.BACON);

        pizza.addTopping(Topping.MOZZARELLA);
        pizza.addTopping(Topping.EXTRA_CHEESE);
        pizza.addTopping(Topping.EXTRA_MEATS);

        pizza.addTopping(Topping.BBQ);
        pizza.setQuantity(1);


        Drink drink= new Drink();
        drink.setSize(DrinkSize.LARGE);
        drink.setQuantity(2);

        GarlicKnots knots= new GarlicKnots();
        knots.setQuantity(10);

        item.add(pizza);
        item.add(drink);
        item.add(knots);

        double total=item.stream().mapToDouble( x -> x.getTotalPrice()).sum();

        System.out.println(total);
    }
}
