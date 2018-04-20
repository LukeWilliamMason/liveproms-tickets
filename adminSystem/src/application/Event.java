package application;

public class Event {

	private String eventName;
	private String eventAddress;
	private String eventPostcode;
	private String eventTel;
	private String eventInfo;
	
	public Event(String eventName, String eventAddress, String eventPostcode, String eventTel, String eventInfo) {
		this.eventName = eventName;
		this.eventAddress = eventAddress;
		this.eventPostcode = eventPostcode;
		this.eventTel = eventTel;
		this.eventInfo = eventInfo;
	}
	
	// getters
	public String getEventName() { return eventName; }
	public String getEventAddress() { return eventAddress; }
	public String getEventPostcode() { return eventPostcode; }
	public String getEventTel() { return eventTel; }
	public String getEventInfo() { return eventInfo; }
	
	//setters
	public void setEventName(String eventName) { this.eventName = eventName; }
	public void setEventAddress(String eventAddress) { this.eventAddress = eventAddress; }
	public void setEventPostcode(String eventPostcode) { this.eventPostcode = eventPostcode; }
	public void setEventTel(String eventTel) { this.eventTel = eventTel; }
	public void setEventInfo(String eventInfo) { this.eventInfo = eventInfo; }
}
