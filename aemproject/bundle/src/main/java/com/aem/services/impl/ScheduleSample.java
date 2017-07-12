package com.aem.services.impl;

import org.apache.felix.scr.annotations.*;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by chaplygin on 29.06.2017.
 */
@Component(metatype = true, immediate = true, label = "ScheduleSampleTest")
@Service
@Properties({
        @Property(name = "scheduler.expression", value = "*/30 * * * * ?",
                description = "Cron-job expression"),
        @Property(name = "scheduler.concurrent", boolValue=false,
                description = "Whether or not to schedule this task concurrently")
})
public class ScheduleSample implements Runnable {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference
    private JobManagerWrapper jobManagerWrapper;

    private Map<String,Object> properties;

    @Property
    private static final String PROP_1="prop1" ;

    private String property;

    public void run() {
        logger.info("ScheduleSample RUN "+property);

        jobManagerWrapper.addJob(JobConsumerImpl.TOPIC, properties);
    }

    @Activate
    @Modified
    public void activate(Map<String,Object> map){

        property = PropertiesUtil.toString(map.get(PROP_1), "null");

        properties = map;

        logger.info("Activate ScheduleSample property: "+property);


    }
}
