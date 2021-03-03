package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ProductModel;

public class CartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("display");
		HttpSession httpSession = req.getSession();
		ArrayList<ProductModel> productModels = httpSession.getAttribute("cart") == null
				? new ArrayList<ProductModel>() : (ArrayList<ProductModel>) httpSession.getAttribute("cart");
		req.setAttribute("prods", productModels);
		req.getRequestDispatcher("/view/search.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
