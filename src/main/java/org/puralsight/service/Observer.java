package org.puralsight.service;

import org.puralsight.model.Order;

/**
 * Observer Design Pattern, Observer interface with the parameter
 */
public interface Observer {
    void update(Order order);
}
