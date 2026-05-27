package org.puralsight.util;

import org.puralsight.service.impl.EventManager;
import org.puralsight.service.impl.FileWriterObserver;
import org.puralsight.service.impl.LoggerObserver;
import org.puralsight.service.impl.SmsObserver;

public class ObserverManagerSingleton {

    private static ObserverManagerSingleton instance;

    private final EventManager observerManager;

    private final LoggerObserver loggerObserver;
    private final FileWriterObserver fileWriterObserver;
    private final SmsObserver smsObserver;

    // Private constructor
    private ObserverManagerSingleton() {

        observerManager = new EventManager();

        loggerObserver = new LoggerObserver();
        fileWriterObserver = new FileWriterObserver();
        smsObserver = new SmsObserver();

        // Add observers only once
        observerManager.addObserver(loggerObserver);
        observerManager.addObserver(fileWriterObserver);
        observerManager.addObserver(smsObserver);
    }

    // Singleton instance
    public static ObserverManagerSingleton getInstance() {

        if (instance == null) {
            instance = new ObserverManagerSingleton();
        }

        return instance;
    }

    // Getter
    public EventManager getObserverManager() {
        return observerManager;
    }
}
