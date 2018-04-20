package application;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainWindowController {

	@FXML TableView<Event> eventView;
	@FXML TableColumn<Event, String> eventName;
	
	
	private Main main;
	
	public void initialize(){
		eventName.setCellValueFactory(new PropertyValueFactory<Event, String>("eventName"));
		
		
	}
	
	public void setMain(Main main) {
		this.main = main;
		eventView.setItems(main.getEventData());
	}
	
	@FXML
	public void handleNewEvent() {
		
	}
}
