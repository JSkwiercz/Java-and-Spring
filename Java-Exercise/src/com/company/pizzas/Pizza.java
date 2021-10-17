package com.company.pizzas;

import com.company.pizzas.ingredients.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private String dough;
    private List<Ingredient> ingredients = new ArrayList<>();

    public Pizza(String name, String dough, List<Ingredient> ingredients) {
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        double price = 0;
        for (Ingredient i : ingredients) {
            price += i.getPrice();
        }
        return price;
    }

    @Override
    public String toString() {
        StringBuilder returnValue = new StringBuilder();
        returnValue.append(getName()).append("\n").append("Dough: ").append(getDough()).append("\nIngredients: \n");
        for (Ingredient i : ingredients) {
            returnValue.append(i.getName()).append("\n");
        }
        returnValue.append("Price: ").append(this.getPrice());
        return returnValue.toString();
    }
}
