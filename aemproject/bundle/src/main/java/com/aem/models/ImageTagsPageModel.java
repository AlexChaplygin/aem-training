package com.aem.models;

import com.aem.services.ImageFinder;
import org.apache.sling.api.resource.*;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jcr.*;
import java.util.*;

/**
 * Created by chaplygin on 25.06.2017.
 */

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ImageTagsPageModel {

    @Inject
    @Named("jcr:title")
    private String title;

    @Inject
    private ImageFinder imageFinder;

    @Self
    private Resource resource;

    private List<String> imagePathArrayList;

    @PostConstruct
    protected void activate() throws RepositoryException, LoginException {

        imagePathArrayList = new ArrayList<String>();

        imagePathArrayList = imageFinder.getImagesByTag(resource);
    }

    public String getTitle() {
        return title;
    }

    public Resource getResource() {
        return resource;
    }

    public List<String> getImagePathArrayList() {
        return imagePathArrayList;
    }
}
