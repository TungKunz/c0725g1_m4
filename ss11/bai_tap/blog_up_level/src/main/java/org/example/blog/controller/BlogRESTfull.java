package org.example.blog.controller;

import org.example.blog.entity.Blog;
import org.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogRESTfull {
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ResponseEntity<Page<Blog>> getAllBlog(Pageable pageable){
        Page<Blog> blogs = blogService.findAll(pageable);
        return ResponseEntity.ok(blogs);
    }
    @PostMapping("")
    public ResponseEntity<?> saveBlog(@RequestBody Blog blog) {
        try {
            if (blog == null) {
                return ResponseEntity
                        .badRequest()
                        .body("Blog không hợp lệ");
            }

            boolean saved = blogService.add(blog);

            if (saved) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity
                        .status(409)
                        .body("Không thể lưu blog");
            }

        } catch (Exception ex) {
            return ResponseEntity
                    .status(500)
                    .body("Lỗi server: " + ex.getMessage());
        }
    }


}
