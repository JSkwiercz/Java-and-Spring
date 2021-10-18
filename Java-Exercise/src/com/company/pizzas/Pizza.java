package com.company.pizzas;

import com.company.pizzas.ingredients.Ingredients;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private String dough;
    private List<Ingredients> ingredients = new ArrayList<>();

    public Pizza(String name, String dough, List<Ingredients> ingredients) {
        this.name = name;
        this.dough = dough;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        double price = 0;
        for (Ingredients i : ingredients) {
            price += i.getPrice();
        }
        return price;
    }

    @Override
    public String toString() {
        StringBuilder returnValue = new StringBuilder();
        returnValue.append(getName()).append(":").append(getDough()).append(":");
        for (Ingredients i : ingredients) {
            returnValue.append(i.getName()).append(",");
        }
        returnValue.deleteCharAt(returnValue.length() - 1).append(";");
        return returnValue.toString();
    }
}
