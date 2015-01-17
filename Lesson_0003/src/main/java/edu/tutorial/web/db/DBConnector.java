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
    //private static final String DB_URL = "jdbc:sqlite:C:\\Users\\vladimirkr\\IdeaProjects\\WebTutorial\\Lesson_0003\\Lesson_0003.db";
    private static final String DB_URL = "jdbc:sqlite:C:\\Users\\unclejoe33\\IdeaProjects\\WebTutorial\\Lesson_0003\\Lesson_0003.db";
    private Driver driver;
    private Connection connection;
    private PreparedStatement stGetUsers;
    private PreparedStatement stAddUser;

    String reqGetUsers = "select * from user";
    String reqAddUser = "insert into user (first_name, second_name, username, password, email, sex_id, profession_id, language_id) values (?,?,?,?,?,?,?,?)";

    private Logger logger;

    {
        logger = Logger.getLogger(DBConnector.class);
    }
    public DBConnector() {
        logger.info("DBConnector creation...");
        try {
            driver = (Driver) Class.forName("org.sqlite.JDBC").newInstance();
            connection = DriverManager.getConnection(DB_URL);
            stGetUsers = connection.prepareStatement(reqGetUsers);
            stAddUser = connection.prepareStatement(reqAddUser);
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
        List<UserData> resultList=new ArrayList();
        try {
            ResultSet resultSet = stGetUsers.executeQuery();
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
    public void addUser(UserData userData) throws SQLException {
        logger.info("Users data from DB");
        //first_name, second_name, username, password, email, sex_id, profession_id, language_id
        stAddUser.setString(1, userData.getFirstName());
        stAddUser.setString(2, userData.getSecondName());
        stAddUser.setString(3, userData.getUsername());
        stAddUser.setString(4, userData.getPassword());
        stAddUser.setString(5, userData.getEmail());
        stAddUser.setInt(6, userData.getSexId());
        stAddUser.setInt(7, userData.getProfessionId());
        stAddUser.setInt(8, userData.getLanguageId());
        stAddUser.executeUpdate();
    }
}
