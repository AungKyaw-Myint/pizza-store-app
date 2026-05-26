package org.puralsight.service;

import org.puralsight.model.Order;

public interface Observer {
    void update(Order order);
}
