package com.aem.services.impl;

import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import org.apache.felix.scr.annotations.*;
import org.apache.sling.api.resource.*;
import org.apache.sling.jcr.resource.JcrResourceConstants;
import java.util.Collections;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;

import org.osgi.framework.Constants;
import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.day.cq.mailer.MessageGatewayService;

/**
 * Created by chaplygin on 27.06.2017.
 */

@Component
@Service
@Properties({
        @Property(name = Constants.SERVICE_DESCRIPTION, value = "Test workflow process implementation."),
        @Property(name = Constants.SERVICE_VENDOR, value = "Adobe"),
        @Property(name = "process.label", value = "Test Workflow Process") })
public class WorkflowTestService implements WorkflowProcess {

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

//    @Reference
//    private MessageGatewayService messageGatewayService;

    public void execute(WorkItem item, WorkflowSession wfsession, MetaDataMap metaDataMap) throws WorkflowException {

        WorkflowData workflowData = item.getWorkflowData();

        String path = workflowData.getPayload().toString();

        ResourceResolver resourceResolver = null;
        Resource resource = null;

        Session session = wfsession.adaptTo(Session.class);

        try {

            if(path.matches("^.*dog.*")) {

                resourceResolver = getResourceResolver(session);

                resource = resourceResolver.getResource(path);

                TagManager tagManager = resourceResolver.adaptTo(TagManager.class);
                Tag tag = tagManager.createTag("training:dog", "dog", "tag dog for images");
                tagManager.setTags(resource, new Tag[]{tag});

                item.getWorkflowData().getMetaDataMap().put("metaDataMapValue", "testtttt");

                resourceResolver.commit();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ResourceResolver getResourceResolver(Session session) throws LoginException {
        return resourceResolverFactory.getResourceResolver(Collections.<String, Object>singletonMap(JcrResourceConstants.AUTHENTICATION_INFO_SESSION,
                session));
    }
}
