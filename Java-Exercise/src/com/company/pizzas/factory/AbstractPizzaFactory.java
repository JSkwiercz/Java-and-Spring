package com.company.pizzas.factory;

import com.company.pizzas.Pizza;
import com.company.pizzas.ingredients.Ingredient;

import java.util.List;

public interface AbstractPizzaFactory {

    Pizza createPizza(String name, List<Ingredient> addTo, List<Ingredient> removeFrom);
}
