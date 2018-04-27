package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.*;
import java.util.Properties;

public class Datasource   {
	
        public static final String url = "jdbc:mysql://livepromotio.mysql.database.azure.com/ticket_system";
        public static final String user = "lukelive@livepromotio";
        public static final String password = "Live1972";
        
        public static final String TABLE_USERS = "users";
        public static final String COLUMN_USER_ID = "id";
        public static final String COLUMN_USER_USERNAME = "username";
        public static final String COLUMN_USER_PASSWORD = "password";
        
        public static final String TABLE_EVENTS = "events";
        public static final String COLUMN_EVENT_ID = "EventID";
        public static final String COLUMN_EVENT_NAME = "EventName";
        public static final String COLUMN_EVENT_STARTDATE = "EventStartDate";
        public static final String COLUMN_EVENT_ENDDATE = "EventEndDate";
        public static final String COLUMN_EVENT_ADDRESSLINEONE = "EventAddressLineOne";
        public static final String COLUMN_EVENT_ADDRESSLINETWO = "EventAddressLineTwo";        
        public static final String COLUMN_EVENT_POSTCODE = "EventPostcode";
        public static final String COLUMN_EVENT_TEL = "EventTel";
        public static final String COLUMN_EVENT_TC = "EventTC";
        
        private Connection conn;
        
        public boolean open(){
        try{
            // Set connection properties.
            Properties properties = new Properties();
            properties.setProperty("user", user);
            properties.setProperty("password", password);
            properties.setProperty("useSSL", "true");
            properties.setProperty("verifyServerCertificate", "true");
            properties.setProperty("requireSSL", "false");

            // get connection
            conn = DriverManager.getConnection(url, properties);
          	System.out.println("Successfully connected to database");
        	return true;
        } catch(SQLException e){
        	System.out.println("Failed to connect to database");
        	return false;
        }
        }
        
        public void close() {
        	try{
        		if(conn != null){
        			conn.close();
        		}
        	} catch(SQLException e) {
        		System.out.println("Couldn't close connection" + e.getMessage());
        	}
        }
        
        
}