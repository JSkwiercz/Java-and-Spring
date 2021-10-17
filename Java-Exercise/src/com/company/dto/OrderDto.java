package com.company.dto;

import com.company.io.Order;
import com.company.pizzas.Pizza;
import com.company.ui.model.request.PizzaOrderModel;

import java.util.ArrayList;
import java.util.List;

public class OrderDto{
    private String name;
    private List<Pizza> check = new ArrayList<>();

    public OrderDto(Order order) {
        this.name = order.getName();
        this.check = order.getCheck();
    }

    public OrderDto(PizzaOrderModel order) {
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
