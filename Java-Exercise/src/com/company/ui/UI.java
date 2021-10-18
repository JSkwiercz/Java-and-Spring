package com.company.ui;

import com.company.pizzas.Pizza;
import com.company.pizzas.factory.AbstractPizzaFactory;
import com.company.pizzas.factory.PizzaConstants;
import com.company.pizzas.factory.PizzaFactory;
import com.company.pizzas.ingredients.Ingredients;
import com.company.ui.controller.OrderController;
import com.company.ui.model.request.PizzaOrderModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UI {
    private final Boolean ADD = true;
    private final Boolean REMOVE = false;
    private AbstractPizzaFactory pizzaFactory = new PizzaFactory();
    private OrderController orderController = new OrderController();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void run() throws IOException {
        String input = "";
        while(!input.equals("C")) {
            List<Pizza> pizzas = new ArrayList<>();
            System.out.println("Welcome to Pizza Acturis, make your order:\n1) Pizza Margherita\n2) Pizza Capriciosa\n3) Calzone");
            input = reader.readLine();
            while (!input.equals("4")) {
                switch (input) {
                    case "1" -> {
                        List<Ingredients> addTo = askForIngredients(ADD);
                        List<Ingredients> removeFrom = askForIngredients(REMOVE);
                        Pizza pizza = pizzaFactory.createPizza(PizzaConstants.MARGHERITA, addTo, removeFrom);
                        pizzas.add(pizza);
                    }
                    case "2" -> {
                        List<Ingredients> addTo = askForIngredients(ADD);
                        List<Ingredients> removeFrom = askForIngredients(REMOVE);
                        Pizza pizza = pizzaFactory.createPizza(PizzaConstants.CAPRICIOSA, addTo, removeFrom);
                        pizzas.add(pizza);
                    }
                    case "3" -> {
                        List<Ingredients> addTo = askForIngredients(ADD);
                        List<Ingredients> removeFrom = askForIngredients(REMOVE);
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
            System.out.println("If you want to make new order, type Y\nIf you want to close app, type C");
            input = reader.readLine();
        }
    }

    public List<Ingredients> askForIngredients(Boolean action) throws IOException{
        List<Ingredients> ingredients = new ArrayList<>();
        printQuestion(action);

        String input = reader.readLine();
        if (input.equals("Y")) {
            System.out.println("List of ingredients:\n1) Cheese\n2) Tomato\n3) Basil\n4) Ham\n5) Salami\n6) Spinach\n7) Pineapple\n8) Mushrooms\n9) End adding");
            input = reader.readLine();
            while (!input.equals("9")) {
                Ingredients ingredient = Ingredients.values()[Integer.valueOf(input) + 1];
                ingredients.add(ingredient);
                preintResponse(action, ingredient.getName());
                input = reader.readLine();
            }
        }
        return ingredients;
    }

    private void printQuestion(Boolean action)
    {
        if (action == ADD) {
            System.out.println("Do you want to add some ingredients? (Y/N)");
        } else {
            System.out.println("Do you want to delete some ingredients? (Y/N)");
        }
    }

    private void preintResponse(Boolean action, String name) {
        if (action == ADD) {
            System.out.println("Added " + name);
        } else {
            System.out.println("Removed " + name);
        }
    }
}
