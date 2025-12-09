package org.example.formsignup.controller;


import jakarta.validation.Valid;
import org.example.formsignup.dto.UserDTO;
import org.example.formsignup.entity.User;
import org.example.formsignup.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.print.Pageable;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping(value = "/create")
    public String showFormAdd( Model model){
        model.addAttribute("user",new UserDTO());
        return "user/index";
    }
    @PostMapping(value = "/create")
    public String addUser(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "user/index";
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        userService.add(user);
        return "redirect:/user/create";
    }
}
