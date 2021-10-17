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
        try {
            orders = loadFile();
        } catch (IOException | ClassNotFoundException e) {
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
            orders = loadFile();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

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
        oos.writeObject(orders);
        oos.close();
    }

    private List<Order> loadFile() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("orders.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Order> order = (List<Order>) ois.readObject();
        ois.close();
        return order;
    }
}
