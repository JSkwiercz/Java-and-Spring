package com.company.io;

import com.company.dto.OrderDto;
import com.company.pizzas.Pizza;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String name;
    private List<Pizza> check = new ArrayList<>();

    public Order() {
    }

    public Order(Order order) {
        this.name = order.getName();
        this.check = order.getCheck();
    }

    public Order(OrderDto orderDto) {
        this.name = orderDto.getName();
        this.check = orderDto.getCheck();
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
