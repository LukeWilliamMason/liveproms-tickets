package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.Properties;

public class Datasource   {
	
        public static final String url = "jdbc:mysql://livepromotio.mysql.database.azure.com/ticket_system";
        public static final String user = "lukelive@livepromotio";
        public static final String password = "Live1972";
        
        public static final String TABLE_USERS = "users";
        public static final String COLUMN_USER_USERNAME = "username";
        public static final String COLUMN_USER_PASSWORD = "password";
        
        public static final String TABLE_EVENTS = "events";
        public static final String COLUMN_EVENT_NAME = "eventName";
        public static final String COLUMN_EVENT_STARTDATETIME = "eventStartDateTime";
        public static final String COLUMN_EVENT_ENDDATETIME = "eventEndDateTime";
        public static final String COLUMN_EVENT_CREATED = "eventCreated";
        public static final String COLUMN_EVENT_INFO = "eventInfo";
        public static final String COLUMN_EVENT_TC = "eventTC";
        
        public static final String TABLE_VENUES = "venues";
        public static final String COLUMN_VENUE_NAME = "venueName";
        public static final String COLUMN_VENUE_ADDRESSLINEONE = "venueAddressLineOne";
        public static final String COLUMN_VENUE_ADDRESSLINETWO = "venueAddressLineTwo";        
        public static final String COLUMN_VENUE_POSTCODE = "venuePostcode";
        public static final String COLUMN_VENUE_TOWNCITY = "venueTownCity";
        public static final String COLUMN_VENUE_TEL = "venueTelephone";
        public static final String COLUMN_VENUE_EMAIL = "venueEmail";
        
        public static final String TABLE_TICKETS = "tickets";
        public static final String COLUMN_TICKET_NAME = "ticketName";
        public static final String COLUMN_TICKET_PRICE = "ticketPrice";
        public static final String COLUMN_TICKET_QUANTITY = "ticketQuantity";
        public static final String COLUMN_TICKET_INFO = "ticketInfo";
        
        public static final String TABLE_ORDERS = "orders";
        public static final String COLUMN_ORDER_ID = "orderID";
        public static final String COLUMN_ORDER_DATE = "orderDate";
        public static final String COLUMN_ORDER_VALID = "orderValid";
        public static final String COLUMN_ORDER_INVITATION = "invitation";
        public static final String COLUMN_ORDER_EMAIL = "orderEmail";
        
        
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
        
