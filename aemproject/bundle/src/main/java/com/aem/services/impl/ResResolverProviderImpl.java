package com.aem.services.impl;

import com.aem.services.ResResolverProvider;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chaplygin on 26.07.2017.
 */

@Component(immediate = true, metatype = true)
@Service
public class ResResolverProviderImpl implements ResResolverProvider {

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    private Map<String, Object> AUTH_PROPS = null;

    private void init(){
        AUTH_PROPS = new HashMap<String, Object>();
        AUTH_PROPS.put(ResourceResolverFactory.SUBSERVICE,"reksoft-system-user");
    }

    // TODO: разобраться почему не работает с заполнением под 1.8 java
//    private static final Map<String, Object> AUTH_PROPS =
//            Collections.singletonMap(ResourceResolverFactory.SUBSERVICE,"reksoft-system-user");

    public ResourceResolver getResourceResolver() throws LoginException {

        if(AUTH_PROPS == null)
            init();

        ResourceResolver resourceResolver = resourceResolverFactory.getServiceResourceResolver(AUTH_PROPS);

        return resourceResolver;

    }


}
