package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpasswprd";
    private static final String CONN = "jdbc:mysql://localhost/login";
    private static final String SQCONN = "jdbc:sqlite:school.sqlite";

    public static Connection getConnetciton() throws SQLException {

        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:school.sqlite");
        }
        catch (ClassNotFoundException|SQLException ex){
            ex.printStackTrace();
        }
        return null;

    }
}
