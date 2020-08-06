package com.fuzzyAQP.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action != null && action.equalsIgnoreCase("Logout") )
		{
		/*	System.out.println("LLLLLLL");
			HttpSession session=request.getSession();
			session.invalidate();
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
			cookie.setMaxAge(0);
			cookie.setValue(null);
			cookie.setPath("/");
			response.addCookie(cookie);
		    response.sendRedirect("login.jsp");*/
			Cookie[] cookies=request.getCookies();
		    String userName = "", password = "",rememberVal="";
		    if (cookies != null) {
		         for (Cookie cookie : cookies) {
		           if(cookie.getName().equals("cookuser")) {
		             userName = cookie.getValue();
		           }
		           if(cookie.getName().equals("cookpass")){
		             password = cookie.getValue();
		           }
		           if(cookie.getName().equals("cookrem")){
		             rememberVal = cookie.getValue();
		           }
		         }
		    }
		    Cookie cUserName = new Cookie("cookuser", userName.trim());
	        Cookie cPassword = new Cookie("cookpass", password.trim());
	        Cookie cRemember = new Cookie("cookrem", rememberVal.trim());
	        cUserName.setMaxAge(0);//15 days
	        cPassword.setMaxAge(0);
	        cRemember.setMaxAge(0);
	        response.addCookie(cUserName);
	        response.addCookie(cPassword);
	        response.addCookie(cRemember);
		    HttpSession httpSession = request.getSession();
		    httpSession.invalidate();
		    request.setAttribute("msg", "You have successfully logged out.");
		    response.sendRedirect("login.jsp");
		    /*RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
		    requestDispatcher.forward(request, response);*/
		
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
