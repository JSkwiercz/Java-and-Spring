package com.company.io.repositories;

import com.company.io.Order;
import com.company.pizzas.Pizza;
import com.company.pizzas.ingredients.Ingredients;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public Order findByName(String name) {

        try {
            loadFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Order order : orders) {
            if (order.getName().equals(name)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public Order save(Order order) {

        try {
            loadFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.orders.add(order);

        try {
            writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return findByName(order.getName());
    }

    @Override
    public Order update(Order order) {

        try {
            loadFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Order updateOrder = new Order(findByName(order.getName()));
        for (Pizza p : order.getCheck()) {
            updateOrder.addPizza(p);
        }

        findByName(order.getName()).setCheck(updateOrder.getCheck());

        try {
            writeFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return findByName(order.getName());
    }

    private void writeFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("orders.txt"));
        for (Order order : orders) {
            writer.write(order.getName() + ";");
            for (Pizza pizza : order.getCheck()) {
                writer.write(pizza.toString());
            }
            writer.write("\n");
        }
        writer.close();
    }

    private void loadFile() throws IOException {
        FileInputStream fis = new FileInputStream("orders.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        this.orders.clear();

        String strLine;
        while ((strLine = br.readLine()) != null) {
            String[] line = strLine.split(";");
            List<Pizza> pizzas = new ArrayList<>();
            Order order = new Order();
            order.setName(line[0]);
            for (int i = 1; i < line.length; i++) {
                String[] piz = line[i].split(":");
                String[] ings = piz[2].split(",");
                List<Ingredients> ingredients = new ArrayList<>();
                for (int j = 0; j < ings.length; j++) {
                    Ingredients ingredient = Ingredients.valueOf(getName(ings[j]));
                    ingredients.add(ingredient);
                }
                Pizza pizza = new Pizza(piz[0], piz[1], ingredients);
                pizzas.add(pizza);
            }
            order.setCheck(pizzas);
            this.orders.add(order);
        }

        fis.close();
    }

    private String getName(String ing) {
        return ing.replaceAll("\\s", "").toUpperCase();
    }
}
