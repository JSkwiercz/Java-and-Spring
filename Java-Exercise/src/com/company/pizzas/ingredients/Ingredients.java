package com.company.pizzas.ingredients;

public enum Ingredients {
    DOUGH("Dough", 10.0),
    CHEESE("Cheese", 6.0),
    TOMATO_SAUCE("Tomato Sauce", 6.0),
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

    public static Ingredients findIngredient(String name) {
        if(name.equals(DOUGH.getName())) return DOUGH;
        if(name.equals(CHEESE.getName())) return CHEESE;
        if(name.equals(TOMATO_SAUCE.getName())) return TOMATO_SAUCE;
        if(name.equals(TOMATO.getName())) return TOMATO;
        if(name.equals(BASIL.getName())) return BASIL;
        if(name.equals(HAM.getName())) return HAM;
        if(name.equals(SALAMI.getName())) return SALAMI;
        if(name.equals(SPINACH.getName())) return SPINACH;
        if(name.equals(PINEAPPLE.getName())) return PINEAPPLE;
        if(name.equals(MUSHROOMS.getName())) return MUSHROOMS;
        return null;
    }
}

