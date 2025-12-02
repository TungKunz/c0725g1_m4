package org.example.sandwich.service;

import org.example.sandwich.entity.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getAll();
    boolean add(Order order);
}
