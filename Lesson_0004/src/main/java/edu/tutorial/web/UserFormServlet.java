package edu.tutorial.web;

import edu.tutorial.web.db.statements.Statement;
import edu.tutorial.web.db.statements.StatementManager;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by devsnotes2014@gmail.com on 22.01.2015.
 */
public class UserFormServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/web_lesson_0004";
    private static final String DB_USER = "msadmin";
    private static final String DB_PASS = "msadmin";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";


    private Driver driver;
    private Connection connection;

    private Map<String, Statement> statementMap;
    private Logger logger;
    {
        BasicConfigurator.configure();
        logger = Logger.getLogger(UserFormServlet.class);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    public void init() throws ServletException {
        logger.info("Servlet initialized.");

        try {
            driver = (Driver) Class.forName(JDBC_DRIVER).newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            logger.info("DB connected.");
            StatementManager.setConnection(connection);

            statementMap = new HashMap<String, Statement>();
            statementMap.put("allUsers", Statement.getStatement("select * from user"));
            statementMap.put("allLanguages", Statement.getStatement("select * from languages"));
            statementMap.put("allSexes", Statement.getStatement("select * from sex"));
            statementMap.put("allProfessions", Statement.getStatement("select * from profession"));

            ResultSet resultSet = statementMap.get("allUsers").execute();
            while (resultSet.next()) {
                logger.info(resultSet.getString("name"));
                logger.info(resultSet.getString("pass"));
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        logger.info("Servlet destroyed.");
    }
}
