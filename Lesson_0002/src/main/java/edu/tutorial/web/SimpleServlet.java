package edu.tutorial.web;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by vladimirkr on 1/13/2015.
 */
public class SimpleServlet extends HttpServlet {
    private Logger logger;
    {
        BasicConfigurator.configure();
        logger = Logger.getLogger(SimpleServlet.class);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Request handling...");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>All parameters:</h1><br/>");
        Map<String, String[]> map = req.getParameterMap();
        for (Object key:map.keySet()) {
            for (Object value:map.get(key)) {
                writer.println("<p>" + (String) key + " - " + (String) value + "</p>");
            }
        }
        writer.println("</body></html>");
    }

    public void init() throws ServletException {
        logger.info("Servlet initialized.");
    }
}
