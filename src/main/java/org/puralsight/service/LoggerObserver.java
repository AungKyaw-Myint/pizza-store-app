package org.puralsight.service;

import org.puralsight.model.Order;

public class LoggerObserver implements Observer{

    @Override
    public void update(Order order) {


        System.out.println(
                "📝 Logging person: " + order.getCustName()
        );
    }
}
