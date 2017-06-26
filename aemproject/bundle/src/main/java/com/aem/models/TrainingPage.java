package com.aem.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
//import com.day.cq.commons.jcr.JcrConstants;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.commons.jcr.JcrConstants;

/**
 * Created by chaplygin on 23.06.2017.
 */

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TrainingPage {

    @Inject
    @Named("jcr:title")
    private String title;

    @Self
    private Resource resource;

    private String path;

    private Page page;

    @PostConstruct
    protected void activate() throws RepositoryException {
        path = resource.getPath();
        Node node = resource.adaptTo(Node.class);
        Session session = resource.getResourceResolver().adaptTo(Session.class);
        // resource.getResourceResolver().adaptTo(PageManager.class)
        node.setProperty("prop1", (String)null);
        session.save();
    }

    public String getTitle() {
        return title;
    }

    public Resource getResource() {
        return resource;
    }
}
