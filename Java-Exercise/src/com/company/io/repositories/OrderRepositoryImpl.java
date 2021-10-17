package com.company.io.repositories;

import com.company.io.Order;
import com.company.pizzas.Pizza;

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
        for (Order order : orders) {
            if (order.getName().equals(name)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public Order save(Order order) {

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

        Order updateOrder = findByName(order.getName());
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
        FileOutputStream fos = new FileOutputStream("orders.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Order order: orders) {
            oos.writeBytes(order.getName() + "\n");
            for(Pizza pizza: order.getCheck()) {
                oos.writeBytes(pizza.toString());
            }
        }
        oos.close();
    }
}
