package org.example.hom_thu.controller;

import org.example.hom_thu.model.HomThu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomThuController {
    @GetMapping("/add")
    public ModelAndView showFrom(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add");
        modelAndView.addObject("homThu", new HomThu());
        modelAndView.addObject("languages",new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        modelAndView.addObject("size",new String[]{"5", "10", "15", "20"});

        return modelAndView;
    }

    @GetMapping("/about")
    public ModelAndView showAbout(@ModelAttribute("homThu") HomThu homThu){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("homThu", homThu);
        return modelAndView;
    }
}