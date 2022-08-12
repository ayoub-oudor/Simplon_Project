package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.ProfesseurDao;
import entity.Professeur;


@WebServlet("/")
public class ProfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Professeur prof = new Professeur();
    public ProfesseurDao profdao;
    
	public void init() {
		profdao = new ProfesseurDao();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				System.out.println("new");
				showNewForm(request, response);
				break;
			case "/insert":
				System.out.println("insert");
				insert(request, response);
				break;
			case "/delete":
				System.out.println("delete");
				delete(request, response);
				break;
			case "/edit":
				System.out.println("edit");
				showEditForm(request, response);
				break;
			case "/update":
				System.out.println("update");
				update(request, response);
				break;
			default:
				System.out.println("list des professeurs");
				listProfesseur(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	protected void listProfesseur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List <Professeur> listProfesseur = profdao.getAllUser();
		request.setAttribute("listProfesseur",listProfesseur);
		RequestDispatcher dispatcher = request.getRequestDispatcher("profList.jsp");
		dispatcher.forward(request, response);
		response.sendRedirect("profList.jsp");
	}
	

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Ayoub");
		RequestDispatcher dispatcher = request.getRequestDispatcher("profAdd.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean existingUser = profdao.getUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("profAdd.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("mmm");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");

		prof.setNom(nom);
		prof.setPrenom(prenom);

		
		try {
			profdao.saveUser(prof);
			response.sendRedirect("profList.jsp");
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");

		prof.setNom(nom);
		prof.setPrenom(prenom);

		
		try {
			profdao.updateUser(prof);
			response.sendRedirect("profList.jsp");
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
		
	}
	

	private void delete(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		profdao.deleteUser(id);
		response.sendRedirect("profList.jsp");
		
	}
}
