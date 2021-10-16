package com.company.ui.model.response;

import com.company.pizzas.Pizza;

import java.util.ArrayList;
import java.util.List;

public class OrderResponse {
    private String userName;
    private List<Pizza> check = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Pizza> getCheck() {
        return check;
    }

    public void setCheck(List<Pizza> check) {
        this.check = check;
    }
}
