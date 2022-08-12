package main;

import dao.CourDao;
import entity.Cour;
 
public class Main2 {

	public static void main(String[] args) {
		
		
		   //Main Admin//
		   //AdminDao dao = new AdminDao();
		   
		   //Admin admin = new Admin("ayoub","1234");
		   //Admin admin1 = new Admin(1,"Ayoub","5432");
           //dao.saveUser(admin);
		   //dao.getUser("ayoub","1234");
		   //dao.getUser(1);
		   //dao.updateUser(admin);
		   //dao.deleteUser(3);
		   
		   //Main Cour//
		   CourDao dao = new CourDao();
		   Cour cour = new Cour("data base","11/08/2022");
		   dao.saveUser(cour);
		   
		   //Main Professeur//
		   
		   
		   //Main Student//
		   
	} 

}
