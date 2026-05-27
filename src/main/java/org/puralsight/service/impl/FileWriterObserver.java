package org.puralsight.service.impl;

import org.puralsight.model.Order;
import org.puralsight.service.Observer;
import org.puralsight.util.FileWriterCsv;

/**
 * One of the Observer subscriptions to writing file of each order.
 */
public class FileWriterObserver implements Observer {

    private FileWriterCsv fileWriterCsv = new FileWriterCsv();

    @Override
    public void update(Order order) {

        fileWriterCsv.writeItems(order.getItemList(),order);
        System.out.println(
                "📝 File writer observer: " + order.getDateTime()
        );
    }
}
