package test;

import com.company.pizzas.Pizza;
import com.company.pizzas.factory.AbstractPizzaFactory;
import com.company.pizzas.factory.PizzaFactory;
import com.company.pizzas.ingredients.Ingredients;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PizzaFactoryTest {

    @Test
    void shouldMakeMargherita() {
        List<Ingredients> addTo = new ArrayList<>();
        List<Ingredients> removeFrom = new ArrayList<>();
        List<Ingredients> ingredients = new ArrayList<>();
        ingredients.add(Ingredients.DOUGH);
        ingredients.add(Ingredients.TOMATO_SAUCE);
        ingredients.add(Ingredients.CHEESE);
        Pizza margherita = new Pizza("Margherita", "Normal", ingredients);

        AbstractPizzaFactory pizzaFactory = new PizzaFactory();
        Pizza pizza = pizzaFactory.createPizza("Margherita", addTo, removeFrom);


        Assertions.assertEquals(margherita.toString(), pizza.toString());
    }

    @Test
    void shouldMakeCapriciosaWithPineappleWithoutMushrooms() {
        List<Ingredients> addTo = new ArrayList<>();
        List<Ingredients> removeFrom = new ArrayList<>();
        List<Ingredients> ingredients = new ArrayList<>();
        ingredients.add(Ingredients.DOUGH);
        ingredients.add(Ingredients.TOMATO_SAUCE);
        ingredients.add(Ingredients.CHEESE);
        ingredients.add(Ingredients.HAM);
        ingredients.add(Ingredients.PINEAPPLE);

        Pizza capriciosa = new Pizza("Capriciosa", "Normal", ingredients);

        addTo.add(Ingredients.PINEAPPLE);
        removeFrom.add(Ingredients.MUSHROOMS);

        AbstractPizzaFactory pizzaFactory = new PizzaFactory();
        Pizza pizza = pizzaFactory.createPizza("Capriciosa", addTo, removeFrom);

        Assertions.assertEquals(capriciosa.toString(), pizza.toString());
    }
}
