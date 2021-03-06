package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController extends MainWindowController{
	
	@FXML Label eventAddressLineOneLabel;
	@FXML Label eventAddressLineTwoLabel;
	@FXML Label eventPostcodeLabel;
	@FXML Label eventTelephoneLabel;
	@FXML Label eventTCLabel;
	@FXML Label eventInfoLabel;
	@FXML Label eventStartDateLabel;
	@FXML Label eventEndDateLabel;
	@FXML Label eventStartTimeLabel;
	@FXML Label eventEndTimeLabel;
	@FXML Label eventEmailLabel;
	
	private Main main;
	
	public void setMain(Main main){
		this.main = main;
	}
	
public void showInfo(Event event){
		
		eventNameLabel.setText(event.getEventName());
		eventAddressLineOneLabel.setText(event.getVenueName());
		
		String eventAddress = "";
		
		if(event.getVenueAddressLineOne() != null)
		{
			eventAddress += event.getVenueAddressLineOne() + " ";
		}
		if(event.getVenueAddressLineTwo() != null){
			eventAddress+= event.getVenueAddressLineTwo() + " ";
		}
		
		eventAddressLineTwoLabel.setText( eventAddress + event.getVenuePostcode()+ " " + event.getVenueTownCity());
		eventTelephoneLabel.setText(event.getVenueTel());
		eventTCLabel.setText(event.getEventTC());
		eventInfoLabel.setText(event.getEventInfo());
		eventEmailLabel.setText(event.getVenueEmail());
		
		String displayTime = event.getEventStartDateTime();
		displayTime = displayTime.substring(11, 13) + ":" + displayTime.substring(14, 16);
		eventStartTimeLabel.setText(displayTime);
		
		displayTime = event.getEventEndDateTime();
		displayTime = displayTime.substring(11, 13) + ":" + displayTime.substring(14, 16);
		eventEndTimeLabel.setText(displayTime);
		
		
		String displayDate = event.getEventStartDateTime();
		displayDate = displayDate.substring(8,10) + "/" + displayDate.substring(5,7) + "/" + displayDate.substring(0, 4) ;		
		eventStartDateLabel.setText(displayDate);
		
		
		displayDate = event.getEventEndDateTime();
		displayDate = displayDate.substring(8,10) + "/" + displayDate.substring(5,7) + "/" + displayDate.substring(0, 4) ;
		eventEndDateLabel.setText(displayDate);
		
	}

}