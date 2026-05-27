package org.puralsight.view;

import org.puralsight.model.Item;
import org.puralsight.util.Helpers;
import org.puralsight.view.enums.OrderViewOption;

import java.util.ArrayList;
import java.util.List;

import static org.puralsight.util.Helpers.displayFooter;
import static org.puralsight.util.Helpers.displayHeader;

/**
 * Order Menu for the user. Choose the function like add item and checkout for the item.
 */
public class OrderPage {

    private PizzaOrderPage pizzaOrder = new PizzaOrderPage();
    private DrinkOrderPage drinkOrder= new DrinkOrderPage();
    private GarlicKnotsOrderPage garlicKnotsOrder = new GarlicKnotsOrderPage();
    private CheckOutPage checkOutPage= new CheckOutPage();

    public void orderMenu(){

        OrderViewOption orderViewOption;
        List<Item> itemList= new ArrayList<>();
        do {
            displayHeader();
            displayOrderMenu();
            displayFooter();
            int choice = Helpers.readInt("Choose an option: ");
            orderViewOption = OrderViewOption.fromCode(choice).orElse(null);
            handleOrderViewChoice(orderViewOption,itemList);
        } while (orderViewOption != OrderViewOption.CANCEL_ORDER);

        System.out.println("Home Page!");
    }

    private void displayOrderMenu() {

        for (OrderViewOption option : OrderViewOption.values()) {
            System.out.printf("      %d) %s%n", option.getCode(), option.getLabel());
        }
    }

    private void handleOrderViewChoice(OrderViewOption option,List<Item> itemList) {
        if (option == null) {
            System.out.println("Invalid option. Please try again.");
            return;
        }
        switch (option) {
            case ADD_PIZZA -> pizzaOrder.pizzaOrdering(itemList);
            case ADD_DRINK -> drinkOrder.drinkOrdering(itemList);
            case ADD_GARLIC_KNOTS -> garlicKnotsOrder.garlicKnotsOrdering(itemList);
            case CHECKOUT -> checkOutPage.checkOut(itemList);
            case CANCEL_ORDER -> itemList = new ArrayList<>();
        }
    }
}
