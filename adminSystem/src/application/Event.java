package application;


public class Event {

	private String eventID;
	private String eventName;
	private String eventInfo;
	private String eventAddressLineOne;
	private String eventAdderssLineTwo;
	private String eventPostcode;
	private String eventTel;
	private String eventTC;
	private String eventStartDate;
	private String eventEndDate;
	
	//getters
	public String getEventID(){ return eventID; }
	public String getEventName(){ return eventName; }
	public String getEventInfo(){ return eventInfo; }
	public String getEventStartDate(){ return eventStartDate; }
	public String getEventEndDate(){ return eventEndDate; }
	public String getEventAddressLineOne(){ return eventAddressLineOne; }
	public String getEventAddressLineTwo(){ return eventAdderssLineTwo; }
	public String getEventPostcode(){ return eventPostcode; }
	public String getEventTel(){ return eventTel; }
	public String getEventTC(){ return eventTC; }
	
	//setters
	public void setEventID(String eventID){ this.eventID = eventID; }
	public void setEventName(String eventName){ this.eventName = eventName; }
	public void setEventInfo(String eventInfo){ this.eventInfo = eventInfo; }
	public void setEventAddressLineOne(String eventAddressLineOne){ this.eventAddressLineOne = eventAddressLineOne; }
	public void setEventAddressLineTwo(String eventAdderssLineTwo){ this.eventAdderssLineTwo = eventAdderssLineTwo; }
	public void setEventPostcode(String eventPostcode){ this.eventPostcode = eventPostcode; }
	public void setEventTel(String eventTel){ this.eventTel = eventTel; }
	public void setEventTC(String eventTC){ this.eventTC = eventTC; }
	public void setEventStartDate(String eventStartDate){ this.eventStartDate = eventStartDate; }
	public void setEventEndDate(String eventEndDate){ this.eventEndDate = eventEndDate; }
	
	
	
	
}
