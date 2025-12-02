package org.example.sandwich.repository;

import org.example.sandwich.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository implements IOrderRepository{

    private final static List<Order> orders = new ArrayList<>();

    @Override
    public List<Order> getAll() {
        return orders;
    }

    @Override
    public boolean add(Order order) {
        return orders.add(order);
    }
}
