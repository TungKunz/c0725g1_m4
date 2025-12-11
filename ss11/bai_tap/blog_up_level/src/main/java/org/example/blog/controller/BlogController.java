package org.example.blog.controller;


import org.example.blog.entity.Blog;
import org.example.blog.entity.Category;
import org.example.blog.service.IBlogService;
import org.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String showBlog(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDir,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Integer categoryId,
            Model model) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Blog> blogPage;
        if (keyword != null && !keyword.isEmpty()) {
            blogPage = blogService.search(keyword, pageable);
            model.addAttribute("keyword", keyword);
        } else if (categoryId != null) {
            blogPage = blogService.findAllByCategory(categoryId, pageable);
            model.addAttribute("categoryId", categoryId);
        } else {
            blogPage = blogService.findAll(pageable);
        }

        model.addAttribute("blogPage", blogPage);
        model.addAttribute("categories", categoryService.findAll()); // Để hiển thị list category cho bộ lọc
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("sortDir", sortDir);
        return "blog/blog-list";
    }

    @GetMapping(value = "/create")
    public String showFormAdd(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categories", categoryService.findAll()); // Truyền list category
        return "blog/blog-create";
    }

    @PostMapping(value = "/create")
    public String createBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        String mess=blogService.add(blog)? "Thêm mới thành công":" Thêm mới thất bại";
        redirectAttributes.addFlashAttribute("mess",mess);
        return "redirect:/blogs";

    }

    @GetMapping("detail/{id}")
    public String showDetail(@PathVariable(name = "id") int id,Model model){
        Blog blog=blogService.findById(id);
        model.addAttribute("blog",blog);
        model.addAttribute("editMode", false);
        return "blog/blog-detail";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable(name = "id") int id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        model.addAttribute("editMode", true);
        model.addAttribute("categories", categoryService.findAll());
        return "blog/blog-detail";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirect) {
        String mess = blogService.add(blog)? "Chỉnh sửa thành công" : "Chỉnh sửa thất bại";
        redirect.addFlashAttribute("mess", mess);
        return "redirect:/blogs/detail/" + blog.getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable(name = "id") int id, RedirectAttributes redirectAttributes){
        String mess= blogService.deleteById(id)? "Xóa thành công":"Xóa thất bại";
        redirectAttributes.addFlashAttribute("mess",mess);
        return "redirect:/blogs";
    }
}