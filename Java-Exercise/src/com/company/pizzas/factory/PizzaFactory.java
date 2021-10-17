package com.company.pizzas.factory;

import com.company.pizzas.Pizza;
import com.company.pizzas.ingredients.Ingredient;
import com.company.pizzas.ingredients.IngredientsConstants;

import java.util.*;

public class PizzaFactory implements AbstractPizzaFactory{



    @Override
    public Pizza createPizza(String name, List<Ingredient> addTo, List<Ingredient> removeFrom) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(IngredientsConstants.DOUGH);
        ingredients.add(IngredientsConstants.TOMATO_SAUCE);
        ingredients.add(IngredientsConstants.CHEESE);

        if(name.equalsIgnoreCase(PizzaConstants.MARGHERITA)) {
            ingredients.addAll(addTo);

            for (int i = 0; i < ingredients.size(); i++) {
                for(Ingredient x : removeFrom) {
                    if (ingredients.get(i).getName().equals(x.getName())) {
                        ingredients.remove(i);
                    }
                }
            }
            return new Pizza(PizzaConstants.MARGHERITA, "Normal", ingredients);
        }
        if(name.equalsIgnoreCase(PizzaConstants.CAPRICIOSA)) {
            ingredients.add(IngredientsConstants.HAM);
            ingredients.add(IngredientsConstants.MUSHROOMS);
            ingredients.addAll(addTo);

            for (int i = 0; i < ingredients.size(); i++) {
                for(Ingredient x : removeFrom) {
                    if (ingredients.get(i).getName().equals(x.getName())) {
                        ingredients.remove(i);
                    }
                }
            }

            return new Pizza(PizzaConstants.CAPRICIOSA, "Normal", ingredients);

        }
        if(name.equalsIgnoreCase(PizzaConstants.CALZONE)) {
            ingredients.addAll(addTo);
            for (int i = 0; i < ingredients.size(); i++) {
                for(Ingredient x : removeFrom) {
                    if (ingredients.get(i).getName().equals(x.getName())) {
                        ingredients.remove(i);
                    }
                }
            }
            return new Pizza(PizzaConstants.CALZONE, "Calzone", ingredients);

        }
        else {
            System.out.println("There is no such pizza in a system");
        }
        return null;
    }
}
