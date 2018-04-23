package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MainWindowController {

	@FXML TableView<Event> eventView;
	@FXML TableColumn<Event ,String> eventNameColumn;
	@FXML Label eventNameLabel;
	
	private Stage stage;
	private Main main;
	
	public void initialize(){
		eventView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		eventNameColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("eventName"));

		eventView.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showTitle(newValue));
	}
	
	public void setMain(Main main, Stage stage){
		this.main = main;
		this.stage = stage;
		eventView.setItems(main.getEventData());
	}
	
	public void showTitle(Event event){
		eventNameLabel.setText(event.getEventName());
	}
	
	@FXML
	public void handleNewEvent() {
		
	}
	
	@FXML
	public void handleDashboard() {
		
	}
	
	@FXML
	public void handleAnalytics() {
		
	}
	
	@FXML
	public void handleValidTickets() {
		
	}
	
	@FXML
	public void handleInvitations() {
		
	}
	
	@FXML
	public void handlePackages() {
		
	}
	
	@FXML
	public void handleSettings() {
		
	}
	
}
