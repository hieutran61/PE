package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtils {
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
     public static Connection makeConnection()throws Exception {
        System.out.println("DBUtils begin");
        String connectionUrl = "jdbc:sqlserver://HIEUTRAN:1433;databaseName=PE_Se16_Su22;User=sa;Password=Changtrailaucaak";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(connectionUrl);
        return con;
     }
     
    public static void main(String[] args) throws Exception {
        System.out.println(DBUtils.makeConnection());
    }

     
}
