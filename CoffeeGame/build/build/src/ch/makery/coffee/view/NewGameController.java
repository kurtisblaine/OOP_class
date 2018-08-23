package ch.makery.coffee.view;

import java.io.IOException;
import java.time.Duration;
import java.util.Timer;
import java.util.TimerTask;
import ch.makery.coffee.Orders;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;


public class NewGameController{

	// Reference to the Orders class
	private Orders order;

	@FXML
	private void initialize() {

		order = new Orders();
	}


	//handle new cup event
	@FXML
	private void handleEmptyCups(ActionEvent event) throws IOException{
		//TODO: change cursor
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Added ingredient");
		alert.setHeaderText(null);
		alert.setContentText( order.addItem( Orders.EMPTY_CUPS ) );
		alert.showAndWait();
	}


	//handle coffee event
	@FXML
	private void handleCoffee(ActionEvent event) throws IOException{
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Added ingredient");
		alert.setHeaderText(null);
		alert.setContentText( order.addItem( Orders.COFFEE ) );
		alert.showAndWait();
		
	}


	//handle ice event
	@FXML
	private void handleIce(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Added ingredient");
		alert.setHeaderText(null);
		alert.setContentText( order.addItem( Orders.ICE ) );
		alert.showAndWait();
	}


	//handle espresso event
	@FXML
	private void handleEspresso(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Added ingredients");
		alert.setHeaderText(null);
		alert.setContentText( order.addItem( Orders.ESPRESSO ) );
		alert.showAndWait();
	}


	//handle milk event
	@FXML
	private void handleMilk(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Added ingredient");
		alert.setHeaderText(null);
		alert.setContentText( order.addItem( Orders.MILK ) );
		alert.showAndWait();
	}

	//handle caramel event
	@FXML
	private void handleCaramel(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Added ingredient");
		alert.setHeaderText(null);
		alert.setContentText( order.addItem( Orders.CARAMEL ) );
		alert.showAndWait();
	}

	//handle Hazelnut
	@FXML
	private void handleHazelnut(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Added ingredient");
		alert.setHeaderText(null);
		alert.setContentText( order.addItem( Orders.HAZELNUT ) );
		alert.showAndWait();
		
	}

	@FXML
	private void handleCurrentOrder(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Current order: ");
		alert.setHeaderText(null);
		alert.setContentText( order.printCurrentOrder() );
		alert.showAndWait();
		
	}

	@FXML
	private void handleCurrentItems(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Current ingredients: ");
		alert.setHeaderText(null);
		alert.setContentText( order.printCurrentItems() );
		alert.showAndWait();
		
	}
	
	//handle submit event
	@FXML
	private void handleSubmit(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Submit order");
		alert.setHeaderText(null);
		alert.setContentText( order.submit() );
		alert.showAndWait();

		if( order.isM_orderMade() == true )
		{
			alert.setTitle("New Order!");
			alert.setHeaderText(null);
			alert.setContentText( order.newOrder() );
			alert.showAndWait();
		}
	}

}//end new game controller
    
