// src/main/java/org/example/gio_hang/service/OrderService.java (Phiên bản đã sửa)

package org.example.gio_hang.service;

import org.example.gio_hang.entity.Cart;
import org.example.gio_hang.entity.CartItem;
import org.example.gio_hang.entity.Order;
import org.example.gio_hang.entity.OrderItem;
import org.example.gio_hang.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Thêm @Transactional

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Transactional
    public Order createOrderFromCart(Cart cart, String name, String email, String address) {
        if (cart == null || cart.getItems() == null || cart.getItems().isEmpty()) {
            throw new RuntimeException("Giỏ hàng trống.");
        }

        Order order = new Order();
        order.setCustomerName(name);
        order.setCustomerEmail(email);
        order.setCustomerAddress(address);
        order.setCreatedAt(LocalDateTime.now());

        order.setTotalAmount(cart.getTotalAmount());

        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem ci : cart.getItems()) {
            OrderItem oi = new OrderItem();
            oi.setOrder(order);
            oi.setProduct(ci.getProduct());
            oi.setQuantity(ci.getQuantity());
            oi.setPrice(ci.getProduct().getPrice());

            orderItems.add(oi);
        }
        order.setItems(orderItems);

        return orderRepository.save(order);
    }
}