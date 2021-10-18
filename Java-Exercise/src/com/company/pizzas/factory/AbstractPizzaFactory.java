package com.company.pizzas.factory;

import com.company.pizzas.Pizza;
import com.company.pizzas.ingredients.Ingredients;

import java.util.List;

public interface AbstractPizzaFactory {

    Pizza createPizza(String name, List<Ingredients> addTo, List<Ingredients> removeFrom);
}
