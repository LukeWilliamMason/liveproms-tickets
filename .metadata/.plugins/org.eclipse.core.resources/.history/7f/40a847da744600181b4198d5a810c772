package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewEventController {

	@FXML private TextField eventNameField, eventAddressField, eventPostcodeField, eventTelField, eventInfoField;
	
	private Stage stage;
	private Main main;
	
	public void setMain(Main main, Stage stage) {
		this.main = main;
		this.stage = stage;
	}
	
	@FXML
	public void handleOk() {
		Event event = new Event(
				eventNameField.getText(),
				eventAddressField.getText(),
				eventPostcodeField.getText(),
				eventTelField.getText(),
				eventInfoField.getText()
				);
		main.getEventData().add(event);
		stage.close();
	}
	
	@FXML
	public void handleCancel() {
		stage.close();
	}
	
}
