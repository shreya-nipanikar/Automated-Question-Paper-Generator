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
import com.fuzzyAQP.dao.TeacherDetailsDao;
import com.fuzzyAQP.dao.TeacherDetailsDaoImpl;
import com.fuzzyAQP.pojo.CounsilDetailsPojo;
import com.fuzzyAQP.pojo.TeacherDetailsPojo;
import com.fuzzyAQP.utility.EmailUtility;
import com.google.gson.Gson;

/**
 * Servlet implementation class TeacherServlet
 */
public class CounsilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounsilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		
		CounsilDetailsDao counsilDetailsDao=new CounsilDetailsDaoImpl();
		
		
		
	
		if(action!=null && action.equals("cousilmemberList"))
		{
			List<CounsilDetailsPojo> list=counsilDetailsDao.getCouncileList();
			System.out.println("size"+list.size());
			session.setAttribute("list", list);
			response.sendRedirect("allCounsilList.jsp");
			
		}
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String action=request.getParameter("action");
		System.out.println("action"+action);
		CounsilDetailsDao counsilDetailsDao=new CounsilDetailsDaoImpl();
		HttpSession session=request.getSession();

		
		
		
	 if(action!=null && action.equalsIgnoreCase("RegisterCounsil"))
		{
			String counsil_name=request.getParameter("counsil_name");
			String contact_no=request.getParameter("contact_no");
			String email=request.getParameter("email");
			//String password="You Are Register";
			String branch=request.getParameter("branch");
			
			CounsilDetailsPojo counsilDetailsPojo=new CounsilDetailsPojo();
			counsilDetailsPojo.setName(counsil_name);
			counsilDetailsPojo.setContact_no(contact_no);
			counsilDetailsPojo.setEmail_id(email);
			//counsilDetailsPojo.setPassword(password);
			//teacherDetailsPojo.setBranch(branch);
			
			boolean b=counsilDetailsDao.addCouncileDetails(counsilDetailsPojo);
			if(b)
			{
				//EmailUtility emailUtility=new EmailUtility();
				//emailUtility.sendEmailUtil(email, password);
				//System.out.println("UserNameIDDDDD :"+email +    "    passwordddd :"  +password);
				 request.setAttribute("error", "Details Submitted Successfully!!");
					RequestDispatcher rd=request.getRequestDispatcher("counsilRegister.jsp");
					rd.include(request, response);
			}
			else {
				 request.setAttribute("error", "Sorry..Details Already Exist!!");
					RequestDispatcher rd=request.getRequestDispatcher("counsilRegister.jsp");
					rd.include(request, response);
			}
		}
	 
	 
	 
	 
	 else if(action!=null && action.equals("deleteCounsil"))
		{
		
			long councile_id=Long.parseLong(request.getParameter("counsil_id"));
			System.out.println("councile_id"+councile_id);
			
			boolean b=counsilDetailsDao.deleteCouncile(councile_id);
			if(b){
				PrintWriter out = response.getWriter();
				String json = new Gson().toJson(b);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.write(json);
				//response.sendRedirect("CounsilServlet?action=cousilmemberList");
			}
		}
		
		else if(action!=null && action.equals("updateCounsil"))
		{
			long counsil_id=Long.parseLong(request.getParameter("counsil_id"));
			System.out.println("councile_id"+counsil_id);
			
			List<CounsilDetailsPojo> counsillist=counsilDetailsDao.getCouncileListOnID(counsil_id);
			System.out.println("counsillist "+counsillist.size());
			PrintWriter out = response.getWriter();
			String json = new Gson().toJson(counsillist);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);
			
		}
		
		else if(action!=null && action.equals("updateCounsilDetails"))
		{
			long counsil_id=Long.parseLong(request.getParameter("counsil_id"));
			System.out.println("councile_id"+counsil_id);
			String counsil_name=request.getParameter("counsil_name");
			System.out.println("counsil_name"+counsil_name);
			String contact_no=request.getParameter("contact_no");
			System.out.println("contact_no"+contact_no);
			String email=request.getParameter("email");
			System.out.println("email"+email);
			/*String branch=request.getParameter("branch");
			System.out.println("branch"+branch);*/
			/*String password=request.getParameter("password");
			System.out.println("password"+password);*/
			
			CounsilDetailsPojo counsilDetailsPojo=new CounsilDetailsPojo();
			counsilDetailsPojo.setName(counsil_name);
			counsilDetailsPojo.setContact_no(contact_no);
			counsilDetailsPojo.setEmail_id(email);
			//counsilDetailsPojo.setPassword(password);	
			counsilDetailsPojo.setId(counsil_id);
			//teacherDetailsPojo.setBranch(branch);
			
			boolean b=counsilDetailsDao.updateDetails(counsilDetailsPojo);
			PrintWriter out = response.getWriter();
			String json = new Gson().toJson(b);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);
		}
		else if(action!=null && action.equals("counsilData"))
		{
			String counsil_name=request.getParameter("counsil_name");
			System.out.println("counsil_name"+counsil_name);
			
			List<CounsilDetailsPojo> list=counsilDetailsDao.getCouncileList(counsil_name);
			System.out.println("size"+list.size());
			PrintWriter out = response.getWriter();
			String json = new Gson().toJson(list);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);
		}

	}

}
