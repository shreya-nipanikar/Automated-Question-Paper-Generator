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

import com.fuzzyAQP.dao.TeacherDetailsDao;
import com.fuzzyAQP.dao.TeacherDetailsDaoImpl;
import com.fuzzyAQP.pojo.TeacherDetailsPojo;
import com.fuzzyAQP.utility.EmailUtility;
import com.google.gson.Gson;

/**
 * Servlet implementation class TeacherServlet
 */
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherServlet() {
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
		
		TeacherDetailsDao teacherDetailsDao=new TeacherDetailsDaoImpl();
		
		
		
	
		if(action!=null && action.equals("teacherList"))
		{
			List<TeacherDetailsPojo> list=teacherDetailsDao.getTeacherList();
			System.out.println("size"+list.size());
			session.setAttribute("list", list);
			response.sendRedirect("allTeacherList.jsp");
			
		}
		else if(action!=null && action.equals("subAdminteacherList"))
		{
			String email=(String) session.getAttribute("username");
			List<TeacherDetailsPojo> list=teacherDetailsDao.getTeacherListSubAdmin(email);
			System.out.println("size"+list.size());
			session.setAttribute("list", list);
			response.sendRedirect("subAdminTeacherList.jsp");
			
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
		TeacherDetailsDao teacherDetailsDao=new TeacherDetailsDaoImpl();
		HttpSession session=request.getSession();

		
		
		
	 if(action!=null && action.equalsIgnoreCase("RegisterTeacher"))
		{
			String teacher_name=request.getParameter("teacher_name");
			String contact_no=request.getParameter("contact_no");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			String branch=request.getParameter("branch");
			int roll_id=(int) session.getAttribute("rollID");
			String uname=(String) session.getAttribute("username");
			
			TeacherDetailsPojo teacherDetailsPojo=new TeacherDetailsPojo();
			teacherDetailsPojo.setName(teacher_name);
			teacherDetailsPojo.setContact_no(contact_no);
			teacherDetailsPojo.setEmail_id(email);
			teacherDetailsPojo.setPassword(password);
			teacherDetailsPojo.setBranch(branch);
			teacherDetailsPojo.setRoll_id(roll_id);
			teacherDetailsPojo.setUsername(uname);
			
			boolean b=teacherDetailsDao.addTeacherDetails(teacherDetailsPojo);
			if(b)
			{
				System.out.println("register if");
				EmailUtility emailUtility=new EmailUtility();
				emailUtility.sendEmailUtil(email, password);
				System.out.println("UserNameIDDDDD :"+email +    "    passwordddd :"  +password);
				 request.setAttribute("error", "Details Submitted Successfully!!");
					RequestDispatcher rd=request.getRequestDispatcher("teacherRegister.jsp");
					rd.include(request, response);
			}
			else {
				System.out.println("register elseif");
				 request.setAttribute("error", "Sorry..Details Already Exist!!");
					RequestDispatcher rd=request.getRequestDispatcher("teacherRegister.jsp");
					rd.include(request, response);
			}
		}
	 
	 
	 
	 
	 else if(action!=null && action.equals("deleteTeacher"))
		{
		
			long teacher_id=Long.parseLong(request.getParameter("teacher_id"));
			System.out.println("teacher_id"+teacher_id);
			
			boolean b=teacherDetailsDao.deleteTeacher(teacher_id);
			if(b){
				PrintWriter out = response.getWriter();
				String json = new Gson().toJson(b);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.write(json);
				
				//response.sendRedirect("TeacherServlet?action=teacherList");
			}
		}
		
		else if(action!=null && action.equals("updateTeacher"))
		{
			long teacher_id=Long.parseLong(request.getParameter("teacher_id"));
			System.out.println("teacher_id"+teacher_id);
			
			List<TeacherDetailsPojo> facultylist=teacherDetailsDao.getTeacheListOnID(teacher_id);
			PrintWriter out = response.getWriter();
			String json = new Gson().toJson(facultylist);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);
			
		}
		
		else if(action!=null && action.equals("updateTeacherDetails"))
		{
			long teacher_id=Long.parseLong(request.getParameter("teacher_id"));
			System.out.println("teacher_id"+teacher_id);
			String teacher_name=request.getParameter("teacher_name");
			System.out.println("teacher_name"+teacher_name);
			String contact_no=request.getParameter("contact_no");
			System.out.println("contact_no"+contact_no);
			String email=request.getParameter("email");
			System.out.println("email"+email);
			String branch=request.getParameter("branch");
			System.out.println("branch"+branch);
			/*String password=request.getParameter("password");
			System.out.println("password"+password);*/
			
			TeacherDetailsPojo teacherDetailsPojo=new TeacherDetailsPojo();
			teacherDetailsPojo.setName(teacher_name);
			teacherDetailsPojo.setContact_no(contact_no);
			teacherDetailsPojo.setEmail_id(email);
			//teacherDetailsPojo.setPassword(password);	
			teacherDetailsPojo.setId(teacher_id);
			teacherDetailsPojo.setBranch(branch);
			
			boolean b=teacherDetailsDao.updateDetails(teacherDetailsPojo);
			PrintWriter out = response.getWriter();
			String json = new Gson().toJson(b);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);
		}
	 
		else if(action!=null && action.equals("teacherData"))
		{
			String teacher_name=request.getParameter("teacher_name");
			System.out.println("teacher_name"+teacher_name);
			List<TeacherDetailsPojo> b=teacherDetailsDao.teacherDetails(teacher_name);
			PrintWriter out = response.getWriter();
			String json = new Gson().toJson(b);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);
		}

	}

}
