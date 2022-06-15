package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.ImplementsDao;
import Models.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignInController implements Initializable{
	
	ImplementsDao implDao = new ImplementsDao();
	User user;
	
    @FXML
    private Hyperlink createaccountbtn;

    @FXML
    private TextField email;

    @FXML
    private Hyperlink forgetpasswordbtn;

    @FXML
    private PasswordField password;

    @FXML
    private Button signinbtn;
    
    void clear() {

        email.setText(null);
        password.setText(null);
        signinbtn.setDisable(false);
    }

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}



}
