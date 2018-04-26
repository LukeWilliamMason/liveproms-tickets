package application;

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
		
		
		String user = usernameField.getText();
		String password = passwordField.getText();
		if(usernameField.getText().equals("user") && passwordField.getText().equals("pass")) {
			main.mainWindow();
		} else {
			loginStatusLabel.setText("Invalid Username or Password");
		}
	}

	
}
