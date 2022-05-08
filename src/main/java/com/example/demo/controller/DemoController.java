package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
public class DemoController {

    @RequestMapping("/hello")
    public String getHello(Model model){
        model.addAttribute("date", LocalDate.now());
        return "helloWorld";

    }
}
