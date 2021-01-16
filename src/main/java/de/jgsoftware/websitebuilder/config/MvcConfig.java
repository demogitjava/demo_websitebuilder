package de.jgsoftware.websitebuilder.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer
{

    @Autowired
    private AppConfigLocale appConfigLocale;


    public void addViewControllers(ViewControllerRegistry registry)
    {

        registry.addViewController("/").setViewName("de");

        registry.addViewController("/en/").setViewName("en");
        registry.addViewController("/es/").setViewName("es");
        registry.addViewController("/fr/").setViewName("fr");
        registry.addViewController("/it/").setViewName("it");
        registry.addViewController("/tr/").setViewName("tr");

        registry.addViewController("/demo/").setViewName("demo");
        registry.addViewController("/admin/").setViewName("admin");
        registry.addViewController("/profile/").setViewName("profile");
        registry.addViewController("/login/").setViewName("login");
        registry.addViewController("/manager/").setViewName("manager");

    }

    public AppConfigLocale getAppConfigLocale() {
        return appConfigLocale;
    }
    public void setAppConfigLocale(AppConfigLocale appConfigLocale) {
        this.appConfigLocale = appConfigLocale;
    }
}