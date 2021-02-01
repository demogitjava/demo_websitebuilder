package de.jgsoftware.websitebuilder.service;


import de.jgsoftware.websitebuilder.dao.Dao_DemoPageController;
import de.jgsoftware.websitebuilder.dao.Dao_DemoPagePreview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class DemoPageService
{


    @Autowired
    Dao_DemoPagePreview demopreview;

    public Dao_DemoPagePreview getDemopreview() {
        return demopreview;
    }

    public void setDemopreview(Dao_DemoPagePreview demopreview) {
        this.demopreview = demopreview;
    }
}
