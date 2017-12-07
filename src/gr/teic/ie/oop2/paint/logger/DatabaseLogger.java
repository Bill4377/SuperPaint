
package gr.teic.ie.oop2.paint.logger;

import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseLogger implements MyLogger{
    
    private static String dbURL = "jdbc:derby://localhost:1527/logsdb";
    private static String tableName = "LOGS";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;
    
    
    
    public DatabaseLogger(){
        
    }
    
    
    public void Connect(){
         try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
            System.out.println("Connected");
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
        
    }
    
    @Override
    public void writeLog(String s){
     
        Connect();
        try
        {
            PreparedStatement pst1  =  conn.prepareStatement("insert into LOGS (timestamp_ , value) values (? , ? )");  
            pst1.setTimestamp(1, new java.sql.Timestamp(new java.util.Date().getTime()));
            
            pst1.setString(2, s);
            pst1.executeUpdate();
            
            
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    
    
}
