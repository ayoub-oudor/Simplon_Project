package Controllers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import DAO.ImplementsDao;
import Models.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
 
public class HomeController  implements Initializable {

	ImplementsDao implDao = new ImplementsDao();
	User user;

	@FXML
	private TextField id;
	@FXML
	private TextField nom;
	@FXML
	private TextField prenom;
	@FXML
	private TextField age;
	@FXML
	private TextField email;
	@FXML
	private TextField adresse;
	@FXML
	private TextField ville;
	@FXML
	private TextField pays;
	@FXML
	private TableView<User> tableView;
	@FXML
	private TableColumn<User, Integer> coid; 
	@FXML
	private TableColumn<User, String> conom;
	@FXML
	private TableColumn<User, String> coprenom;
	@FXML
	private TableColumn<User, Integer> coage;
	@FXML
	private TableColumn<User, String> coemail;
	@FXML
	private TableColumn<User, String> coadresse;
	@FXML
	private TableColumn<User, String> coville;
	@FXML
	private TableColumn<User, String> copays;
	@FXML
	private Button btninsert;
	@FXML
	private Button btnselect;
	@FXML
	private Button btnupdate;
	@FXML
	private Button btndelete;
	
	public final ObservableList<User> data =
			FXCollections.observableArrayList(
//			new User(20, "LATIFA", "AMOUGUAY",22, "nawal@gmail.com", "eljouda", "agadir", "Mroc"),
//            new User(21, "ayoube", "ALAMI",23, "nawal@gmail.com", "eljouda", "agadir", "Mroc"),
//            new User(23,"said", "ALAMI",15, "nawal@gmail.com", "eljouda", "agadir", "Mroc"),
//            new User(24,"othman", "ALAMI",20, "nawal@gmail.com", "eljouda", "agadir", "Mroc"),
//            new User(25,"abdelali", "ALAMI",22, "nawal@gmail.com", "eljouda", "agadir", "Mroc"),
//            new User(26,"anass", "ALAMI",25, "nawal@gmail.com", "eljouda", "agadir", "Mroc")
			);
	 
	public void affiche () {
		data.addAll(implDao.select()); 
		coid.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        conom.setCellValueFactory(new PropertyValueFactory<User, String>("nom"));
        coprenom.setCellValueFactory(new PropertyValueFactory<User, String>("prenom"));
        coage.setCellValueFactory(new PropertyValueFactory<User, Integer>("age"));
        coemail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        coadresse.setCellValueFactory(new PropertyValueFactory<User, String>("adresse"));
        coville.setCellValueFactory(new PropertyValueFactory<User, String>("ville"));
        copays.setCellValueFactory(new PropertyValueFactory<User, String>("pays"));
        tableView.setItems(data);
        tableView.refresh();
	}
	
    void clear() {
        id.setText(null);
        nom.setText(null);
        prenom.setText(null);
        age.setText(null);
        email.setText(null);
        adresse.setText(null);
        ville.setText(null);
        pays.setText(null);
        btninsert.setDisable(false);
    }

	@FXML
    private void onInsertAction(ActionEvent event) throws IOException {
		int userid = Integer.parseInt(id.getText());
		int userage = Integer.parseInt(age.getText());
		User user = new User(userid,nom.getText(),prenom.getText(),userage,email.getText(),adresse.getText(),ville.getText(),pays.getText());
		implDao.insert(user);
		affiche();
		clear();    
	}
	
	@FXML
	private void onselectAction(ActionEvent event) throws IOException{
		
		affiche();
		
		clear();

//		 if(implDao.insert(user)) {
//			 data.addAll(implDao.select());
//			 tableView.refresh();
//		 }
		
        
	}	
	
	@FXML
	private void onupdateAction(ActionEvent event) throws IOException{
		int user_id = Integer.parseInt(id.getText());
		int user_age = Integer.parseInt(age.getText());
		User user = new User(user_id,nom.getText(),prenom.getText(),user_age,email.getText(),adresse.getText(),ville.getText(),pays.getText());
		System.out.println(implDao.update(user_id, user));
		clear();
	}

	
	@FXML
	private void ondeleteAction(ActionEvent event) throws IOException{
		int user_id = Integer.parseInt(coid.getText());
		new User(user_id,nom.getText(),prenom.getText(),age.getAnchor(),email.getText(),adresse.getText(),ville.getText(),pays.getText());
		implDao.delete(user_id);
		clear();
	}

	@Override
	public void initialize(URL Location, ResourceBundle ressources) {
		affiche ();
	}

}
