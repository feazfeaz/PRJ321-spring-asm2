package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDao;
import bean.ProductModel;

public class NotFoundServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get " + this.getClass().getSimpleName());
		System.out.println(req.getContextPath());
		Integer count = (Integer) this.getServletContext().getAttribute("count");
		this.getServletContext().setAttribute("count", count == null ? 0 : ++count );
		req.getRequestDispatcher("/view/not-found.jsp").forward(req, res);
		System.out.println("alo alo alo alo ");
		
//		ProductDao dao = new ProductDao();
//		ArrayList<ProductModel> productModels = dao.getAll();
//		for(ProductModel productModel : productModels){
//			System.out.println(productModel.getId()
//					+":" + productModel.getNameItems()
//					+":" + productModel.getPrice());
//		}
//		
//		ProductModel productModel = dao.getById(3);
//		System.out.println("đơn mục tiêu:" + productModel.getId()
//					+":" + productModel.getNameItems()
//					+":" + productModel.getPrice() );
//		
//		System.out.println(dao.getNames());

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post " + this.getClass().getSimpleName());
		doGet(req, res);
	}
	
}
//UserDao user = new UserDao();
//ArrayList<UserModel> userModels = user.getAll();
//
//if(userModels == null){
//	System.out.println("null");
//	return ;
//}
//
//for(UserModel model : userModels){
//	System.out.println(model.getId() 
//			+ " | " + model.getUsername()
//			+ " | " + model.getPassword()
//			+ " | " + model.getName()
//			+ " | " + model.getRole());
//}
//
//UserModel userM =  user.login(req.getParameter("tk"),req.getParameter("mk"));
//if(userM == null){
//	System.out.println("có người lạ!");
//}else{
//	System.out.println("id: "+userM.getId()
//	+"\ntk: "+userM.getUsername()
//	+"\nmk: "+userM.getPassword());
//}