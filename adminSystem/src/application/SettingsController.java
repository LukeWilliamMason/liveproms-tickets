package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class SettingsController extends MainWindowController {
	
	@FXML TextField newUserField, newPassField, confirmPassField;

	private Main main;
	
	public void setMain(Main main){
		this.main = main;
	}
	
	public void showInfo(Event event){		
		eventNameLabel.setText(event.getEventName());
		
	}
	
	@FXML
	public void handleCreateAccount() {
		User user = new User();
		String username = newUserField.getText();
		String password = newPassField.getText();
		String confirmPass = confirmPassField.getText();
		
			Datasource datasource = new Datasource();
			datasource.open();
			user.setPassword(password);
			user.setUsername(username);
			datasource.insertUsers(user);
			datasource.close();
		
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
		Datasource datasource = new Datasource();
		datasource.open();
		int i = eventView.getSelectionModel().getSelectedIndex();
		Event event = new Event();
		event = eventView.getSelectionModel().getSelectedItem();
		datasource.deleteEvent(event);
		SettingsController.getEventData().remove(i);
	}
	
}
