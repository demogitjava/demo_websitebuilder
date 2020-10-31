package de.jgsoftware.websitebuilder.dao;


import de.jgsoftware.websitebuilder.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import de.jgsoftware.websitebuilder.model.m_webtextlayout;

import java.util.List;

@Repository
public class Dao_DemoPageController
{

    @Autowired
    private JdbcTemplate jtm;

    @Autowired
    private IndexService sdemowebtext;

    // returns all entriys from Table
    public List<m_webtextlayout> getPageLanguageText()
    {
        List<m_webtextlayout> webtextlayouts = jtm.query("select * from webtextlayout", new BeanPropertyRowMapper(m_webtextlayout.class));

        return webtextlayouts;
    }


}
