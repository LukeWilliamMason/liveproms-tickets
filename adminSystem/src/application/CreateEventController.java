package application;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CreateEventController extends MainWindowController {
	
	private static final String String = null;
	@FXML private TextField eventNameField;
	@FXML private JFXComboBox<String> eventLocationField;
	@FXML private JFXDatePicker eventStartDateField;
	@FXML private JFXDatePicker eventStartTimeField;
	@FXML private JFXDatePicker eventEndDateField;
	@FXML private JFXDatePicker eventEndTimeField;
	@FXML private TextArea eventInfoField;
	@FXML private TextArea eventTCField;
	@FXML private Label eventStatusLabel;

	private Main main;
	private Stage stage;
	
	public void setMain(Main main, Stage stage){
		this.main = main;
		this.stage = stage;
	}
	
	private static ObservableList<String> venueData = FXCollections.observableArrayList();
	public static ObservableList<String> getVenueData() { return venueData; }
	
	public void initialize(){
		Datasource datasource = new Datasource();
		datasource.open();
		venueData = datasource.queryVenueName();
		eventLocationField.setItems(venueData);
	}
	
	@FXML
	public void handleCreateEvent(){
		Event event = new Event();
		
		String eventName = eventNameField.getText();
		String eventSD = eventStartDateField.getValue().toString();
		String eventST = eventStartTimeField.getTime().toString();
		String eventET = eventEndTimeField.getTime().toString();
		String eventED = eventEndDateField.getValue().toString();
		String eventInfo = eventInfoField.getText();
		String eventTC = eventTCField.getText();
	
		
		
		
		event.setEventName(eventName);		

		event.setEventStartDateTime(eventSD + " " + eventST);	
		
		event.setEventEndDateTime(eventED + " " + eventET);
		
		event.setEventInfo(eventInfoField.getText());
		
		event.setEventTC(eventTCField.getText());
		
		
		event.setVenueName(eventLocationField.getValue());
		
		Datasource datasource = new Datasource();
		datasource.open();
		datasource.insertEvent(event);
		datasource.close();
		Alert alert = new Alert(AlertType.CONFIRMATION);
		   alert.setTitle("Success!");
		   alert.setHeaderText("New event added.");
		   alert.setContentText(eventName + " has successfully been created.");
		   alert.showAndWait();
		stage.close();
		
		
	}
	
}