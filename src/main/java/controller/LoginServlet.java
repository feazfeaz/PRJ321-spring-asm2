package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("req get login ");
		req.getRequestDispatcher("view/login.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("req post login ");
		
		if(req.getParameter("username").trim().equals(getServletContext().getInitParameter("username")) 
				&& req.getParameter("password").trim().equals(getServletContext().getInitParameter("password"))  ){
			req.getRequestDispatcher("view/home.jsp").forward(req, res);;
		}else{
			req.setAttribute("erro", "You wrong your username or password!");
			req.getRequestDispatcher("view/login.jsp").forward(req, res);
		}
	}
}
