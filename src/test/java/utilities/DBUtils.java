package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {


    private static Connection connection;
    private static Statement statement;

    //1.Adim; connection olusturalim
    public static Connection connectionOlustur(String hostname, String databaseismi, String username, String pasword) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //url syntax:

        String url ="jdbc:postgresql://"+hostname+":5432/"+ databaseismi;
        try {
            connection= DriverManager.getConnection(url,username, pasword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static  Statement statementOlustur(){
        try {
            statement= connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;


    }

    public static void connectionStatementKapat(){

        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
