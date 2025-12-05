package org.example.blog.service;

import org.example.blog.entity.Blog;
import org.example.blog.entity.Category;
import org.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    @Autowired
    private ICategoryService categoryService; // Thêm Category Service

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        // Trả về Page<Blog> thay vì List<Blog>
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public boolean add(Blog blog) {
        return blogRepository.save(blog)!=null;
    }

    @Override
    public boolean deleteById(int id) {
        try {
            blogRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    // Triển khai tìm kiếm và phân trang
    @Override
    public Page<Blog> search(String keyword, Pageable pageable) {
        String searchKeyword = "%" + keyword + "%";
        return blogRepository.findAllByContentContainingOrDetailContaining(searchKeyword, searchKeyword, pageable);
    }

    // Triển khai hiển thị theo danh mục và phân trang
    @Override
    public Page<Blog> findAllByCategory(int categoryId, Pageable pageable) {
        Category category = categoryService.findById(categoryId);
        if (category != null) {
            return blogRepository.findAllByCategory(category, pageable);
        }
        return Page.empty(pageable);
    }
}