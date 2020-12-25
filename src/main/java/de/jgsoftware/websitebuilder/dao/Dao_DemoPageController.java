package de.jgsoftware.websitebuilder.dao;


import de.jgsoftware.websitebuilder.dao.interfaces.Int_m_webtextlayout;
import de.jgsoftware.websitebuilder.model.m_bootstrap_comonents;
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
    Int_m_webtextlayout int_mwebtextlayout;

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


    /**
     *
     *  SAVE DATA OVER CRUD REPOSITORY INTERFACE  -> \\ interfaces\Int_m_webtextlayout
     * @param webtextlayout save data over CrudRepository
     */
    public void saveFormModalData(m_webtextlayout webtextlayout)
    {

        int_mwebtextlayout.save(webtextlayout);

    }
}

