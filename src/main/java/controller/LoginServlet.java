package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.Users;


public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("get /login");
		
		//logout
		if(req.getParameter("action") != null && req.getParameter("action").equals("logout")){
			
			logout(req, res);

			return;
		}
		
		req.getRequestDispatcher("view/login.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("post /login");
		//retrieve user
		String userValue = req.getParameter("username").trim();
		String passValue = req.getParameter("password").trim();
		
		System.out.println("có gi đó sai sai");
		
		Users users = Users.getInstance();
		if(userValue.isEmpty() || passValue.isEmpty()){
			req.setAttribute("error", "Dont let empty your username or password!");
			doGet(req, res);
			
		}else if(userValue.equals(users.adminName) && passValue.equals(users.adminPass)){
			System.out.println("đúng rồi ");
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("isAdmin", true);
			req.setAttribute("isAdmin", true);
			//login as admin
			req.getRequestDispatcher("/admin").forward(req, res);
			
		}else if(userValue.equals(users.userName) && passValue.equals(users.password)){
			//login as user
			
			//set cookie
			Cookie cookieUsername = new Cookie("un", userValue);
			cookieUsername.setMaxAge(60*60*24*30);
			Cookie cookiePassword = new Cookie("pw", passValue);
			cookiePassword.setMaxAge(60*60*24*30);
			res.addCookie(cookieUsername);
			res.addCookie(cookiePassword);
			
			//redirect
			req.getRequestDispatcher("index.jsp").forward(req, res);
			
		}else{
			req.setAttribute("error", "You wrong your username or password!");
			doGet(req, res);
		}
	}
	
	public void logout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//set cookie
		Cookie cookieUsername = new Cookie("un", null);
		cookieUsername.setMaxAge(0);
		Cookie cookiePassword = new Cookie("pw", null);
		cookiePassword.setMaxAge(0);
		res.addCookie(cookieUsername);
		res.addCookie(cookiePassword);
		
		req.getRequestDispatcher("index.jsp").forward(req, res);
	}
}
