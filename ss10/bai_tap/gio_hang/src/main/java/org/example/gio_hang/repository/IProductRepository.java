package org.example.gio_hang.repository;

import org.example.gio_hang.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
