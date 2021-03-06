package application;

public class Order {

	private String orderID;
	private String ticketName;
	private String orderDate;
	private String orderValid;
	private String invitation;
	private String orderEmail;
	
	//getters
	public String getOrderID(){ return orderID; }
	public String getTicketName(){ return ticketName; }
	public String getOrderDate(){ return orderDate; }
	public String getOrderValid(){ return orderValid; }
	public String getOrderInvitation(){ return invitation; }
	public String getOrderEmail(){ return orderEmail; }
	
	//setters
	public void setOrderID(String orderID){ this.orderID = orderID; }
	public void setTicketName(String ticketName){ this.ticketName = ticketName; }
	public void setOrderDate(String orderDate){this.orderDate = orderDate; }
	public void setOrderValid(String orderValid){ this.orderValid = orderValid; }
	public void setInvitation(String invitation){ this.invitation = invitation; }
	public void setOrderEmail(String orderEmail){ this.orderEmail = orderEmail; }
	
}
