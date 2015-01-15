package edu.tutorial.web.db;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by vladimirkr on 1/14/2015.
 */
public class DBConnector {
    private static final String DB_URL = "jdbc:sqlite:\\Lesson_0003.db";
    private Driver driver;
    private Connection connection;

    private Logger logger;

    {
        logger = Logger.getLogger(DBConnector.class);
    }
    public DBConnector() {
        logger.info("DBConnector creation...");
        try {
            driver = (Driver) Class.forName("org.sqlite.JDBC").newInstance();
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        logger.info("DBConnector creation completed");
    }

    public void showUsersNames() {
        String request = "select * from user";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                logger.info(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
