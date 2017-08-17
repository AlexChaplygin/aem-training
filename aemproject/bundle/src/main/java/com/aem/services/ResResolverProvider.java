package com.aem.services;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;

/**
 * Created by chaplygin on 26.07.2017.
 */
public interface ResResolverProvider {

    ResourceResolver getResourceResolver() throws LoginException;

}
