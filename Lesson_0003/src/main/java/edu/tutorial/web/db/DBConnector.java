package edu.tutorial.web.db;

import edu.tutorial.web.bean.UserData;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladimirkr on 1/14/2015.
 */
public class DBConnector {
    private static final String DB_URL = "jdbc:sqlite:C:\\Users\\vladimirkr\\IdeaProjects\\WebTutorial\\Lesson_0003\\Lesson_0003.db";
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

    public List<UserData> getUsers() {
        logger.info("Users data from DB");
        String request = "select * from user";
        List<UserData> resultList=new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while (resultSet.next()) {
                UserData userData = new UserData.Builder()
                        .setId(Integer.parseInt(resultSet.getString("id")))
                        .setFirstName(resultSet.getString("first_name"))
                        .setSecondName(resultSet.getString("second_name"))
                        .setUsername(resultSet.getString("username"))
                        .setPassword(resultSet.getString("password"))
                        .setEmail(resultSet.getString("email"))
                        .setSexId(Integer.parseInt(resultSet.getString("sex_id")))
                        .setProfessionId(Integer.parseInt(resultSet.getString("profession_id")))
                        .setLanguageId(Integer.parseInt(resultSet.getString("language_id")))
                        .build();
                resultList.add(userData);
                logger.info(userData.toString());
            }
            logger.info("All data updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }
    public void addUser(UserData userData) {

    }
}
