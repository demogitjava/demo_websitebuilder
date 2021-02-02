package de.jgsoftware.websitebuilder.dao;


import de.jgsoftware.websitebuilder.dao.interfaces.Int_m_webtextlayout;
import de.jgsoftware.websitebuilder.model.m_bootstrap_components;
import de.jgsoftware.websitebuilder.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import de.jgsoftware.websitebuilder.model.m_webtextlayout;

import java.util.List;
import java.io.*;

@Repository
public class Dao_DemoPageController
{

    @Autowired
    Int_m_webtextlayout int_mwebtextlayout;

    @Autowired
    private JdbcTemplate jtm;

    @Lazy
    @Autowired
    private IndexService sdemowebtext;


    public static String demopage;
    public static String headerpage;

    // returns all entriys from Table
    public List<m_webtextlayout> getPageLanguageText()
    {
        List<m_webtextlayout> webtextlayouts = jtm.query("select * from webtextlayout", new BeanPropertyRowMapper(m_webtextlayout.class));

        return webtextlayouts;
    }


    // returns all entriys from stored Bootstrap Compoents
    // with ${ value } for mapping to Theamyleaf
    public List<m_bootstrap_components> getBootstrapComponents()
    {

        // query("select * from bootstrap_components", new BeanPropertyRowMapper(m_bootstrap_comonents.class));

       // SqlRowSet rs = select.queryForRowSet(query, new HashMap<String, Object>());
        List<m_bootstrap_components> bootstrap_comonents = jtm.query("select * from BOOTSTRAP_COMPONENTS", new BeanPropertyRowMapper(m_bootstrap_components.class));

        return bootstrap_comonents;
    }


    /**
     *
     *  SAVE DATA OVER CRUD REPOSITORY INTERFACE  interfaces\Int_m_webtextlayout
     *  webtextlayout save data over CrudRepository
     */
    public void saveFormModalData(m_webtextlayout webtextlayout)
    {

        int_mwebtextlayout.save(webtextlayout);

    }

    /*
            save File
            with name header.html
            and header.css
     */
    public void saveheaderfile(String gjshtml, String gjscss)
    {
        try
        {
            // header.html
            FileWriter headerhtml = new FileWriter("header.html");
            headerhtml.write(gjshtml.toString());
            headerhtml.close();

            // header.css
            FileWriter headercss = new FileWriter("header.css");
            headercss.write(gjscss.toString());
            headercss.close();

        } catch (Exception e)
        {
            System.out.print("Error" + e);
        }
    }

    /**
     *  save content
     *  content.html
     *  content.css
     */
    public void savecontentfile(String gjshtml, String gjscss)
    {
        try
        {
            // header.html
            FileWriter contenthtml = new FileWriter("content.html");
            contenthtml.write(gjshtml.toString());
            contenthtml.close();

            // header.css
            FileWriter contentcss = new FileWriter("content.css");
            contentcss.write(gjscss.toString());
            contentcss.close();


        } catch (Exception e)
        {
            System.out.print("Error" + e);
        }
    }


    /**
     *  save content
     *  content.html
     *  content.css
     */
    public void savefooterfile(String gjshtml, String gjscss)
    {
        try
        {
            // header.html
            FileWriter footerhtml = new FileWriter("footer.html");
            footerhtml.write(gjshtml.toString());
            footerhtml.close();

            // header.css
            FileWriter footercss = new FileWriter("footer.css");
            footercss.write(gjscss.toString());
            footercss.close();


        } catch (Exception e)
        {
            System.out.print("Error" + e);
        }
    }


    /*
        include demopage as default
        to grapesjs editor
     */
    public String loaddefaultpagetograpesjs()
    {
        demopage = new String("demo.html");

        return demopage;
    }


    public String loadheaderpagetograpesjs()
    {
        headerpage = new String("header.html");
        return headerpage;

    }

    public static String getDemopage() {
        return demopage;
    }

    public static void setDemopage(String demopage) {
        Dao_DemoPageController.demopage = demopage;
    }

    public static String getHeaderpage() {
        return headerpage;
    }

    public static void setHeaderpage(String headerpage) {
        Dao_DemoPageController.headerpage = headerpage;
    }
}

