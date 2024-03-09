package jm.task.core.jdbc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/pre-project";
    private static final String user = "alex";
    private static final String password = "alex";

    private static final String driver = "com.mysql.cj.jdbc.Driver";

    public static Connection open() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(URL, user, password);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
