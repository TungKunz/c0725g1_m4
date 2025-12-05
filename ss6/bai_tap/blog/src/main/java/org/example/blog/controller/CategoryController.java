package org.example.blog.controller;

import org.example.blog.entity.Category;
import org.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String showCategoryList(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "blog/category/category-list";
    }

    @GetMapping("/create")
    public String showFormAdd(Model model) {
        model.addAttribute("category", new Category());
        return "blog/category/category-create";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        String mess = categoryService.save(category) ? "Lưu Category thành công" : "Lưu Category thất bại";
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable(name = "id") int id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "blog/category/category-create";
    }


    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable(name = "id") int id, RedirectAttributes redirectAttributes) {
        String mess = categoryService.deleteById(id) ? "Xóa Category thành công" : "Xóa Category thất bại";
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/categories";
    }
}