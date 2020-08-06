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









import com.fuzzyAQP.dao.SubAdminDao;
import com.fuzzyAQP.dao.SubAdminDaoImpl;
import com.fuzzyAQP.pojo.SubAdminDetailsPojo;
import com.fuzzyAQP.utility.EmailUtility;
import com.google.gson.Gson;

/**
 * Servlet implementation class SubAdminServlet
 */
public class SubAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
String action=request.getParameter("action");
		
		System.out.println("action"+action);
		SubAdminDao subadminDao=new SubAdminDaoImpl();
		HttpSession session=request.getSession();
		
		if(action!=null && action.equals("viewSubAdmin"))
		{
		
			List<SubAdminDetailsPojo> subadminList=subadminDao.getAllSubAdmin();
			System.out.println("subadminList size"+subadminList.size());
			session.setAttribute("subadminList", subadminList);
			response.sendRedirect("viewSubAdmin.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String action=request.getParameter("action");
		
		System.out.println("action"+action);
		SubAdminDao subadminDao=new SubAdminDaoImpl();
		HttpSession session=request.getSession();
		
		if(action!=null && action.equals("RegisterSubAdmin"))
		{
		String name=request.getParameter("name");
		String contact_no=request.getParameter("contact_no");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println("name"+name);
		System.out.println("contact_no"+contact_no);
		int roll_id=(int) session.getAttribute("rollID");
		
		SubAdminDetailsPojo subAdminDetailsPojo=new SubAdminDetailsPojo();
		subAdminDetailsPojo.setName(name);
		subAdminDetailsPojo.setEmail(email);
		subAdminDetailsPojo.setContact_no(contact_no);
		subAdminDetailsPojo.setPassword(password);
		subAdminDetailsPojo.setRoll_id(roll_id);
		
		
		boolean x=subadminDao.AddSubAdmin(subAdminDetailsPojo);
		if(x)
		{
			EmailUtility emailUtility=new EmailUtility();
			emailUtility.sendEmailUtil(email,password);
			
			System.out.println("email Student servlet :"+email+"email Student servlet :"+password);
			request.setAttribute("error", "Details Submitted Successfully!!");
			RequestDispatcher rd=request.getRequestDispatcher("addSubAdmin.jsp");
			rd.include(request, response);
		}
		else
		{
			 request.setAttribute("error", "Sorry..Details Already Exist!!");
				RequestDispatcher rd=request.getRequestDispatcher("teacherRegister.jsp");
				rd.include(request, response);
		}
		}
		
		else if(action!=null && action.equals("deleteSubAdmin"))
		{
			
			int id =Integer.parseInt(request.getParameter("rowID"));
			System.out.println("id"+id);
			
			
			
			boolean b = subadminDao.deleteSubAdmin(id);
			System.out.println("servlet boolean"+b);
			if (b)
			{
				PrintWriter out = response.getWriter(); 
				String json = new Gson().toJson(b); 
				response.setContentType("application/json"); 
				response.setCharacterEncoding("UTF-8"); 
				out.write(json);
			}
	
			
			
			
		}
		
		else if(action!=null && action.equals("subAdminById"))
		{
			
			int id =Integer.parseInt(request.getParameter("rowID"));
			System.out.println("id"+id);
			
			
			
			SubAdminDetailsPojo subAdminDetailsPojo=subadminDao.getSubAdmin(id);
			//System.out.println("servlet boolean"+b);
			
			PrintWriter out = response.getWriter(); 
			String json = new Gson().toJson(subAdminDetailsPojo); 
			response.setContentType("application/json"); 
			response.setCharacterEncoding("UTF-8"); 
			out.write(json);
		}
		
		else if(action!=null && action.equals("updateSubAdmin"))
		{
			long id=Long.parseLong(request.getParameter("subadmin_ID"));
			String name=request.getParameter("subadmin_name");
			String contact_no=request.getParameter("contact_no");
			String email=request.getParameter("email");
			//String password=request.getParameter("password");
			System.out.println("name"+name);
			System.out.println("contact_no"+contact_no);
			
			SubAdminDetailsPojo subAdminDetailsPojo=new SubAdminDetailsPojo();
			subAdminDetailsPojo.setName(name);
			subAdminDetailsPojo.setEmail(email);
			subAdminDetailsPojo.setContact_no(contact_no);
			//subAdminDetailsPojo.setPassword(password);
			subAdminDetailsPojo.setId(id);
			boolean b =subadminDao.updatesubAdminn(subAdminDetailsPojo);
			if(b)
			{
				PrintWriter out = response.getWriter(); 
				String json = new Gson().toJson(b); 
				response.setContentType("application/json"); 
				response.setCharacterEncoding("UTF-8"); 
				out.write(json);
			//	response.sendRedirect("SubAdminServlet?action=viewSubAdmin");
			}
			else
			{
				response.sendRedirect("login.jsp");
			}
		}
		
		else if(action!=null && action.equals("subadminData"))
		{
			String subadmin_name=request.getParameter("subadmin_name");
			System.out.println("subadmin_name"+subadmin_name);
			List<SubAdminDetailsPojo> subadminList=subadminDao.getAllSubAdmin(subadmin_name);
			System.out.println("subadminList size"+subadminList.size());
			PrintWriter out = response.getWriter(); 
			String json = new Gson().toJson(subadminList); 
			response.setContentType("application/json"); 
			response.setCharacterEncoding("UTF-8"); 
			out.write(json);
		}
		
	
	}

}
