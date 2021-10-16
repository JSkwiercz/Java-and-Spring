package com.company.io.repositories;

import com.company.io.User;
import com.company.pizzas.Pizza;

import java.util.*;

public class UserBase implements UserRepository{
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public User findByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User save(User user) {

        this.users.add(user);

        return findByName(user.getName());
    }

    @Override
    public User update(User user) {

        User updateUser = findByName(user.getName());
        for (Pizza p : user.getCheck()) {
            updateUser.addPizza(p);
        }

        findByName(user.getName()).setCheck(updateUser.getCheck());

        return findByName(user.getName());
    }
}
