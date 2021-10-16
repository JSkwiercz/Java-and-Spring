package com.company.dto;

import com.company.io.User;
import com.company.pizzas.Pizza;
import com.company.ui.model.request.PizzaOrderModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDto implements Serializable {
    private String name;
    private List<Pizza> check = new ArrayList<>();

    public UserDto(User user) {
        this.name = user.getName();
        this.check = user.getCheck();
    }

    public UserDto(PizzaOrderModel order) {
        this.name = order.getUserName();
        this.check = (order.getPizzas());
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
}
