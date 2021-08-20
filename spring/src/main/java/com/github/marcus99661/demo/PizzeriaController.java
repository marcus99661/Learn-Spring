package com.github.marcus99661.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class PizzeriaController {
    private List<Pizza> pizzaList = List.of(
            new Pizza("Margherita", 5.0),
            new Pizza("Napoletana", 6.0),
            new Pizza("Calzone", 7.5)
    );

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("pizzas", pizzaList);
        return "menu";
    }
}
