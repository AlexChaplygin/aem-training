package com.aem.servlets;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.*;
import org.apache.sling.api.servlets.OptingServlet;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chaplygin on 23.06.2017.
 */

@SlingServlet(
        label = "Samples - Sling All Methods Servlet",
        description = "Sample implementation of a Sling All Methods Servlet.",
        paths = { "/services/all-sample" },
        methods = { "GET", "POST" }, // Ignored if paths is set - Defaults to GET if not specified
        resourceTypes = { }, // Ignored if paths is set
        selectors = { "print.a4" }, // Ignored if paths is set
        extensions = { "html", "htm" }  // Ignored if paths is set
)
public class SlingModelsServlet extends SlingAllMethodsServlet implements OptingServlet {

    private static final long serialVersionUID = 1L;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private ResourceResolver resourceResolver;

    @Override
    protected final void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws
            ServletException, IOException {
        // Implement custom handling of POST requests

        // Get Request parameter value
        String newWorld = request.getParameter("world");

        // Do some work
        Resource resource = request.getResourceResolver().getResource("/content/world");
        ModifiableValueMap properties = resource.adaptTo(ModifiableValueMap.class);
        properties.put("name", newWorld);
        resource.getResourceResolver().commit();

        // Set the content type as needed
        // The repsonse type is usually closely correlated to the extension the servlet listens on.
        response.setContentType("application/json");

        // When constructing a JSON response, leverage the Sling JSON Apis
        JSONObject jsonResponse = new JSONObject();
        try {
            jsonResponse.put("success", true);
            jsonResponse.put("new-world", newWorld);
            // Write the JSON to the response
            response.getWriter().write(jsonResponse.toString(2));
            // Be default, a 200 HTTP Response Status code is used
        } catch (JSONException e) {
            logger.error("Could not formulate JSON response");
            // Servlet failures should always return an approriate HTTP Status code
            response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            // If you do not set your own HTML Response content, the OOTB HATEOS Response is used
            response.getWriter().write("ERROR");
        }
    }


    public boolean accepts(SlingHttpServletRequest slingHttpServletRequest) {
        return true;
    }
}
