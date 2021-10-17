package com.company.io.repositories;

import com.company.io.Order;

import java.io.Serializable;

public interface OrderRepository extends Serializable {
    Order findByName (String name);
    Order save (Order order);
    Order update (Order order);
}
