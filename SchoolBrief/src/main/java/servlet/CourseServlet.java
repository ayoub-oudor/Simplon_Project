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


import dao.StudentDao;
import entity.Student;


@WebServlet("/")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Student student = new Student();
    public StudentDao studentdao;
    
	public void init() {
		studentdao = new StudentDao();
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
				System.out.println("list des etudiants");
				listStudent(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	protected void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List <Student> listStudent = studentdao.getAllUser();
		request.setAttribute("listStudent",listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentList.jsp");
		dispatcher.forward(request, response);
		response.sendRedirect("studentList.jsp");
	}
	

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Ayoub");
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentAdd.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean existingUser = studentdao.getUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentAdd.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("mmm");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");

		student.setNom(nom);
		student.setPrenom(prenom);

		
		try {
			studentdao.saveUser(student);
			response.sendRedirect("studentList.jsp");
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");

		student.setNom(nom);
		student.setPrenom(prenom);

		
		try {
			studentdao.updateUser(student);
			response.sendRedirect("studentList.jsp");
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
		
	}
	

	private void delete(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		studentdao.deleteUser(id);
		response.sendRedirect("studentList.jsp");
		
	}
}
