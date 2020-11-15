package de.jgsoftware.websitebuilder.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/demo")
public class DemoController
{


    // load default landingpage
    @GetMapping({"preview", "/"})
    public ModelAndView mvcdemo() {

        //model.addAttribute("lgname", plgservice.getMultipagelanguage().getPageLanguageText());
        //model.addAttribute("productList", indexservice.getDaoProduct().getProductsforLandingpage());
        ModelAndView mv = new ModelAndView("preview");


        //mv.setView("templates/startbootstrap-small-business/index.html");
        mv.addObject("message", "TestString 123");

        System.out.print("Der DemoController wurde geladen");
        return mv;
    }

}
