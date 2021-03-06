package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class VenuesController extends MainWindowController{
	
	private Main main;
	@FXML private TextField venueNameField;
	@FXML private TextField venueAddressLineOneField;
	@FXML private TextField venueAddressLineTwoField;
	@FXML private TextField venueTownCityField;
	@FXML private TextField venuePostcodeField;
	@FXML private TextField venueTelephoneField;
	@FXML private TextField venueEmailField;
	@FXML private TableView<Venue> venueView;
	@FXML private TableColumn<Venue, String> venueNameColumn, venueAddressLineOneColumn, venueAddressLineTwoColumn,
	venueTownCityColumn, venueTelephoneColumn, venueEmailColumn, venuePostcodeColumn;
	
	
	public void setMain(Main main){
		this.main = main;
	}
	
	private static ObservableList<Venue> venueData = FXCollections.observableArrayList();
	public static ObservableList<Venue> getVenueData() { return venueData; }
	
public void initialize(){
		
		
		Datasource datasource = new Datasource();
		datasource.open();
		
		venueData = datasource.queryVenues();
		venueView.setItems(venueData);
		venueNameColumn.setCellValueFactory(new PropertyValueFactory<Venue, String>("venueName"));
		venueAddressLineOneColumn.setCellValueFactory(new PropertyValueFactory<Venue, String>("venueAddressLineOne"));
		venueAddressLineTwoColumn.setCellValueFactory(new PropertyValueFactory<Venue, String>("venueAddressLineTwo"));
		venueTownCityColumn.setCellValueFactory(new PropertyValueFactory<Venue, String>("venueTownCity"));
		venueTelephoneColumn.setCellValueFactory(new PropertyValueFactory<Venue, String>("venueTel"));
		venueEmailColumn.setCellValueFactory(new PropertyValueFactory<Venue, String>("venueEmail"));
		venuePostcodeColumn.setCellValueFactory(new PropertyValueFactory<Venue, String>("venuePostcode"));
		
		
		eventData = datasource.queryEvents();
		eventView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		eventNameColumn.setCellValueFactory(new PropertyValueFactory<Event, String>("EventName"));
		eventView.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showInfo(newValue));
		
		
		
		
	}

	
	public void showInfo(Event event){		
		
	}
	
	@FXML
	public void addVenue(){
		Venue venue = new Venue();
		
		String venueName = venueNameField.getText();
		String venueAddressLineOne = venueAddressLineOneField.getText();
		String venueAddressLineTwo = venueAddressLineTwoField.getText();
		String venueTownCity = venueTownCityField.getText();
		String venuePostcode = venuePostcodeField.getText();
		String venueTelephone = venueTelephoneField.getText();
		String venueEmail = venueEmailField.getText();
	
		
		
		
		venue.setVenueName(venueName);;		

		venue.setVenueAddressLineOne(venueAddressLineOne);	
		
		venue.setVenueAddressLineTwo(venueAddressLineTwo);
		
		venue.setVenueTownCity(venueTownCity);
		
		venue.setVenuePostcode(venuePostcode);;
		
		venue.setVenueTel(venueTelephone);
		
		venue.setVenueEmail(venueEmail);
		
		
		Datasource datasource = new Datasource();
		datasource.open();
		datasource.insertVenue(venue);
		datasource.close();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		   alert.setTitle("Success!");
		   alert.setHeaderText("New venue added.");
		   alert.setContentText(venueName + " has successfully been created.");
		   alert.showAndWait();
		
		initialize();
		venueNameField.setText("");
		venueAddressLineOneField.setText("");
		venueAddressLineTwoField.setText("");
		venueTownCityField.setText("");
		venuePostcodeField.setText("");
		venueTelephoneField.setText("");
		venueEmailField.setText("");
	}
	
	@FXML
	public void deleteVenue(){
		Datasource datasource = new Datasource();
		datasource.open();
		int i = venueView.getSelectionModel().getSelectedIndex();
		Venue venue = new Venue();
		venue = venueView.getSelectionModel().getSelectedItem();
		datasource.deleteVenue(venue);
		VenuesController.getVenueData().remove(i);
	}
	
	
}
