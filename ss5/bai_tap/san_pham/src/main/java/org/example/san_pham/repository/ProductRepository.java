package org.example.san_pham.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.example.san_pham.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getAllProduct() {
        TypedQuery<Product> query = entityManager.createQuery("FROM Product", Product.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public boolean addProduct(Product product) {
        try {
            entityManager.persist(product);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @Transactional
    @Override
    public boolean deleteProduct(Product product) {
        try {
            if (!entityManager.contains(product)) {
                product = entityManager.merge(product);
            }
            entityManager.remove(product);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public boolean editProduct(Product product) {
        try {
            entityManager.merge(product);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Product getById(int id) {
        return entityManager.find(Product.class, id);
    }
}
