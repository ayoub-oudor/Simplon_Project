package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import dao.AdminDao;


public class Admin_Servlet_login extends HttpServlet {
	AdminDao adminDao = new AdminDao();
	private static final long serialVersionUID = 1L; 
	
    public Admin_Servlet_login() {
        super();
    } 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
 
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login(request, response);
	}

	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("psw");
		//boolean result = adminDao.getUser(username, password);
		PrintWriter out = response.getWriter();
		response.sendRedirect("courseList.jsp");
		
//		try {
//			
//			if(result == true) {
//				response.sendRedirect("index.jsp");
//
//			}
//			else {
//				response.sendRedirect("login.jsp");
//			       out.println("<script type=\"text/javascript\">");
//			       out.println("alert('Username or password incorrect');");
//			       out.println("location='Signin_Admin.jsp';");
//			       out.println("</script>");
//
//			}
//		}
//		catch(Exception e){
//			e.printStackTrace(); 
//		}
		
	}
}
