package com.fuzzyAQP.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;









import com.fuzzyAQP.dao.CounsilDetailsDao;
import com.fuzzyAQP.dao.CounsilDetailsDaoImpl;
import com.fuzzyAQP.dao.SubAdminDao;
import com.fuzzyAQP.dao.SubAdminDaoImpl;
import com.fuzzyAQP.dao.TeacherDetailsDao;
import com.fuzzyAQP.dao.TeacherDetailsDaoImpl;
import com.fuzzyAQP.pojo.CounsilDetailsPojo;
import com.fuzzyAQP.pojo.SubAdminDetailsPojo;
import com.fuzzyAQP.pojo.TeacherDetailsPojo;
import com.fuzzyAQP.utility.EmailUtility;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int  attempt;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException
    {
    	attempt=0;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		System.out.println("action"+action);
		TeacherDetailsDao teacherDetailsDao=new TeacherDetailsDaoImpl();
		SubAdminDao subAdminDao=new SubAdminDaoImpl();
		CounsilDetailsDao counsilDetailsDao=new CounsilDetailsDaoImpl();
		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();  
		
		if(action!=null && action.equals("Login"))
		{
			String username=request.getParameter("username");
			session.setAttribute("loginusername", username);
			System.out.println("username"+username);
			String password=request.getParameter("password");
			System.out.println("password"+password);
			
			if(username.equals("admin@gmail.com")&&password.equals("admin"))
			{
				session.setAttribute("rollID", 0);
				response.sendRedirect("adminHome.jsp");
			}
			else if(!username.equals("admin@gmail.com")&& !password.equals("admin"))
			{

				username=request.getParameter("username");
			    password=request.getParameter("password");
			    TeacherDetailsPojo teacherDetailsPojo=new TeacherDetailsPojo();
				teacherDetailsPojo.setEmail_id(username);
				teacherDetailsPojo.setPassword(password);
			    session.setAttribute("email", username);
			    boolean x1=teacherDetailsDao.teacherLogin(username, password);
					
			   if(x1)
				 {
					   TeacherDetailsPojo teacherDetailsPojo2=teacherDetailsDao.getDetailsOnEmail(username);
					   long teacher_id=teacherDetailsPojo2.getId();
					   System.out.println("teacher_id......."+teacher_id);
					   session.setAttribute("teacher_id", teacher_id);
					   response.sendRedirect("teacherHome.jsp");
				 }
			  
				else
				{
					SubAdminDetailsPojo subAdminDetailsPojo=new SubAdminDetailsPojo();
					subAdminDetailsPojo.setEmail(username);
					subAdminDetailsPojo.setPassword(password);
					 boolean x2=subAdminDao.Login(username, password);
					 if(x2)
					 {
						 session.setAttribute("username", username);
						 session.setAttribute("rollID", 1);
						 response.sendRedirect("subAdminHome.jsp");
					 }
					
					 else{
						 
						 
						 attempt = attempt + 1;
			                System.out.println("attempt"+attempt);
			                if(attempt<=3)
			                {
			                  System.out.println("dont login");
			                  System.out.println("attempt"+attempt);
			                  request.setAttribute("error", "Your Username OR Password is Wrong..!");
			  		        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			  		        rd.include(request, response);
			                 // response.sendRedirect("login.jsp");
			                
			               
			                }
			                else
			                {
			                	String msg="";
			                	EmailUtility emailUtility=new EmailUtility();
			                	List<CounsilDetailsPojo> list=counsilDetailsDao.getCouncileList();
			                	for(int i=0;i<list.size();i++){
			                		String email=list.get(i).getEmail_id();
			                		
			        				emailUtility.sendEmail1(email, username);
			                	}
			        			System.out.println("size"+list.size());
			                    System.out.println("login");
			                    System.out.println("attempt"+attempt);
			                    attempt = 0;
			                    
			                   /* request.setAttribute("error", "Your Username OR Password is Wrong..!");
						        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
						        rd.include(request, response);*/
			                    response.sendRedirect("login.jsp");
			                  
			                    
			                    
			                    //emailUtility.sendEmail(toAddress, subject, message, attachFiles);
			                } 
					 
						 
						 /*request.setAttribute("error", "Your Username OR Password is Wrong..!");
					        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
					        rd.include(request, response);*/
						 
					 }
					
				}
			
			}
			else
			{
				
				
					 attempt = attempt + 1;
		                System.out.println("attempt"+attempt);
		                if(attempt<=3)
		                {
		                  System.out.println("dont login");
		                  System.out.println("attempt"+attempt);
		                  request.setAttribute("error", "Your Username OR Password is Wrong..!");
		  		        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		  		        rd.include(request, response);
		                 // response.sendRedirect("login.jsp");
		                
		               
		                }
		                else
		                {
		                	String msg="";
		                	EmailUtility emailUtility=new EmailUtility();
		                	List<CounsilDetailsPojo> list=counsilDetailsDao.getCouncileList();
		                	for(int i=0;i<list.size();i++){
		                		String email=list.get(i).getEmail_id();
		                		
		        				emailUtility.sendEmail1(email, username);
		                	}
		        			System.out.println("size"+list.size());
		                    System.out.println("login");
		                    System.out.println("attempt"+attempt);
		                    attempt = 0;
		                    response.sendRedirect("login.jsp");
		                  
		                    
		                    
		                    //emailUtility.sendEmail(toAddress, subject, message, attachFiles);
		                } 
				 
				
				
				
			}
		
			
		
		  
		}
	}
}

