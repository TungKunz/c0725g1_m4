package org.example.sandwich.controller;

import org.example.sandwich.entity.Order;
import org.example.sandwich.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {


    @Autowired
    private OrderService orderService;

    @GetMapping("/add")
    public String showOrder(){
        return "order";
    }
    @GetMapping("/list")
    public String showOrderList(Model model){
        model.addAttribute("orders",orderService.getAll());
        return "list";
    }


    @PostMapping("/add")
    public String addOrder(@ModelAttribute Order order){
        orderService.add(order);
        return "redirect:list";
    }
}