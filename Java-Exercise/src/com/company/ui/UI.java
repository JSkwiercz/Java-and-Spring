package com.company.ui;

import com.company.pizzas.Pizza;
import com.company.pizzas.factory.AbstractPizzaFactory;
import com.company.pizzas.factory.PizzaConstants;
import com.company.pizzas.factory.PizzaFactory;
import com.company.pizzas.ingredients.Ingredient;
import com.company.pizzas.ingredients.IngredientsConstants;
import com.company.ui.controller.OrderController;
import com.company.ui.model.request.PizzaOrderModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UI {
    private AbstractPizzaFactory pizzaFactory = new PizzaFactory();
    private List<Pizza> pizzas = new ArrayList<>();
    private OrderController orderController = new OrderController();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void run() throws IOException {

        System.out.println("Welcome to Pizza Acturis, make your order:\n1) Pizza Margherita\n2) Pizza Capriciosa\n3) Calzone");
        String input = reader.readLine();
        while (!input.equals("4")) {
            switch (input) {
                case "1" -> {
                    List<Ingredient> addTo = askForAdditions();
                    List<Ingredient> removeFrom = askForRemove();
                    Pizza pizza = pizzaFactory.createPizza(PizzaConstants.MARGHERITA, addTo, removeFrom);
                    pizzas.add(pizza);
                }
                case "2" -> {
                    List<Ingredient> addTo = askForAdditions();
                    List<Ingredient> removeFrom = askForRemove();
                    Pizza pizza = pizzaFactory.createPizza(PizzaConstants.CAPRICIOSA, addTo, removeFrom);
                    pizzas.add(pizza);
                }
                case "3" -> {
                    List<Ingredient> addTo = askForAdditions();
                    List<Ingredient> removeFrom = askForRemove();
                    Pizza pizza = pizzaFactory.createPizza(PizzaConstants.CALZONE, addTo, removeFrom);
                    pizzas.add(pizza);
                }
                default -> System.out.println("Wrong number");
            }
            System.out.println("If you want to add another pizza, type number from 1-3\nIf you want to finish you order, type 4");
            input = reader.readLine();
        }

        System.out.println("Insert your name: ");
        PizzaOrderModel order = new PizzaOrderModel();
        input = reader.readLine();
        order.setUserName(input);
        order.setPizzas(pizzas);
        orderController.makeOrder(order);

    }

    public List<Ingredient> askForAdditions() throws IOException{
        List<Ingredient> addTo = new ArrayList<>();
        System.out.println("Do you want to add some ingredients? (Y/N)");
        String input = reader.readLine();
        if (input.equals("Y")) {
            System.out.println("List of ingredients:\n1) Cheese\n2) Tomato\n3) Basil\n4) Ham\n5) Salami\n6) Spinach\n7) Pineapple\n8) Mushrooms\n9) End adding");
            input = reader.readLine();
            while (!input.equals("9")) {
                switch (input) {
                    case "1" -> {
                        addTo.add(IngredientsConstants.CHEESE);
                        System.out.println("Added Cheese");
                    }
                    case "2" -> {
                        addTo.add(IngredientsConstants.TOMATO);
                        System.out.println("Added Tomato");
                    }
                    case "3" -> {
                        addTo.add(IngredientsConstants.BASIL);
                        System.out.println("Added Basil");
                    }
                    case "4" -> {
                        addTo.add(IngredientsConstants.HAM);
                        System.out.println("Added Ham");
                    }
                    case "5" -> {
                        addTo.add(IngredientsConstants.SALAMI);
                        System.out.println("Added Salami");
                    }
                    case "6" -> {
                        addTo.add(IngredientsConstants.SPINACH);
                        System.out.println("Added Spinach");
                    }
                    case "7" -> {
                        addTo.add(IngredientsConstants.PINEAPPLE);
                        System.out.println("Added Pineapple");
                    }
                    case "8" -> {
                        addTo.add(IngredientsConstants.MUSHROOMS);
                        System.out.println("Added Mushrooms");
                    }
                }
                input = reader.readLine();
            }
        }
        return addTo;
    }

    public List<Ingredient> askForRemove() throws IOException{
        List<Ingredient> removeFrom = new ArrayList<>();
        System.out.println("Do you want to remove some ingredients? (Y/N)");
        String input = reader.readLine();
        if(input.equals("Y")) {
            System.out.println("List of ingredients:\n1) Cheese\n2) Tomato\n3) Basil\n4) Ham\n5) Salami\n6) Spinach\n7) Pineapple\n8) Mushrooms\n9) End removing");
            input = reader.readLine();
            while (!input.equals("9")) {
                switch (input) {
                    case "1" -> {
                        removeFrom.add(IngredientsConstants.CHEESE);
                        System.out.println("Removed Cheese");
                    }
                    case "2" -> {
                        removeFrom.add(IngredientsConstants.TOMATO);
                        System.out.println("Removed Tomato");
                    }
                    case "3" -> {
                        removeFrom.add(IngredientsConstants.BASIL);
                        System.out.println("Removed Basil");
                    }
                    case "4" -> {
                        removeFrom.add(IngredientsConstants.HAM);
                        System.out.println("Removed Ham");
                    }
                    case "5" -> {
                        removeFrom.add(IngredientsConstants.SALAMI);
                        System.out.println("Removed Salami");
                    }
                    case "6" -> {
                        removeFrom.add(IngredientsConstants.SPINACH);
                        System.out.println("Removed Spinach");
                    }
                    case "7" -> {
                        removeFrom.add(IngredientsConstants.PINEAPPLE);
                        System.out.println("Removed Pineapple");
                    }
                    case "8" -> {
                        removeFrom.add(IngredientsConstants.MUSHROOMS);
                        System.out.println("Removed Mushrooms");
                    }
                }
                input = reader.readLine();
            }
        }
        return removeFrom;
    }
}
