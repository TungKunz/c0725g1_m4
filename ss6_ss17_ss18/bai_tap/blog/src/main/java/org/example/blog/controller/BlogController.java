package org.example.blog.controller;


import org.example.blog.entity.Blog;
import org.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping(value = "/blogs")
    public String showBlog(Model model){
        List<Blog> blogList=blogService.findAll();
        model.addAttribute("blogList",blogList);
        return "blog/blog-list";
    }
    @GetMapping(value = "/create")
    public String showFormAdd(Model model){
        model.addAttribute("blog",new Blog());
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
        return "blog/blog-detail";
    }
    @PostMapping("/update")
    public String updateBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirect) {
        String mess = blogService.add(blog)? "Chỉnh sửa thành công" : "Chỉnh sửa thất bại";
        redirect.addFlashAttribute("mess", mess);
        return "redirect:/detail/" + blog.getId();
    }
    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable(name = "id") int id, RedirectAttributes redirectAttributes){
        String mess= blogService.deleteById(id)? "Xóa thành công":"Xóa thất bại";
        redirectAttributes.addFlashAttribute("mess",mess);
        return "redirect:/blogs";
    }
}
