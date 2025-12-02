package org.example.sandwich.repository;

import org.example.sandwich.entity.Order;

import java.util.List;

public interface IOrderRepository {
    List<Order> getAll();
    boolean add(Order order);
}
