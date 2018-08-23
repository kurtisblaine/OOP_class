package ch.makery.coffee;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	//fields
    public Stage primaryStage;
    public static BorderPane rootLayout;

    //run application
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Coffee Game");
        
        // Set the application icon.
        this.primaryStage.getIcons().add(new Image("file:resources/images/Starbucks_Book.png"));
        
        initRootLayout();
        showMainMenu();
        
    }
    
    //initializes root layout
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //shows main menu
    public static void showMainMenu() {
        try {
            // Load
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/MainMenu.fxml"));
            AnchorPane mainMenu = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(mainMenu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    //returns main menu
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    //start getters and setters
    public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}

	public static BorderPane getRootLayout() {
    	return rootLayout;
    }
	//end getters and setters
    
    public static void main(String[] args) {
        launch(args);
    }
}
