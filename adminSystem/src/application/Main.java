package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import java.sql.*;
import java.util.List;
import java.util.Properties;


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
	
	public void venuesWindow() {

		try {

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("VenuesView.fxml"));
		AnchorPane pane = loader.load();
		Scene scene = new Scene(pane);
		
		Stage stage = new Stage();
		
		VenuesController controller = loader.getController();
		controller.setMain(this, stage);

		primaryStage.setScene(scene);
		primaryStage.show();

		} catch (Exception e) {
		e.printStackTrace();
		}
		}
	
	public void ticketsWindow() {

		try {

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("TicketsView.fxml"));
		AnchorPane pane = loader.load();
		Scene scene = new Scene(pane);
		
		Stage stage = new Stage();
		
		TicketsController controller = loader.getController();
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
	
	public void loadingWindow() {

		try {

		FXMLLoader loader = new FXMLLoader(Main.class.getResource("LoadingView.fxml"));
		AnchorPane pane = loader.load();
		Scene scene = new Scene(pane);
		
		Stage stage = new Stage();	

		primaryStage.setScene(scene);
		primaryStage.show();

		} catch (Exception e) {
		e.printStackTrace();
		}
		}
	
	public void createEventWindow()  {
		try{
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("CreateEventView.fxml"));
			AnchorPane pane = loader.load();
			
			Scene scene = new Scene(pane);		
			Stage stage = new Stage();
			
			CreateEventController controller = loader.getController();
			controller.setMain(this, stage);
			
			stage.initOwner(primaryStage);
			stage.initModality(Modality.APPLICATION_MODAL);
			
			stage.setTitle("Create Event");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public Main() {
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
