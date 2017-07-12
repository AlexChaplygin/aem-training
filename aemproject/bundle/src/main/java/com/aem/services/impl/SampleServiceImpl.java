package com.aem.services.impl;

import com.aem.services.SampleService;
import com.aem.services.SampleServiceFactory;
import com.aem.services.WorkflowStarterTest;
import com.day.cq.workflow.WorkflowException;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.api.resource.LoginException;
import org.osgi.service.component.ComponentContext;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

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

    @Property(label = "propertyConfigFileF")
    private static final String PROP_4F_NAME = "prop4f";

    private List<String> propertiesValues;

//    @Reference(target = "(prop1=val1)")
//    private SampleServiceFactory sampleServiceFactory;

    // можно просто inject без bund unbind
    @Reference(cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE, referenceInterface = SampleServiceFactory.class,
            policy = ReferencePolicy.DYNAMIC, bind = "bindService", unbind = "unbindService")
    private List<SampleServiceFactory> sampleServiceFactories = new ArrayList<SampleServiceFactory>();

    public void bindService(SampleServiceFactory sampleServiceFactory){
        sampleServiceFactories.add(sampleServiceFactory);
    }

    public void unbindService(SampleServiceFactory sampleServiceFactory){
        sampleServiceFactories.remove(sampleServiceFactory);
    }

    @Inject
    private List<SampleService> sampleServiceFactories1;

    @Reference
    private WorkflowStarterTest workflowStarterTest;

    @Activate
    @Modified
//    public void activate(Map<String, Object> properties){
    public void activate(ComponentContext componentContext) throws LoginException, WorkflowException {

//        workflowStarterTest.startWorkflow();


//        String property = componentContext.getProperties().get("prop4").toString();

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
