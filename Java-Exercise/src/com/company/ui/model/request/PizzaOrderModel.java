package com.company.ui.model.request;

import com.company.pizzas.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaOrderModel {
    private String userName;
    private List<Pizza> pizzas = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