        public ObservableList<Event> queryEvents(){
        	
        	try(Statement statement = conn.createStatement();
        	ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_EVENTS + 
        			" INNER JOIN " + TABLE_VENUES + " WHERE " + TABLE_EVENTS + "." + COLUMN_VENUE_NAME + " = " + TABLE_VENUES + "." + COLUMN_VENUE_NAME)){   		
        		
        		ObservableList<Event> events = FXCollections.observableArrayList();        		
        		while(results.next()){
        			Event event = new Event();
        			event.setEventName(results.getString(COLUMN_EVENT_NAME));
        			event.setEventStartDateTime(results.getString(COLUMN_EVENT_STARTDATETIME));
        			event.setEventEndDateTime(results.getString(COLUMN_EVENT_ENDDATETIME));
        			event.setVenueName(results.getString(COLUMN_VENUE_NAME));
        			event.setVenueAddressLineOne(results.getString(COLUMN_VENUE_ADDRESSLINEONE));
           			event.setVenueAddressLineTwo(results.getString(COLUMN_VENUE_ADDRESSLINETWO));
           			event.setVenueTownCity(results.getString(COLUMN_VENUE_TOWNCITY));
           			event.setVenuePostcode(results.getString(COLUMN_VENUE_POSTCODE));
           			event.setVenueTel(results.getString(COLUMN_VENUE_TEL));
           			event.setVenueEmail(results.getString(COLUMN_VENUE_EMAIL));
           			event.setEventTC(results.getString(COLUMN_EVENT_TC));
           			event.setEventInfo(results.getString(COLUMN_EVENT_INFO));
        			events.add(event);
        		}
        		
        		return events;
        		
        	} catch(SQLException e) {
        		System.out.println("Query failed:" + e.getMessage());
        		return null;     
        	}
       }
        
        public void insertEvent(Event event){
        	try{
        		conn.createStatement();
        		PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO " + TABLE_EVENTS + " VALUES (?, ?, ?, ?, ?, ?, ?);"  );
        		preparedStatement.setString(1, event.getEventName());
        		preparedStatement.setString(2, event.getEventStartDateTime());
        		preparedStatement.setString(3, event.getEventEndDateTime());
        		Calendar cal = Calendar.getInstance();
        		   java.util.Date utilDate = new java.util.Date();
        		   cal.setTime(utilDate);
        		   cal.set(Calendar.MILLISECOND, 0);
        		preparedStatement.setString(4, new java.sql.Timestamp(utilDate.getTime()).toString());
        		preparedStatement.setString(5, event.getEventInfo());
        		preparedStatement.setString(6, event.getEventTC());
        		preparedStatement.setString(7, event.getVenueName());
        		preparedStatement.execute();
        	{   		
     		

        		System.out.println("Event Successfully Added");
        		
        	}} catch(SQLException e) {
        		System.out.println("Query failed:" + e.getMessage()); 
        	}
       }
        
        public void insertOrder(Order order){
        	try{
        		conn.createStatement();
        		PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO " + TABLE_ORDERS + " VALUES (?, ?, ?, ?, ?, ?);"  );
        		preparedStatement.setString(1, order.getOrderID());
        		preparedStatement.setString(2, order.getTicketName());
        		preparedStatement.setString(3, order.getOrderDate());
        		Date date = new Date(0, 0, 0); 
        		preparedStatement.setString(4, order.getOrderValid());
        		preparedStatement.setString(5, order.getOrderInvitation());
        		preparedStatement.setString(6, order.getOrderEmail());
        		preparedStatement.execute();
        	{   		
     		

        		System.out.println("Order Successfully Added");
        		
        	}} catch(SQLException e) {
        		System.out.println("Query failed:" + e.getMessage()); 
        	}
       }
        
        public void insertVenue(Venue venue){
        	try{
        		conn.createStatement();
        		PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO " + TABLE_VENUES + " VALUES (?, ?, ?, ?, ?, ?, ?);"  );
        		preparedStatement.setString(1, venue.getVenueName());
        		preparedStatement.setString(2, venue.getVenueAddressLineOne());
        		preparedStatement.setString(3, venue.getVenueAddressLineTwo()); 
        		preparedStatement.setString(4, venue.getVenueTownCity());
        		preparedStatement.setString(5, venue.getVenuePostcode());
        		preparedStatement.setString(6, venue.getVenueEmail());
        		preparedStatement.setString(7, venue.getVenueTel());
        		preparedStatement.execute();
        	{   		
     		

        		System.out.println("Order Successfully Added");
        		
        	}} catch(SQLException e) {
        		System.out.println("Query failed:" + e.getMessage()); 
        	}
       }
        
        public void insertTicket(Ticket ticket){
        	try{
        		conn.createStatement();
        		PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO " + TABLE_TICKETS + " VALUES (?, ?, ?, ?, ?);"  );
        		preparedStatement.setString(1, ticket.getTicketName());
        		preparedStatement.setString(2, ticket.getTicketPrice());
        		preparedStatement.setString(3, ticket.getTicketQuantity());
        		preparedStatement.setString(4, ticket.getEventName());
        		preparedStatement.setString(5, ticket.getTicketInfo());
        		preparedStatement.execute();
        	{   		
     		

        		System.out.println("Ticket Successfully Added");
        		
        	}} catch(SQLException e) {
        		System.out.println("Query failed:" + e.getMessage()); 
        	}
       }
        


        public List<User> queryUsers(){
        	
        	try(Statement statement = conn.createStatement();
        	ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_USERS)){   		
        		
        		List<User> users = new ArrayList<>();        		
        		while(results.next()){
        			User user = new User();
        			user.setUsername(results.getString(COLUMN_USER_USERNAME));
        			user.setPassword(results.getString(COLUMN_USER_PASSWORD));
        			users.add(user);
        		}
        		
        		return users;
        		
        	} catch(SQLException e) {
        		System.out.println("Query failed:" + e.getMessage());
        		return null;     
        	}
       }
        
public void insertUsers(User user){
	try{
		conn.createStatement();
		PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO " + TABLE_USERS + " VALUES (?, ?);"  );
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.execute();
	{   		
		

		System.out.println("User Successfully Added");
		
	}} catch(SQLException e) {
		System.out.println("Query failed:" + e.getMessage()); 
	}
}
        

        
        public ObservableList<Order> queryOrders(){
        	try(Statement statement = conn.createStatement();
        	ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_ORDERS)){
        		
        		ObservableList<Order> orders = FXCollections.observableArrayList();
        		while(results.next()){
        			Order order = new Order();
        			order.setOrderID(results.getString(COLUMN_ORDER_ID));
        			order.setTicketName(results.getString(COLUMN_TICKET_NAME));
        			order.setOrderDate(results.getString(COLUMN_ORDER_DATE));
        			order.setOrderValid(results.getString(COLUMN_ORDER_VALID));
        			order.setInvitation(results.getString(COLUMN_ORDER_INVITATION));
        			order.setOrderEmail(results.getString(COLUMN_ORDER_EMAIL));
        			orders.add(order);
        		}
        		
        		return orders;
        	} catch(SQLException e) {
        		System.out.println("Query failed:" + e.getMessage());
        		return null;       	
        }
        }
        
