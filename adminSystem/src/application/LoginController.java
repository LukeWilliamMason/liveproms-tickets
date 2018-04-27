package application;

import java.util.List;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	
	@FXML private Label loginStatusLabel;
	@FXML private JFXTextField usernameField;
	@FXML private JFXPasswordField passwordField;
	
	private Stage stage;
	private Main main;
	
	public void setMain(Main main){
		this.main = main;
	}
	
	@FXML
	public void handleLogin() {
		
		Boolean success = false;
		String userentry = usernameField.getText();
		String passwordentry = passwordField.getText();
		Datasource datasource = new Datasource();
		datasource.open();
		List<User> users = datasource.queryUsers();
		for(User user : users){
		if(user.getUsername().equals(userentry) && user.getPassword().equals(passwordentry)){
			success = true;
			main.mainWindow();
		}
		}
		if(success == false){
			loginStatusLabel.setText("Invalid Username or Password");
		}
	}

	
}
