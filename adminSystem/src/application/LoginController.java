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

public class LoginController{

	
	@FXML private Label loginStatusLabel;
	@FXML public JFXTextField usernameField;
	@FXML private JFXPasswordField passwordField;
	
	private Stage stage;
	private Main main;
	
	public void setMain(Main main){
		this.main = main;	
	}
	
	@FXML
	public void handleLogin() {
		String userentry = usernameField.getText();
		String passwordentry = passwordField.getText();
		Boolean success = false;
		Datasource datasource = new Datasource();
		if(!datasource.open()){
			loginStatusLabel.setText("Failed to connect.");
			return;
		}
		List<User> users = datasource.queryUsers();
		for(User user : users){
		if(user.getUsername().equals(userentry) && user.getPassword().equals(passwordentry)){
			success = true;
			main.mainWindow();
			datasource.close();
		}
		}
		if(success == false){
			loginStatusLabel.setText("Invalid Username or Password");
		}
	}

	
}
