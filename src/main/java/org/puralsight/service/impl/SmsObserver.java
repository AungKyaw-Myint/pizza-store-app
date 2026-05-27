package org.puralsight.service.impl;

import org.puralsight.model.Order;
import org.puralsight.service.Observer;

/**
 * One of the Observer subscriptions to writing file of each order.
 */
public class SmsObserver implements Observer {
    @Override
    public void update(Order order) {
        System.out.println(
                "💬 Sms sender observer: " + order.getDateTime()
        );

//        System.out.println(
//                "📩 Email sender observer: " + order.getDateTime()
//        );
    }
}
