package com.ehsaniara.design.observer;

/**
 * Created by Ehsaniara (Jay.Ara) on 10/1/17.
 * From http://www.ehsaniara.com
 */
public interface Observer {
    //method to update the observer, used by subject
    void update();

    //attach with subject to observe
    void setSubject(Subject sub);
}
