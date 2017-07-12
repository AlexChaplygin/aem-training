package com.aem.services.impl;

import com.aem.services.WorkflowStarterTest;
import com.day.cq.workflow.WorkflowException;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import com.day.cq.workflow.model.WorkflowModel ;
import com.day.cq.workflow.WorkflowService ;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkflowData;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Session;

/**
 * Created by chaplygin on 28.06.2017.
 */

@Component(immediate = true, metatype = true)
@Service
public class WorkflowStarterTestImpl implements WorkflowStarterTest {

    @Reference
    private WorkflowService workflowService;

    private Session session;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    public void startWorkflow() throws LoginException, WorkflowException {

        logger.info("sdfsfsdfsdfsdf");

        session = resourceResolverFactory.getAdministrativeResourceResolver(null).adaptTo(Session.class);

        WorkflowSession wfSession = workflowService.getWorkflowSession(session);

// Get the workflow model
        WorkflowModel wfModel = wfSession.getModel("/etc/workflow/models/trainingworkflow/jcr:content/model");

// Get the workflow data
// The first param in the newWorkflowData method is the payloadType.  Just a fancy name to let it know what type of workflow it is working with.
        WorkflowData wfData = wfSession.newWorkflowData("JCR_PATH", "/content/dam/kdad/images/IMG_20151030_093307.jpg/jcr:content/renditions/original");

// Invoke the Workflow
        wfSession.startWorkflow(wfModel, wfData);
    }
}
