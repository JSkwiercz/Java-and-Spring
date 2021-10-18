package com.company.pizzas.ingredients;

public class IngredientsConstants {
    public static final Ingredient DOUGH = new Ingredient("Dough", 10.0);
    public static final Ingredient CHEESE = new Ingredient("Cheese", 6.0);
    public static final Ingredient TOMATO_SAUCE = new Ingredient("Tomato Sauce", 6.0);
    public static final Ingredient TOMATO = new Ingredient("Tomato", 3.0);
    public static final Ingredient BASIL = new Ingredient("Basil", 3.0);
    public static final Ingredient HAM = new Ingredient("Ham", 4.0);
    public static final Ingredient SALAMI = new Ingredient("Salami", 5.0);
    public static final Ingredient SPINACH = new Ingredient("Spinach", 4.0);
    public static final Ingredient PINEAPPLE = new Ingredient("Pineapple", 6.0);
    public static final Ingredient MUSHROOMS = new Ingredient("Mushrooms", 4.0);

    public Ingredient findIngredient(String name) {
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
