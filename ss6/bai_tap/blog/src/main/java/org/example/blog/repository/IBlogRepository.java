package org.example.blog.repository;

import org.example.blog.entity.Blog;
import org.example.blog.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findAllByContentContainingOrDetailContaining(String content, String detail, Pageable pageable);
    Page<Blog> findAllByCategory(Category category, Pageable pageable);
}