package org.example.blog.service;

import org.example.blog.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(int id);
    boolean save(Category category);
    boolean deleteById(int id);
}