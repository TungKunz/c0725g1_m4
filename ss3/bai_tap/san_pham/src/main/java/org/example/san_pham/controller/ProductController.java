package org.example.san_pham.controller;


import org.example.san_pham.entity.Product;
import org.example.san_pham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/products")
    public String products(Model model){
        model.addAttribute("productList",productService.getAllProduct());
        return "list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/create")
    public String createProduct(@ModelAttribute("product") Product product,RedirectAttributes redirectAttributes){
        boolean isAdded = productService.addProduct(product);
        String mess = "Thêm sản phẩm thất bại.";
        if (isAdded) {
            mess="Thêm sản phẩm thành công.";
        }
        redirectAttributes.addFlashAttribute("mess",mess);
        return "redirect:/products";
    }
    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id") int id,Model model){
        Product product=productService.getById(id);
        model.addAttribute(product);
        return "edit";
    }
    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("product") Product product,RedirectAttributes redirectAttributes){
        boolean isEdit = productService.editProduct(product);
        String mess = "Sửa sản phẩm thất bại.";
        if (isEdit) {
            mess="Sửa sản phẩm thành công.";
        }
        redirectAttributes.addFlashAttribute("mess",mess);
        return "redirect:/products";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
        Product product = productService.getById(id);
        String mess = " Không xóa được sản phẩm";
        boolean isDeleteSuccess=false;
        if(product!=null) {
            isDeleteSuccess=productService.deleteProduct(product);
        }
        if(isDeleteSuccess){
            mess="Xóa thành công";
        }
        redirectAttributes.addFlashAttribute("mess",mess);
        return "redirect:/products";
    }
}
