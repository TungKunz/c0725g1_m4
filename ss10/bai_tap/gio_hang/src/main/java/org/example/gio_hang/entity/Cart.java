package org.example.gio_hang.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Long, CartItem> items = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        CartItem item = items.get(product.getId());
        if (item == null) {
            item = new CartItem();
            item.setProduct(product);
            item.setQuantity(quantity);
            items.put(product.getId(), item);
        } else {
            item.setQuantity(item.getQuantity() + quantity);
        }
    }

    public void updateQuantity(Long productId, int quantity) {
        CartItem item = items.get(productId);
        if (item != null) {
            if (quantity <= 0) {
                items.remove(productId);
            } else {
                item.setQuantity(quantity);
            }
        }
    }

    public void removeProduct(Long productId) {
        items.remove(productId);
    }

    public Double getTotalAmount() {
        return items.values().stream()
                .mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity())
                .sum();
    }

    public Collection<CartItem> getItems() {
        return items.values();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
