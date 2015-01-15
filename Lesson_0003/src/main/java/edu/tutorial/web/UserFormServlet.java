package edu.tutorial.web;

import edu.tutorial.web.db.DBConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vladimirkr on 1/14/2015.
 */
public class UserFormServlet extends HttpServlet {
    private DBConnector dbConnector;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dbConnector.showUsersNames();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void init() throws ServletException {
        super.init();
        dbConnector = new DBConnector();
    }
}
