package org.example.blog.repository;

import org.example.blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
