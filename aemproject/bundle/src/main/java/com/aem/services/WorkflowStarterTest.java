package com.aem.services;

import com.day.cq.workflow.WorkflowException;
import org.apache.sling.api.resource.LoginException;

/**
 * Created by chaplygin on 28.06.2017.
 */
public interface WorkflowStarterTest {
    void startWorkflow() throws LoginException, WorkflowException;
}
