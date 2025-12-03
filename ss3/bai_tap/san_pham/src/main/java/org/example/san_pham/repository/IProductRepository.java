package org.example.san_pham.repository;

import org.example.san_pham.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProduct();
    boolean addProduct(Product product);
    boolean deleteProduct(Product product);
    boolean editProduct(Product product);
    Product getById(int id);
}
