package com.company.service;

import com.company.dto.OrderDto;
import com.company.io.Order;
import com.company.io.repositories.OrderRepositoryImpl;
import com.company.io.repositories.OrderRepository;

public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository = new OrderRepositoryImpl();

    @Override
    public OrderDto sendOrder(OrderDto orderDto) {
        if (orderRepository.findByName(orderDto.getName()) != null) {
            return updateOrder(orderDto);
        }

        Order order = new Order(orderDto);

        Order storedOrderDetails = orderRepository.save(order);

        return new OrderDto(storedOrderDetails);
    }

    @Override
    public OrderDto getOrder(String name) {

        Order order = orderRepository.findByName(name);

        if (order == null) {
            throw new RuntimeException("User not found");
        }

        return new OrderDto(order);
    }

    @Override
    public OrderDto updateOrder(OrderDto orderDto) {

        Order order = orderRepository.findByName(orderDto.getName());

        Order updatedOrderDetails = orderRepository.update(order);

        return new OrderDto(updatedOrderDetails);
    }
}
