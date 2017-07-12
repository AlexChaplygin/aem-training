package com.aem.services.impl;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.api.SlingRepository;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.observation.EventListener;

/**
 * Created by chaplygin on 28.06.2017.
 */

@Component
public class ObserverComponent implements EventListener {

    @Reference
    private SlingRepository slingRepository;

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Activate
    public void activate(){
        try {
            Session session = slingRepository.loginAdministrative(null);
            session.getWorkspace().getObservationManager().addEventListener(this,
                    Event.PROPERTY_CHANGED | Event.PROPERTY_REMOVED,
                    "/content/kdad", true, null, null, false);
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }

    public void onEvent(EventIterator eventIterator) {
        Event event = eventIterator.nextEvent();

        String s = "";
    }
}
