package org.puralsight.view;

import org.puralsight.model.GarlicKnots;
import org.puralsight.model.Item;
import org.puralsight.model.Order;
import org.puralsight.util.Helpers;

import java.time.LocalDateTime;
import java.util.List;

import static org.puralsight.util.Helpers.displayHeader;
import static org.puralsight.util.Helpers.readRequiredString;

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

        String custName= Helpers.readRequiredString("Enter your name :");
        order.setCustName(custName);
        order.setDateTime(LocalDateTime.now());


        /*
        double totalPrice = 0;
        int items= 0;

        for(Item item : itemList){
            System.out.println(item);
            totalPrice+=item.getTotalPrice();
            if(item instanceof GarlicKnots){
                items+=1;
            }else {
                items+=item.getQuantity();
            }
        }

        printGrandTotal(totalPrice,items);

         */
        boolean isOrder=Helpers.readBoolean("Would you like to Complete Order (y/n)?");
        if(isOrder){
            System.out.println("Order Complete");
        }

    }

    private void printGrandTotal(double totalPrice, int items){
        Helpers.displayFooter();
        System.out.printf(
                "    %-1s %-15s 💰$%-10s : $%3.2f%n",
                "🧾ITEMS :",
                items,
                "GRAND TOTAL",
                totalPrice
        );
        Helpers.displayFooter();
    }
}
