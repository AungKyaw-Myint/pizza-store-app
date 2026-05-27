package org.puralsight.view;

import org.puralsight.model.GarlicKnots;
import org.puralsight.model.Item;
import org.puralsight.util.Helpers;

import java.util.List;

import static org.puralsight.util.Helpers.displayHeader;

/**
 * Garlic Knots Order cmd page, including adding, quantity and confirmation
 */
public class GarlicKnotsOrderPage {

    public void garlicKnotsOrdering(List<Item> itemList){

        displayHeader();
        GarlicKnots garlicKnots= new GarlicKnots();
        int quantity=Helpers.readPositiveInt("How much would you like to order (Garlic Knots)? :");

        garlicKnots.setName("Garlic Knots");
        garlicKnots.setQuantity(quantity);

        System.out.println(garlicKnots);
        boolean isOrder=Helpers.readBoolean("Would you like to add Order (y/n)?");
        if(isOrder){
            itemList.add(garlicKnots);
        }

    }
}