public ObservableList<Venue> queryVenues(){
        	
        	try(Statement statement = conn.createStatement();
        	ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_VENUES)){   		
        		
        		ObservableList<Venue> venues = FXCollections.observableArrayList();        		
        		while(results.next()){
        			Venue venue = new Venue();
        			venue.setVenueName(results.getString(COLUMN_VENUE_NAME));
        			venue.setVenueAddressLineOne(results.getString(COLUMN_VENUE_ADDRESSLINEONE));
        			venue.setVenueAddressLineTwo(results.getString(COLUMN_VENUE_ADDRESSLINETWO));
        			venue.setVenueTownCity(results.getString(COLUMN_VENUE_TOWNCITY));
        			venue.setVenuePostcode(results.getString(COLUMN_VENUE_POSTCODE));
        			venue.setVenueTel(results.getString(COLUMN_VENUE_TEL));
        			venue.setVenueEmail(results.getString(COLUMN_VENUE_EMAIL));
        			venues.add(venue);
        		}
        		
        		return venues;
        		
        	} catch(SQLException e) {
        		System.out.println("Query failed:" + e.getMessage());
        		return null;     
        	}
       }

public ObservableList<String> queryVenueName(){
	
	try(Statement statement = conn.createStatement();
	ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_VENUES)){   		
		
		ObservableList<String> venues = FXCollections.observableArrayList();        		
		while(results.next()){
			String string = new String();
			string = results.getString(COLUMN_VENUE_NAME);
			venues.add(string);
		}
		
		return venues;
		
	} catch(SQLException e) {
		System.out.println("Query failed:" + e.getMessage());
		return null;     
	}
}

public ObservableList<String> queryEventName(){
	
	try(Statement statement = conn.createStatement();
	ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_EVENTS)){   		
		
		ObservableList<String> events = FXCollections.observableArrayList();        		
		while(results.next()){
			String string = new String();
			string = results.getString(COLUMN_EVENT_NAME);
			events.add(string);
		}
		
		return events;
		
	} catch(SQLException e) {
		System.out.println("Query failed:" + e.getMessage());
		return null;     
	}
}

public ObservableList<String> queryTicketName(){
	
	try(Statement statement = conn.createStatement();
	ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_TICKETS)){   		
		
		ObservableList<String> tickets = FXCollections.observableArrayList();        		
		while(results.next()){
			String string = new String();
			string = results.getString(COLUMN_TICKET_NAME);
			tickets.add(string);
		}
		
		return tickets;
		
	} catch(SQLException e) {
		System.out.println("Query failed:" + e.getMessage());
		return null;     
	}
}

public ObservableList<Ticket> queryTickets(){
	
	try(Statement statement = conn.createStatement();
	ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_TICKETS)){   		
		
		ObservableList<Ticket> tickets = FXCollections.observableArrayList();        		
		while(results.next()){
			Ticket ticket = new Ticket();
			ticket.setTicketName(results.getString(COLUMN_TICKET_NAME));
			ticket.setTicketPrice(results.getString(COLUMN_TICKET_PRICE));
			ticket.setTicketQuantity(results.getString(COLUMN_TICKET_QUANTITY));
			tickets.add(ticket);
		}
		
		return tickets;
		
	} catch(SQLException e) {
		System.out.println("Query failed:" + e.getMessage());
		return null;     
	}
}

public void deleteTicket(Ticket ticket){
	try{
		conn.createStatement();
		PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM " + TABLE_TICKETS + " WHERE " + COLUMN_TICKET_NAME + " = ?");
		preparedStatement.setString(1, ticket.getTicketName());
		preparedStatement.execute();
	{   		
		

		System.out.println("Event Successfully Deleted");
		
	}} catch(SQLException e) {
		System.out.println("Query failed:" + e.getMessage()); 
	}
}


public void deleteOrder(Order order){
	try{
		conn.createStatement();
		PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM " + TABLE_ORDERS + " WHERE " + COLUMN_ORDER_ID + " = ?");
		preparedStatement.setString(1, order.getOrderID());
		preparedStatement.execute();
	{   		
		

		System.out.println("Event Successfully Deleted");
		
	}} catch(SQLException e) {
		System.out.println("Query failed:" + e.getMessage()); 
	}
}

public void deleteVenue(Venue venue){
	try{
		conn.createStatement();
		PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM " + TABLE_VENUES + " WHERE " + COLUMN_VENUE_NAME + " = ?");
		preparedStatement.setString(1, venue.getVenueName());
		preparedStatement.execute();
	{   		
		

		System.out.println("Event Successfully Deleted");
		
	}} catch(SQLException e) {
		System.out.println("Query failed:" + e.getMessage()); 
	}
}

public void deleteEvent(Event event){
	try{
		conn.createStatement();
		PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM " + TABLE_EVENTS + " WHERE " + COLUMN_EVENT_NAME + " = ?");
		preparedStatement.setString(1, event.getVenueName());
		preparedStatement.execute();
	{   		
		

		System.out.println("Event Successfully Deleted");
		
	}} catch(SQLException e) {
		System.out.println("Query failed:" + e.getMessage()); 
	}
}


}
