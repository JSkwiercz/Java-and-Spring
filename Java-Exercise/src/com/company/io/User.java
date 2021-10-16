package com.company.io;

import com.company.dto.UserDto;
import com.company.pizzas.Pizza;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Pizza> check = new ArrayList<>();

    public User(User user) {
        this.name = user.getName();
        this.check = user.getCheck();
    }

    public User(UserDto userDto) {
        this.name = userDto.getName();
        this.check = userDto.getCheck();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pizza> getCheck() {
        return check;
    }

    public void setCheck(List<Pizza> check) {
        this.check = check;
    }

    public void addPizza(Pizza pizza) {
        this.check.add(pizza);
    }
}
