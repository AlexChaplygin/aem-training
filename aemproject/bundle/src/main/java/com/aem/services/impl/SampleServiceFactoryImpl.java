package com.aem.services.impl;

import com.aem.services.SampleService;
import com.aem.services.SampleServiceFactory;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.service.component.ComponentContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chaplygin on 27.06.2017.
 */

@Component(immediate = true, metatype = true, label = "SampleServiceFactoryConfig", policy = ConfigurationPolicy.REQUIRE, configurationFactory = true)
@Service
@Property(name = "SampleServiceFactoryImpl name", value = "value", label = "Include type", description = "Type of generated include tags", options = {
                @PropertyOption(name = "SSI", value = "Apache SSI"),
                @PropertyOption(name = "ESI", value = "ESI"),
                @PropertyOption(name = "JSI", value = "Javascript") })
public class SampleServiceFactoryImpl implements SampleServiceFactory {

    @Property
    private static final String PROP_1="prop1";

    private String id;

    @Activate
    @Modified
    public void activate(Map<String, Object> properties){
        id = PropertiesUtil.toString(properties.get(PROP_1), "null");
    }

    public String getId() {
        return id;
    }
}
