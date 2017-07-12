package com.aem.services.impl;

import com.day.cq.replication.ReplicationAction;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingConstants;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

/**
 * Created by chaplygin on 28.06.2017.
 */

@Component(metatype = true)
@Service(EventHandler.class)
@Properties({@Property(name = EventConstants.EVENT_TOPIC,
        value = {SlingConstants.TOPIC_RESOURCE_ADDED,
                SlingConstants.TOPIC_RESOURCE_CHANGED,
                SlingConstants.TOPIC_RESOURCE_REMOVED}),
        @Property(name = EventConstants.EVENT_FILTER, value = {"(path=/content/*)"})}
)
public class SampleEventHandlerImpl implements EventHandler {

    public void handleEvent(Event event) {
        String s = "";
//        ReplicationAction.EVENT_TOPIC
    }
}
