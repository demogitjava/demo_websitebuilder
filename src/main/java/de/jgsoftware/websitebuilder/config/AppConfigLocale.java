package de.jgsoftware.websitebuilder.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;


@Configuration
public class AppConfigLocale extends WebMvcConfigurerAdapter
{



    @Bean
    public Object localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.GERMANY);

        return sessionLocaleResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor()
    {


        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("language");
        //return lci;

        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
        //registry.addInterceptor(servletInterceptor_lang);
    }



}



