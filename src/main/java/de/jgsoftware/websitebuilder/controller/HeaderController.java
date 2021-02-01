package de.jgsoftware.websitebuilder.controller;


import de.jgsoftware.websitebuilder.service.DemoPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/header")
public class HeaderController {
    java.util.Locale locale;

    @Autowired
    DemoPageService demoPageService;

    @Autowired
    HttpServletRequest request;

    // load default landingpage
    @GetMapping({"header", "/"})
    public ModelAndView header() {

        //model.addAttribute("lgname", plgservice.getMultipagelanguage().getPageLanguageText());
        //model.addAttribute("productList", indexservice.getDaoProduct().getProductsforLandingpage());
        ModelAndView mv = new ModelAndView("header");


        //mv.setView("templates/startbootstrap-small-business/index.html");
        mv.addObject("message", "TestString 123");


        /**
         *   Get Country to display Language
         *   only for this Controller
         *
         */
        String languagestr = RequestContextUtils.getLocale(request).getLanguage();
        mv.addObject("lang", languagestr);


        /**
         *   IMPORTENT to set H2 comp value to editor
         *   Bootstrap VALUES for Navigation Bar
         *   class = navbar // Bootstrap
         */
        mv.addObject("webtextcomp", demoPageService.getDemopreview().getPageNav());


        System.out.print("Der DemoController wurde geladen");

        return mv;
    }

}

