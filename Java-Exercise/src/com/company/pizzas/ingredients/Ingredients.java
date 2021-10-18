package com.company.pizzas.ingredients;

public enum Ingredients {
    DOUGH("Dough", 10.0),
    CHEESE("Cheese", 6.0),
    TOMATOSAUCE("Tomato Sauce", 6.0),
    TOMATO("Tomato", 3.0),
    BASIL("Basil", 3.0),
    HAM("Ham", 4.0),
    SALAMI("Salami", 5.0),
    SPINACH("Spinach", 4.0),
    PINEAPPLE("Pineapple", 6.0),
    MUSHROOMS("Mushrooms", 4.0),
    ;

    private final String name;
    private final double price;

    Ingredients(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}

