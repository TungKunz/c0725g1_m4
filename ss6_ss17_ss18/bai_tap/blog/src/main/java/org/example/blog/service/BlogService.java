package org.example.blog.service;

import org.example.blog.entity.Blog;
import org.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
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
}
