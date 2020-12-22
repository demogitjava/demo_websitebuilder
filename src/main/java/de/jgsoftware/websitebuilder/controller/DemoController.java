package de.jgsoftware.websitebuilder.controller;


import de.jgsoftware.websitebuilder.service.DemoPageService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/demo")
public class DemoController
{


    java.util.Locale locale;

    @Autowired
    DemoPageService demoPageService;

    @Autowired
    HttpServletRequest request;

    // load default landingpage
    @GetMapping({"demo", "/"})
    public ModelAndView demo() {

        //model.addAttribute("lgname", plgservice.getMultipagelanguage().getPageLanguageText());
        //model.addAttribute("productList", indexservice.getDaoProduct().getProductsforLandingpage());
        ModelAndView mv = new ModelAndView("demo");


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
         *   Bootstrap VALUES for Navigation Bar
         *   class = navbar // Bootstrap
         */
        mv.addObject("webtextcomp", demoPageService.getDemopreview().getPageNav());


        System.out.print("Der DemoController wurde geladen");

        return mv;
    }

}
