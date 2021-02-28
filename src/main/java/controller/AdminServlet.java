package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AdminServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("tao củng nhận dc");
		HttpSession httpSession = req.getSession();
		System.out.println("alo "+ Boolean.parseBoolean(req.getAttribute("isAdmin")+""));
		if((httpSession.getAttribute("isAdmin") != null 
				&& Boolean.parseBoolean(httpSession.getAttribute("isAdmin")+"") ) 
				|| Boolean.parseBoolean(req.getAttribute("isAdmin")+"")
				){
			System.out.println("có vào đây");
			req.getRequestDispatcher("/admin-view/index.jsp").forward(req, res);
		}else{
			System.out.println("có gì sai không?");
			System.out.println("có");
			
			System.out.println("req " + req.getAttribute("isAdmin"));
			System.out.println("ss  ");
//			req.getRequestDispatcher("/login").forward(req, res);
			req.getRequestDispatcher("/login").forward(req, res);
		}

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}
}
