package edu.tutorial.web;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by vladimirkr on 1/12/2015.
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
        logger.info("Process doGet");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>Hello, servlet</body></html>");
        logger.info("Complete doGet");
    }

    public void init() throws ServletException {
        logger.info("INIT");
    }
}
