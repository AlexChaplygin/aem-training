package com.aem.services.impl;

import com.aem.services.SampleService;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.service.component.ComponentContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by chaplygin on 26.06.2017.
 */

@Component(immediate = true, metatype = true, label = "SampleServiceConfig", policy = ConfigurationPolicy.REQUIRE)
@Service
@Properties({
    @Property(name = "prop1", value = "val1"),
    @Property(name = "prop2", value = "val2")
})
public class SampleServiceImpl implements SampleService{

    @Property(value = "val3")
    private static final String PROP_3_NAME = "prop3";

    @Property(label = "propertyConfigFile")
    private static final String PROP_4_NAME = "prop4";

    private List<String> propertiesValues;

    @Activate
    @Modified
//    public void activate(Map<String, Object> properties){
    public void activate(ComponentContext componentContext){

        propertiesValues = new ArrayList<String>();

        String property = componentContext.getProperties().get("prop4").toString();

//        propertiesValues.add(PropertiesUtil.toString(properties.get("prop1"), "null"));
//        propertiesValues.add(PropertiesUtil.toString(properties.get("prop2"), "null"));
//        propertiesValues.add(PropertiesUtil.toString(properties.get("prop3"), "null"));

        String s = "";
    }

    @Deactivate
    public void deactivate(){
        String s = "";
    }

    public void test() {
        String s = "";
    }
}
