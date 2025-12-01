package org.example.change_money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChangeMoneyController {

    @GetMapping("/change")
    public ModelAndView change(@RequestParam(value = "money", required = false) Double money) {
        ModelAndView mav = new ModelAndView("view-change-money");
        if (money == null) {
            return mav;
        }

        double result = money * 24500;
        mav.addObject("result", result);
        mav.addObject("money", money);

        return mav;
    }
}
