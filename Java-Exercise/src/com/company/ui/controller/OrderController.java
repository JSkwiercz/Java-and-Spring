package com.company.ui.controller;

import com.company.dto.UserDto;
import com.company.service.UserService;
import com.company.service.UserServiceImpl;
import com.company.ui.model.request.PizzaOrderModel;
import com.company.ui.model.response.OrderResponse;

public class OrderController {

    UserService userService = new UserServiceImpl();

    public OrderResponse makeOrder(PizzaOrderModel pizzaOrder) {

        OrderResponse returnValue = new OrderResponse();

        UserDto userDto = new UserDto(pizzaOrder);
        UserDto createdUser = userService.createUser(userDto);

        returnValue.setUserName(createdUser.getName());
        returnValue.setCheck(createdUser.getCheck());
        return returnValue;

    }

    public OrderResponse updateOrder(PizzaOrderModel pizzaOrder) {

        OrderResponse returnValue = new OrderResponse();

        UserDto userDto = new UserDto(pizzaOrder);
        UserDto updatedUser = userService.updateUser(userDto);

        returnValue.setUserName(updatedUser.getName());
        returnValue.setCheck(updatedUser.getCheck());
        return returnValue;
    }
}
