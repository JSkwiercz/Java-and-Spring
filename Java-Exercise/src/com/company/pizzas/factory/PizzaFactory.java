package com.company.pizzas.factory;

import com.company.pizzas.Pizza;
import com.company.pizzas.ingredients.Ingredients;

import java.util.*;

public class PizzaFactory implements AbstractPizzaFactory{



    @Override
    public Pizza createPizza(String name, List<Ingredients> addTo, List<Ingredients> removeFrom) {
        List<Ingredients> ingredients = new ArrayList<>();
        ingredients.add(Ingredients.DOUGH);
        ingredients.add(Ingredients.TOMATOSAUCE);
        ingredients.add(Ingredients.CHEESE);

        if(name.equalsIgnoreCase(PizzaConstants.MARGHERITA)) {
            ingredients.addAll(addTo);

            for (int i = 0; i < ingredients.size(); i++) {
                for(Ingredients x : removeFrom) {
                    if (ingredients.get(i).getName().equals(x.getName())) {
                        ingredients.remove(i);
                    }
                }
            }
            return new Pizza(PizzaConstants.MARGHERITA, "Normal", ingredients);
        }
        if(name.equalsIgnoreCase(PizzaConstants.CAPRICIOSA)) {
            ingredients.add(Ingredients.HAM);
            ingredients.add(Ingredients.MUSHROOMS);
            ingredients.addAll(addTo);

            for (int i = 0; i < ingredients.size(); i++) {
                for(Ingredients x : removeFrom) {
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
                for(Ingredients x : removeFrom) {
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
