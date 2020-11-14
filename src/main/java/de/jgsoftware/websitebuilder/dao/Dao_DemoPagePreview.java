package de.jgsoftware.websitebuilder.dao;

import de.jgsoftware.websitebuilder.model.m_webtextlayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class Dao_DemoPagePreview
{

    @Autowired
    private JdbcTemplate jtm;


    // return Navbar Items to DemoPageController
    public List<m_webtextlayout> getPageNav()
    {
        List<m_webtextlayout> pagenavbar = jtm.query("select * from webtextlayout where comp_name like 'navbar'", new BeanPropertyRowMapper(m_webtextlayout.class));

        return pagenavbar;
    }

}
