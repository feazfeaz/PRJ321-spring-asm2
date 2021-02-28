package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.UserBean;

public class TestServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("somebody get me?");
		
		testFunc(req,res);

		req.getRequestDispatcher("view/test.jsp").forward(req, res);
	}
	
	void testFunc(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		sendObjectAsAtt(req,res);
		ssAndCookie(req,res);
		
	}
	
	//cookei thực sự mất khi đóng trình duyệt nhé dafuggggggggggg
	void ssAndCookie(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			System.out.println("have some old cookei");
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName() + " : " + cookie.getValue());
			}
		}else{
			System.out.println("nothing so creating cookei...");
			Cookie cookie1 = new Cookie("cookei1", "value of cookei 1");
			cookie1.setMaxAge(60*60*24);
			Cookie cookie2 = new Cookie("cookei2", "value of cookei 2");
			//not age
			res.addCookie(cookie2);
			res.addCookie(cookie1);
		}
		
		HttpSession httpSession = req.getSession();
		System.out.println(httpSession.isNew() ? " SS nó mới" : "SS nó cũ");
		System.out.println(httpSession.getAttribute("username"));
		if(httpSession.isNew()){
			System.out.println("mới");
			httpSession.setAttribute("username", "thisisusername");
		}else{
			System.out.println("cũ");
			System.out.println(httpSession.getAttribute("username"));
		}
		
		
	} 
	
	
	
	void sendObjectAsAtt(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		UserBean send = new UserBean();
		send.setUsername("alo alo alo");
		req.setAttribute("ulti", send);
		req.setAttribute("example", "this is example");
		UserBean asd =  (UserBean) req.getAttribute("ulti");
		System.out.println(asd.getUsername());
	}

}
