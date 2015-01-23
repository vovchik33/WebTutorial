package edu.tutorial.web.db.statements;

import edu.tutorial.web.db.statements.Statement;

import java.sql.Connection;

/**
 * Created by devsnotes2014@gmail.com on 22.01.2015.
 */
public class StatementManager {
    private static Connection connection;

    public static Statement getStatement(String sqlRequest) {
        return new Statement(sqlRequest);
    }

    public static void setConnection(Connection connection) {
        StatementManager.connection = connection;
    }

    public static Connection getConnection() {
        return connection;
    }
}
