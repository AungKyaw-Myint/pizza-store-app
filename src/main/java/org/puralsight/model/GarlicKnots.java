package org.puralsight.model;

import org.puralsight.service.Priceable;

public class GarlicKnots extends Item implements Priceable {

    private static final double price=1.5;
//    private int quantity;


    @Override
    public double getTotalPrice() {
        return price*getQuantity();
    }
}
