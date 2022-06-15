package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception { 
		try { 
			Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/Home.fxml"));
			Scene scene = new Scene(root);
			
			//scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
			
			Image icon = new Image("Images/icon.png"); 
			primaryStage.getIcons().add(icon);  
			primaryStage.setTitle("Fiche d'inscription");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			System.err.println(e); 
			e.printStackTrace(); 
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		  
		 
	} 

}
