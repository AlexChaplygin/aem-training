package com.aem.community;

import java.io.IOException;

import javax.servlet.ServletException;

import com.aem.models.TrainingPage;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.request.RequestPathInfo;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chaplygin on 23.06.2017.
 */

@SlingServlet(paths="/bin/slingmodel", methods="GET")
public class SlingModelsServlet extends SlingAllMethodsServlet{

    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private ResourceResolver resourceResolver;

    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)throws ServletException,IOException{
        logger.info("inside sling model test servlet");
        response.setContentType("text/html");
        try {
            resourceResolver = request.getResourceResolver();

            String s = request.getPathInfo();
            RequestPathInfo pathinfo = request.getRequestPathInfo();

            Resource resource = resourceResolver.resolve("/content/kdad/training-general-page/page-stage/jcr:content");
            ValueMap valueMap=resource.adaptTo(ValueMap.class);

            response.getWriter().write("Output from ValueMap is template: "+valueMap.get("cq:template").toString()+"");

            TrainingPage trainingPage = resource.adaptTo(TrainingPage.class);
            response.getWriter().write("Output from Sling Model is title: "+trainingPage.getTitle()+" Resource: "+trainingPage.getResource()+" Path: "+trainingPage.getResource().getPath());

        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }


}
