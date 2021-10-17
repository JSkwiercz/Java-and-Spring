package test;

import com.company.pizzas.Pizza;
import com.company.pizzas.factory.AbstractPizzaFactory;
import com.company.pizzas.factory.PizzaFactory;
import com.company.pizzas.ingredients.Ingredient;
import com.company.pizzas.ingredients.IngredientsConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PizzaFactoryTest {

    @Test
    void shouldMakeMargherita() {
        List<Ingredient> addTo = new ArrayList<>();
        List<Ingredient> removeFrom = new ArrayList<>();
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(IngredientsConstants.DOUGH);
        ingredients.add(IngredientsConstants.TOMATO_SAUCE);
        ingredients.add(IngredientsConstants.CHEESE);
        Pizza margherita = new Pizza("Margherita", "Normal", ingredients);

        AbstractPizzaFactory pizzaFactory = new PizzaFactory();
        Pizza pizza = pizzaFactory.createPizza("Margherita", addTo, removeFrom);


        Assertions.assertEquals(margherita.toString(), pizza.toString());
    }

    @Test
    void shouldMakeCapriciosaWithPineappleWithoutMushrooms() {
        List<Ingredient> addTo = new ArrayList<>();
        List<Ingredient> removeFrom = new ArrayList<>();
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(IngredientsConstants.DOUGH);
        ingredients.add(IngredientsConstants.TOMATO_SAUCE);
        ingredients.add(IngredientsConstants.CHEESE);
        ingredients.add(IngredientsConstants.HAM);
        ingredients.add(IngredientsConstants.PINEAPPLE);

        Pizza capriciosa = new Pizza("Capriciosa", "Normal", ingredients);

        addTo.add(IngredientsConstants.PINEAPPLE);
        removeFrom.add(IngredientsConstants.MUSHROOMS);

        AbstractPizzaFactory pizzaFactory = new PizzaFactory();
        Pizza pizza = pizzaFactory.createPizza("Capriciosa", addTo, removeFrom);

        Assertions.assertEquals(capriciosa.toString(), pizza.toString());
    }
}
