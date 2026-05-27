package org.puralsight.service;

/**
 * Observer Design Pattern, Subject interface for the push notification subscriber.
 */
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
