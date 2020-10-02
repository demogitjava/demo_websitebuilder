package de.jgsoftware.websitebuilder.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class IndexPageController
{




    @RequestMapping("/index")
    public String welcome(Model model) {
       // log.info("Spring Boot Thymeleaf Configuration Example");
        model.addAttribute("message", "sdfdsf");
        return "index";
    }


    @GetMapping("/demo")
    public String login() {
        return "redirect:demo";
    }

}
