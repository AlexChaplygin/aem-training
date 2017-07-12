package com.aem.services.impl;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.event.jobs.Job;
import org.apache.sling.event.jobs.consumer.JobConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.aem.services.impl.JobConsumerImpl.TOPIC;

/**
 * Created by chaplygin on 29.06.2017.
 */

@Component(metatype = true)
@Service
@Property(name = JobConsumer.PROPERTY_TOPICS, value = TOPIC)
public class JobConsumerImpl implements JobConsumer {

    public static final String TOPIC="mytopic";

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public JobResult process(Job job) {

        logger.info("Job Process "+ job.getTopic());

        return JobResult.FAILED;
    }
}
