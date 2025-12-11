package org.example.gio_hang.service;

import org.example.gio_hang.entity.Cart;
import org.example.gio_hang.entity.Order;

public interface IOrderService {
    Order createOrderFromCart(Cart cart, String name, String email, String address);
}
