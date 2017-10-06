package com.ehsaniara.design.mediator;

/**
 * Created by Ehsaniara (Jay.Ara) on 10/1/17.
 * From http://www.ehsaniara.com
 */
public interface ChatMediator {
    void sendMessage(String msg, User user);

    void addUser(User user);
}
