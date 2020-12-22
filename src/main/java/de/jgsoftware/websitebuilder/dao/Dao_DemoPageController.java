package de.jgsoftware.websitebuilder.dao;


import de.jgsoftware.websitebuilder.model.m_bootstrap_comonents;
import de.jgsoftware.websitebuilder.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import de.jgsoftware.websitebuilder.model.m_webtextlayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    // returns all entriys from stored Bootstrap Compoents
    // with ${ value } for mapping to Theamyleaf
    public List<m_bootstrap_comonents> getBootstrapComponents()
    {

        // query("select * from bootstrap_components", new BeanPropertyRowMapper(m_bootstrap_comonents.class));

       // SqlRowSet rs = select.queryForRowSet(query, new HashMap<String, Object>());
        List<m_bootstrap_comonents> bootstrap_comonents = jtm.query("select * from BOOTSTRAP_COMPONENTS", new BeanPropertyRowMapper(m_bootstrap_comonents.class));

        return bootstrap_comonents;
    }


}
