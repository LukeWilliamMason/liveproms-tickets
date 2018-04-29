package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainWindowController{

	@FXML TableView<Event> eventView;
	@FXML TableColumn<Event ,String> eventNameColumn;
	@FXML Label eventNameLabel;
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
	
	private Stage stage;
	private Main main;
	
	public ObservableList<Event> eventData = FXCollections.observableArrayList();
	public ObservableList<Event> getEventData() { return eventData; }
	
	public void initialize(){
		Datasource datasource = new Datasource();
		
		datasource.open();
		eventData = datasource.queryEvents();
		eventView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		eventNameColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("EventName"));
		eventView.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showTitle(newValue));
	}
	
	public void setMain(Main main, Stage stage){
		this.main = main;
		this.stage = stage;
		eventView.setItems(getEventData());
	}
	
	public void showTitle(Event event){
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
	
	@FXML
	public void handleNewEvent() {
		
	}
	
	@FXML
	public void handleDashboard() throws IOException {
		main.mainWindow();
	}
	
	@FXML
	public void handleAnalytics() throws IOException {
		main.analyticsWindow();
	}
	
	@FXML
	public void handleValidTickets() throws IOException{
		main.validTicketsWindow();
	}
	
	@FXML
	public void handleInvitations() throws IOException{
		main.invitationsWindow();
	}
	
	@FXML
	public void handlePackages() {
		main.packagesWindow();
	}
	
	@FXML
	public void handleSettings() {
		main.settingsWindow();
	}
	
}
