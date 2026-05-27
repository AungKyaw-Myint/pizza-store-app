package org.puralsight.view;

import org.puralsight.model.Item;
import org.puralsight.model.Order;
import org.puralsight.service.impl.EventManager;
import org.puralsight.util.Helpers;
import org.puralsight.util.ObserverManagerSingleton;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.puralsight.util.Helpers.displayHeader;

/**
 * Checkout User cmd page
 */
public class CheckOutPage {

    public void checkOut(List<Item> itemList){

        displayHeader();

        if(itemList.size() < 1){
            boolean isOrder=Helpers.readBoolean("⚠ ORDER LIST IS EMPTY! GO BACK TO MAIN MENU (y/n): ");
            return;
        }

        Order order= new Order();
        order.setItemList(itemList);
        order.printItemList();
        printGrandTotal(order.calculateGrandTotal(), order.getTotalItems());

        boolean isOrder=Helpers.readBoolean("Would you like to Complete Order (y/n)?");
        if(isOrder){
            String custName= Helpers.readRequiredString("Enter your name :");
            order.setCustName(custName);
            order.setDateTime(LocalDateTime.now());
            System.out.println("Your order is complete!");

            /**
             * Using Observer Design pattern.
             * Sending all subscription list including like file writing, Email and SMS notification (future enhancement).
             * Using Singleton Design Pattern creating ObserverManger.
             */
            EventManager observerManager =
                    ObserverManagerSingleton
                            .getInstance()
                            .getObserverManager();
            observerManager.setOrder(order);

            itemList.clear();
        }

    }

    private void printGrandTotal(double totalPrice, int items){
        Helpers.displayFooter();
        System.out.printf(
                "    %-1s %-15s 💰%-10s : $%3.2f%n",
                "🧾ITEMS :",
                items,
                "GRAND TOTAL",
                totalPrice
        );
        Helpers.displayFooter();
    }
}
