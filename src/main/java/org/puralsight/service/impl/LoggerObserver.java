package org.puralsight.service.impl;

import org.puralsight.model.Order;
import org.puralsight.service.Observer;

public class LoggerObserver implements Observer {

    @Override
    public void update(Order order) {


        System.out.println(
                "📝 Logging Observer: " + order.getDateTime()
        );
    }
}
