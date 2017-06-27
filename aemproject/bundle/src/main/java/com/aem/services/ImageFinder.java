package com.aem.services;

import org.apache.sling.api.resource.Resource;

import java.util.List;

/**
 * Created by chaplygin on 26.06.2017.
 */


public interface ImageFinder {

    List<String> getImagesByTag(Resource resource);

}
