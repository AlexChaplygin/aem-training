package com.aem.models;

import com.day.cq.commons.RangeIterator;
import com.day.cq.dam.commons.util.DamUtil;
import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import com.day.cq.dam.api.Asset;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.resource.*;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.felix.scr.annotations.Reference;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jcr.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chaplygin on 25.06.2017.
 */

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ImageTagsPageModel {

    @Inject
    @Named("jcr:title")
    private String title;

    @Self
    private Resource resource;

    private String path;

    private Page page;

    private String imagePath;

    private List<String> imagePathArrayList;

    @PostConstruct
    protected void activate() throws RepositoryException, LoginException {
        imagePathArrayList = new ArrayList<String>();
        path = resource.getPath();
        Node node = resource.adaptTo(Node.class);
        Session session = resource.getResourceResolver().adaptTo(Session.class);
        // resource.getResourceResolver().adaptTo(PageManager.class)

//        ResourceResolver resourceResolver = resource.getResourceResolver();
//        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
//        Page page = pageManager.getContainingPage(resource);
//        Asset asset = DamUtil.resolveToAsset(resourceResolver.getResource(path));

        List<Resource> list = new ArrayList<Resource>();
        Iterator<Resource> iter =  resource.listChildren();
        Resource parsysResource = iter.next();
        Resource imageResource = parsysResource.listChildren().next();


        ValueMap valueMap=imageResource.adaptTo(ValueMap.class);
        TagManager tagManager = imageResource.getResourceResolver().adaptTo(TagManager.class);

        String str = ((String[])valueMap.get("cq:tags"))[0];
        Tag custTag = tagManager.resolve(str);

        RangeIterator<Resource> it = tagManager.find(str);



        while(it.hasNext()){
            Resource taggedResource = it.next().getParent();

            ValueMap taggedValueMap=taggedResource.adaptTo(ValueMap.class);

            ResourceResolver resourceResolver = taggedResource.getResourceResolver();
            Asset asset = DamUtil.resolveToAsset(resourceResolver.getResource(taggedValueMap.get("cq:parentPath").toString() + "/" +
                    taggedValueMap.get("cq:name").toString()));

            imagePathArrayList.add(asset.getRenditions().get(1).getPath());
        }

        session.save();
    }

    public String getTitle() {
        return title;
    }

    public Resource getResource() {
        return resource;
    }

    public String getImagePath() {
        return imagePath;
    }

    public List<String> getImagePathArrayList() {
        return imagePathArrayList;
    }
}
