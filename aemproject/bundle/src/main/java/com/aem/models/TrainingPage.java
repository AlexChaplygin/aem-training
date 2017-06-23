package com.aem.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

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

    @PostConstruct
    protected void activate(){
        path = resource.getPath();
    }

    public String getTitle() {
        return title;
    }

    public Resource getResource() {
        return resource;
    }
}
