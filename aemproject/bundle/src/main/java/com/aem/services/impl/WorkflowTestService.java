package com.aem.services.impl;

import org.apache.felix.scr.annotations.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import javax.jcr.Repository;
import javax.jcr.SimpleCredentials;
import javax.jcr.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.jackrabbit.commons.JcrUtils;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javax.jcr.RepositoryException;

import org.apache.jackrabbit.commons.JcrUtils;

import javax.jcr.Session;
import javax.jcr.Node;
import org.osgi.framework.Constants;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//Sling Imports
import org.apache.sling.api.resource.ResourceResolverFactory ;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.Resource;
import com.day.cq.wcm.api.Page;

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
    private MessageGatewayService messageGatewayService;

    public void execute(WorkItem item, WorkflowSession wfsession, MetaDataMap args) throws WorkflowException {

            String s = "";
    }
}
