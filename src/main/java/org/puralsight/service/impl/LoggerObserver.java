package org.puralsight.service.impl;

import org.puralsight.model.Order;
import org.puralsight.service.Observer;
import org.puralsight.util.FileWriterCsv;

/**
 * One of the Observer subscriptions to writing file of each order.
 */
public class LoggerObserver implements Observer {

    private FileWriterCsv fileWriterCsv = new FileWriterCsv();

    @Override
    public void update(Order order) {

        fileWriterCsv.orderFileWriting(order);
        System.out.println(
                "📝 Logging Observer: " + order.getDateTime()
        );
    }
}
