package com.ehsaniara.design.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ehsaniara (Jay.Ara) on 10/1/17.
 * From http://www.ehsaniara.com
 */
public class ChatMediatorImpl implements ChatMediator {

    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String msg, User user) {
        for (User u : this.users) {
            //message should not be received by the user sending it
            if (u != user) {
                u.receive(msg);
            }
        }
    }
}
