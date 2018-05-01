package application;

import javafx.fxml.FXML;

public class SettingsController extends MainWindowController {

	private Main main;
	
	public void setMain(Main main){
		this.main = main;
	}
	
	public void showInfo(Event event){		
		eventNameLabel.setText(event.getEventName());
		
	}
	
	@FXML
	public void handleCreateAccount() {
	}
	
	@FXML
	public void handleChangePassword() {
	}
	
	@FXML
	public void handleUpdateInfo() {
	}
	
	@FXML
	public void handleDeleteUser() {
	}
	
	@FXML
	public void handleDeleteEvent() {
	}
	
}
