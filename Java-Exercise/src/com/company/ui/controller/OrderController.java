package com.company.ui.controller;

import com.company.dto.OrderDto;
import com.company.service.OrderService;
import com.company.service.OrderServiceImpl;
import com.company.ui.model.request.PizzaOrderModel;
import com.company.ui.model.response.OrderResponse;

public class OrderController {

    OrderService orderService = new OrderServiceImpl();

    public OrderResponse makeOrder(PizzaOrderModel pizzaOrder) {

        OrderResponse returnValue = new OrderResponse();

        OrderDto orderDto = new OrderDto(pizzaOrder);
        OrderDto createdUser = orderService.sendOrder(orderDto);

        returnValue.setUserName(createdUser.getName());
        returnValue.setCheck(createdUser.getCheck());
        return returnValue;

    }
}
