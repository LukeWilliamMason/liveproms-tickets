package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
			this.primaryStage = primaryStage;
			loginWindow();
		}
	
	public void loginWindow()  {
		try{
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("loginView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			
			LoginController controller = loader.getController();
			controller.setMain(this);
			
			Stage stage = new Stage();
			
			stage.setTitle("LP Ticket Artist");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void mainWindow()  {
		try{
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainWindowView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			
			Stage stage = new Stage();
			
			MainWindowController controller = loader.getController();
			controller.setMain(this, primaryStage);
			
			primaryStage.setTitle("LP Ticket Artist");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void analyticsWindow() {

		try {

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("AnalyticsView.fxml"));
		AnchorPane pane = loader.load();
		Scene scene = new Scene(pane);
		
		Stage stage = new Stage();
		
		AnalyticsController controller = loader.getController();
		controller.setMain(this, stage);

		primaryStage.setScene(scene);
		primaryStage.show();

		} catch (Exception e) {
		e.printStackTrace();
		}
		}
	
	public void validTicketsWindow() {

		try {

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("ValidTicketsView.fxml"));
		AnchorPane pane = loader.load();
		Scene scene = new Scene(pane);
		
		Stage stage = new Stage();
		
		ValidTicketsController controller = loader.getController();
		controller.setMain(this, stage);

		primaryStage.setScene(scene);
		primaryStage.show();

		} catch (Exception e) {
		e.printStackTrace();
		}
		}
	
	public void invitationsWindow() {

		try {

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("InvitationsView.fxml"));
		AnchorPane pane = loader.load();
		Scene scene = new Scene(pane);
		
		Stage stage = new Stage();
		
		InvitationsController controller = loader.getController();
		controller.setMain(this, stage);

		primaryStage.setScene(scene);
		primaryStage.show();

		} catch (Exception e) {
		e.printStackTrace();
		}
		}
	
	public void packagesWindow() {

		try {

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("PackagesView.fxml"));
		AnchorPane pane = loader.load();
		Scene scene = new Scene(pane);
		
		Stage stage = new Stage();
		
		PackagesController controller = loader.getController();
		controller.setMain(this, stage);

		primaryStage.setScene(scene);
		primaryStage.show();

		} catch (Exception e) {
		e.printStackTrace();
		}
		}
	
	public void settingsWindow() {

		try {

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("SettingsView.fxml"));
		AnchorPane pane = loader.load();
		Scene scene = new Scene(pane);
		
		Stage stage = new Stage();
		
		SettingsController controller = loader.getController();
		controller.setMain(this, stage);

		primaryStage.setScene(scene);
		primaryStage.show();

		} catch (Exception e) {
		e.printStackTrace();
		}
		}
	
	
	private ObservableList<Event> eventData = FXCollections.observableArrayList();
	public ObservableList<Event> getEventData() {return eventData;}
	
	public Main() {
	eventData.add(new Event("1", "Truckfest Original 2018", "A Place full of Trucks!", "Pebo", "Pedo", "PE112AB", "01260847857", "No ticket refunds"));
	eventData.add(new Event("2", "LRO Owners International 2018", "A Place full of Landies!", "Pebo", "Pedo", "PE112AB", "01260847857", "No ticket refunds"));
	eventData.add(new Event("3", "Sywell Classic 2018", "A Place full of Landies!", "Pebo", "Pedo", "PE112AB", "01260847857", "No ticket refunds"));
	eventData.add(new Event("4", "UB40 at Lincoln Castle 2018", "A Place full of Landies!", "Pebo", "Pedo", "PE112AB", "01260847857", "No ticket refunds"));
	eventData.add(new Event("5", "Status Quo at Holkham Hall 2018", "A Place full of Landies!", "Pebo", "Pedo", "PE112AB", "01260847857", "No ticket refunds"));
	eventData.add(new Event("6", "Scottish Land Rover Show 2018", "A Place full of Landies!", "Pebo", "Pedo", "PE112AB", "01260847857", "No ticket refunds"));
	eventData.add(new Event("7", "Kelmarsh Land Rover Show 2018", "A Place full of Landies!", "Pebo", "Pedo", "PE112AB", "01260847857", "No ticket refunds"));
	eventData.add(new Event("8", "MCN Bike Show 2018", "A Place full of Landies!", "Pebo", "Pedo", "PE112AB", "01260847857", "No ticket refunds"));
	eventData.add(new Event("9", "Last Night of the Proms 2018", "A Place full of Landies!", "Pebo", "Pedo", "PE112AB", "01260847857", "No ticket refunds"));

	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
