package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import DAO.ImplementsDao;
import Models.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController implements Initializable{
	
	ImplementsDao implDao = new ImplementsDao();
	User user;
	
    @FXML
    private TextField adresse;

    @FXML
    private TextField age;

    @FXML
    private Button btnconnexion;

    @FXML
    private Button btnenregistrer;

    @FXML
    private TextField email;

    @FXML
    private TextField nom;

    @FXML
    private PasswordField password;

    @FXML
    private TextField pays;

    @FXML
    private TextField prenom;

    @FXML
    private TextField ville;
	
    void clear() {
        nom.setText(null);
        prenom.setText(null);
        age.setText(null);
        email.setText(null);
        adresse.setText(null);
        ville.setText(null);
        pays.setText(null);
        password.setText(null);
        btnenregistrer.setDisable(false);
    }
    
//	@FXML
//    private void onInsertAction(ActionEvent event) throws IOException {
//		int userid = Integer.parseInt(id.getText());
//		int userage = Integer.parseInt(age.getText());
//		User user = new User(userid,nom.getText(),prenom.getText(),userage,email.getText(),adresse.getText(),ville.getText(),pays.getText());
//		implDao.insert(user);
//		affiche();
//		clear();    
//	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}


}
