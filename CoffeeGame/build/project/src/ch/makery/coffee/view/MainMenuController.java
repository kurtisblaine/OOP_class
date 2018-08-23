package ch.makery.coffee.view;

import java.io.IOException;

import ch.makery.coffee.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class MainMenuController extends Main{
  
        @FXML
        private Button newGame;
        @FXML
        private Button highScores;
    
    //handles exit java
	@FXML
	private void handleExit() {
		System.exit(0);
	}
	
	//handles high score button
	@FXML
	private void handleHighScores(ActionEvent event) throws IOException{
		   //new loader
		   FXMLLoader loader = new FXMLLoader();
	       loader.setLocation(Main.class.getResource("view/HighScores.fxml"));
	       AnchorPane highScores = loader.load();
	       
	       //rootlayout to anchorpane
	       rootLayout.setCenter(highScores); 
	       
	       	//displays notice
	    	Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Coffee Game");
	        alert.setHeaderText("NOTE");
	        alert.setContentText("The high score table is currently under construction");
	        alert.showAndWait();
	}
	

	//handles new game button
	@FXML
	 private void handleNewGame(ActionEvent event) throws IOException{
		   //new loader
	       FXMLLoader loader = new FXMLLoader();
	       loader.setLocation(Main.class.getResource("view/NewGame.fxml"));
	       AnchorPane newGame = loader.load();
	       
	       //rootlayout to anchorpane
	       rootLayout.setCenter(newGame); 
	       
	       Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Coffee Game");
	        alert.setHeaderText("Coffee Order!");
	        alert.setContentText("Hey, New guy! Coffee order just arrived!" + "\n" + "Black Coffee, stat!" +
	        "\n" + "If you need some help, then navigate to the help button in the header");
	        alert.showAndWait();
	       }
	
  }
	
	    
	

