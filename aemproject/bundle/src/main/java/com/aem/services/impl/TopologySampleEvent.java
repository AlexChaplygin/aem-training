package com.aem.services.impl;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.discovery.TopologyEvent;
import org.apache.sling.discovery.TopologyEventListener;

/**
 * Created by chaplygin on 29.06.2017.
 */

@Component(metatype = true)
@Service(TopologySampleEvent.class)
public class TopologySampleEvent implements Runnable,TopologyEventListener{

    public void handleTopologyEvent(TopologyEvent topologyEvent) {
        String s ="";
    }

    public void run() {
        String s ="";
    }
}
