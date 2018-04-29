package application;

public class Ticket {

	private String eventName;
	private String ticketName;
	private String ticketPrice;
	private String ticketQuantity;
	private String ticketInfo;
	
	//getters
	public String getEventName(){ return eventName; }
	public String getTicketName(){ return ticketName; }
	public String getTicketPrice(){ return ticketPrice; }
	public String getTicketQuantity(){ return ticketQuantity; }
	public String getTicketInfo(){ return ticketInfo; }
	
	//setters
	public void setEventName(String eventName){ this.eventName = eventName; }
	public void setTicketName(String ticketName){ this.ticketName = ticketName; }
	public void setTicketPrice(String ticketPrice){this.ticketPrice = ticketPrice; }
	public void setTicketQuantity(String ticketQuantity){ this.ticketQuantity = ticketQuantity; }
	public void setTicketInfo(String ticketInfo){ this.ticketInfo = ticketInfo; }
	
}
