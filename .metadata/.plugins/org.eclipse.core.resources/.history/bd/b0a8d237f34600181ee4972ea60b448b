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
			mainWindow();
		}
	
	public void mainWindow()  {
		try{
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainWindowView.fxml"));
			AnchorPane pane = loader.load();
			Scene scene = new Scene(pane);
			
			MainWindowController controller = loader.getController();
			controller.setMain(this);
			
			primaryStage.setTitle("LP Ticket Artist");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private ObservableList<Event> eventData = FXCollections.observableArrayList();
	public ObservableList<Event> getEventData() {return eventData;}
	
	public Main() {
	eventData.add(new Event("1", "Truckfest Original 2018", "A Place full of Trucks!", "Pebo", "Pedo", "PE112AB", "01260847857", "No ticket refunds"));
	eventData.add(new Event("2", "LRO Owners International 2018", "A Place full of Landies!", "Pebo", "Pedo", "PE112AB", "01260847857", "No ticket refunds"));
	eventData.add(new Event("2", "LRO Owners International 2018", "A Place full of Landies!", "Pebo", "Pedo", "PE112AB", "01260847857", "No ticket refunds"));
	eventData.add(new Event("2", "LRO Owners International 2018", "A Place full of Landies!", "Pebo", "Pedo", "PE112AB", "01260847857", "No ticket refunds"));
	eventData.add(new Event("2", "LRO Owners International 2018", "A Place full of Landies!", "Pebo", "Pedo", "PE112AB", "01260847857", "No ticket refunds"));
	eventData.add(new Event("2", "LRO Owners International 2018", "A Place full of Landies!", "Pebo", "Pedo", "PE112AB", "01260847857", "No ticket refunds"));
	eventData.add(new Event("2", "LRO Owners International 2018", "A Place full of Landies!", "Pebo", "Pedo", "PE112AB", "01260847857", "No ticket refunds"));
	eventData.add(new Event("2", "LRO Owners International 2018", "A Place full of Landies!", "Pebo", "Pedo", "PE112AB", "01260847857", "No ticket refunds"));
	eventData.add(new Event("2", "LRO Owners International 2018", "A Place full of Landies!", "Pebo", "Pedo", "PE112AB", "01260847857", "No ticket refunds"));

	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
