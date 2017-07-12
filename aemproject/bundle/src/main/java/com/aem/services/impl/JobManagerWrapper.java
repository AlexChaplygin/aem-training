package com.aem.services.impl;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.event.jobs.JobManager;

import java.util.Map;

/**
 * Created by chaplygin on 29.06.2017.
 */

@Component
@Service(JobManagerWrapper.class)
public class JobManagerWrapper {

    @Reference
    private JobManager jobManager;

    public void addJob(String topic, Map<String,Object> properties){
        jobManager.addJob(topic, properties);
    }
}
