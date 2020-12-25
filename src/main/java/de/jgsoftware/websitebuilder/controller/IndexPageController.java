package de.jgsoftware.websitebuilder.controller;


import de.jgsoftware.websitebuilder.model.m_webtextlayout;
import de.jgsoftware.websitebuilder.service.DemoPageService;
import de.jgsoftware.websitebuilder.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/")
public class IndexPageController {
    @Autowired
    DemoPageService demoPageService;
    @Autowired
    HttpServletRequest request;

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

        /*
                returns all Objects form
                BOOTSTRAP_COMPOENTS to Controller
         */
        mv.addObject( "bootstrapcomponent", idexservice.getDcontroller().getBootstrapComponents());




        /**
         *  DemoController Values
         *  to Display the demo website in websitebuilder
         */
        /**
         *   Bootstrap VALUES for Navigation Bar
         *   class = navbar // Bootstrap
         */
        mv.addObject("webtextcomp", demoPageService.getDemopreview().getPageNav());
        /**
         *   Get Country to display Language
         *   only for this Controller
         *
         */
        String languagestr = RequestContextUtils.getLocale(request).getLanguage();
        mv.addObject("lang", languagestr);

        return mv;
    }


    @PostMapping("/edit/crudlist")
    public String submitForm(m_webtextlayout webtextlayout) {
        System.out.println(webtextlayout);

        idexservice.getDcontroller().saveFormModalData(webtextlayout);
        return "redirect:/";
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