package ch.makery.coffee.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

import ch.makery.coffee.Main;
import ch.makery.coffee.Orders;


 //root layout controller
public class RootLayoutController{

    //handles about in main menu
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Coffee Game");
        alert.setHeaderText("About");
        alert.setContentText("Select 'New Game' to begin the coffee gaming experience. Click on the coffee cup and complete the specified coffee "
        		+ "with the correct ingredients:" + "\n\n" + 
        		"Drinks that are iced require ice as an ingredient." +"\n"+
        		"Americano drinks require espresso, Lattes require milk and espresso, and Macchiatos require milk, coffee, and espresso\n" +
        		"Flavors are as specified\n" + "Enjoy your day at work!" + "\nREMEMBER: All incorrect orders will drain your money"
        		+"\n\n" +
        		"Author group: Sioux Falls Java. ");

        alert.showAndWait();
    }

    //handles close in main menu
    @FXML
    private void handleExit() {
    	//exits
        System.exit(0);
    }
    
    @FXML
    private void handleGoHome(){
    	//shows main menu
    	Main.showMainMenu();
    	//displays high score
    	TextInputDialog dialog = new TextInputDialog();
    	dialog.setTitle("Score");
    	if(Orders.m_high_score <= 0.00){
        	dialog.setHeaderText("Your High Score: $"+ Orders.m_score +"\n" + "Please Enter Your Name: ");
        }
        else{
        	dialog.setHeaderText("Your High Score: $"+ Orders.m_high_score +"\n"+ "Please Enter Your Name: ");
        }
    	
    	Optional<String> result = dialog.showAndWait();
    	if(result.isPresent()){
    		String name = result.get();
    	}
    }
    
}