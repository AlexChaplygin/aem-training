package com.aem.servlets;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ModifiableValueMap;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.OptingServlet;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by chaplygin on 23.06.2017.
 */

@SlingServlet(
        label = "Samples - Sling All Methods Servlet",
        description = "Sample implementation of a Sling All Methods Servlet.",
//        paths = { "/services/all-sample" },
        methods = { "GET", "POST" }, // Ignored if paths is set - Defaults to GET if not specified
//        resourceTypes = { "sling/servlet/default" }, // Ignored if paths is set все запросы ловит
        resourceTypes = { "nt/unstructured" }, // Ignored if paths is set
        selectors = { "print.a4" }, // Ignored if paths is set
        extensions = { "html" }  // Ignored if paths is set
)
public class TestServlet extends SlingAllMethodsServlet {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private ResourceResolver resourceResolver;

    @Override
    protected final void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws
            ServletException, IOException {
        logger.info("POST TestServlet");
    }

    @Override
    protected final void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws
            ServletException, IOException {
        logger.info("GET TestServlet");
    }


    public boolean accepts(SlingHttpServletRequest slingHttpServletRequest) {
        return true;
    }
}
