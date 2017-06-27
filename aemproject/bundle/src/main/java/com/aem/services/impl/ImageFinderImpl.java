package com.aem.services.impl;

import com.aem.services.ImageFinder;
import com.day.cq.dam.api.Asset;
import com.day.cq.dam.commons.util.DamUtil;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.Resource;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.Query;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.result.SearchResult;

import javax.jcr.Session;
import java.util.*;

/**
 * Created by chaplygin on 26.06.2017.
 */

@Component(immediate = true)
@Service
public class ImageFinderImpl implements ImageFinder {

    private List<String> imagePathArrayList = null;

    private Asset imageAsset = null;

    public List<String> getImagesByTag(Resource resource, String [] tags){

        imagePathArrayList = new ArrayList<String>();

        Session session = resource.getResourceResolver().adaptTo(Session.class);
        QueryBuilder queryBuilder = resource.getResourceResolver().adaptTo(QueryBuilder.class);

        Map<String, String> predicates = new HashMap<String, String>();
        predicates.put("path", "/content/dam");
        predicates.put("type", "dam:Asset");
        predicates.put("group.p.or", "true");

        for(int i =0; i<tags.length; i++)
            predicates.put("group."+i+"_fulltext", tags[i]);
        predicates.put("group.fulltext.realPath", "jcr:content/metadata/cq:tags");

        Query query = queryBuilder.createQuery(PredicateGroup.create(predicates), session);

        SearchResult result = query.getResult();
        Iterator<Resource> resultResources = result != null ? result.getResources() : null;

        while(resultResources.hasNext()){

            imageAsset = DamUtil.resolveToAsset(resultResources.next());

            imagePathArrayList.add(imageAsset.getRenditions().get(1).getPath());
        }

        return imagePathArrayList;

    }

}
