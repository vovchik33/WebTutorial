package edu.tutorial.web.db.statements;

import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by devsnotes2014@gmail.com on 22.01.2015.
 */
public class Statement {
    protected String sqlRequest;
    protected PreparedStatement preparedStatement;
    private Logger logger;

    public ResultSet resultSet;

    {
        logger = Logger.getLogger(Statement.class);
    }


    Statement(String sqlRequest) {
        this.sqlRequest = sqlRequest;
        logger.info("Statement created.");
        try {
            preparedStatement = StatementManager.getConnection().prepareStatement(sqlRequest);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Statement getStatement(String name) {
        return StatementManager.getStatement(name);
    }

    public ResultSet execute() {
        logger.info("Execute SQL request.");
        try {
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
