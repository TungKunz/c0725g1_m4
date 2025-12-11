package org.example.gio_hang.service;

import org.example.gio_hang.entity.Product;

import java.util.List;

public interface IProductService {
    Product findById(Long id);
    List<Product> findAll();
}
