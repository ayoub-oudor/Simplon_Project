package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SignUp extends Application{

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/Home.fxml"));
			Scene scene = new Scene(root);
			
			//scene.getStylesheets().add(getClass().getResource("/css/application.css2").toExternalForm());
			
			Image icon = new Image("Images/icon.png"); 
			primaryStage.getIcons().add(icon);  
			primaryStage.setTitle("Register");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			System.err.println(e); 
			e.printStackTrace(); 
		}
	}

	public static void main(String[] args) {

	}


}
