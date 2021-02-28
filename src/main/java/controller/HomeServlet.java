package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import utils.Users;

public class HomeServlet extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("có thằng nào đó gọi home GET");
		
		//check cookei to retrieve user
		req.setAttribute("userObj", retrieveUser(req, resp));
		
		req.getRequestDispatcher("view/home.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("có thằng nào đó gọi home POST");
		doGet(req,res);
	}
	
	public User retrieveUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String username = null
				, password = null
				, name = null;
		for (Cookie cookie: req.getCookies()) {
			if(cookie.getName().equals("un")){
				username = cookie.getValue().trim();
			}else if(cookie.getName().equals("pw")) {
				password = cookie.getValue().trim();
			}else if(cookie.getName().equals("name")){
				name = cookie.getValue();
			}
		}
		System.out.println(username + ":" + password + ":" + name );
		Users users = Users.getInstance();
		if(username != null && password != null 
				&& username.equals(users.userName) && password.equals(users.password)) {
			return new User(username,password,name);
		}else{
			return null;
		}
	}
	
}
