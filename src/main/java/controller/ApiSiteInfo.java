package controller;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import utils.UserBean;

/**
 * Servlet implementation class ApiSiteInfo
 */
@WebServlet (urlPatterns= {"/api/info"})
public class ApiSiteInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiSiteInfo() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(req.getContextPath() + " GET");
		
		test(req,res);
		
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getContextPath() + " POST");
		doGet(request, response);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getContextPath() + " PUT");
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getContextPath() + " DELETE");
	}

	 
	void test(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("UTF-8");
		System.out.println(req.getParameter("a"));
		System.out.println(req.getParameter("par1"));
		System.out.println("isNull: " + req.getReader() == null);
		BufferedReader br = req.getReader();
		String line = "";
		String finalResult = "";

		while ((line = br.readLine()) != null) {
			System.out.println("line: "  + line);
			finalResult+=line;
		}
		System.out.println("đây à kết quả: " + finalResult);
	}
}
