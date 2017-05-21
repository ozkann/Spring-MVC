package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	
	public static Connection getConnect(){
		Connection connection = null; 
	
	
	String url = "jdbc:mysql://localhost:3306/testDB?useSSL=false";
    String user = "root";
    String password = "12345";
    try {
       connection = DriverManager.getConnection(url, user, password);
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
	return connection;
    
    
    
	
	
	}

}
