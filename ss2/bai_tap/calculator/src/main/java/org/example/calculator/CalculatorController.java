package org.example.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("num1",0);
        model.addAttribute("num2",0);
        return "result";
    }

    @GetMapping("/calculator")
    public String home(@RequestParam(name = "action") String action, @RequestParam(name = "num1") int num1, @RequestParam(name = "num2") int num2, Model model) {

        switch (action){
            case "+":
                model.addAttribute("ketqua",num1+num2);
                break;
            case "-":
                model.addAttribute("ketqua",num1-num2);
                break;
            case "*":
                model.addAttribute("ketqua",num1*num2);
                break;
            case "/":
                model.addAttribute("ketqua",num1/num2);
                break;
            default:
                break;
        }
        return "result";
    }
}
