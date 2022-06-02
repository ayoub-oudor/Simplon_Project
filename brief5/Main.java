package brief5;
public class Main {

	public static void main(String[] args) {

		
	
		 
		 //insert 
		
		 CandidatDao canDao = new  CandidatDao();
			
			  Candidat cn = new Candidat("hanae", "hanae", 38, "h@", "tetouane", "tetouane","morocco");
			  System.out.println(canDao.save(cn));
			  
			  cn.afficher();
			 
		 
		 
		 //select
		canDao.read();
		
		 //update
		 canDao.update(4, "samir");
		 canDao.read();
		 
		 //delete
	     canDao.delete(5);
	     canDao.read();
		 
	} 

}
 