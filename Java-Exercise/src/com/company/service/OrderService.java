package com.company.service;

import com.company.dto.OrderDto;

public interface OrderService {
    OrderDto sendOrder(OrderDto orderDto);
    OrderDto getOrder(String name);
    OrderDto updateOrder(OrderDto orderDto);
}
