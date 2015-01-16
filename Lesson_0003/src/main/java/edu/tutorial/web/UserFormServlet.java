package edu.tutorial.web;

import edu.tutorial.web.bean.UserData;
import edu.tutorial.web.db.DBConnector;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by vladimirkr on 1/14/2015.
 */
public class UserFormServlet extends HttpServlet {
    private DBConnector dbConnector;
    private Logger logger;
    {
        BasicConfigurator.configure();
        logger = Logger.getLogger(UserFormServlet.class);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Handle Form request");
        logger.info("Request parameters:");
        Map<String, String[]> parametersMap = req.getParameterMap();
        UserData userData = new UserData.Builder(parametersMap).build();
        logger.info(userData.toString());
        req.setAttribute("userData", userData);
        req.getRequestDispatcher("complete.jsp").forward(req, resp);
        //resp.sendRedirect("complete.jsp");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void init() throws ServletException {
        super.init();
        dbConnector = new DBConnector();
    }
}
