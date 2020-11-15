package de.jgsoftware.websitebuilder.controller;


import de.jgsoftware.websitebuilder.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/demo")
    public String demopreview()
    {

        return "redirect:/demo/";
    }


    @GetMapping("login")
    public String login() {
        return "login";
    }




}