package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SignIn extends Application{

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/Interfaces/SignIn.fxml"));
			Scene scene = new Scene(root);
			
			//scene.getStylesheets().add(getClass().getResource("/css/application.css1").toExternalForm());
			
			Image icon = new Image("Images/icon.png"); 
			primaryStage.getIcons().add(icon);  
			primaryStage.setTitle("Login");
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
