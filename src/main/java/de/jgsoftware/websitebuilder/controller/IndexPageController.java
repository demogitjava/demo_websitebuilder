package de.jgsoftware.websitebuilder.controller;


import de.jgsoftware.websitebuilder.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
@RequestMapping("/")
public class IndexPageController {



    @Autowired
    public IndexService idexservice;


    // load default landingpage
    @GetMapping({"index", "/"})
    public ModelAndView index() {

        //model.addAttribute("lgname", plgservice.getMultipagelanguage().getPageLanguageText());
        //model.addAttribute("productList", indexservice.getDaoProduct().getProductsforLandingpage());
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("message", "TestString 123");
        /*
                return all Objects of table
                webtextlayout to mvc Controller
         */
        mv.addObject("listtemplate", idexservice.getDcontroller().getPageLanguageText());
        return mv;
    }


    @PostMapping("/edit/crudlist")
    public ModelAndView editcrudlist()
    {

        ModelAndView mv = new ModelAndView("editcrudlist");




        return mv;
    }

    @GetMapping("demo")
    public String demopreview()
    {

        // redirect:demo
        return "preview";
    }


    @GetMapping("login")
    public String login() {
        return "login";
    }




}