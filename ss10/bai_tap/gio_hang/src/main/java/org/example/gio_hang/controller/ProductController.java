package org.example.gio_hang.controller;

import jakarta.servlet.http.HttpSession;
import org.example.gio_hang.entity.Cart;
import org.example.gio_hang.entity.Product;
import org.example.gio_hang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    // Trang danh sách sản phẩm
    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "cart/product/list"; // product/list.html
    }

    // Trang chi tiết sản phẩm
    @GetMapping("/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "cart/product/detail"; // product/detail.html
    }

}

