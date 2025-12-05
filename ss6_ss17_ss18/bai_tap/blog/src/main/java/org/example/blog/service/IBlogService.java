package org.example.blog.service;

import org.example.blog.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(int id);
    boolean add(Blog blog);
    boolean deleteById(int id);
}
