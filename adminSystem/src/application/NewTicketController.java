package application;

import com.jfoenix.controls.JFXComboBox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewTicketController extends MainWindowController {
	
	@FXML private JFXComboBox<String> eventNameField;
	@FXML private TextField ticketNameField, ticketPriceField, ticketQuantityField, ticketInfoField;
	
	private Main main;
	private Stage stage;
	
	
	public void setMain(Main main, Stage stage){
		this.main = main;
		this.stage = stage;
	}
	
	private static ObservableList<String> eventData = FXCollections.observableArrayList();
	public static ObservableList<String> getEventName() { return eventData; }
	
	public void initialize(){
		Datasource datasource = new Datasource();
		datasource.open();
		eventData = datasource.queryEventName();
		eventNameField.setItems(eventData);
	}
	
	@FXML
	public void handleCreateTicket(){
		
		Ticket ticket = new Ticket();
		
		String ticketName = ticketNameField.getText();
		String ticketPrice= ticketPriceField.getText();
		String ticketQuantity = ticketQuantityField.getText();
		String eventName = eventNameField.getValue().toString();
		String ticketInfo = ticketInfoField.getText();
		
		ticket.setTicketName(ticketName);
		ticket.setTicketPrice(ticketPrice);
		ticket.setTicketQuantity(ticketQuantity);
		ticket.setEventName(eventName);
		ticket.setTicketInfo(ticketInfo);
		
	
		
		Datasource datasource = new Datasource();
		datasource.open();
		datasource.insertTicket(ticket);
		datasource.close();
		Alert alert = new Alert(AlertType.CONFIRMATION);
		   alert.setTitle("Success!");
		   alert.setHeaderText("New ticket added.");

		   alert.showAndWait();
		stage.close();
		
		
	}
	
}
