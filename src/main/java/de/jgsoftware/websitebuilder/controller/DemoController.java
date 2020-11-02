package de.jgsoftware.websitebuilder.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController
{



    /*

        @RequestMapping("/index")
	public ModelAndView thymeleafView(Map<String, Object> model) {
	    model.put("number", 1234);
	    model.put("message", "Hello from Spring MVC");
	    return new ModelAndView("thymeleaf/index");
	}
 public String index(Model model, Locale locale)
     */


    @RequestMapping({"/"})
    public String demo()
    {

        return "demo";
    }



    /*

        @RequestMapping("/index")
	public ModelAndView thymeleafView(Map<String, Object> model) {
	    model.put("number", 1234);
	    model.put("message", "Hello from Spring MVC");
	    return new ModelAndView("thymeleaf/index");
	}
 public String index(Model model, Locale locale)
     */




}
