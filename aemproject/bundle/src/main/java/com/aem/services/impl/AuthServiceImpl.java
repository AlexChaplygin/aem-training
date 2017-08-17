package com.aem.services.impl;

import com.aem.services.AuthService;
import com.aem.services.ResResolverProvider;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.api.resource.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

/**
 * Created by chaplygin on 26.07.2017.
 */

@Component(metatype = true, immediate = true, label = "ScheduleSampleTest")
@Service
public class AuthServiceImpl implements AuthService
{
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference
    private ResResolverProvider resResolverProvider;

    @Activate
    @Modified
    protected void activate() throws LoginException, PersistenceException, RepositoryException {
        ResourceResolver resourceResolver = resResolverProvider.getResourceResolver();

        Resource resource = resourceResolver.getResource("/apps/company-site/components/content/carousel_rich");
        ValueMap map = resource.getValueMap();
        Node node = resource.adaptTo(Node.class);
        node.setProperty("sdsf","sdfsdf");

        resourceResolver.commit();

        logger.info("Get Resource Resolver");
    }
}
