package com.ehsaniara.design.observer;

/**
 * Created by Ehsaniara (Jay.Ara) on 10/1/17.
 * From http://www.ehsaniara.com
 */
public interface Subject {
    //methods to register and unregister observers
    void register(Observer obj);

    void unregister(Observer obj);

    //method to notify observers of change
    void notifyObservers();

    //method to get updates from subject
    Object getUpdate(Observer obj);
}
