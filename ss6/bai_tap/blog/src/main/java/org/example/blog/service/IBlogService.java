package org.example.blog.service;

import org.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
    Blog findById(int id);
    boolean add(Blog blog);
    boolean deleteById(int id);

    Page<Blog> search(String keyword, Pageable pageable);
    Page<Blog> findAllByCategory(int categoryId, Pageable pageable);
}