package org.puralsight.service.impl;

import org.puralsight.model.Order;
import org.puralsight.service.Observer;
import org.puralsight.service.Subject;

import java.util.ArrayList;
import java.util.List;

public class EventManager implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private Order order;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(order);
        }
    }

    public void setOrder(Order order) {
        this.order= new Order();
        this.order = order;
        notifyObservers();
    }
}
