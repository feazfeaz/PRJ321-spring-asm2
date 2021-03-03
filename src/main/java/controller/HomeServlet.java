package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ProductDao;
import DAO.UserDao;
import bean.Model;
import bean.ProductModel;
import bean.UserModel;

public class HomeServlet extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("có thằng nào đó gọi home GET");
		
		if(req.getParameter("action") != null && req.getParameter("action").equals("addProd")){
			System.out.println(req.getParameter("idProd"));
			HttpSession httpSession = req.getSession();
			
			ArrayList<ProductModel> productModels = httpSession.getAttribute("cart") == null 
					? new ArrayList<ProductModel>() : (ArrayList<ProductModel>)  httpSession.getAttribute("cart");
					
			productModels.add(new ProductDao().getById(Integer.parseInt(req.getParameter("idProd"))));
			
			httpSession.setAttribute("cart", productModels);
		}
		
		//check cookei to retrieve user
		req.setAttribute("userObj", retrieveUser(req, resp));
		req.setAttribute("prods", new ProductDao().getAll());
		req.getRequestDispatcher("view/home.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("có thằng nào đó gọi home POST");
		doGet(req,res);
	}
	
	public UserModel retrieveUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String username = null
				, password = null
				, name = null;
		if(req.getCookies()== null){return null;}
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
		
		return (username != null && password != null) 
				? new UserDao().login(username, password) : null; 
	}
	
}
