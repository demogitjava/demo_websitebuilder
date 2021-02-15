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
import javax.servlet.http.HttpServletResponse;

import de.jgsoftware.websitebuilder.model.m_bootstrap_components;
import static java.nio.charset.StandardCharsets.*;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexPageController {

    @Autowired
    public DemoPageService demoPageService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    public IndexService idexservice;

    public ModelAndView mv;

    public String loadtemplatetograpesjs;
    public String loaddefautlpage;

    // load default landingpage
    @GetMapping({"index", "/"})
    public ModelAndView index() {

        //model.addAttribute("lgname", plgservice.getMultipagelanguage().getPageLanguageText());
        //model.addAttribute("productList", indexservice.getDaoProduct().getProductsforLandingpage());
        mv = new ModelAndView("index");
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


        /*
            load default html page like

            header.html
            bodycontent.html
            or footer.html to grapesjs
         */
        DemoController democtrl = new DemoController();
        mv.addObject("loadnavigationtogjs", democtrl);



        /*
            load defautl html page to grapesjs
            and display in editor
         */

        mv.addObject("defaultpage", idexservice.getDcontroller().loaddefaultpagetograpesjs()); // default is demo.html set to grapesjs



        ArrayList loadfragments = new ArrayList();
        loadfragments.add("header");
        loadfragments.add("bodycontent");
        loadfragments.add("footer");

        mv.addObject("loadfragments", loadfragments);


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


    /*
        load default header
        template
     */
    @RequestMapping("/header")
    public String demoheader()
    {
        return "redirect:/header/";
    }


    /*
            load navigation menu to
            grapesjs
     */
    @RequestMapping("/loadenavigationmenu")
    public String loadnavigatiomenu()
    {

        return "redirect:/";
    }


    @GetMapping("login")
    public String login() {
        return "login";
    }


    /**
     * save data to header.html and header.css
     * over post from editor to file
     * @param gjshtml
     * @param gjscss
     * @return
     */

    @RequestMapping("/saveheaderdata")
    @ResponseBody
    public String header(
            @RequestParam(value = "gjshtml", required = false) String gjshtml,
            @RequestParam(value = "gjscss", required = false) String gjscss)
          // HttpServletRequest request, HttpServletResponse response)
    {


        idexservice.getDcontroller().saveheaderfile(gjshtml, gjscss);
        System.out.print("das ist htmlgsjs");

        return "header data saved";
    }


    /**
     *  save content to file
     *  content.html
     *  content.css
     *
     * @param gjshtml
     * @param gjscss
     * @return
     */
    @RequestMapping("/savecontentdata")
    @ResponseBody
    public String content(
            @RequestParam(value = "gjshtml", required = false) String gjshtml,
            @RequestParam(value = "gjscss", required = false) String gjscss)
    // HttpServletRequest request, HttpServletResponse response)
    {


        idexservice.getDcontroller().savecontentfile(gjshtml, gjscss);

        return "content data saved";
    }


    /**
     *  save footer to file
     *  footer.html
     *  footer.css
     *
     * @param gjshtml
     * @param gjscss
     * @return
     */
    @RequestMapping("/savefooterdata")
    @ResponseBody
    public String footer(
            @RequestParam(value = "gjshtml", required = false) String gjshtml,
            @RequestParam(value = "gjscss", required = false) String gjscss)
    // HttpServletRequest request, HttpServletResponse response)
    {


        idexservice.getDcontroller().savefooterfile(gjshtml, gjscss);

        return "content data saved";
    }



    /**
     *  save footer to file
     *  footer.html
     *  footer.css
     *
     * @param gjshtml
     * @param gjscss
     * @return
     */
    @RequestMapping("/getNavheaderdata")
    @ResponseBody
    public String navheader(
            @RequestParam(value = "gjshtml", required = false) String gjshtml)

    // HttpServletRequest request, HttpServletResponse response)
    {


        List<m_bootstrap_components> lbtcomp = idexservice.getDcontroller().getBootstrapComponents();
        String htmldata = (String) lbtcomp.get(0).getCompname();

        return htmldata;
    }


    /*
        override default loading page "demo.html"
        to header.html
     */

    @RequestMapping(value = "/loadnavigationmenu", method = RequestMethod.POST)
    public String loadheaderfragment(@RequestParam("headerfragment") String headerfragment)
    {


        headerfragment = idexservice.getDcontroller().loadheaderpagetograpesjs();  // header.html
        String defaultpage = idexservice.getDcontroller().loaddefaultpagetograpesjs();  // demo.html

        index().getModel().replace("defaultpage", idexservice.getDcontroller().loadheaderpagetograpesjs()); // header.html

        // your logic here
        return "redirect:/";
    }
}