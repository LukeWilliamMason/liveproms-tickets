package application;

public class VenuesController extends MainWindowController{
	
	private Main main;
	
	public void setMain(Main main){
		this.main = main;
	}

	
	public void showInfo(Event event){		
		eventNameLabel.setText(event.getEventName());
		
	}
	
}
