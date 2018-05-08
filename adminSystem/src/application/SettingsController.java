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
		String username = newUserField.getText().toString();
		String password = newPassField.getText().toString();
		String confirmPass = confirmPassField.getText().toString();
		
		if(username.equals(null) || password.equals(null) || confirmPass.equals(null)){
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText("Fields are empty.");
			alert.setContentText("Fill in all required fields.");
			alert.showAndWait();
		}
		if(password.equals(confirmPass)){
			try{
			Datasource datasource = new Datasource();
			datasource.open();
			user.setPassword(password);
			user.setUsername(username);
			datasource.insertUsers(user);
			datasource.close();
			}catch(Exception e){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Uh, oh!");
				alert.setHeaderText("Error!");
				alert.setContentText("User already exists.");
				alert.showAndWait();
			}
		}else{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Uh, oh!");
			alert.setHeaderText("Error!");
			alert.setContentText("Passwords do not match.");
			alert.showAndWait();
		}
		
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
