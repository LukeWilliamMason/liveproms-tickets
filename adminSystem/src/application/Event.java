package application;


public class Event extends Venue {

	private String eventName;
	private String eventInfo;
	private String eventTC;
	private String eventStartDateTime;
	private String eventEndDateTime;
	private String eventCreated;
	
	//getters
	public String getEventName(){ return eventName; }
	public String getEventInfo(){ return eventInfo; }
	public String getEventStartDateTime(){ return eventStartDateTime; }
	public String getEventEndDateTime(){ return eventEndDateTime; }
	public String getEventTC(){ return eventTC; }
	public String getEventCreated(){ return eventCreated; };
	
	//setters
	public void setEventName(String eventName){ this.eventName = eventName; }
	public void setEventInfo(String eventInfo){ this.eventInfo = eventInfo; }
	public void setEventTC(String eventTC){ this.eventTC = eventTC; }
	public void setEventStartDateTime(String eventStartDateTime){ this.eventStartDateTime = eventStartDateTime; }
	public void setEventEndDateTime(String eventEndDateTime){ this.eventEndDateTime = eventEndDateTime; }
	public void setEventCreated(String eventCreated){ this.eventCreated = eventCreated; }
	
	
	
	
}
