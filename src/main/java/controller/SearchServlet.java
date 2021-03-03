package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDao;
import bean.ProductModel;

public class SearchServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("alo");
		System.out.println(req.getParameter("search"));
		ArrayList<ProductModel> productModels = new ProductDao().getAll();
		ArrayList<ProductModel> result = new ArrayList<ProductModel>();
		
		for (ProductModel p : productModels) {
			if(p.getNameItems().contains(req.getParameter("search").trim())){
				result.add(p);
			}
		}
		String.valueOf(null);
		System.out.println("an toan");
		req.setAttribute("isAddAble", 1);
		req.setAttribute("prods", result);
		req.getRequestDispatcher("/view/search.jsp").forward(req, res);;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req, res);
		
	}

}
