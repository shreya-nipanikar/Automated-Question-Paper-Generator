package com.fuzzyAQP.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.fuzzyAQP.dao.SubjectDetailsDao;
import com.fuzzyAQP.dao.SubjectDetailsDaoImpl;
import com.fuzzyAQP.pojo.CustomizePojo;
import com.fuzzyAQP.pojo.PaperSetDetailsPojo;
import com.fuzzyAQP.pojo.QuestionDetailsPojo;
import com.fuzzyAQP.pojo.SubjectDetailsPojo;
/*import com.fuzzyAQP.utility.EmailUtility;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;*/

/**
 * Servlet implementation class TeacherServlet
 */
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		SubjectDetailsDao subjectDetailsDao=new SubjectDetailsDaoImpl();
	
		if(action!=null && action.equals("branchList"))
		{
			List<SubjectDetailsPojo> branchList=subjectDetailsDao.getBranchList();
			System.out.println("size"+branchList.size());
			session.setAttribute("branchList", branchList);
			response.sendRedirect("subjectRegister.jsp");
			
		}
		
		else if(action!=null && action.equals("yearList"))
		{
			String branch=request.getParameter("branch_name");
			
			List<SubjectDetailsPojo> yearList=subjectDetailsDao.getYearList(branch);
			System.out.println("size"+yearList.size());
			PrintWriter out = response.getWriter();
			String json = new Gson().toJson(yearList);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);
			
		}
		
		else if(action!=null && action.equals("semList"))
		{
			String year=request.getParameter("year");
			List<SubjectDetailsPojo> semList=subjectDetailsDao.getSemList(year);
			System.out.println("size"+semList.size());
			PrintWriter out = response.getWriter();
			String json = new Gson().toJson(semList);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);
			
		}
		else if(action!=null && action.equals("subjectDetailsList"))
		{
			long teacher_id=(long) session.getAttribute("teacher_id");
			List<SubjectDetailsPojo> allSubjectDetailsList=subjectDetailsDao.getAllDetailsSubject(teacher_id);
			System.out.println("size"+allSubjectDetailsList.size());
			session.setAttribute("allSubjectDetailsList", allSubjectDetailsList);
			response.sendRedirect("subjectUpdate.jsp");
		}
		
		else if(action!=null && action.equals("template1f0r80dataSet1"))
		{
			List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set1");
			List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set1");
			List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set1");
			List<QuestionDetailsPojo> set4=(List<QuestionDetailsPojo>) session.getAttribute("list4Set1");
			List<QuestionDetailsPojo> set5=(List<QuestionDetailsPojo>) session.getAttribute("list5Set1");
			List<QuestionDetailsPojo> set6=(List<QuestionDetailsPojo>) session.getAttribute("list6Set1");
			session.setAttribute("list1Set1", set1);
			session.setAttribute("list2Set1", set2);
			session.setAttribute("list3Set1", set3);
			session.setAttribute("list4Set1", set4);
			session.setAttribute("list5Set1", set5);
			session.setAttribute("list6Set1", set6);
			response.sendRedirect("custom80template1.jsp");
		}
		else if(action!=null && action.equals("template1f0r80dataSet2"))
		{
			List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set2");
			List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set2");
			List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set2");
			List<QuestionDetailsPojo> set4=(List<QuestionDetailsPojo>) session.getAttribute("list4Set2");
			List<QuestionDetailsPojo> set5=(List<QuestionDetailsPojo>) session.getAttribute("list5Set2");
			List<QuestionDetailsPojo> set6=(List<QuestionDetailsPojo>) session.getAttribute("list6Set2");
			session.setAttribute("list1", set1);
			session.setAttribute("list2", set2);
			session.setAttribute("list3", set3);
			session.setAttribute("list4", set4);
			session.setAttribute("list5", set5);
			session.setAttribute("list6", set6);
			response.sendRedirect("custom80template1Set2.jsp");
		}
		else if(action!=null && action.equals("template1f0r80dataSet3"))
		{
			List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set3");
			List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set3");
			List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set3");
			List<QuestionDetailsPojo> set4=(List<QuestionDetailsPojo>) session.getAttribute("list4Set3");
			List<QuestionDetailsPojo> set5=(List<QuestionDetailsPojo>) session.getAttribute("list5Set3");
			List<QuestionDetailsPojo> set6=(List<QuestionDetailsPojo>) session.getAttribute("list6Set3");
			session.setAttribute("list1", set1);
			session.setAttribute("list2", set2);
			session.setAttribute("list3", set3);
			session.setAttribute("list4", set4);
			session.setAttribute("list5", set5);
			session.setAttribute("list6", set6);
			response.sendRedirect("custom80template1Set3.jsp");
		}
		
		else if(action!=null && action.equals("template2f0r80dataSet1"))
		{
			List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set1");
			List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set1");
			List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set1");
			List<QuestionDetailsPojo> set4=(List<QuestionDetailsPojo>) session.getAttribute("list4Set1");
			List<QuestionDetailsPojo> set5=(List<QuestionDetailsPojo>) session.getAttribute("list5Set1");
			List<QuestionDetailsPojo> set6=(List<QuestionDetailsPojo>) session.getAttribute("list6Set1");
			session.setAttribute("list1Set1", set1);
			session.setAttribute("list2Set1", set2);
			session.setAttribute("list3Set1", set3);
			session.setAttribute("list4Set1", set4);
			session.setAttribute("list5Set1", set5);
			session.setAttribute("list6Set1", set6);
			response.sendRedirect("custom80template2.jsp");
		}
		else if(action!=null && action.equals("template2f0r80dataSet2"))
		{
			List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set2");
			List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set2");
			List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set2");
			List<QuestionDetailsPojo> set4=(List<QuestionDetailsPojo>) session.getAttribute("list4Set2");
			List<QuestionDetailsPojo> set5=(List<QuestionDetailsPojo>) session.getAttribute("list5Set2");
			List<QuestionDetailsPojo> set6=(List<QuestionDetailsPojo>) session.getAttribute("list6Set2");
			session.setAttribute("tem2list1", set1);
			session.setAttribute("tem2list2", set2);
			session.setAttribute("tem2list3", set3);
			session.setAttribute("tem2list4", set4);
			session.setAttribute("tem2list5", set5);
			session.setAttribute("tem2list6", set6);
			response.sendRedirect("custom80template2Set2.jsp");
		}
		else if(action!=null && action.equals("template2f0r80dataSet3"))
		{
			List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set3");
			List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set3");
			List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set3");
			List<QuestionDetailsPojo> set4=(List<QuestionDetailsPojo>) session.getAttribute("list4Set3");
			List<QuestionDetailsPojo> set5=(List<QuestionDetailsPojo>) session.getAttribute("list5Set3");
			List<QuestionDetailsPojo> set6=(List<QuestionDetailsPojo>) session.getAttribute("list6Set3");
			session.setAttribute("list1", set1);
			session.setAttribute("list2", set2);
			session.setAttribute("list3", set3);
			session.setAttribute("list4", set4);
			session.setAttribute("list5", set5);
			session.setAttribute("list6", set6);
			response.sendRedirect("custom80template2Set3.jsp");
		}
		
		else if(action!=null && action.equals("template3f0r80dataSet1"))
		{
			List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set1");
			List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set1");
			List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set1");
			List<QuestionDetailsPojo> set4=(List<QuestionDetailsPojo>) session.getAttribute("list4Set1");
			List<QuestionDetailsPojo> set5=(List<QuestionDetailsPojo>) session.getAttribute("list5Set1");
			List<QuestionDetailsPojo> set6=(List<QuestionDetailsPojo>) session.getAttribute("list6Set1");
			session.setAttribute("list1Set1", set1);
			session.setAttribute("list2Set1", set2);
			session.setAttribute("list3Set1", set3);
			session.setAttribute("list4Set1", set4);
			session.setAttribute("list5Set1", set5);
			session.setAttribute("list6Set1", set6);
			response.sendRedirect("custom80template3.jsp");
		}
		else if(action!=null && action.equals("template3f0r80dataSet2"))
		{
			List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set2");
			List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set2");
			List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set2");
			List<QuestionDetailsPojo> set4=(List<QuestionDetailsPojo>) session.getAttribute("list4Set2");
			List<QuestionDetailsPojo> set5=(List<QuestionDetailsPojo>) session.getAttribute("list5Set2");
			List<QuestionDetailsPojo> set6=(List<QuestionDetailsPojo>) session.getAttribute("list6Set2");
			session.setAttribute("list1", set1);
			session.setAttribute("list2", set2);
			session.setAttribute("list3", set3);
			session.setAttribute("list4", set4);
			session.setAttribute("list5", set5);
			session.setAttribute("list6", set6);
			response.sendRedirect("custom80template3Set2.jsp");
		}
		else if(action!=null && action.equals("template3f0r80dataSet3"))
		{
			List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set3");
			List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set3");
			List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set3");
			List<QuestionDetailsPojo> set4=(List<QuestionDetailsPojo>) session.getAttribute("list4Set3");
			List<QuestionDetailsPojo> set5=(List<QuestionDetailsPojo>) session.getAttribute("list5Set3");
			List<QuestionDetailsPojo> set6=(List<QuestionDetailsPojo>) session.getAttribute("list6Set3");
			session.setAttribute("list1", set1);
			session.setAttribute("list2", set2);
			session.setAttribute("list3", set3);
			session.setAttribute("list4", set4);
			session.setAttribute("list5", set5);
			session.setAttribute("list6", set6);
			response.sendRedirect("custom80template3Set3.jsp");
		}
		else if(action!=null && action.equals("template1dataSet1"))
		{
			List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("temSet1");
			System.out.println("set1"+set1.size());
			session.setAttribute("temSet1", set1);
			response.sendRedirect("custom30template1.jsp");
		}
		else if(action!=null && action.equals("template1dataSet2"))
		{
			List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("temSet2");
			System.out.println("set2"+set2.size());
			session.setAttribute("set2", set2);
			response.sendRedirect("custom30template1Set2.jsp");
		}
		
		else if(action!=null && action.equals("template1dataSet3"))
		{
			List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("temSet3");
			System.out.println("set3"+set3.size());
			session.setAttribute("set3", set3);
			response.sendRedirect("custom30template1Set3.jsp");
		}
		
		
		else if(action!=null && action.equals("template2dataSet1"))
		{
			List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("allqus");
			List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("allqus1");
			List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("allqus2");
			System.out.println("set1"+set1.size());
			session.setAttribute("allqus", set1);
			session.setAttribute("allqus2", set2);
			session.setAttribute("allqus3", set3);
			response.sendRedirect("custom30template2.jsp");
		}
		else if(action!=null && action.equals("template2dataSet2"))
		{
			List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("allqusSet2");
			List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("allqus1Set2");
			List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("allqus2Set2");
			System.out.println("set1"+set1.size());
			session.setAttribute("allqus2", set1);
			session.setAttribute("allqus2Set2", set2);
			session.setAttribute("allqusSet2", set3);
			response.sendRedirect("custom30template2Set2.jsp");
		}
		
		else if(action!=null && action.equals("template2dataSet3"))
		{
			List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("allqusSet3");
			List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("allqus1Set3");
			List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("allqus2Set3");
			System.out.println("set1"+set1.size());
			session.setAttribute("allqusSet3", set1);
			session.setAttribute("allqus1Set3", set2);
			session.setAttribute("allqus2Set3", set3);
			response.sendRedirect("custom30template2Set3.jsp");
		}
		
		else if(action!=null && action.equals("template3dataSet1"))
		{
			List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("allQuest");
			System.out.println("set1"+set1.size());
			session.setAttribute("allQuest", set1);
			response.sendRedirect("custom30template3.jsp");
		}
		else if(action!=null && action.equals("template3dataSet2"))
		{
			List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("allQuestSet2");
			System.out.println("set2"+set2.size());
			session.setAttribute("set2", set2);
			response.sendRedirect("custom30template3Set2.jsp");
		}
		
		else if(action!=null && action.equals("template3dataSet3"))
		{
			List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("allQuestSet3");
			System.out.println("set3"+set3.size());
			session.setAttribute("set3", set3);
			response.sendRedirect("custom30template3Set3.jsp");
		}
		
		else if(action!=null && action.equals("template4dataSet1"))
		{
			List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1");
			List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2");
			List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3");
			System.out.println("set1"+set1.size());
			session.setAttribute("list1", set1);
			session.setAttribute("list2", set2);
			session.setAttribute("list3", set3);
			response.sendRedirect("custom30template4.jsp");
		}
		else if(action!=null && action.equals("template4dataSet2"))
		{
			List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set2");
			List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set2");
			List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set2");
			System.out.println("set1"+set1.size());
			session.setAttribute("List1Set2", set1);
			session.setAttribute("List2Set2", set2);
			session.setAttribute("List3Set2", set3);
			response.sendRedirect("custom30template4Set2.jsp");
		}
		
		else if(action!=null && action.equals("template4dataSet3"))
		{
			List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set3");
			List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set3");
			List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set3");
			System.out.println("set1"+set1.size());
			session.setAttribute("List1Set3", set1);
			session.setAttribute("List2Set3", set2);
			session.setAttribute("List3Set3", set3);
			response.sendRedirect("custom30template4Set3.jsp");
		}
		else if(action!=null && action.equals("custom30Set1"))
		{
			List<CustomizePojo> set1=(List<CustomizePojo>) session.getAttribute("lst1");
			session.setAttribute("lst1", set1);
			response.sendRedirect("custom30Set1.jsp");
		}
		else if(action!=null && action.equals("custom30Set2"))
		{
			List<CustomizePojo> set2=(List<CustomizePojo>) session.getAttribute("lst2");
			session.setAttribute("lst2", set2);
			response.sendRedirect("custom30Set2.jsp");
		}
		else if(action!=null && action.equals("custom30Set3"))
		{
			List<CustomizePojo> set3=(List<CustomizePojo>) session.getAttribute("lst3");
			session.setAttribute("lst3", set3);
			response.sendRedirect("custom30Set3.jsp");
		}
		
		else if(action!=null && action.equals("custom80Set1"))
		{
			List<CustomizePojo> set1=(List<CustomizePojo>) session.getAttribute("list1");
			session.setAttribute("list1", set1);
			response.sendRedirect("custom80Set1.jsp");
		}
		else if(action!=null && action.equals("custom80Set2"))
		{
			List<CustomizePojo> set2=(List<CustomizePojo>) session.getAttribute("list2");
			session.setAttribute("list2", set2);
			response.sendRedirect("custom80Set2.jsp");
		}
		else if(action!=null && action.equals("custom80Set3"))
		{
			List<CustomizePojo> set3=(List<CustomizePojo>) session.getAttribute("list3");
			session.setAttribute("list3", set3);
			response.sendRedirect("custom80Set3.jsp");
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
		HttpSession session=request.getSession();
		SubjectDetailsDao subjectDetailsDao=new SubjectDetailsDaoImpl();
		
		
		
	 if(action!=null && action.equalsIgnoreCase("RegisterSubject"))
		{
			String branch=request.getParameter("branch");
			String year=request.getParameter("year");
			String sem=request.getParameter("sem");
			int module=Integer.parseInt(request.getParameter("module"));
			String subject=request.getParameter("subject");
			long teacher_id=(long) session.getAttribute("teacher_id");
			
			SubjectDetailsPojo subjectDetailsPojo=new SubjectDetailsPojo();
			subjectDetailsPojo.setBranch(branch);
			subjectDetailsPojo.setNo_of_module(module);
			subjectDetailsPojo.setSemester(sem);
			subjectDetailsPojo.setYear(year);
			subjectDetailsPojo.setSubject(subject);
			subjectDetailsPojo.setTeacher_id(teacher_id);
			
			boolean b=subjectDetailsDao.addSubjectDetails(subjectDetailsPojo);
			System.out.println("bbb"+b);
			if(b)
			{
				System.out.println("n json");
				PrintWriter out = response.getWriter();
				String json = new Gson().toJson(b);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.write(json);
			}
			
		}
	 
	 
	 else if(action!=null && action.equalsIgnoreCase("updateSubject"))
		{
		     long sub_id=0;
			 /*sub_id=Long.parseLong(request.getParameter("subject_id"));
			 System.out.println("sub_id before"+sub_id);
			 if(sub_id == 0){*/
				 sub_id=Long.parseLong(request.getParameter("subject_id"));
			/* }*/
			 System.out.println("sub_id after"+sub_id);
			 SubjectDetailsPojo subjectDetailsList=subjectDetailsDao.getSubjectDetailsOnID(sub_id);
			 PrintWriter out = response.getWriter();
			String json = new Gson().toJson(subjectDetailsList);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);
		}
	 else if(action!=null && action.equalsIgnoreCase("updateSubjectDetails"))
		{
		    long sub_id=Long.parseLong(request.getParameter("subject_id"));
		    System.out.println("sub_id"+sub_id);
		    String branch=request.getParameter("branch");
		    System.out.println("branch"+branch);
			String year=request.getParameter("year");
			System.out.println("year"+year);
			String sem=request.getParameter("sem");
			System.out.println("sem"+sem);
			int module=Integer.parseInt(request.getParameter("module"));
			System.out.println("module"+module);
			String subject=request.getParameter("subject_name");
			
			SubjectDetailsPojo subjectDetailsPojo=new SubjectDetailsPojo();
			subjectDetailsPojo.setBranch(branch);
			subjectDetailsPojo.setNo_of_module(module);
			subjectDetailsPojo.setSemester(sem);
			subjectDetailsPojo.setYear(year);
			subjectDetailsPojo.setSubject(subject);
			subjectDetailsPojo.setSub_id(sub_id);
			boolean b=subjectDetailsDao.updateDetails(subjectDetailsPojo);
			if(b){
				
				PrintWriter out = response.getWriter();
				String json = new Gson().toJson(b);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.write(json);
			}
			
		}
	 else if(action!=null && action.equalsIgnoreCase("deleteSubject"))
		{
		    long sub_id=Long.parseLong(request.getParameter("subject_id"));
		    System.out.println("sub_id"+sub_id);
		    boolean b=subjectDetailsDao.deleteSubject(sub_id);
		    if(b){
		    	PrintWriter out = response.getWriter();
				String json = new Gson().toJson(b);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.write(json);
		    	//response.sendRedirect("SubjectServlet?action=subjectDetailsList");
		    }
		}
	 
	 else if(action!=null && action.equalsIgnoreCase("subjectData"))
		{
		    String subject_name=request.getParameter("subject_name");
		    System.out.println("sub_name"+subject_name);
		    SubjectDetailsPojo subjectDetailsPojo=subjectDetailsDao.getSubjectOnSubName(subject_name);
		    PrintWriter out = response.getWriter();
			String json = new Gson().toJson(subjectDetailsPojo);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);
		}
	 
	 else if(action!=null && action.equalsIgnoreCase("generatePaper"))
	 {
		 String branch=request.getParameter("branch");
		    System.out.println("branch"+branch);
			String year=request.getParameter("year");
			System.out.println("year"+year);
			String sem=request.getParameter("sem");
			System.out.println("sem"+sem);
			String subject=request.getParameter("subject");
			System.out.println("subject"+subject);
			String date=request.getParameter("date");
			System.out.println("date"+date);
			String difficulty=request.getParameter("difficulty");
			System.out.println("difficulty"+difficulty);
			String time=request.getParameter("time");
			System.out.println("time"+time);
			String time2=time.replace(":",".");
			System.out.println("time2"+time2);
			double time1=Double.parseDouble(time2);
			System.out.println("time1"+time1);
			String marks=request.getParameter("marks");
			System.out.println("marks"+marks);
			/*int fmod =Integer.parseInt(request.getParameter("fromModule"));
			int tmod =Integer.parseInt(request.getParameter("toModule"));*/
			String template=request.getParameter("template");
			System.out.println("template"+template);
			session.setAttribute("subject", subject);
			session.setAttribute("sem", sem);
			session.setAttribute("subject", subject);
			session.setAttribute("date", date);
			session.setAttribute("time", time1);
			Random randomGenerator= new Random();
		   /* long q_id=0;
		    String question=null;*/
		    int select=0;
			//String fmod1 =request.getParameter("fromModule");
		    String practical=request.getParameter("practical");
			System.out.println("practical"+practical);
			String theory=request.getParameter("theory");
			System.out.println("theory"+theory);
			
			String[] analytical = practical.split(",");
			String pract1 = analytical[0]; 
			String pract2 = analytical[1];
			 
			System.out.println("pract1"+pract1);
			
			String[] descriptive = theory.split(",");
			String theory1 = descriptive[0]; 
			String theory2 = descriptive[1];
			System.out.println("theory1"+theory1);
			
			String[] difficultyLevel = difficulty.split("-");
			String level1 = difficultyLevel[0]; 
			String level2 = difficultyLevel[1];
			System.out.println("level1"+level1);
			
			int difflevel1=Integer.parseInt(level1);
			int difflevel2=Integer.parseInt(level2);
			int diffAvg=((difflevel1+difflevel2)/2);
			int finalDiff=10-diffAvg;
			
			int analytical1=Integer.parseInt(pract1);
			int analytical2=Integer.parseInt(pract2);
			int descriptive1=Integer.parseInt(theory1);
			int descriptive2=Integer.parseInt(theory2);
			
			int anlAvg=0;
			int desAvg=0;
			double FSKAnl=0;
			double FSKDes=0;
			anlAvg=((analytical1+analytical2)/2);
			desAvg=((descriptive1+descriptive2)/2);
			FSKAnl=10-anlAvg;
			FSKDes=10-FSKAnl;
			System.out.println("anlAvg"+anlAvg);
			System.out.println("desAvg"+desAvg);
			System.out.println("FSKAnl"+FSKAnl);
			System.out.println("FSKDes"+FSKDes);
			
			double mark=0;
			double a1=(FSKAnl/10);
			System.out.println("a1"+a1);
			double analyticalMarks= (a1*mark);
			double b1=(FSKDes/10);
			double descriptiveMarks=(b1*mark);
			System.out.println("analyticalMarks"+analyticalMarks);
			System.out.println("descriptiveMarks"+descriptiveMarks);
			
			
			int max=0;
			String AnalyticalLevel=null;
			String DescriptiveLevel=null;
			int a=((analytical1+descriptive1)/2);
			int b=((analytical1+descriptive2)/2);
			int c=((analytical2+descriptive1)/2);
			int d=((analytical2+descriptive2)/2);
			System.out.println("a"+a+""+"b"+b+""+"c"+c+""+"d"+d );
			if(a>b)
			{
				max=a;
			}
			else if(c>max)
			{
				max=c;
			}
			else if(d>max)
			{
				max=d;
			}
			System.out.println("max"+max);
			
			if(max >=1 && max<=2)
			{
				AnalyticalLevel="veryLow";
				DescriptiveLevel="veryhigh";
			}
			else if(max>=3 && max<=4)
			{
				AnalyticalLevel="low";
				DescriptiveLevel="high";
			}
			else if(max>=5 && max<=6)
			{
				AnalyticalLevel="medium";
				DescriptiveLevel="medium";
			}
			else if(max>=7 && max<=8)
			{
				AnalyticalLevel="high";
				DescriptiveLevel="low";
			}
			else if(max>=9 && max<=10)
			{
				AnalyticalLevel="veryhigh";
				DescriptiveLevel="veryLow";
			}
			System.out.println("AnalyticalLevel"+AnalyticalLevel);
			System.out.println("DescriptiveLevel"+DescriptiveLevel);
			
			
			int osq=7;
			int osm=10;
			double osmAdiv=(analyticalMarks/osm);
			double osmDdiv=(descriptiveMarks/osm);
			
			if((osmAdiv+osmDdiv)>osq)
			{
				osmAdiv=osq-1;
				osmDdiv=1;
			}
			
			double FSKe=0;
			double FSKm=0;
			double FSKd=0;
			if(difficulty.equalsIgnoreCase("1-2"))
			{
				 FSKe=5;
				 FSKm=3;
				 FSKd=2;
			}
			else if(difficulty.equalsIgnoreCase("3-4"))
			{
				 FSKe=4;
				 FSKm=5;
				 FSKd=1;
			}
			else if(difficulty.equalsIgnoreCase("5-6"))
			{
				 FSKe=2;
				 FSKm=3;
				 FSKd=5;
			}
			
			
			double x=FSKe+FSKm+FSKd;
			System.out.println("FSKe"+FSKe);
			System.out.println("FSKm"+FSKm);
			System.out.println("FSKd"+FSKd);
			double w =5;
			double y=x/w;
			
			
			
			double FSKe1=(double)(FSKe/y);
			double FSKm1=(double)(FSKm/y);
			double FSKd1=(double)(FSKd/y);
			
			double FSKe2 =Math.round(FSKe1);
			double FSKm2 =Math.round(FSKm1);
			double FSKd2 =Math.round(FSKd1);
			System.out.println("FSKe1"+FSKe1);
			System.out.println("FSKm1"+FSKm1);
			System.out.println("FSKd1"+FSKd1);
			System.out.println("FSKe2"+FSKe2);
			System.out.println("FSKm2"+FSKm2);
			System.out.println("FSKd2"+FSKd2);
			if(marks.equals("80")){
			 
			if(template.equals("template1"))
			{
				
				
				
				
				
			 osq=9;
			 osm=5;
			List<QuestionDetailsPojo> osmQuestionList=new ArrayList<QuestionDetailsPojo>();

			List<QuestionDetailsPojo> easylistByosm=subjectDetailsDao.getEasyQuestionByOsm(subject,osm);
			List<QuestionDetailsPojo> mediumlistByosm=subjectDetailsDao.getMediumQuestionByOsm(subject,osm);
			List<QuestionDetailsPojo> hardlistByosm=subjectDetailsDao.getHardQuestionByOsm(subject,osm);
			System.out.println("easylistByosm size............"+easylistByosm.size());
			System.out.println("mediumlistByosm size............"+mediumlistByosm.size());
			System.out.println("hardlistByosm size............"+hardlistByosm.size());

			osmQuestionList.addAll(easylistByosm);
			osmQuestionList.addAll(mediumlistByosm);
			osmQuestionList.addAll(hardlistByosm);
			System.out.println("osmQuestionList 5mks"+osmQuestionList.size());
			
			
			 osq=6;
			 osm=10;
			 
			 List<QuestionDetailsPojo> osmQuestionList1=new ArrayList<QuestionDetailsPojo>();
			 
			    List<QuestionDetailsPojo> easylistFor10Marks=subjectDetailsDao.getEasyQuestionByOsm(subject,osm);
				List<QuestionDetailsPojo> mediumlistFor10Marks=subjectDetailsDao.getMediumQuestionByOsm(subject,osm);
				List<QuestionDetailsPojo> hardlistFor10Marks=subjectDetailsDao.getHardQuestionByOsm(subject,osm);
				System.out.println("easylistByosm size............"+easylistFor10Marks.size());
				System.out.println("mediumlistByosm size............"+mediumlistFor10Marks.size());
				System.out.println("hardlistByosm size............"+hardlistFor10Marks.size());
			
				osmQuestionList1.addAll(easylistFor10Marks);
				osmQuestionList1.addAll(mediumlistFor10Marks);
				osmQuestionList1.addAll(hardlistFor10Marks);
				System.out.println("osmQuestionList of 10mks"+osmQuestionList1.size());
			
			
				 osq=2;
				 osm=6;
				 
				 List<QuestionDetailsPojo> osmQuestionList2=new ArrayList<QuestionDetailsPojo>();
				 
				    List<QuestionDetailsPojo> easylistFor6Marks=subjectDetailsDao.getEasyQuestionByOsm(subject,osm);
					List<QuestionDetailsPojo> mediumlistFor6Marks=subjectDetailsDao.getMediumQuestionByOsm(subject,osm);
					List<QuestionDetailsPojo> hardlistFor6Marks=subjectDetailsDao.getHardQuestionByOsm(subject,osm);
					System.out.println("easylistByosm size............"+easylistFor6Marks.size());
					System.out.println("mediumlistByosm size............"+mediumlistFor6Marks.size());
					System.out.println("hardlistByosm size............"+hardlistFor6Marks.size());
				
					osmQuestionList2.addAll(easylistFor6Marks);
					osmQuestionList2.addAll(mediumlistFor6Marks);
					osmQuestionList2.addAll(hardlistFor6Marks);
					System.out.println("osmQuestionList of 6mks"+osmQuestionList2.size());
			
					
					
					 osq=2;
					 osm=4;
					 
					 List<QuestionDetailsPojo> osmQuestionList3=new ArrayList<QuestionDetailsPojo>();
					 
					    List<QuestionDetailsPojo> easylistFor4Marks=subjectDetailsDao.getEasyQuestionByOsm(subject,osm);
						List<QuestionDetailsPojo> mediumlistFor4Marks=subjectDetailsDao.getMediumQuestionByOsm(subject,osm);
						List<QuestionDetailsPojo> hardlistFor4Marks=subjectDetailsDao.getHardQuestionByOsm(subject,osm);
						System.out.println("easylistByosm size............"+easylistFor4Marks.size());
						System.out.println("mediumlistByosm size............"+mediumlistFor4Marks.size());
						System.out.println("hardlistByosm size............"+hardlistFor4Marks.size());
					
						osmQuestionList3.addAll(easylistFor4Marks);
						osmQuestionList3.addAll(mediumlistFor4Marks);
						osmQuestionList3.addAll(hardlistFor4Marks);
						System.out.println("osmQuestionList before for 4mks"+osmQuestionList3.size());
						
						
						//for queston 1
						List<QuestionDetailsPojo> ques1final=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<5;i++){
							
							select=randomGenerator.nextInt(osmQuestionList.size());
					    	QuestionDetailsPojo qid=osmQuestionList.get(select);
					    	ques1final.add(qid);
					    	
					    	osmQuestionList.remove(select);
					        System.out.println("osmQuestionList after:::"+osmQuestionList.size());
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList.get(i).getQuestion());
							ques1final.add(questionDetailsPojo);*/
						}
						System.out.println("ques1final size"+ques1final.size());
						session.setAttribute("list1Set1", ques1final);
					 
						//ques1 set 2
						
						List<QuestionDetailsPojo> ques1finalForSet2=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<5;i++)
					    {
					    	select=randomGenerator.nextInt(osmQuestionList.size());
					    	QuestionDetailsPojo qid=osmQuestionList.get(select);
					    	ques1finalForSet2.add(qid);
					    	
					    	osmQuestionList.remove(select);
					    System.out.println("osmQuestionList:::"+osmQuestionList.size());
					    
					    }
						System.out.println("ques1finalForSet2 size"+ques1finalForSet2.size());
						session.setAttribute("list1Set2", ques1finalForSet2);
						
						//questn 1 set3
						
						List<QuestionDetailsPojo> ques1finalForSet3=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<5;i++)
					    {
					    	select=randomGenerator.nextInt(osmQuestionList.size());
					    	QuestionDetailsPojo qid=osmQuestionList.get(select);
					    	ques1finalForSet3.add(qid);
					    	
					    	osmQuestionList.remove(select);
					    System.out.println("osmQuestionList:::"+osmQuestionList.size());
					    
					    }
						System.out.println("ques1finalForSet3 size"+ques1finalForSet3.size());
						session.setAttribute("list1Set3", ques1finalForSet3);

						
						//for questn 2 10mks set1
						
						List<QuestionDetailsPojo> ques2final=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<2;i++){
							
							select=randomGenerator.nextInt(osmQuestionList1.size());
					    	QuestionDetailsPojo qid=osmQuestionList1.get(select);
					    	ques2final.add(qid);
					    	
					    	osmQuestionList1.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
							
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());
							ques2final.add(questionDetailsPojo);*/
						}
						System.out.println("ques2final size"+ques2final.size());
						session.setAttribute("list2Set1", ques2final);
						
						//q2 set2
						List<QuestionDetailsPojo> ques2finalSet2=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<2;i++){
							
							select=randomGenerator.nextInt(osmQuestionList1.size());
					    	QuestionDetailsPojo qid=osmQuestionList1.get(select);
					    	ques2finalSet2.add(qid);
					    	
					    	osmQuestionList1.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
							
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());
							ques2final.add(questionDetailsPojo);*/
						}
						System.out.println("ques2finalSet2 size"+ques2finalSet2.size());
						session.setAttribute("list2Set2", ques2finalSet2);
						
						
						List<QuestionDetailsPojo> ques2finalSet3=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<2;i++){
							
							select=randomGenerator.nextInt(osmQuestionList1.size());
					    	QuestionDetailsPojo qid=osmQuestionList1.get(select);
					    	ques2finalSet3.add(qid);
					    	
					    	osmQuestionList1.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
							
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());
							ques2final.add(questionDetailsPojo);*/
						}
						System.out.println("ques2finalSet2 size"+ques2finalSet2.size());
						session.setAttribute("list2Set3", ques2finalSet3);
						
						
						
						//for questn 3 set1
						List<QuestionDetailsPojo> ques3final=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<1;i++){
							
							select=randomGenerator.nextInt(osmQuestionList1.size());
					    	QuestionDetailsPojo qid=osmQuestionList1.get(select);
					    	ques3final.add(qid);
					    	osmQuestionList1.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
							
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());*/
							
							
					        select=randomGenerator.nextInt(osmQuestionList2.size());
					    	QuestionDetailsPojo qid1=osmQuestionList2.get(select);
					    	ques3final.add(qid1);
					    	osmQuestionList2.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList2.size());
							/*QuestionDetailsPojo questionDetailsPojo1=new QuestionDetailsPojo();
							questionDetailsPojo1.setQuestion(osmQuestionList2.get(i).getQuestion());*/
							
					        select=randomGenerator.nextInt(osmQuestionList3.size());
					    	QuestionDetailsPojo qid2=osmQuestionList3.get(select);
					    	ques3final.add(qid2);
					    	osmQuestionList3.remove(select);
					        System.out.println("osmQuestionList3 after:::"+osmQuestionList3.size());
							/*QuestionDetailsPojo questionDetailsPojo2=new QuestionDetailsPojo();
							questionDetailsPojo2.setQuestion(osmQuestionList3.get(i).getQuestion());*/
							/*ques3final.add(questionDetailsPojo);
							ques3final.add(questionDetailsPojo1);
							ques3final.add(questionDetailsPojo2);*/
						}
						System.out.println("ques3final size"+ques3final.size());
						session.setAttribute("list3Set1", ques3final);
						
						// ques3 set2
						List<QuestionDetailsPojo> ques3finalSet2=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<1;i++){
							
							select=randomGenerator.nextInt(osmQuestionList1.size());
					    	QuestionDetailsPojo qid=osmQuestionList1.get(select);
					    	ques3finalSet2.add(qid);
					    	osmQuestionList1.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
							
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());*/
							
							
					        select=randomGenerator.nextInt(osmQuestionList2.size());
					    	QuestionDetailsPojo qid1=osmQuestionList2.get(select);
					    	ques3finalSet2.add(qid1);
					    	osmQuestionList2.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList2.size());
							/*QuestionDetailsPojo questionDetailsPojo1=new QuestionDetailsPojo();
							questionDetailsPojo1.setQuestion(osmQuestionList2.get(i).getQuestion());*/
							
					        select=randomGenerator.nextInt(osmQuestionList3.size());
					    	QuestionDetailsPojo qid2=osmQuestionList3.get(select);
					    	ques3finalSet2.add(qid2);
					    	osmQuestionList3.remove(select);
					        System.out.println("osmQuestionList3 after:::"+osmQuestionList3.size());
							/*QuestionDetailsPojo questionDetailsPojo2=new QuestionDetailsPojo();
							questionDetailsPojo2.setQuestion(osmQuestionList3.get(i).getQuestion());
							ques3final.add(questionDetailsPojo);
							ques3final.add(questionDetailsPojo1);
							ques3final.add(questionDetailsPojo2);*/
						}
						System.out.println("ques3finalSet2 size"+ques3finalSet2.size());
						session.setAttribute("list3Set2", ques3finalSet2);
						
						// ques3 set3
						List<QuestionDetailsPojo> ques3finalSet3=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<1;i++){
							
							select=randomGenerator.nextInt(osmQuestionList1.size());
					    	QuestionDetailsPojo qid=osmQuestionList1.get(select);
					    	ques3finalSet3.add(qid);
					    	osmQuestionList1.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
							
						/*	QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());*/
							
							
					        select=randomGenerator.nextInt(osmQuestionList2.size());
					    	QuestionDetailsPojo qid1=osmQuestionList2.get(select);
					    	ques3finalSet3.add(qid1);
					    	osmQuestionList2.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList2.size());
							/*QuestionDetailsPojo questionDetailsPojo1=new QuestionDetailsPojo();
							questionDetailsPojo1.setQuestion(osmQuestionList2.get(i).getQuestion());*/
							
					        select=randomGenerator.nextInt(osmQuestionList3.size());
					    	QuestionDetailsPojo qid2=osmQuestionList3.get(select);
					    	ques3finalSet3.add(qid2);
					    	osmQuestionList3.remove(select);
					        System.out.println("osmQuestionList3 after:::"+osmQuestionList3.size());
							/*QuestionDetailsPojo questionDetailsPojo2=new QuestionDetailsPojo();
							questionDetailsPojo2.setQuestion(osmQuestionList3.get(i).getQuestion());
							ques3final.add(questionDetailsPojo);
							ques3final.add(questionDetailsPojo1);
							ques3final.add(questionDetailsPojo2);*/
						}
						System.out.println("ques3finalSet3 size"+ques3finalSet3.size());
						session.setAttribute("list3Set3", ques3finalSet3);
					
						//for questn 4  set1
						
						List<QuestionDetailsPojo> ques4final=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<1;i++){
							
							select=randomGenerator.nextInt(osmQuestionList3.size());
					    	QuestionDetailsPojo qid=osmQuestionList3.get(select);
					    	ques4final.add(qid);
					    	osmQuestionList3.remove(select);
					        System.out.println("osmQuestionList3 after:::"+osmQuestionList3.size());
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList3.get(i).getQuestion());*/
							
					        
					        select=randomGenerator.nextInt(osmQuestionList2.size());
					    	QuestionDetailsPojo qid1=osmQuestionList2.get(select);
					    	ques4final.add(qid1);
					    	osmQuestionList2.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList2.size());
							/*QuestionDetailsPojo questionDetailsPojo1=new QuestionDetailsPojo();
							questionDetailsPojo1.setQuestion(osmQuestionList2.get(i).getQuestion());*/
							
					        
					        select=randomGenerator.nextInt(osmQuestionList1.size());
					    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
					    	ques4final.add(qid3);
					    	osmQuestionList1.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
							/*QuestionDetailsPojo questionDetailsPojo2=new QuestionDetailsPojo();
							questionDetailsPojo2.setQuestion(osmQuestionList1.get(i).getQuestion());
							ques4final.add(questionDetailsPojo);
							ques4final.add(questionDetailsPojo1);
							ques4final.add(questionDetailsPojo2);*/
						}
						System.out.println("ques4final size"+ques4final.size());
						session.setAttribute("list4Set1", ques4final);
						
						//questn 4 set2
						List<QuestionDetailsPojo> ques4finalSet2=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<1;i++){
							
							select=randomGenerator.nextInt(osmQuestionList3.size());
					    	QuestionDetailsPojo qid=osmQuestionList3.get(select);
					    	ques4finalSet2.add(qid);
					    	osmQuestionList3.remove(select);
					        System.out.println("osmQuestionList3 after:::"+osmQuestionList3.size());
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList3.get(i).getQuestion());*/
							
					        
					        select=randomGenerator.nextInt(osmQuestionList2.size());
					    	QuestionDetailsPojo qid1=osmQuestionList2.get(select);
					    	ques4finalSet2.add(qid1);
					    	osmQuestionList2.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList2.size());
							/*QuestionDetailsPojo questionDetailsPojo1=new QuestionDetailsPojo();
							questionDetailsPojo1.setQuestion(osmQuestionList2.get(i).getQuestion());*/
							
					        
					        select=randomGenerator.nextInt(osmQuestionList1.size());
					    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
					    	ques4finalSet2.add(qid3);
					    	osmQuestionList1.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList2.size());
							/*QuestionDetailsPojo questionDetailsPojo2=new QuestionDetailsPojo();
							questionDetailsPojo2.setQuestion(osmQuestionList1.get(i).getQuestion());
							ques4final.add(questionDetailsPojo);
							ques4final.add(questionDetailsPojo1);
							ques4final.add(questionDetailsPojo2);*/
						}
						System.out.println("ques4finalSet2 size"+ques4finalSet2.size());
						session.setAttribute("list4Set2", ques4finalSet2);
						//questn 4 set3
						
						List<QuestionDetailsPojo> ques4finalSet3=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<1;i++){
							
							select=randomGenerator.nextInt(osmQuestionList3.size());
					    	QuestionDetailsPojo qid=osmQuestionList3.get(select);
					    	ques4finalSet3.add(qid);
					    	osmQuestionList3.remove(select);
					        System.out.println("osmQuestionList3 after:::"+osmQuestionList3.size());
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList3.get(i).getQuestion());*/
							
					        
					        select=randomGenerator.nextInt(osmQuestionList2.size());
					    	QuestionDetailsPojo qid1=osmQuestionList2.get(select);
					    	ques4finalSet3.add(qid1);
					    	osmQuestionList2.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList2.size());
							/*QuestionDetailsPojo questionDetailsPojo1=new QuestionDetailsPojo();
							questionDetailsPojo1.setQuestion(osmQuestionList2.get(i).getQuestion());*/
							
					        
					        select=randomGenerator.nextInt(osmQuestionList1.size());
					    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
					    	ques4finalSet3.add(qid3);
					    	osmQuestionList1.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
							/*QuestionDetailsPojo questionDetailsPojo2=new QuestionDetailsPojo();
							questionDetailsPojo2.setQuestion(osmQuestionList1.get(i).getQuestion());
							ques4final.add(questionDetailsPojo);
							ques4final.add(questionDetailsPojo1);
							ques4final.add(questionDetailsPojo2);*/
						}
						System.out.println("ques4finalSet3 size"+ques4finalSet3.size());
						session.setAttribute("list4Set3", ques4finalSet3);
						
						// for questn 5
						List<QuestionDetailsPojo> ques5final=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<2;i++){
							
							select=randomGenerator.nextInt(osmQuestionList1.size());
					    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
					    	ques5final.add(qid3);
					    	osmQuestionList1.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());
							ques5final.add(questionDetailsPojo);*/
						}
						System.out.println("ques5final size"+ques5final.size());
						session.setAttribute("list5Set1", ques5final);
						
					//q5 set2
						
						List<QuestionDetailsPojo> ques5finalSet2=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<2;i++){
							
							select=randomGenerator.nextInt(osmQuestionList1.size());
					    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
					    	ques5finalSet2.add(qid3);
					    	osmQuestionList1.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());
							ques5final.add(questionDetailsPojo);*/
						}
						System.out.println("ques5finalSet2 size"+ques5finalSet2.size());
						session.setAttribute("list5Set2", ques5finalSet2);
                       //q5 set3
						
						List<QuestionDetailsPojo> ques5finalSet3=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<2;i++){
							
							select=randomGenerator.nextInt(osmQuestionList1.size());
					    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
					    	ques5finalSet3.add(qid3);
					    	osmQuestionList1.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
						/*	QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());
							ques5final.add(questionDetailsPojo);*/
						}
						System.out.println("ques5finalSet3 size"+ques5finalSet3.size());
						session.setAttribute("list5Set3", ques5finalSet3);
						
						
						//questn 6 set1
						List<QuestionDetailsPojo> ques6final=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<4;i++){
							
							select=randomGenerator.nextInt(osmQuestionList.size());
					    	QuestionDetailsPojo qid3=osmQuestionList.get(select);
					    	ques6final.add(qid3);
					    	osmQuestionList.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList.size());
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList.get(i).getQuestion());
							ques6final.add(questionDetailsPojo);*/
						}
						System.out.println("ques6final size"+ques6final.size());
						session.setAttribute("list6Set1",ques6final);
					//q6 set2
						List<QuestionDetailsPojo> ques6finalSet2=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<4;i++){
							
							select=randomGenerator.nextInt(osmQuestionList.size());
					    	QuestionDetailsPojo qid3=osmQuestionList.get(select);
					    	ques6finalSet2.add(qid3);
					    	osmQuestionList.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList.size());
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList.get(i).getQuestion());
							ques6final.add(questionDetailsPojo);*/
						}
						System.out.println("ques6finalSet2 size"+ques6finalSet2.size());
						session.setAttribute("list6Set2",ques6finalSet2);
						//q6 set3
						
						List<QuestionDetailsPojo> ques6finalSet3=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<4;i++){
							
							select=randomGenerator.nextInt(osmQuestionList.size());
					    	QuestionDetailsPojo qid3=osmQuestionList.get(select);
					    	ques6finalSet3.add(qid3);
					    	osmQuestionList.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList.size());
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList.get(i).getQuestion());
							ques6final.add(questionDetailsPojo);*/
						}
						System.out.println("ques6finalSet3 size"+ques6finalSet3.size());
						session.setAttribute("list6Set3",ques6finalSet3);
						
						/*session.setAttribute("list1", ques1final);
						session.setAttribute("list2",ques2final );
						session.setAttribute("list3", ques3final);
						*/
						
						
						
						response.sendRedirect("custom80template1.jsp");
						
			}
			
			else if(template.equals("template2"))
			{
				
				
				
			 osq=9;
			 osm=5;
			List<QuestionDetailsPojo> osmQuestionList=new ArrayList<QuestionDetailsPojo>();

			List<QuestionDetailsPojo> easylistByosm=subjectDetailsDao.getEasyQuestionByOsm(subject,osm);
			List<QuestionDetailsPojo> mediumlistByosm=subjectDetailsDao.getMediumQuestionByOsm(subject,osm);
			List<QuestionDetailsPojo> hardlistByosm=subjectDetailsDao.getHardQuestionByOsm(subject,osm);
			System.out.println("easylistByosm size............"+easylistByosm.size());
			System.out.println("mediumlistByosm size............"+mediumlistByosm.size());
			System.out.println("hardlistByosm size............"+hardlistByosm.size());

			osmQuestionList.addAll(easylistByosm);
			osmQuestionList.addAll(mediumlistByosm);
			osmQuestionList.addAll(hardlistByosm);
			System.out.println("osmQuestionList 5mks"+osmQuestionList.size());
			
			 osq=6;
			 osm=10;
			 
			 List<QuestionDetailsPojo> osmQuestionList1=new ArrayList<QuestionDetailsPojo>();
			 
			    List<QuestionDetailsPojo> easylistFor10Marks=subjectDetailsDao.getEasyQuestionByOsm(subject,osm);
				List<QuestionDetailsPojo> mediumlistFor10Marks=subjectDetailsDao.getMediumQuestionByOsm(subject,osm);
				List<QuestionDetailsPojo> hardlistFor10Marks=subjectDetailsDao.getHardQuestionByOsm(subject,osm);
				System.out.println("easylistByosm size............"+easylistFor10Marks.size());
				System.out.println("mediumlistByosm size............"+mediumlistFor10Marks.size());
				System.out.println("hardlistByosm size............"+hardlistFor10Marks.size());
			
				osmQuestionList1.addAll(easylistFor10Marks);
				osmQuestionList1.addAll(mediumlistFor10Marks);
				osmQuestionList1.addAll(hardlistFor10Marks);
				System.out.println("osmQuestionList of 10mks"+osmQuestionList1.size());
			
			
				 osq=2;
				 osm=6;
				 
				 List<QuestionDetailsPojo> osmQuestionList2=new ArrayList<QuestionDetailsPojo>();
				 
				    List<QuestionDetailsPojo> easylistFor6Marks=subjectDetailsDao.getEasyQuestionByOsm(subject,osm);
					List<QuestionDetailsPojo> mediumlistFor6Marks=subjectDetailsDao.getMediumQuestionByOsm(subject,osm);
					List<QuestionDetailsPojo> hardlistFor6Marks=subjectDetailsDao.getHardQuestionByOsm(subject,osm);
					System.out.println("easylistByosm size............"+easylistFor6Marks.size());
					System.out.println("mediumlistByosm size............"+mediumlistFor6Marks.size());
					System.out.println("hardlistByosm size............"+hardlistFor6Marks.size());
				
					osmQuestionList2.addAll(easylistFor6Marks);
					osmQuestionList2.addAll(mediumlistFor6Marks);
					osmQuestionList2.addAll(hardlistFor6Marks);
					System.out.println("osmQuestionList of 6mks"+osmQuestionList2.size());
			
					
					
					 osq=2;
					 osm=4;
					 
					 List<QuestionDetailsPojo> osmQuestionList3=new ArrayList<QuestionDetailsPojo>();
					 
					    List<QuestionDetailsPojo> easylistFor4Marks=subjectDetailsDao.getEasyQuestionByOsm(subject,osm);
						List<QuestionDetailsPojo> mediumlistFor4Marks=subjectDetailsDao.getMediumQuestionByOsm(subject,osm);
						List<QuestionDetailsPojo> hardlistFor4Marks=subjectDetailsDao.getHardQuestionByOsm(subject,osm);
						System.out.println("easylistByosm size............"+easylistFor4Marks.size());
						System.out.println("mediumlistByosm size............"+mediumlistFor4Marks.size());
						System.out.println("hardlistByosm size............"+hardlistFor4Marks.size());
					
						osmQuestionList3.addAll(easylistFor4Marks);
						osmQuestionList3.addAll(mediumlistFor4Marks);
						osmQuestionList3.addAll(hardlistFor4Marks);
						System.out.println("osmQuestionList before for 4mks"+osmQuestionList3.size());
						
						
						
						//q1 set1
						
						List<QuestionDetailsPojo> ques1final=new ArrayList<QuestionDetailsPojo>();
						
						for(int i=0;i<1;i++){
							 select=randomGenerator.nextInt(osmQuestionList1.size());
						    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
						    	ques1final.add(qid3);
						    	osmQuestionList1.remove(select);
						        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
						}
						for(int i=0;i<2;i++)
					    {
					    	select=randomGenerator.nextInt(osmQuestionList.size());
					    	QuestionDetailsPojo qid=osmQuestionList.get(select);
					    	ques1final.add(qid);
					    	
					    	osmQuestionList.remove(select);
					        System.out.println("osmQuestionList:::"+osmQuestionList.size());
					    }
						
						System.out.println("ques4final size"+ques1final.size());
						session.setAttribute("list1Set1", ques1final);
						
						//q1 set2
						ArrayList<QuestionDetailsPojo> ques1finalSet2=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<1;i++){
							 select=randomGenerator.nextInt(osmQuestionList1.size());
						    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
						    	ques1finalSet2.add(qid3);
						    	osmQuestionList1.remove(select);
						        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
						}
						
						for(int i=0;i<2;i++)
					    {
					    	select=randomGenerator.nextInt(osmQuestionList.size());
					    	QuestionDetailsPojo qid=osmQuestionList.get(select);
					    	ques1finalSet2.add(qid);
					    	
					    	osmQuestionList.remove(select);
					        System.out.println("osmQuestionList:::"+osmQuestionList.size());
					    }
						System.out.println("ques4finalSet2 size"+ques1finalSet2.size());
						session.setAttribute("list1Set2", ques1finalSet2);
						
						//q1 set3
						ArrayList<QuestionDetailsPojo> ques1finalSet3=new ArrayList<QuestionDetailsPojo>();
						
						for(int i=0;i<1;i++){
							 select=randomGenerator.nextInt(osmQuestionList1.size());
						    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
						    	ques1finalSet3.add(qid3);
						    	osmQuestionList1.remove(select);
						        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
						}
						
						for(int i=0;i<2;i++)
					    {
					    	select=randomGenerator.nextInt(osmQuestionList.size());
					    	QuestionDetailsPojo qid=osmQuestionList.get(select);
					    	ques1finalSet3.add(qid);
					    	
					    	osmQuestionList.remove(select);
					        System.out.println("osmQuestionList:::"+osmQuestionList.size());
					    }
						System.out.println("ques1finalSet3 size"+ques1finalSet3.size());
						session.setAttribute("list1Set3", ques1finalSet3);
						
						
						//q2 set1
						
	
						
						ArrayList<QuestionDetailsPojo> ques2final=new ArrayList<QuestionDetailsPojo>();
						
						for(int i=0;i<1;i++){
							 select=randomGenerator.nextInt(osmQuestionList1.size());
						    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
						    	ques2final.add(qid3);
						    	osmQuestionList1.remove(select);
						        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
						}
						for(int i=0;i<2;i++)
					    {
					    	select=randomGenerator.nextInt(osmQuestionList.size());
					    	QuestionDetailsPojo qid=osmQuestionList.get(select);
					    	ques2final.add(qid);
					    	
					    	osmQuestionList.remove(select);
					        System.out.println("osmQuestionList:::"+osmQuestionList.size());
					    }
						
						System.out.println("ques2final size"+ques2final.size());
						session.setAttribute("list2Set1", ques2final);
						
						//q2 set2
						ArrayList<QuestionDetailsPojo> ques2finalSet2=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<1;i++){
							 select=randomGenerator.nextInt(osmQuestionList1.size());
						    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
						    	ques2finalSet2.add(qid3);
						    	osmQuestionList1.remove(select);
						        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
						}
						
						for(int i=0;i<2;i++)
					    {
					    	select=randomGenerator.nextInt(osmQuestionList.size());
					    	QuestionDetailsPojo qid=osmQuestionList.get(select);
					    	ques2finalSet2.add(qid);
					    	osmQuestionList.remove(select);
					        System.out.println("osmQuestionList:::"+osmQuestionList.size());
					    }
						System.out.println("ques2finalSet2 size"+ques2finalSet2.size());
						session.setAttribute("list2Set2", ques2finalSet2);
						
						//q2 set3
						ArrayList<QuestionDetailsPojo> ques2finalSet3=new ArrayList<QuestionDetailsPojo>();
						
						for(int i=0;i<1;i++){
							 select=randomGenerator.nextInt(osmQuestionList1.size());
						    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
						    	ques2finalSet3.add(qid3);
						    	osmQuestionList1.remove(select);
						        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
						}
						
						for(int i=0;i<2;i++)
					    {
					    	select=randomGenerator.nextInt(osmQuestionList.size());
					    	QuestionDetailsPojo qid=osmQuestionList.get(select);
					    	ques2finalSet3.add(qid);
					    	
					    	osmQuestionList.remove(select);
					        System.out.println("osmQuestionList:::"+osmQuestionList.size());
					    }
						System.out.println("ques2finalSet3 size"+ques2finalSet3.size());
						session.setAttribute("list2Set3", ques2finalSet3);
						
						//for questn 3 10mks set1
						
						ArrayList<QuestionDetailsPojo> ques3final=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<2;i++){
							
							select=randomGenerator.nextInt(osmQuestionList1.size());
					    	QuestionDetailsPojo qid=osmQuestionList1.get(select);
					    	ques3final.add(qid);
					    	
					    	osmQuestionList1.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
							
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());
							ques2final.add(questionDetailsPojo);*/
						}
						System.out.println("ques3final size"+ques3final.size());
						session.setAttribute("list3Set1", ques3final);
						
						//q3 set2
						ArrayList<QuestionDetailsPojo> ques3finalSet2=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<2;i++){
							
							select=randomGenerator.nextInt(osmQuestionList1.size());
					    	QuestionDetailsPojo qid=osmQuestionList1.get(select);
					    	ques3finalSet2.add(qid);
					    	
					    	osmQuestionList1.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
							
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());
							ques2final.add(questionDetailsPojo);*/
						}
						System.out.println("ques3finalSet2 size"+ques3finalSet2.size());
						session.setAttribute("list3Set2", ques3finalSet2);
						
						//q3 set3
						ArrayList<QuestionDetailsPojo> ques3finalSet3=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<2;i++){
							
							select=randomGenerator.nextInt(osmQuestionList1.size());
					    	QuestionDetailsPojo qid=osmQuestionList1.get(select);
					    	ques3finalSet3.add(qid);
					    	
					    	osmQuestionList1.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
							
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());
							ques2final.add(questionDetailsPojo);*/
						}
						System.out.println("ques2finalSet2 size"+ques2finalSet2.size());
						session.setAttribute("list3Set3", ques3finalSet3);
						
						//for questn 4 10mks set1
						
						ArrayList<QuestionDetailsPojo> ques4final=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<2;i++){
							
							select=randomGenerator.nextInt(osmQuestionList1.size());
					    	QuestionDetailsPojo qid=osmQuestionList1.get(select);
					    	ques4final.add(qid);
					    	
					    	osmQuestionList1.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
							
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());
							ques2final.add(questionDetailsPojo);*/
						}
						System.out.println("ques4final size"+ques4final.size());
						session.setAttribute("list4Set1", ques4final);
						
						//q4 set2
						ArrayList<QuestionDetailsPojo> ques4finalSet2=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<2;i++){
							
							select=randomGenerator.nextInt(osmQuestionList1.size());
					    	QuestionDetailsPojo qid=osmQuestionList1.get(select);
					    	ques4finalSet2.add(qid);
					    	
					    	osmQuestionList1.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
							
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());
							ques2final.add(questionDetailsPojo);*/
						}
						System.out.println("ques4finalSet2 size"+ques4finalSet2.size());
						session.setAttribute("list4Set2", ques4finalSet2);
						
						//q4 set3
						ArrayList<QuestionDetailsPojo> ques4finalSet3=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<2;i++){
							
							select=randomGenerator.nextInt(osmQuestionList1.size());
					    	QuestionDetailsPojo qid=osmQuestionList1.get(select);
					    	ques4finalSet3.add(qid);
					    	
					    	osmQuestionList1.remove(select);
					        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
							
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());
							ques2final.add(questionDetailsPojo);*/
						}
						System.out.println("ques4finalSet3 size"+ques4finalSet3.size());
						session.setAttribute("list4Set3", ques4finalSet3);
						
						//q5 set1
						

						
						ArrayList<QuestionDetailsPojo> ques5final=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<2;i++)
					    {
					    	select=randomGenerator.nextInt(osmQuestionList.size());
					    	QuestionDetailsPojo qid=osmQuestionList.get(select);
					    	ques5final.add(qid);
					    	
					    	osmQuestionList.remove(select);
					        System.out.println("osmQuestionList:::"+osmQuestionList.size());
					    }
						for(int i=0;i<1;i++){
							 select=randomGenerator.nextInt(osmQuestionList1.size());
						    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
						    	ques5final.add(qid3);
						    	osmQuestionList1.remove(select);
						        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
						}
						System.out.println("ques5final size"+ques5final.size());
						session.setAttribute("list5Set1", ques5final);
						
						//q5 set2
						ArrayList<QuestionDetailsPojo> ques5finalSet2=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<2;i++)
					    {
					    	select=randomGenerator.nextInt(osmQuestionList.size());
					    	QuestionDetailsPojo qid=osmQuestionList.get(select);
					    	ques5finalSet2.add(qid);
					    	
					    	osmQuestionList.remove(select);
					        System.out.println("osmQuestionList:::"+osmQuestionList.size());
					    }
						for(int i=0;i<1;i++){
							 select=randomGenerator.nextInt(osmQuestionList1.size());
						    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
						    	ques5finalSet2.add(qid3);
						    	osmQuestionList1.remove(select);
						        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
						}
						System.out.println("ques5finalSet2 size"+ques5finalSet2.size());
						session.setAttribute("list5Set2", ques5finalSet2);
						
						//q5 set3
						ArrayList<QuestionDetailsPojo> ques5finalSet3=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<2;i++)
					    {
					    	select=randomGenerator.nextInt(osmQuestionList.size());
					    	QuestionDetailsPojo qid=osmQuestionList.get(select);
					    	ques5finalSet3.add(qid);
					    	
					    	osmQuestionList.remove(select);
					        System.out.println("osmQuestionList:::"+osmQuestionList.size());
					    }
						for(int i=0;i<1;i++){
							 select=randomGenerator.nextInt(osmQuestionList1.size());
						    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
						    	ques5finalSet3.add(qid3);
						    	osmQuestionList1.remove(select);
						        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
						}
						System.out.println("ques5finalSet3 size"+ques5finalSet3.size());
						session.setAttribute("list5Set3", ques5finalSet3);
						
						//for queston 6
						ArrayList<QuestionDetailsPojo> ques6final=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<5;i++){
							
							select=randomGenerator.nextInt(osmQuestionList.size());
					    	QuestionDetailsPojo qid=osmQuestionList.get(select);
					    	ques6final.add(qid);
					    	
					    	osmQuestionList.remove(select);
					        System.out.println("osmQuestionList after:::"+osmQuestionList.size());
							/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
							questionDetailsPojo.setQuestion(osmQuestionList.get(i).getQuestion());
							ques1final.add(questionDetailsPojo);*/
						}
						System.out.println("ques6final size"+ques6final.size());
						session.setAttribute("list6Set1", ques6final);
					 
						//ques6 set 2
						
						ArrayList<QuestionDetailsPojo> ques6finalForSet2=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<5;i++)
					    {
					    	select=randomGenerator.nextInt(osmQuestionList.size());
					    	QuestionDetailsPojo qid=osmQuestionList.get(select);
					    	ques6finalForSet2.add(qid);
					    	
					    	osmQuestionList.remove(select);
					    System.out.println("osmQuestionList:::"+osmQuestionList.size());
					    
					    }
						System.out.println("ques6finalForSet2 size"+ques6finalForSet2.size());
						session.setAttribute("list6Set2", ques6finalForSet2);
						
						//questn 6 set3
						
						ArrayList<QuestionDetailsPojo> ques6finalForSet3=new ArrayList<QuestionDetailsPojo>();
						for(int i=0;i<5;i++)
					    {
					    	select=randomGenerator.nextInt(osmQuestionList.size());
					    	QuestionDetailsPojo qid=osmQuestionList.get(select);
					    	ques6finalForSet3.add(qid);
					    	
					    	osmQuestionList.remove(select);
					    System.out.println("osmQuestionList:::"+osmQuestionList.size());
					    
					    }
						System.out.println("ques6finalForSet3 size"+ques6finalForSet3.size());
						session.setAttribute("list6Set3", ques6finalForSet3);
						response.sendRedirect("custom80template2.jsp");
						
			}
			else if(template.equals("template3"))
			{
			
				
			 osq=9;
			 osm=5;
			List<QuestionDetailsPojo> osmQuestionList=new ArrayList<QuestionDetailsPojo>();

			List<QuestionDetailsPojo> easylistByosm=subjectDetailsDao.getEasyQuestionByOsm(subject,osm);
			List<QuestionDetailsPojo> mediumlistByosm=subjectDetailsDao.getMediumQuestionByOsm(subject,osm);
			List<QuestionDetailsPojo> hardlistByosm=subjectDetailsDao.getHardQuestionByOsm(subject,osm);
			System.out.println("easylistByosm size............"+easylistByosm.size());
			System.out.println("mediumlistByosm size............"+mediumlistByosm.size());
			System.out.println("hardlistByosm size............"+hardlistByosm.size());

			osmQuestionList.addAll(easylistByosm);
			osmQuestionList.addAll(mediumlistByosm);
			osmQuestionList.addAll(hardlistByosm);
			System.out.println("osmQuestionList 5mks"+osmQuestionList.size());
			
			 osq=6;
			 osm=10;
			 
			 List<QuestionDetailsPojo> osmQuestionList1=new ArrayList<QuestionDetailsPojo>();
			 
			    List<QuestionDetailsPojo> easylistFor10Marks=subjectDetailsDao.getEasyQuestionByOsm(subject,osm);
				List<QuestionDetailsPojo> mediumlistFor10Marks=subjectDetailsDao.getMediumQuestionByOsm(subject,osm);
				List<QuestionDetailsPojo> hardlistFor10Marks=subjectDetailsDao.getHardQuestionByOsm(subject,osm);
				System.out.println("easylistByosm size............"+easylistFor10Marks.size());
				System.out.println("mediumlistByosm size............"+mediumlistFor10Marks.size());
				System.out.println("hardlistByosm size............"+hardlistFor10Marks.size());
			
				osmQuestionList1.addAll(easylistFor10Marks);
				osmQuestionList1.addAll(mediumlistFor10Marks);
				osmQuestionList1.addAll(hardlistFor10Marks);
				System.out.println("osmQuestionList of 10mks"+osmQuestionList1.size());
			
			
				 osq=2;
				 osm=6;
				 
				 List<QuestionDetailsPojo> osmQuestionList2=new ArrayList<QuestionDetailsPojo>();
				 
				    List<QuestionDetailsPojo> easylistFor6Marks=subjectDetailsDao.getEasyQuestionByOsm(subject,osm);
					List<QuestionDetailsPojo> mediumlistFor6Marks=subjectDetailsDao.getMediumQuestionByOsm(subject,osm);
					List<QuestionDetailsPojo> hardlistFor6Marks=subjectDetailsDao.getHardQuestionByOsm(subject,osm);
					System.out.println("easylistByosm size............"+easylistFor6Marks.size());
					System.out.println("mediumlistByosm size............"+mediumlistFor6Marks.size());
					System.out.println("hardlistByosm size............"+hardlistFor6Marks.size());
				
					osmQuestionList2.addAll(easylistFor6Marks);
					osmQuestionList2.addAll(mediumlistFor6Marks);
					osmQuestionList2.addAll(hardlistFor6Marks);
					System.out.println("osmQuestionList of 6mks"+osmQuestionList2.size());
			
					
					
					 osq=2;
					 osm=4;
					 
					 List<QuestionDetailsPojo> osmQuestionList3=new ArrayList<QuestionDetailsPojo>();
					 
					    List<QuestionDetailsPojo> easylistFor4Marks=subjectDetailsDao.getEasyQuestionByOsm(subject,osm);
						List<QuestionDetailsPojo> mediumlistFor4Marks=subjectDetailsDao.getMediumQuestionByOsm(subject,osm);
						List<QuestionDetailsPojo> hardlistFor4Marks=subjectDetailsDao.getHardQuestionByOsm(subject,osm);
						System.out.println("easylistByosm size............"+easylistFor4Marks.size());
						System.out.println("mediumlistByosm size............"+mediumlistFor4Marks.size());
						System.out.println("hardlistByosm size............"+hardlistFor4Marks.size());
					
						osmQuestionList3.addAll(easylistFor4Marks);
						osmQuestionList3.addAll(mediumlistFor4Marks);
						osmQuestionList3.addAll(hardlistFor4Marks);
						System.out.println("osmQuestionList before for 4mks"+osmQuestionList3.size());
			
			
			//for queston 1
						ArrayList<QuestionDetailsPojo> ques1final=new ArrayList<QuestionDetailsPojo>();
			for(int i=0;i<5;i++){
				
				select=randomGenerator.nextInt(osmQuestionList.size());
		    	QuestionDetailsPojo qid=osmQuestionList.get(select);
		    	ques1final.add(qid);
		    	
		    	osmQuestionList.remove(select);
		        System.out.println("osmQuestionList after:::"+osmQuestionList.size());
				/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion(osmQuestionList.get(i).getQuestion());
				ques1final.add(questionDetailsPojo);*/
			}
			System.out.println("ques1final size"+ques1final.size());
			session.setAttribute("list1Set1", ques1final);
		 
			//ques1 set 2
			
			ArrayList<QuestionDetailsPojo> ques1finalForSet2=new ArrayList<QuestionDetailsPojo>();
			for(int i=0;i<5;i++)
		    {
		    	select=randomGenerator.nextInt(osmQuestionList.size());
		    	QuestionDetailsPojo qid=osmQuestionList.get(select);
		    	ques1finalForSet2.add(qid);
		    	
		    	osmQuestionList.remove(select);
		    System.out.println("osmQuestionList:::"+osmQuestionList.size());
		    
		    }
			System.out.println("ques1finalForSet2 size"+ques1finalForSet2.size());
			session.setAttribute("list1Set2", ques1finalForSet2);
			
			//questn 1 set3
			
			ArrayList<QuestionDetailsPojo> ques1finalForSet3=new ArrayList<QuestionDetailsPojo>();
			for(int i=0;i<5;i++)
		    {
		    	select=randomGenerator.nextInt(osmQuestionList.size());
		    	QuestionDetailsPojo qid=osmQuestionList.get(select);
		    	ques1finalForSet3.add(qid);
		    	
		    	osmQuestionList.remove(select);
		    System.out.println("osmQuestionList:::"+osmQuestionList.size());
		    
		    }
			System.out.println("ques1finalForSet3 size"+ques1finalForSet3.size());
			session.setAttribute("list1Set3", ques1finalForSet3);

			//for questn 2 10mks set1
			
			ArrayList<QuestionDetailsPojo> ques2final=new ArrayList<QuestionDetailsPojo>();
			for(int i=0;i<2;i++){
				
				select=randomGenerator.nextInt(osmQuestionList1.size());
		    	QuestionDetailsPojo qid=osmQuestionList1.get(select);
		    	ques2final.add(qid);
		    	
		    	osmQuestionList1.remove(select);
		        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
				
				/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());
				ques2final.add(questionDetailsPojo);*/
			}
			System.out.println("ques2final size"+ques2final.size());
			session.setAttribute("list2Set1", ques2final);
			
			//q2 set2
			ArrayList<QuestionDetailsPojo> ques2finalSet2=new ArrayList<QuestionDetailsPojo>();
			for(int i=0;i<2;i++){
				
				select=randomGenerator.nextInt(osmQuestionList1.size());
		    	QuestionDetailsPojo qid=osmQuestionList1.get(select);
		    	ques2finalSet2.add(qid);
		    	
		    	osmQuestionList1.remove(select);
		        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
				
				/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());
				ques2final.add(questionDetailsPojo);*/
			}
			System.out.println("ques2finalSet2 size"+ques2finalSet2.size());
			session.setAttribute("list2Set2", ques2finalSet2);
			
			
			ArrayList<QuestionDetailsPojo> ques2finalSet3=new ArrayList<QuestionDetailsPojo>();
			for(int i=0;i<2;i++){
				
				select=randomGenerator.nextInt(osmQuestionList1.size());
		    	QuestionDetailsPojo qid=osmQuestionList1.get(select);
		    	ques2finalSet3.add(qid);
		    	
		    	osmQuestionList1.remove(select);
		        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
				
				/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());
				ques2final.add(questionDetailsPojo);*/
			}
			System.out.println("ques2finalSet2 size"+ques2finalSet2.size());
			session.setAttribute("list2Set3", ques2finalSet3);
			
			
			
			//for questn 3 set1
			ArrayList<QuestionDetailsPojo> ques3final=new ArrayList<QuestionDetailsPojo>();
			for(int i=0;i<1;i++){
				
				select=randomGenerator.nextInt(osmQuestionList1.size());
		    	QuestionDetailsPojo qid=osmQuestionList1.get(select);
		    	ques3final.add(qid);
		    	osmQuestionList1.remove(select);
		        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
				
				/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());*/
				
				
		        select=randomGenerator.nextInt(osmQuestionList2.size());
		    	QuestionDetailsPojo qid1=osmQuestionList2.get(select);
		    	ques3final.add(qid1);
		    	osmQuestionList2.remove(select);
		        System.out.println("osmQuestionList1 after:::"+osmQuestionList2.size());
				/*QuestionDetailsPojo questionDetailsPojo1=new QuestionDetailsPojo();
				questionDetailsPojo1.setQuestion(osmQuestionList2.get(i).getQuestion());*/
				
		        select=randomGenerator.nextInt(osmQuestionList3.size());
		    	QuestionDetailsPojo qid2=osmQuestionList3.get(select);
		    	ques3final.add(qid2);
		    	osmQuestionList3.remove(select);
		        System.out.println("osmQuestionList3 after:::"+osmQuestionList3.size());
				/*QuestionDetailsPojo questionDetailsPojo2=new QuestionDetailsPojo();
				questionDetailsPojo2.setQuestion(osmQuestionList3.get(i).getQuestion());*/
				/*ques3final.add(questionDetailsPojo);
				ques3final.add(questionDetailsPojo1);
				ques3final.add(questionDetailsPojo2);*/
			}
			System.out.println("ques3final size"+ques3final.size());
			session.setAttribute("list3Set1", ques3final);
			
			// ques3 set2
			ArrayList<QuestionDetailsPojo> ques3finalSet2=new ArrayList<QuestionDetailsPojo>();
			for(int i=0;i<1;i++){
				
				select=randomGenerator.nextInt(osmQuestionList1.size());
		    	QuestionDetailsPojo qid=osmQuestionList1.get(select);
		    	ques3finalSet2.add(qid);
		    	osmQuestionList1.remove(select);
		        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
				
				/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());*/
				
				
		        select=randomGenerator.nextInt(osmQuestionList2.size());
		    	QuestionDetailsPojo qid1=osmQuestionList2.get(select);
		    	ques3finalSet2.add(qid1);
		    	osmQuestionList2.remove(select);
		        System.out.println("osmQuestionList1 after:::"+osmQuestionList2.size());
				/*QuestionDetailsPojo questionDetailsPojo1=new QuestionDetailsPojo();
				questionDetailsPojo1.setQuestion(osmQuestionList2.get(i).getQuestion());*/
				
		        select=randomGenerator.nextInt(osmQuestionList3.size());
		    	QuestionDetailsPojo qid2=osmQuestionList3.get(select);
		    	ques3finalSet2.add(qid2);
		    	osmQuestionList3.remove(select);
		        System.out.println("osmQuestionList3 after:::"+osmQuestionList3.size());
				/*QuestionDetailsPojo questionDetailsPojo2=new QuestionDetailsPojo();
				questionDetailsPojo2.setQuestion(osmQuestionList3.get(i).getQuestion());
				ques3final.add(questionDetailsPojo);
				ques3final.add(questionDetailsPojo1);
				ques3final.add(questionDetailsPojo2);*/
			}
			System.out.println("ques3finalSet2 size"+ques3finalSet2.size());
			session.setAttribute("list3Set2", ques3finalSet2);
			
			// ques3 set3
			ArrayList<QuestionDetailsPojo> ques3finalSet3=new ArrayList<QuestionDetailsPojo>();
			for(int i=0;i<1;i++){
				
				select=randomGenerator.nextInt(osmQuestionList1.size());
		    	QuestionDetailsPojo qid=osmQuestionList1.get(select);
		    	ques3finalSet3.add(qid);
		    	osmQuestionList1.remove(select);
		        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
				
			/*	QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());*/
				
				
		        select=randomGenerator.nextInt(osmQuestionList2.size());
		    	QuestionDetailsPojo qid1=osmQuestionList2.get(select);
		    	ques3finalSet3.add(qid1);
		    	osmQuestionList2.remove(select);
		        System.out.println("osmQuestionList1 after:::"+osmQuestionList2.size());
				/*QuestionDetailsPojo questionDetailsPojo1=new QuestionDetailsPojo();
				questionDetailsPojo1.setQuestion(osmQuestionList2.get(i).getQuestion());*/
				
		        select=randomGenerator.nextInt(osmQuestionList3.size());
		    	QuestionDetailsPojo qid2=osmQuestionList3.get(select);
		    	ques3finalSet3.add(qid2);
		    	osmQuestionList3.remove(select);
		        System.out.println("osmQuestionList3 after:::"+osmQuestionList3.size());
				/*QuestionDetailsPojo questionDetailsPojo2=new QuestionDetailsPojo();
				questionDetailsPojo2.setQuestion(osmQuestionList3.get(i).getQuestion());
				ques3final.add(questionDetailsPojo);
				ques3final.add(questionDetailsPojo1);
				ques3final.add(questionDetailsPojo2);*/
			}
			System.out.println("ques3finalSet3 size"+ques3finalSet3.size());
			session.setAttribute("list3Set3", ques3finalSet3);
			
			//q4 set1
			

			
			ArrayList<QuestionDetailsPojo> ques4final=new ArrayList<QuestionDetailsPojo>();
			for(int i=0;i<2;i++)
		    {
		    	select=randomGenerator.nextInt(osmQuestionList.size());
		    	QuestionDetailsPojo qid=osmQuestionList.get(select);
		    	ques4final.add(qid);
		    	
		    	osmQuestionList.remove(select);
		        System.out.println("osmQuestionList:::"+osmQuestionList.size());
		    }
			for(int i=0;i<1;i++){
				 select=randomGenerator.nextInt(osmQuestionList1.size());
			    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
			    	ques4final.add(qid3);
			    	osmQuestionList1.remove(select);
			        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
			}
			System.out.println("ques4final size"+ques4final.size());
			session.setAttribute("list4Set1", ques4final);
			
			//q4 set2
			ArrayList<QuestionDetailsPojo> ques4finalSet2=new ArrayList<QuestionDetailsPojo>();
			for(int i=0;i<2;i++)
		    {
		    	select=randomGenerator.nextInt(osmQuestionList.size());
		    	QuestionDetailsPojo qid=osmQuestionList.get(select);
		    	ques4finalSet2.add(qid);
		    	
		    	osmQuestionList.remove(select);
		        System.out.println("osmQuestionList:::"+osmQuestionList.size());
		    }
			for(int i=0;i<1;i++){
				 select=randomGenerator.nextInt(osmQuestionList1.size());
			    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
			    	ques4finalSet2.add(qid3);
			    	osmQuestionList1.remove(select);
			        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
			}
			System.out.println("ques4finalSet2 size"+ques4finalSet2.size());
			session.setAttribute("list4Set2", ques4finalSet2);
			
			//q4 set3
			ArrayList<QuestionDetailsPojo> ques4finalSet3=new ArrayList<QuestionDetailsPojo>();
			for(int i=0;i<2;i++)
		    {
		    	select=randomGenerator.nextInt(osmQuestionList.size());
		    	QuestionDetailsPojo qid=osmQuestionList.get(select);
		    	ques4finalSet3.add(qid);
		    	
		    	osmQuestionList.remove(select);
		        System.out.println("osmQuestionList:::"+osmQuestionList.size());
		    }
			for(int i=0;i<1;i++){
				 select=randomGenerator.nextInt(osmQuestionList1.size());
			    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
			    	ques4finalSet3.add(qid3);
			    	osmQuestionList1.remove(select);
			        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
			}
			System.out.println("ques4finalSet2 size"+ques4finalSet3.size());
			session.setAttribute("list4Set3", ques4finalSet3);
			
			
			// for questn 5
			ArrayList<QuestionDetailsPojo> ques5final=new ArrayList<QuestionDetailsPojo>();
			for(int i=0;i<2;i++){
				
				select=randomGenerator.nextInt(osmQuestionList1.size());
		    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
		    	ques5final.add(qid3);
		    	osmQuestionList1.remove(select);
		        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
				/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());
				ques5final.add(questionDetailsPojo);*/
			}
			System.out.println("ques5final size"+ques5final.size());
			session.setAttribute("list5Set1", ques5final);
			
		//q5 set2
			
			ArrayList<QuestionDetailsPojo> ques5finalSet2=new ArrayList<QuestionDetailsPojo>();
			for(int i=0;i<2;i++){
				
				select=randomGenerator.nextInt(osmQuestionList1.size());
		    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
		    	ques5finalSet2.add(qid3);
		    	osmQuestionList1.remove(select);
		        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
				/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());
				ques5final.add(questionDetailsPojo);*/
			}
			System.out.println("ques5finalSet2 size"+ques5finalSet2.size());
			session.setAttribute("list5Set2", ques5finalSet2);
           //q5 set3
			
			ArrayList<QuestionDetailsPojo> ques5finalSet3=new ArrayList<QuestionDetailsPojo>();
			for(int i=0;i<2;i++){
				
				select=randomGenerator.nextInt(osmQuestionList1.size());
		    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
		    	ques5finalSet3.add(qid3);
		    	osmQuestionList1.remove(select);
		        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
			/*	QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion(osmQuestionList1.get(i).getQuestion());
				ques5final.add(questionDetailsPojo);*/
			}
			System.out.println("ques5finalSet3 size"+ques5finalSet3.size());
			session.setAttribute("list5Set3", ques5finalSet3);
			
			
			//questn 6 set1
			ArrayList<QuestionDetailsPojo> ques6final=new ArrayList<QuestionDetailsPojo>();
			for(int i=0;i<2;i++){
				
				select=randomGenerator.nextInt(osmQuestionList1.size());
		    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
		    	ques6final.add(qid3);
		    	osmQuestionList1.remove(select);
		        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
				/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion(osmQuestionList.get(i).getQuestion());
				ques6final.add(questionDetailsPojo);*/
			}
			System.out.println("ques6final size"+ques6final.size());
			session.setAttribute("list6Set1",ques6final);
		//q6 set2
			ArrayList<QuestionDetailsPojo> ques6finalSet2=new ArrayList<QuestionDetailsPojo>();
			for(int i=0;i<2;i++){
				
				select=randomGenerator.nextInt(osmQuestionList1.size());
		    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
		    	ques6finalSet2.add(qid3);
		    	osmQuestionList1.remove(select);
		        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
				/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion(osmQuestionList.get(i).getQuestion());
				ques6final.add(questionDetailsPojo);*/
			}
			System.out.println("ques6finalSet2 size"+ques6finalSet2.size());
			session.setAttribute("list6Set2",ques6finalSet2);
			//q6 set3
			
			ArrayList<QuestionDetailsPojo> ques6finalSet3=new ArrayList<QuestionDetailsPojo>();
			for(int i=0;i<2;i++){
				
				select=randomGenerator.nextInt(osmQuestionList1.size());
		    	QuestionDetailsPojo qid3=osmQuestionList1.get(select);
		    	ques6finalSet3.add(qid3);
		    	osmQuestionList1.remove(select);
		        System.out.println("osmQuestionList1 after:::"+osmQuestionList1.size());
				/*QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setQuestion(osmQuestionList.get(i).getQuestion());
				ques6final.add(questionDetailsPojo);*/
			}
			System.out.println("ques6finalSet3 size"+ques6finalSet3.size());
			session.setAttribute("list6Set3",ques6finalSet3);
			
			response.sendRedirect("custom80template3.jsp");
			
			}
			
			}
	else if(marks.equals("30")){
				int fmod =Integer.parseInt(request.getParameter("fromModule"));
				int tmod =Integer.parseInt(request.getParameter("toModule"));
				/* Random randomGenerator= new Random();
				    long q_id=0;
				    String question=null;
				    int select=0;*/
				
				
				   if(template.equalsIgnoreCase("template1"))
				   {
				    int que=10;
				    int mark1=6;
				    List<QuestionDetailsPojo> tmp1QuestionList=new ArrayList<QuestionDetailsPojo>();
					List<QuestionDetailsPojo> tmp1QuestionList10=new ArrayList<QuestionDetailsPojo>();
				    List<QuestionDetailsPojo> easylistBytemp1=subjectDetailsDao.getEasyQuestionBytemp2(subject,mark1,fmod,tmod);
				    List<QuestionDetailsPojo> mediumlistBytemp1=subjectDetailsDao.getMediumQuestionBytemp2(subject,mark1,fmod,tmod);
				    List<QuestionDetailsPojo> hardlistBytemp1=subjectDetailsDao.getHardQuestionBytemp2(subject,mark1,fmod,tmod);
				    
				    System.out.println("easylistBytemp1 size............"+easylistBytemp1.size());
				    System.out.println("mediumlistBytemp1 size............"+mediumlistBytemp1.size());
				    System.out.println("hardlistBytemp1 size............"+hardlistBytemp1.size());
				    
				   
				    session.setAttribute("tmp1QuestionList", tmp1QuestionList);
				    
				    tmp1QuestionList.addAll(easylistBytemp1);
				    tmp1QuestionList.addAll(mediumlistBytemp1);
				    tmp1QuestionList.addAll(hardlistBytemp1);
				    System.out.println("tmp1QuestionList size"+tmp1QuestionList.size());
				   
				    //set 1
				    for(int i=0;i<10;i++)
				    {
				    	select=randomGenerator.nextInt(tmp1QuestionList.size());
				    	QuestionDetailsPojo qid=tmp1QuestionList.get(select);
				    	tmp1QuestionList10.add(qid);
				    	
				    tmp1QuestionList.remove(select);
				   // System.out.println("tmp1QuestionList:::"+tmp1QuestionList.size());
				    System.out.println(tmp1QuestionList.get(i).getQuestion());
				    
				    
				    }
				    
				    
				    /*PaperSetDetailsPojo paper=new PaperSetDetailsPojo();
				    paper.setSubject(subject);
				    paper.setPaper_mark(mark);
				    paper.setTime(time);
				    paper.setSem(sem);
				    paper.setTemplate_name(template);
				    boolean b=subjectDetailsDao.addSet1Details(tmp1QuestionList10,paper);*/
				    
				    //set2
				    List<QuestionDetailsPojo> tmp1QuestionListForSet2=new ArrayList<QuestionDetailsPojo>();
				    for(int i=0;i<10;i++)
				    {
				    	select=randomGenerator.nextInt(tmp1QuestionList.size());
				    	QuestionDetailsPojo qid=tmp1QuestionList.get(select);
				    	tmp1QuestionListForSet2.add(qid);
				    	
				    tmp1QuestionList.remove(select);
				    System.out.println("tmp1QuestionList:::"+tmp1QuestionList.size());
				    }
				    session.setAttribute("temSet2", tmp1QuestionListForSet2);
				    
				   //set 3
				    List<QuestionDetailsPojo> tmp1QuestionListForSet3=new ArrayList<QuestionDetailsPojo>();
				    for(int i=0;i<10;i++)
				    {
				    	select=randomGenerator.nextInt(tmp1QuestionList.size());
				    	QuestionDetailsPojo qid=tmp1QuestionList.get(select);
				    	tmp1QuestionListForSet3.add(qid);
				    	
				    tmp1QuestionList.remove(select);
				    System.out.println("tmp1QuestionList:::"+tmp1QuestionList.size());
				    }
				    
				    session.setAttribute("temSet3", tmp1QuestionListForSet3);
				    
				    
				    session.setAttribute("subject", subject);
					session.setAttribute("sem", sem);
				    System.out.println("tmp1QuestionList10 size"+tmp1QuestionList10.size());
				    session.setAttribute("temSet1", tmp1QuestionList10);
				    response.sendRedirect("custom30template1.jsp");
				    
				   }
				   else if(template.equals("template2")){
					
					
					
					int tsq=0;
					int tsm=0;
					
					 tsq=2;
					 tsm=10;
					 List<QuestionDetailsPojo> tsmQuestionList=new ArrayList<QuestionDetailsPojo>();
					
					List<QuestionDetailsPojo> easylistBytsm=subjectDetailsDao.getEasyQuestionBytemp2(subject, tsm,fmod,tmod);
					List<QuestionDetailsPojo> mediumlistBytsm=subjectDetailsDao.getMediumQuestionBytemp2(subject, tsm,fmod,tmod);
					List<QuestionDetailsPojo> hardlistBytsm=subjectDetailsDao.getHardQuestionBytemp2(subject, tsm,fmod,tmod);
					tsmQuestionList.addAll(easylistBytsm);
					tsmQuestionList.addAll(mediumlistBytsm);
					tsmQuestionList.addAll(hardlistBytsm);
					System.out.println("tsmQuestionList before remove"+tsmQuestionList.size());
					
					//set1
					List<QuestionDetailsPojo> tsmQuestionListfinal=new ArrayList<QuestionDetailsPojo>();
				    for(int i=0;i<2;i++)
				    {
				    	select=randomGenerator.nextInt(tsmQuestionList.size());
				    	QuestionDetailsPojo qid=tsmQuestionList.get(select);
				    	tsmQuestionListfinal.add(qid);
				    	
				    	tsmQuestionList.remove(select);
				    	System.out.println("tsmQuestionList after remove"+tsmQuestionList.size());
				    	
				    }
					System.out.println("tsmQuestionListfinal"+tsmQuestionListfinal.size());
					session.setAttribute("allqus", tsmQuestionListfinal);
					
					//set 2
					ArrayList<QuestionDetailsPojo> tsmQuestionListfinalSet2=new ArrayList<QuestionDetailsPojo>();
					for(int i=0;i<2;i++)
				    {
				    	select=randomGenerator.nextInt(tsmQuestionList.size());
				    	QuestionDetailsPojo qid=tsmQuestionList.get(select);
				    	tsmQuestionListfinalSet2.add(qid);
				    	
				    	tsmQuestionList.remove(select);
				    	System.out.println("tsmQuestionList after remove"+tsmQuestionList.size());
				    	
				    }
					session.setAttribute("allqusSet2", tsmQuestionListfinalSet2);
					
					List<QuestionDetailsPojo> tsmQuestionListfinalSet3=new ArrayList<QuestionDetailsPojo>();
					for(int i=0;i<2;i++)
				    {
				    	select=randomGenerator.nextInt(tsmQuestionList.size());
				    	QuestionDetailsPojo qid=tsmQuestionList.get(select);
				    	tsmQuestionListfinalSet3.add(qid);
				    	
				    	tsmQuestionList.remove(select);
				    	System.out.println("tsmQuestionList after remove"+tsmQuestionList.size());
				    	
				    }
					session.setAttribute("allqusSet3", tsmQuestionListfinalSet3);
					
					 tsq=2;
					tsm=12;
					List<QuestionDetailsPojo> tsmQuestionList1=new ArrayList<QuestionDetailsPojo>();
					List<QuestionDetailsPojo> tsmQuestionListfinal1=new ArrayList<QuestionDetailsPojo>();
					List<QuestionDetailsPojo> easylistBytsm1=subjectDetailsDao.getEasyQuestionBytemp2(subject, tsm,fmod,tmod);
					List<QuestionDetailsPojo> mediumlistBytsm1=subjectDetailsDao.getMediumQuestionBytemp2(subject, tsm,fmod,tmod);
					List<QuestionDetailsPojo> hardlistBytsm1=subjectDetailsDao.getHardQuestionBytemp2(subject, tsm,fmod,tmod);
					tsmQuestionList1.addAll(easylistBytsm1);
					tsmQuestionList1.addAll(mediumlistBytsm1);
					tsmQuestionList1.addAll(hardlistBytsm1);
					System.out.println("tsmQuestionList1 before remove"+tsmQuestionList1.size());
					for(int i=0;i<2;i++)
				    {
						select=randomGenerator.nextInt(tsmQuestionList1.size());
				    	QuestionDetailsPojo qid=tsmQuestionList1.get(select);
				    	tsmQuestionListfinal1.add(qid);
				    	
				    	tsmQuestionList.remove(select);
				    	System.out.println("tsmQuestionList1 after remove"+tsmQuestionList1.size());
				    	
				    }
					System.out.println("tsmQuestionListfinal"+tsmQuestionListfinal.size());
					session.setAttribute("allqus1", tsmQuestionListfinal1);
					
					//set 2
					List<QuestionDetailsPojo> tsmQuestionListfinalForSet2=new ArrayList<QuestionDetailsPojo>();
					for(int i=0;i<2;i++)
				    {
						select=randomGenerator.nextInt(tsmQuestionList1.size());
				    	QuestionDetailsPojo qid=tsmQuestionList1.get(select);
				    	tsmQuestionListfinalForSet2.add(qid);
				    	
				    	tsmQuestionList.remove(select);
				    	System.out.println("tsmQuestionList1 after remove"+tsmQuestionList1.size());
				    	
				    }
					session.setAttribute("allqus1Set2", tsmQuestionListfinalForSet2);
					//set 3
					
					List<QuestionDetailsPojo> tsmQuestionListfinalForSet3=new ArrayList<QuestionDetailsPojo>();
					for(int i=0;i<2;i++)
				    {
						select=randomGenerator.nextInt(tsmQuestionList1.size());
				    	QuestionDetailsPojo qid=tsmQuestionList1.get(select);
				    	tsmQuestionListfinalForSet3.add(qid);
				    	
				    	tsmQuestionList.remove(select);
				    	System.out.println("tsmQuestionList1 after remove"+tsmQuestionList1.size());
				    	
				    }
					session.setAttribute("allqus1Set3", tsmQuestionListfinalForSet3);
					
					    tsq=2;
						tsm=8;
						
						List<QuestionDetailsPojo> tsmQuestionList2=new ArrayList<QuestionDetailsPojo>();
						List<QuestionDetailsPojo> easylistBytsm11=subjectDetailsDao.getEasyQuestionBytemp2(subject, tsm,fmod,tmod);
						List<QuestionDetailsPojo> mediumlistBytsm11=subjectDetailsDao.getMediumQuestionBytemp2(subject, tsm,fmod,tmod);
						List<QuestionDetailsPojo> hardlistBytsm11=subjectDetailsDao.getHardQuestionBytemp2(subject, tsm,fmod,tmod);
					
					
					
					tsmQuestionList2.addAll(easylistBytsm11);
					tsmQuestionList2.addAll(mediumlistBytsm11);
					tsmQuestionList2.addAll(hardlistBytsm11);
					for(int i=0;i<tsmQuestionList2.size();i++){
						System.out.println(tsmQuestionList2.get(i).getMarks());
					}
					System.out.println("tsmQuestionList2 before remove"+tsmQuestionList2.size());
					List<QuestionDetailsPojo> tsmQuestionListfinal2=new ArrayList<QuestionDetailsPojo>();
					for(int i=0;i<2;i++)
				    {
						select=randomGenerator.nextInt(tsmQuestionList2.size());
				    	QuestionDetailsPojo qid=tsmQuestionList2.get(select);
				    	tsmQuestionListfinal2.add(qid);
				    	
				    	tsmQuestionList2.remove(select);
				    	System.out.println("tsmQuestionList2 after remove"+tsmQuestionList2.size());
				    	
				    }
					session.setAttribute("allqus2", tsmQuestionListfinal2);
					//set 2
					List<QuestionDetailsPojo> tsmQuestionListForSet2=new ArrayList<QuestionDetailsPojo>();
					for(int i=0;i<2;i++)
				    {

						select=randomGenerator.nextInt(tsmQuestionList2.size());
				    	QuestionDetailsPojo qid=tsmQuestionList2.get(select);
				    	tsmQuestionListForSet2.add(qid);
				    	
				    	tsmQuestionList2.remove(select);
				    	System.out.println("tsmQuestionList2 after remove"+tsmQuestionList2.size());
				    	
				    }
					System.out.println("tsmQuestionListfinal"+tsmQuestionListfinal.size());
					session.setAttribute("allqus2Set2", tsmQuestionListForSet2);
					//set 3
					
					List<QuestionDetailsPojo> tsmQuestionListForSet3=new ArrayList<QuestionDetailsPojo>();
					for(int i=0;i<2;i++)
				    {

						select=randomGenerator.nextInt(tsmQuestionList2.size());
				    	QuestionDetailsPojo qid=tsmQuestionList2.get(select);
				    	tsmQuestionListForSet3.add(qid);
				    	
				    	tsmQuestionList2.remove(select);
				    	System.out.println("tsmQuestionList2 after remove"+tsmQuestionList2.size());
				    	
				    }
					session.setAttribute("allqus2Set3", tsmQuestionListForSet3);
					
					System.out.println("total lList"+tsmQuestionList.size());
					System.out.println("total lList"+tsmQuestionList1.size());
					System.out.println("total lList"+tsmQuestionList2.size());
					
					session.setAttribute("subject", subject);
					session.setAttribute("sem", sem);
					/*session.setAttribute("allqus", tsmQuestionListfinal);
					session.setAttribute("allqus1", tsmQuestionListfinal1);
					session.setAttribute("allqus2", tsmQuestionListfinal2);*/
					
					response.sendRedirect("custom30template2.jsp");
					
				}
				else if(template.equals("template3")){
					

					int tsq=0;
					int tsm=0;
					
					 tsq=6;
					 tsm=10;
					 List<QuestionDetailsPojo> tsmQuestionList=new ArrayList<QuestionDetailsPojo>();
					 List<QuestionDetailsPojo> tsmQuestionListfinal=new ArrayList<QuestionDetailsPojo>();
					List<QuestionDetailsPojo> easylistBytsm=subjectDetailsDao.getEasyQuestionBytemp2(subject, tsm,fmod,tmod);
					List<QuestionDetailsPojo> mediumlistBytsm=subjectDetailsDao.getMediumQuestionBytemp2(subject, tsm,fmod,tmod);
					List<QuestionDetailsPojo> hardlistBytsm=subjectDetailsDao.getHardQuestionBytemp2(subject, tsm,fmod,tmod);
					tsmQuestionList.addAll(easylistBytsm);
					tsmQuestionList.addAll(mediumlistBytsm);
					tsmQuestionList.addAll(hardlistBytsm);
					 System.out.println("tsmQuestionList before size"+tsmQuestionList.size());
					    
					  //set1
					    for(int i=0;i<6;i++)
					    {
					    	select=randomGenerator.nextInt(tsmQuestionList.size());
					    	QuestionDetailsPojo qid=tsmQuestionList.get(select);
					    	tsmQuestionListfinal.add(qid);
					    	
					    	tsmQuestionList.remove(select);
					    System.out.println("tsmQuestionList after:::"+tsmQuestionList.size());
					    }
					    session.setAttribute("allQuest", tsmQuestionListfinal);
					    
					    //set2
					    List<QuestionDetailsPojo> tsmQuestionListfinalForSet2=new ArrayList<QuestionDetailsPojo>();
					    for(int i=0;i<6;i++)
					    {
					    	select=randomGenerator.nextInt(tsmQuestionList.size());
					    	QuestionDetailsPojo qid=tsmQuestionList.get(select);
					    	tsmQuestionListfinalForSet2.add(qid);
					    	
					    	tsmQuestionList.remove(select);
					    System.out.println("tsmQuestionList:::"+tsmQuestionList.size());
					    }
					    session.setAttribute("allQuestSet2", tsmQuestionListfinalForSet2);
					    List<QuestionDetailsPojo>  tsmQuestionListfinalForSet3=new ArrayList<QuestionDetailsPojo>();
					    
					  //set 3
					  for(int i=0;i<6;i++)
					    {
					    	select=randomGenerator.nextInt(tsmQuestionList.size());
					    	QuestionDetailsPojo qid=tsmQuestionList.get(select);
					    	 tsmQuestionListfinalForSet3.add(qid);
					    	
					    	 tsmQuestionList.remove(select);
					    System.out.println("tmp1QuestionList:::"+tsmQuestionList.size());
					    }
					  session.setAttribute("allQuestSet3", tsmQuestionListfinalForSet3);
					  session.setAttribute("subject", subject);
						session.setAttribute("sem", sem);
					response.sendRedirect("custom30template3.jsp");
				}
	            else if(template.equals("template4")){
					

					int tsq=0;
					int tsm=0;
					
					
					 tsq=2;
					 tsm=6;
					 List<QuestionDetailsPojo> tsmQuestionList1=new ArrayList<QuestionDetailsPojo>();
					 
					 List<QuestionDetailsPojo> tsmQuestionListfinal=new ArrayList<QuestionDetailsPojo>();
					 List<QuestionDetailsPojo> tsmQuestionListfinalForSet2=new ArrayList<QuestionDetailsPojo>();
					 List<QuestionDetailsPojo> tsmQuestionListfinalForSet3=new ArrayList<QuestionDetailsPojo>();
					 
					List<QuestionDetailsPojo> easylistBytsm1=subjectDetailsDao.getEasyQuestionBytemp2(subject, tsm,fmod,tmod);
					List<QuestionDetailsPojo> mediumlistBytsm1=subjectDetailsDao.getMediumQuestionBytemp2(subject, tsm,fmod,tmod);
					List<QuestionDetailsPojo> hardlistBytsm1=subjectDetailsDao.getHardQuestionBytemp2(subject, tsm,fmod,tmod);
					tsmQuestionList1.addAll(easylistBytsm1);
					tsmQuestionList1.addAll(mediumlistBytsm1);
					tsmQuestionList1.addAll(hardlistBytsm1);
					System.out.println("tsmQuestionList1 for 6 marks before::"+tsmQuestionList1.size());
					
					 tsq=4;
					 tsm=10;
					 List<QuestionDetailsPojo> tsmQuestionList=new ArrayList<QuestionDetailsPojo>();
					List<QuestionDetailsPojo> easylistBytsm=subjectDetailsDao.getEasyQuestionBytemp2(subject, tsm,fmod,tmod);
					List<QuestionDetailsPojo> mediumlistBytsm=subjectDetailsDao.getMediumQuestionBytemp2(subject, tsm,fmod,tmod);
					List<QuestionDetailsPojo> hardlistBytsm=subjectDetailsDao.getHardQuestionBytemp2(subject, tsm,fmod,tmod);
					tsmQuestionList.addAll(easylistBytsm);
					tsmQuestionList.addAll(mediumlistBytsm);
					tsmQuestionList.addAll(hardlistBytsm);
					System.out.println("tsmQuestionList for 10 before"+tsmQuestionList.size());
					
					for(int i=0;i<2;i++)
				    {
						select=randomGenerator.nextInt(tsmQuestionList1.size());
						QuestionDetailsPojo qid=tsmQuestionList1.get(select);
				    	tsmQuestionListfinal.add(qid);
				    	
				    	tsmQuestionList1.remove(select);
				        System.out.println("tsmQuestionList1 after:::"+tsmQuestionList1.size());
				    
					    select=randomGenerator.nextInt(tsmQuestionList.size());
					    QuestionDetailsPojo qid1=tsmQuestionList.get(select);
				    	tsmQuestionListfinal.add(qid1);
			    	
			    	    tsmQuestionList.remove(select);
			            System.out.println("tsmQuestionList after:::"+tsmQuestionList.size());
				    	
				    }
					session.setAttribute("list1",tsmQuestionListfinal);
					//2nd set
					for(int i=0;i<2;i++)
				    {
						select=randomGenerator.nextInt(tsmQuestionList1.size());
						QuestionDetailsPojo qid=tsmQuestionList1.get(select);
				    	tsmQuestionListfinalForSet2.add(qid);
				    	
				    	tsmQuestionList1.remove(select);
				        System.out.println("tsmQuestionList1 after:::"+tsmQuestionList1.size());
				    
					    select=randomGenerator.nextInt(tsmQuestionList.size());
					    QuestionDetailsPojo qid1=tsmQuestionList.get(select);
					    tsmQuestionListfinalForSet2.add(qid1);
			    	
			    	    tsmQuestionList.remove(select);
			            System.out.println("tsmQuestionList after:::"+tsmQuestionList.size());
				    	
				    }
					
					session.setAttribute("list1Set2",tsmQuestionListfinalForSet2);
					//3rd Set
					for(int i=0;i<2;i++)
				    {
						select=randomGenerator.nextInt(tsmQuestionList1.size());
						QuestionDetailsPojo qid=tsmQuestionList1.get(select);
				    	tsmQuestionListfinalForSet3.add(qid);
				    	
				    	tsmQuestionList1.remove(select);
				        System.out.println("tsmQuestionList1 after:::"+tsmQuestionList1.size());
				    
					    select=randomGenerator.nextInt(tsmQuestionList.size());
					    QuestionDetailsPojo qid1=tsmQuestionList.get(select);
					    tsmQuestionListfinalForSet3.add(qid1);
			    	
			    	    tsmQuestionList.remove(select);
			            System.out.println("tsmQuestionList after:::"+tsmQuestionList.size());
				    	
				    }
					session.setAttribute("list1Set3",tsmQuestionListfinalForSet3);
					
					 List<QuestionDetailsPojo> tsmQuestionListfor10Marks=new ArrayList<QuestionDetailsPojo>();
					 List<QuestionDetailsPojo> tsmQuestionListfor10MarksForSet2=new ArrayList<QuestionDetailsPojo>();
					 List<QuestionDetailsPojo> tsmQuestionListfor10MarksForSet3=new ArrayList<QuestionDetailsPojo>();
					 
					for(int i=4;i<6;i++)
				    {
						select=randomGenerator.nextInt(tsmQuestionList.size());
				    	QuestionDetailsPojo qid=tsmQuestionList.get(select);
				    	tsmQuestionListfor10Marks.add(qid);
				    	
				    	tsmQuestionList.remove(select);
				        System.out.println("tsmQuestionList:::"+tsmQuestionList.size());
				    	
				    }
					session.setAttribute("list2",tsmQuestionListfor10Marks);
					//2nd Set
					
					for(int i=4;i<6;i++)
				    {
						select=randomGenerator.nextInt(tsmQuestionList.size());
				    	QuestionDetailsPojo qid=tsmQuestionList.get(select);
				    	tsmQuestionListfor10MarksForSet2.add(qid);
				    	
				    	tsmQuestionList.remove(select);
				        System.out.println("tsmQuestionList:::"+tsmQuestionList.size());
				    	
				    }
					session.setAttribute("list2Set2",tsmQuestionListfor10MarksForSet2);
					//3re set
					
					for(int i=4;i<6;i++)
				    {
						select=randomGenerator.nextInt(tsmQuestionList.size());
				    	QuestionDetailsPojo qid=tsmQuestionList.get(select);
				    	tsmQuestionListfor10MarksForSet3.add(qid);
				    	
				    	tsmQuestionList.remove(select);
				        System.out.println("tsmQuestionList:::"+tsmQuestionList.size());
				    	
				    }
					session.setAttribute("list2Set3",tsmQuestionListfor10MarksForSet3);
					
					 tsq=2;
					 tsm=4;
					 List<QuestionDetailsPojo> tsmQuestionList2=new ArrayList<QuestionDetailsPojo>();
					 
					 List<QuestionDetailsPojo> tsmQuestionListfinal2=new ArrayList<QuestionDetailsPojo>();
					 List<QuestionDetailsPojo> tsmQuestionListfinalForSetfinal2=new ArrayList<QuestionDetailsPojo>();
					 List<QuestionDetailsPojo> tsmQuestionListfinalForSetfinal3=new ArrayList<QuestionDetailsPojo>();
					 
					List<QuestionDetailsPojo> easylistBytsm2=subjectDetailsDao.getEasyQuestionBytemp2(subject, tsm,fmod,tmod);
					List<QuestionDetailsPojo> mediumlistBytsm2=subjectDetailsDao.getMediumQuestionBytemp2(subject, tsm,fmod,tmod);
					List<QuestionDetailsPojo> hardlistBytsm2=subjectDetailsDao.getHardQuestionBytemp2(subject, tsm,fmod,tmod);
					tsmQuestionList2.addAll(easylistBytsm2);
					tsmQuestionList2.addAll(mediumlistBytsm2);
					tsmQuestionList2.addAll(hardlistBytsm2);
					System.out.println("tsmQuestionList2 for 4 before::"+tsmQuestionList2.size());
					for(int i=0;i<2;i++)
				    {
						select=randomGenerator.nextInt(tsmQuestionList2.size());
				    	QuestionDetailsPojo qid=tsmQuestionList2.get(select);
				    	tsmQuestionListfinal2.add(qid);
				    	
				    	tsmQuestionList2.remove(select);
				        System.out.println("tsmQuestionList2 after:::"+tsmQuestionList2.size());
				    	
				    }
					session.setAttribute("list3",tsmQuestionListfinal2);
					//2 Set
					
					for(int i=0;i<2;i++)
				    {
						select=randomGenerator.nextInt(tsmQuestionList2.size());
				    	QuestionDetailsPojo qid=tsmQuestionList2.get(select);
				    	tsmQuestionListfinalForSetfinal2.add(qid);
				    	
				    	tsmQuestionList2.remove(select);
				        System.out.println("tsmQuestionList2 after:::"+tsmQuestionList2.size());
				    	
				    }
					session.setAttribute("list3Set2",tsmQuestionListfinalForSetfinal2);
					//3 Set
					
					for(int i=0;i<2;i++)
				    {
						select=randomGenerator.nextInt(tsmQuestionList2.size());
				    	QuestionDetailsPojo qid=tsmQuestionList2.get(select);
				    	tsmQuestionListfinalForSetfinal3.add(qid);
				    	
				    	tsmQuestionList2.remove(select);
				        System.out.println("tsmQuestionList2 after:::"+tsmQuestionList2.size());
				    	
				    }
					session.setAttribute("list3Set3",tsmQuestionListfinalForSetfinal3);
					
					
					session.setAttribute("subject", subject);
					session.setAttribute("sem", sem);
					
					
					response.sendRedirect("custom30template4.jsp");
				}
				
			}
			
	else if(marks.equals("customize30Marks")){
		int fmod =Integer.parseInt(request.getParameter("fromModule"));
		int tmod =Integer.parseInt(request.getParameter("toModule"));
		List<CustomizePojo> list=subjectDetailsDao.getCustomizeDetailsFor30Marks(subject, fmod, tmod);
		System.out.println("custom list size on servlet"+list.size());
		String set=null;
		set="set1";
		
			List<CustomizePojo> lst1=subjectDetailsDao.getustomListSet1(set);
			System.out.println("size for set1"+lst1.size());
			session.setAttribute("lst1", lst1);
			response.sendRedirect("custom30Set1.jsp");
		
			set="set2";
		
			List<CustomizePojo> lst2=subjectDetailsDao.getustomListSet1(set);
			System.out.println("size for set2"+lst2.size());
			session.setAttribute("lst2", lst2);
			//response.sendRedirect("custom30Set2.jsp");
		
			set="set3";
		
			List<CustomizePojo> lst3=subjectDetailsDao.getustomListSet1(set);
			System.out.println("size for set3"+lst3.size());
			session.setAttribute("lst3", lst3);
			//response.sendRedirect("custom30Set3.jsp");
			
			
		
		
	}
	else if(marks.equals("customize80Marks")){
		
		List<CustomizePojo> list=subjectDetailsDao.getCustomizeDetailsFor80Marks(subject);
		System.out.println("custom list size on servlet"+list.size());
		String set=null;
		set="set1";
		
			List<CustomizePojo> lst1=subjectDetailsDao.getustomListSet1(set);
			System.out.println("size for set1"+lst1.size());
			session.setAttribute("list1", lst1);
			response.sendRedirect("custom80Set1.jsp");
		
			set="set2";
		
			List<CustomizePojo> lst2=subjectDetailsDao.getustomListSet1(set);
			System.out.println("size for set2"+lst2.size());
			session.setAttribute("list2", lst2);
			//response.sendRedirect("custom30Set2.jsp");
		
			set="set3";
		
			List<CustomizePojo> lst3=subjectDetailsDao.getustomListSet1(set);
			System.out.println("size for set3"+lst3.size());
			session.setAttribute("list3", lst3);
	}		
			
			
			
			
			
/*		 int fromModule=0;
			if(fmod1 == "null")
			{
				fromModule = Integer.parseInt( request.getParameter("frommodule"));
			}
			
			System.out.println("fromModule"+fromModule);
			
			
			String practical=request.getParameter("practical");
			System.out.println("practical"+practical);
			String theory=request.getParameter("theory");
			System.out.println("theory"+theory);
			
			String[] analytical = practical.split(",");
			String pract1 = analytical[0]; 
			String pract2 = analytical[1];
			 
			System.out.println("pract1"+pract1);
			
			String[] descriptive = theory.split(",");
			String theory1 = descriptive[0]; 
			String theory2 = descriptive[1];
			System.out.println("theory1"+theory1);
			
			String[] difficultyLevel = difficulty.split("-");
			String level1 = difficultyLevel[0]; 
			String level2 = difficultyLevel[1];
			System.out.println("level1"+level1);
			
			int difflevel1=Integer.parseInt(level1);
			int difflevel2=Integer.parseInt(level2);
			int diffAvg=((difflevel1+difflevel2)/2);
			int finalDiff=10-diffAvg;
			
			int analytical1=Integer.parseInt(pract1);
			int analytical2=Integer.parseInt(pract2);
			int descriptive1=Integer.parseInt(theory1);
			int descriptive2=Integer.parseInt(theory2);
			
			int anlAvg=0;
			int desAvg=0;
			double FSKAnl=0;
			double FSKDes=0;
			anlAvg=((analytical1+analytical2)/2);
			desAvg=((descriptive1+descriptive2)/2);
			FSKAnl=10-anlAvg;
			FSKDes=10-FSKAnl;
			System.out.println("anlAvg"+anlAvg);
			System.out.println("desAvg"+desAvg);
			System.out.println("FSKAnl"+FSKAnl);
			System.out.println("FSKDes"+FSKDes);
			
			
			double a1=(FSKAnl/10);
			System.out.println("a1"+a1);
			double analyticalMarks= (a1*marks);
			double b1=(FSKDes/10);
			double descriptiveMarks=(b1*marks);
			System.out.println("analyticalMarks"+analyticalMarks);
			System.out.println("descriptiveMarks"+descriptiveMarks);
			
			
			int max=0;
			String AnalyticalLevel=null;
			String DescriptiveLevel=null;
			int a=((analytical1+descriptive1)/2);
			int b=((analytical1+descriptive2)/2);
			int c=((analytical2+descriptive1)/2);
			int d=((analytical2+descriptive2)/2);
			System.out.println("a"+a+""+"b"+b+""+"c"+c+""+"d"+d );
			if(a>b)
			{
				max=a;
			}
			else if(c>max)
			{
				max=c;
			}
			else if(d>max)
			{
				max=d;
			}
			System.out.println("max"+max);
			
			if(max >=1 && max<=2)
			{
				AnalyticalLevel="veryLow";
				DescriptiveLevel="veryhigh";
			}
			else if(max>=3 && max<=4)
			{
				AnalyticalLevel="low";
				DescriptiveLevel="high";
			}
			else if(max>=5 && max<=6)
			{
				AnalyticalLevel="medium";
				DescriptiveLevel="medium";
			}
			else if(max>=7 && max<=8)
			{
				AnalyticalLevel="high";
				DescriptiveLevel="low";
			}
			else if(max>=9 && max<=10)
			{
				AnalyticalLevel="veryhigh";
				DescriptiveLevel="veryLow";
			}
			System.out.println("AnalyticalLevel"+AnalyticalLevel);
			System.out.println("DescriptiveLevel"+DescriptiveLevel);
			
			
			int osq=7;
			int osm=10;
			double osmAdiv=(analyticalMarks/osm);
			double osmDdiv=(descriptiveMarks/osm);
			
			if((osmAdiv+osmDdiv)>osq)
			{
				osmAdiv=osq-1;
				osmDdiv=1;
			}
			
			double FSKe=0;
			double FSKm=0;
			double FSKd=0;
			if(difficulty.equalsIgnoreCase("1-2"))
			{
				 FSKe=5;
				 FSKm=3;
				 FSKd=2;
			}
			else if(difficulty.equalsIgnoreCase("3-4"))
			{
				 FSKe=4;
				 FSKm=5;
				 FSKd=1;
			}
			else if(difficulty.equalsIgnoreCase("5-6"))
			{
				 FSKe=2;
				 FSKm=3;
				 FSKd=5;
			}
			
			
			double x=FSKe+FSKm+FSKd;
			System.out.println("FSKe"+FSKe);
			System.out.println("FSKm"+FSKm);
			System.out.println("FSKd"+FSKd);
			double w =5;
			double y=x/w;
			
			
			
			double FSKe1=(double)(FSKe/y);
			double FSKm1=(double)(FSKm/y);
			double FSKd1=(double)(FSKd/y);
			
			double FSKe2 =Math.round(FSKe1);
			double FSKm2 =Math.round(FSKm1);
			double FSKd2 =Math.round(FSKd1);
			System.out.println("FSKe1"+FSKe1);
			System.out.println("FSKm1"+FSKm1);
			System.out.println("FSKd1"+FSKd1);
			System.out.println("FSKe2"+FSKe2);
			System.out.println("FSKm2"+FSKm2);
			System.out.println("FSKd2"+FSKd2);
			
			List<QuestionDetailsPojo> osmQuestionList=new ArrayList<QuestionDetailsPojo>();

			List<QuestionDetailsPojo> easylistByosm=subjectDetailsDao.getEasyQuestionByOsm(subject,osm);
			List<QuestionDetailsPojo> mediumlistByosm=subjectDetailsDao.getMediumQuestionByOsm(subject,osm);
			List<QuestionDetailsPojo> hardlistByosm=subjectDetailsDao.getHardQuestionByOsm(subject,osm);
			System.out.println("easylistByosm size............"+easylistByosm.size());
			System.out.println("mediumlistByosm size............"+mediumlistByosm.size());
			System.out.println("hardlistByosm size............"+hardlistByosm.size());

			osmQuestionList.addAll(easylistByosm);
			osmQuestionList.addAll(mediumlistByosm);
			osmQuestionList.addAll(mediumlistByosm);
			
			Random randomGenerator = new Random();
			long q_id=0;
			int select=0;
			Collections.shuffle(osmQuestionList);
			select =randomGenerator.nextInt(osmQuestionList.size());
			System.out.println("select......"+select);
			QuestionDetailsPojo id1 = osmQuestionList.get(select);
			q_id=id1.getQuestion_id();
			System.out.println("indexxxxxxx"+q_id);
			List<QuestionDetailsPojo> questionPojo = (List<QuestionDetailsPojo>) subjectDetailsDao.getQuestion(q_id);
			
			int tsq=11;
			int tsm=5;
			
			List<QuestionDetailsPojo> easylistBytsm=subjectDetailsDao.getEasyQuestionByTsm(subject,tsm);
			List<QuestionDetailsPojo> mediumlistBytsm=subjectDetailsDao.getMediumQuestionByTsm(subject,tsm);
			List<QuestionDetailsPojo> hardlistBytsm=subjectDetailsDao.getHardQuestionByTsm(subject,tsm);
			
			System.out.println("easylistBytsm size............"+easylistBytsm.size());
			System.out.println("mediumlistBytsm size............"+mediumlistBytsm.size());
			System.out.println("hardlistBytsm size............"+hardlistBytsm.size());
			
			List<QuestionDetailsPojo> tsmQuestionList=new ArrayList<QuestionDetailsPojo>();
			
			tsmQuestionList.addAll(easylistBytsm);
			tsmQuestionList.addAll(mediumlistBytsm);
			tsmQuestionList.addAll(hardlistBytsm);
			
			Random randomGenerator1 = new Random();
			Collections.shuffle(tsmQuestionList);
			select =randomGenerator.nextInt(tsmQuestionList.size());
			System.out.println("select......"+select);
			
			QuestionDetailsPojo id2 = tsmQuestionList.get(select);
			q_id=id2.getQuestion_id();
			System.out.println("indexxxxxxx"+q_id);
			List<QuestionDetailsPojo> questionPojo1 = (List<QuestionDetailsPojo>) subjectDetailsDao.getQuestion(q_id);
			
			Document document = new Document(PageSize.A4, 50, 50, 50, 50);
			try {
				String pdfpath = "D:\\fuzzyPaper.pdf";
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfpath));
				document.open();
				  Anchor anchorTarget = new Anchor("                      "+"PRELIMINARY EXAMINATIONS-I");
			      anchorTarget.setName("BackToTop");
			      Paragraph paragraph1 = new Paragraph();
			 
			      paragraph1.setSpacingBefore(50);
			 
			      paragraph1.add(anchorTarget);
			      document.add(paragraph1);
			      document.add(new Paragraph("Subject:"+subject+"                                                                                     "+"Acadamic Year:"+"2017-2018")); 
			      document.add(new Paragraph("Class/semester:"+sem+"                                                                                    "+"Time:"+time)); 
			      document.add(new Paragraph("Div:"+"A/B"+"                                                                                              "+"Marks:"+marks));
			     
			      document.add(new Paragraph("Note:"));
			      document.add(new Paragraph("(i) Each question carries 20 marks"));
			      document.add(new Paragraph("(ii) Question 1 is compulsary"));
			      document.add(new Paragraph("(iii) Attempt any three (3) from the remaining question "));
			      document.add(new Paragraph("(iv) Assume suitable data whereever required"));
			
			
			document.add(new Paragraph("                                                                                                                                     " )); 
			document.add(new Paragraph("                                                                                                                                     " )); 
			document.add(new Paragraph("                                                                                                                                     " )); 
			 
			com.itextpdf.text.List l = new com.itextpdf.text.List(true, false, 10);
			com.itextpdf.text.List innerList = new com.itextpdf.text.List(true, false, 10);
						
				
						
						String ele=null;
						float questionmarks=0;
						
						
						int getquestionno =0;
						document.add(new Paragraph("Q1."));
						
							char count1 ='a';
						for(int i=0;i<1;i++)
						{ 
							
							      
																				  
									ele =osmQuestionList.get(i).getQuestion();
									questionmarks=osmQuestionList.get(i).getMarks();
									System.out.println(",,,,,,,,,ele"+ele);
									System.out.println(",,,,,,,,,getquestionno"+getquestionno);
									
										
										document.add(new Paragraph("   "+(count1)+")"+"       "+ele+"                                     "+questionmarks));
										
										
										count1++;			
									
									
						}
						for(int i=0;i<3;i++)
						{ 
							
																				  
									ele =tsmQuestionList.get(i).getQuestion();
									questionmarks=tsmQuestionList.get(i).getMarks();
									System.out.println(",,,,,,,,,ele"+ele);
									System.out.println(",,,,,,,,,getquestionno"+getquestionno);
									
										
										document.add(new Paragraph("   "+(count1)+")"+"       "+ele+"                                     "+questionmarks));
										
										
										
										count1++;	
									
						}
						
						
						
						document.add(new Paragraph("Q2."));
						char count2 ='a';
					
						for(int i=1;i<2;i++)
						{ 
							
																				  
									ele =osmQuestionList.get(i).getQuestion();
									questionmarks=osmQuestionList.get(i).getMarks();
									System.out.println(",,,,,,,,,ele"+ele);
									System.out.println(",,,,,,,,,getquestionno"+getquestionno);
									
										
										document.add(new Paragraph("   "+(count2)+")"+"       "+ele+"                                     "+questionmarks));
										
										
										count2++;
									
									
						}
						for(int i=3;i<6;i++)
						{ 
							
																				  
									ele =tsmQuestionList.get(i).getQuestion();
									questionmarks=tsmQuestionList.get(i).getMarks();
									System.out.println(",,,,,,,,,ele"+ele);
									System.out.println(",,,,,,,,,getquestionno"+getquestionno);
									
										
										document.add(new Paragraph("   "+(count2)+")"+"       "+ele+"                                     "+questionmarks));
										count2++;
										
										
									
									
						}
						
						char count3 ='a';
						document.add(new Paragraph("Q3."));
						
						for(int i=2;i<4;i++)
						{ 
							
																				  
									ele =osmQuestionList.get(i).getQuestion();
									questionmarks=osmQuestionList.get(i).getMarks();
									System.out.println(",,,,,,,,,ele"+ele);
									System.out.println(",,,,,,,,,getquestionno"+getquestionno);
									
										
										document.add(new Paragraph("   "+(count3)+")"+"       "+ele+"                                     "+questionmarks));
										count3++;
										
										
									
									
						}
						
						char count4='a';
						document.add(new Paragraph("Q4."));
						
						for(int i=4;i<6;i++)
						{ 
							
																				  
									ele =osmQuestionList.get(i).getQuestion();
									questionmarks=osmQuestionList.get(i).getMarks();
									System.out.println(",,,,,,,,,ele"+ele);
									System.out.println(",,,,,,,,,getquestionno"+getquestionno);
									
										
										document.add(new Paragraph("   "+(count4)+")"+"       "+ele+"                                     "+questionmarks));
										
										
										
									
									
						}
						
							char count5 ='a';
						document.add(new Paragraph("Q5."));
						
						for(int i=6;i<8;i++)
						{ 
							
																				  
									ele =tsmQuestionList.get(i).getQuestion();
									questionmarks=tsmQuestionList.get(i).getMarks();
									System.out.println(",,,,,,,,,ele"+ele);
									System.out.println(",,,,,,,,,getquestionno"+getquestionno);
									
										
										document.add(new Paragraph("   "+(count5)+")"+"       "+ele+"                                     "+questionmarks));
										
										count5++;
										
									
									
						}
						for(int i=6;i<7;i++)
						{ 
							
																				  
									ele =osmQuestionList.get(i).getQuestion();
									questionmarks=osmQuestionList.get(i).getMarks();
									System.out.println(",,,,,,,,,ele"+ele);
									System.out.println(",,,,,,,,,getquestionno"+getquestionno);
									
										
										document.add(new Paragraph("   "+(count5)+")"+"       "+ele+"                                     "+questionmarks));
										
										count5++;
										
									
									
						}
					
				
						document.add(new Paragraph("Q6."));
						
							char count6 ='a';
						for(int i=8;i<13;i++)
						{ 
							
																				  
									ele =tsmQuestionList.get(i).getQuestion();
									questionmarks=tsmQuestionList.get(i).getMarks();
									System.out.println(",,,,,,,,,ele"+ele);
									System.out.println(",,,,,,,,,getquestionno"+getquestionno);
									
										
										document.add(new Paragraph("   "+(count6)+")"+"       "+ele+"                                     "+questionmarks));
										count6++;
										
										
									
									
						}
						
				
				document.close();
				EmailUtility email1 = new EmailUtility();
				//email1.sendEmailUrl(email, pdfpath);
				response.sendRedirect("facultyhomepage.jsp");
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
			int thsq=2;
			int thsm=6;
			int fsq=2;
			int fsm=4;
			
			
			
			
			
			float toModule=Float.parseFloat((request.getParameter("toModule")));
			System.out.println("toModule"+toModule);*/
		
			
		
			
			
		  /* SubjectDetailsPojo subjectDetailsPojo=subjectDetailsDao.getSubjectOnSubName(subject_name);
		    PrintWriter out = response.getWriter();
			String json = new Gson().toJson(subjectDetailsPojo);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);*/
		 
	 }
	 
	/* else if(action!=null && action.equalsIgnoreCase("generatePaper30Marks"))
		{
		 	String branch=request.getParameter("branch");
		    System.out.println("branch"+branch);
			String year=request.getParameter("year");
			System.out.println("year"+year);
			String sem=request.getParameter("sem");
			System.out.println("sem"+sem);
			String subject=request.getParameter("subject");
			System.out.println("subject"+subject);
			String date=request.getParameter("date");
			System.out.println("date"+date);
			String difficulty=request.getParameter("difficulty");
			System.out.println("difficulty"+difficulty);
			String time=request.getParameter("time");
			System.out.println("time"+time);
			int marks=Integer.parseInt(request.getParameter("marks"));
			System.out.println("marks"+marks);
			int fmod =Integer.parseInt(request.getParameter("fromModule"));
			int tmod =Integer.parseInt(request.getParameter("toModule"));
			String template=request.getParameter("template");
			System.out.println("template"+template);
			
			 Random randomGenerator= new Random();
			    long q_id=0;
			    String question=null;
			    int select=0;
			
			
			   if(template.equalsIgnoreCase("template1"))
			   {
			    int que=10;
			    int mark=6;
			    List<QuestionDetailsPojo> tmp1QuestionList=new ArrayList<QuestionDetailsPojo>();
				Set<QuestionDetailsPojo> tmp1QuestionList10=new HashSet<QuestionDetailsPojo>();
			    List<QuestionDetailsPojo> easylistBytemp1=subjectDetailsDao.getEasyQuestionBytemp2(subject,mark,fmod,tmod);
			    List<QuestionDetailsPojo> mediumlistBytemp1=subjectDetailsDao.getMediumQuestionBytemp2(subject,mark,fmod,tmod);
			    List<QuestionDetailsPojo> hardlistBytemp1=subjectDetailsDao.getHardQuestionBytemp2(subject,mark,fmod,tmod);
			    
			    System.out.println("easylistBytemp1 size............"+easylistBytemp1.size());
			    System.out.println("mediumlistBytemp1 size............"+mediumlistBytemp1.size());
			    System.out.println("hardlistBytemp1 size............"+hardlistBytemp1.size());
			    
			   
			    session.setAttribute("tmp1QuestionList", tmp1QuestionList);
			    
			    tmp1QuestionList.addAll(easylistBytemp1);
			    tmp1QuestionList.addAll(mediumlistBytemp1);
			    tmp1QuestionList.addAll(hardlistBytemp1);
			    
			    
			   
			    float q_marks=0;
			    System.out.println("tmp1QuestionList size"+tmp1QuestionList.size());
			   
			    //set 1
			    for(int i=0;i<10;i++)
			    {
			    	select=randomGenerator.nextInt(tmp1QuestionList.size());
			    	QuestionDetailsPojo qid=tmp1QuestionList.get(select);
			    	tmp1QuestionList10.add(qid);
			    	
			    tmp1QuestionList.remove(select);
			    System.out.println("tmp1QuestionList:::"+tmp1QuestionList.size());
			    
			    }
			    
			    //set2
			    Set<QuestionDetailsPojo> tmp1QuestionListForSet2=new HashSet<QuestionDetailsPojo>();
			    for(int i=0;i<10;i++)
			    {
			    	select=randomGenerator.nextInt(tmp1QuestionList.size());
			    	QuestionDetailsPojo qid=tmp1QuestionList.get(select);
			    	tmp1QuestionListForSet2.add(qid);
			    	
			    tmp1QuestionList.remove(select);
			    System.out.println("tmp1QuestionList:::"+tmp1QuestionList.size());
			    }
			    session.setAttribute("temSet2", tmp1QuestionListForSet2);
			    
			   //set 3
			    Set<QuestionDetailsPojo> tmp1QuestionListForSet3=new HashSet<QuestionDetailsPojo>();
			    for(int i=0;i<10;i++)
			    {
			    	select=randomGenerator.nextInt(tmp1QuestionList.size());
			    	QuestionDetailsPojo qid=tmp1QuestionList.get(select);
			    	tmp1QuestionListForSet3.add(qid);
			    	
			    tmp1QuestionList.remove(select);
			    System.out.println("tmp1QuestionList:::"+tmp1QuestionList.size());
			    }
			    
			    session.setAttribute("temSet3", tmp1QuestionListForSet3);
			    
			    
			    session.setAttribute("subject", subject);
				session.setAttribute("sem", sem);
			    System.out.println("tmp1QuestionList10 size"+tmp1QuestionList10.size());
			    session.setAttribute("temSet1", tmp1QuestionList10);
			    response.sendRedirect("custom30template1.jsp");
			    
			   }
			   else if(template.equals("template2")){
				
				
				
				int tsq=0;
				int tsm=0;
				
				 tsq=2;
				 tsm=10;
				 List<QuestionDetailsPojo> tsmQuestionList=new ArrayList<QuestionDetailsPojo>();
				 Set<QuestionDetailsPojo> tsmQuestionListfinal=new HashSet<QuestionDetailsPojo>();
				List<QuestionDetailsPojo> easylistBytsm=subjectDetailsDao.getEasyQuestionBytemp2(subject, tsm,fmod,tmod);
				List<QuestionDetailsPojo> mediumlistBytsm=subjectDetailsDao.getMediumQuestionBytemp2(subject, tsm,fmod,tmod);
				List<QuestionDetailsPojo> hardlistBytsm=subjectDetailsDao.getHardQuestionBytemp2(subject, tsm,fmod,tmod);
				tsmQuestionList.addAll(easylistBytsm);
				tsmQuestionList.addAll(mediumlistBytsm);
				tsmQuestionList.addAll(hardlistBytsm);
				System.out.println("tsmQuestionList before remove"+tsmQuestionList.size());
				
				//set1
			    for(int i=0;i<2;i++)
			    {
			    	select=randomGenerator.nextInt(tsmQuestionList.size());
			    	QuestionDetailsPojo qid=tsmQuestionList.get(select);
			    	tsmQuestionListfinal.add(qid);
			    	
			    	tsmQuestionList.remove(select);
			    	System.out.println("tsmQuestionList after remove"+tsmQuestionList.size());
			    	
			    }
				System.out.println("tsmQuestionListfinal"+tsmQuestionListfinal.size());
				session.setAttribute("allqus", tsmQuestionListfinal);
				
				//set 2
				Set<QuestionDetailsPojo> tsmQuestionListfinalSet2=new HashSet<QuestionDetailsPojo>();
				for(int i=0;i<2;i++)
			    {
			    	select=randomGenerator.nextInt(tsmQuestionList.size());
			    	QuestionDetailsPojo qid=tsmQuestionList.get(select);
			    	tsmQuestionListfinalSet2.add(qid);
			    	
			    	tsmQuestionList.remove(select);
			    	System.out.println("tsmQuestionList after remove"+tsmQuestionList.size());
			    	
			    }
				session.setAttribute("allqusSet2", tsmQuestionListfinalSet2);
				
				Set<QuestionDetailsPojo> tsmQuestionListfinalSet3=new HashSet<QuestionDetailsPojo>();
				for(int i=0;i<2;i++)
			    {
			    	select=randomGenerator.nextInt(tsmQuestionList.size());
			    	QuestionDetailsPojo qid=tsmQuestionList.get(select);
			    	tsmQuestionListfinalSet3.add(qid);
			    	
			    	tsmQuestionList.remove(select);
			    	System.out.println("tsmQuestionList after remove"+tsmQuestionList.size());
			    	
			    }
				session.setAttribute("allqusSet3", tsmQuestionListfinalSet3);
				
				 tsq=2;
				tsm=12;
				List<QuestionDetailsPojo> tsmQuestionList1=new ArrayList<QuestionDetailsPojo>();
				Set<QuestionDetailsPojo> tsmQuestionListfinal1=new HashSet<QuestionDetailsPojo>();
				List<QuestionDetailsPojo> easylistBytsm1=subjectDetailsDao.getEasyQuestionBytemp2(subject, tsm,fmod,tmod);
				List<QuestionDetailsPojo> mediumlistBytsm1=subjectDetailsDao.getMediumQuestionBytemp2(subject, tsm,fmod,tmod);
				List<QuestionDetailsPojo> hardlistBytsm1=subjectDetailsDao.getHardQuestionBytemp2(subject, tsm,fmod,tmod);
				tsmQuestionList1.addAll(easylistBytsm1);
				tsmQuestionList1.addAll(mediumlistBytsm1);
				tsmQuestionList1.addAll(hardlistBytsm1);
				System.out.println("tsmQuestionList1 before remove"+tsmQuestionList1.size());
				for(int i=0;i<2;i++)
			    {
					select=randomGenerator.nextInt(tsmQuestionList1.size());
			    	QuestionDetailsPojo qid=tsmQuestionList1.get(select);
			    	tsmQuestionListfinal1.add(qid);
			    	
			    	tsmQuestionList.remove(select);
			    	System.out.println("tsmQuestionList1 after remove"+tsmQuestionList1.size());
			    	
			    }
				System.out.println("tsmQuestionListfinal"+tsmQuestionListfinal.size());
				session.setAttribute("allqus1", tsmQuestionListfinal1);
				
				//set 2
				Set<QuestionDetailsPojo> tsmQuestionListfinalForSet2=new HashSet<QuestionDetailsPojo>();
				for(int i=0;i<2;i++)
			    {
					select=randomGenerator.nextInt(tsmQuestionList1.size());
			    	QuestionDetailsPojo qid=tsmQuestionList1.get(select);
			    	tsmQuestionListfinalForSet2.add(qid);
			    	
			    	tsmQuestionList.remove(select);
			    	System.out.println("tsmQuestionList1 after remove"+tsmQuestionList1.size());
			    	
			    }
				session.setAttribute("allqus1Set2", tsmQuestionListfinalForSet2);
				//set 3
				
				Set<QuestionDetailsPojo> tsmQuestionListfinalForSet3=new HashSet<QuestionDetailsPojo>();
				for(int i=0;i<2;i++)
			    {
					select=randomGenerator.nextInt(tsmQuestionList1.size());
			    	QuestionDetailsPojo qid=tsmQuestionList1.get(select);
			    	tsmQuestionListfinalForSet3.add(qid);
			    	
			    	tsmQuestionList.remove(select);
			    	System.out.println("tsmQuestionList1 after remove"+tsmQuestionList1.size());
			    	
			    }
				session.setAttribute("allqus1Set3", tsmQuestionListfinalForSet3);
				
				    tsq=2;
					tsm=8;
					Set<QuestionDetailsPojo> tsmQuestionListfinal2=new HashSet<QuestionDetailsPojo>();
					List<QuestionDetailsPojo> tsmQuestionList2=new ArrayList<QuestionDetailsPojo>();
					List<QuestionDetailsPojo> easylistBytsm11=subjectDetailsDao.getEasyQuestionBytemp2(subject, tsm,fmod,tmod);
					List<QuestionDetailsPojo> mediumlistBytsm11=subjectDetailsDao.getMediumQuestionBytemp2(subject, tsm,fmod,tmod);
					List<QuestionDetailsPojo> hardlistBytsm11=subjectDetailsDao.getHardQuestionBytemp2(subject, tsm,fmod,tmod);
				
				
				
				tsmQuestionList2.addAll(easylistBytsm11);
				tsmQuestionList2.addAll(mediumlistBytsm11);
				tsmQuestionList2.addAll(hardlistBytsm11);
				
				System.out.println("tsmQuestionList2 before remove"+tsmQuestionList2.size());
				for(int i=0;i<2;i++)
			    {
					select=randomGenerator.nextInt(tsmQuestionList2.size());
			    	QuestionDetailsPojo qid=tsmQuestionList2.get(select);
			    	tsmQuestionListfinal2.add(qid);
			    	
			    	tsmQuestionList2.remove(select);
			    	System.out.println("tsmQuestionList2 after remove"+tsmQuestionList2.size());
			    	
			    }
				session.setAttribute("allqus2", tsmQuestionListfinal2);
				//set 2
				Set<QuestionDetailsPojo> tsmQuestionListForSet2=new HashSet<QuestionDetailsPojo>();
				for(int i=0;i<2;i++)
			    {

					select=randomGenerator.nextInt(tsmQuestionList2.size());
			    	QuestionDetailsPojo qid=tsmQuestionList2.get(select);
			    	tsmQuestionListForSet2.add(qid);
			    	
			    	tsmQuestionList2.remove(select);
			    	System.out.println("tsmQuestionList2 after remove"+tsmQuestionList2.size());
			    	
			    }
				System.out.println("tsmQuestionListfinal"+tsmQuestionListfinal.size());
				session.setAttribute("allqus2Set2", tsmQuestionListForSet2);
				//set 3
				
				Set<QuestionDetailsPojo> tsmQuestionListForSet3=new HashSet<QuestionDetailsPojo>();
				for(int i=0;i<2;i++)
			    {

					select=randomGenerator.nextInt(tsmQuestionList2.size());
			    	QuestionDetailsPojo qid=tsmQuestionList2.get(select);
			    	tsmQuestionListForSet3.add(qid);
			    	
			    	tsmQuestionList2.remove(select);
			    	System.out.println("tsmQuestionList2 after remove"+tsmQuestionList2.size());
			    	
			    }
				session.setAttribute("allqus2Set3", tsmQuestionListForSet3);
				
				System.out.println("total lList"+tsmQuestionList.size());
				System.out.println("total lList"+tsmQuestionList1.size());
				System.out.println("total lList"+tsmQuestionList2.size());
				
				session.setAttribute("subject", subject);
				session.setAttribute("sem", sem);
				session.setAttribute("allqus", tsmQuestionListfinal);
				session.setAttribute("allqus1", tsmQuestionListfinal1);
				session.setAttribute("allqus2", tsmQuestionListfinal2);
				
				response.sendRedirect("custom30template2.jsp");
				
			}
			else if(template.equals("template3")){
				

				int tsq=0;
				int tsm=0;
				
				 tsq=6;
				 tsm=10;
				 List<QuestionDetailsPojo> tsmQuestionList=new ArrayList<QuestionDetailsPojo>();
				 Set<QuestionDetailsPojo> tsmQuestionListfinal=new HashSet<QuestionDetailsPojo>();
				List<QuestionDetailsPojo> easylistBytsm=subjectDetailsDao.getEasyQuestionBytemp2(subject, tsm,fmod,tmod);
				List<QuestionDetailsPojo> mediumlistBytsm=subjectDetailsDao.getMediumQuestionBytemp2(subject, tsm,fmod,tmod);
				List<QuestionDetailsPojo> hardlistBytsm=subjectDetailsDao.getHardQuestionBytemp2(subject, tsm,fmod,tmod);
				tsmQuestionList.addAll(easylistBytsm);
				tsmQuestionList.addAll(mediumlistBytsm);
				tsmQuestionList.addAll(hardlistBytsm);
				 System.out.println("tsmQuestionList before size"+tsmQuestionList.size());
				    
				  //set1
				    for(int i=0;i<6;i++)
				    {
				    	select=randomGenerator.nextInt(tsmQuestionList.size());
				    	QuestionDetailsPojo qid=tsmQuestionList.get(select);
				    	tsmQuestionListfinal.add(qid);
				    	
				    	tsmQuestionList.remove(select);
				    System.out.println("tsmQuestionList after:::"+tsmQuestionList.size());
				    }
				    session.setAttribute("allQuest", tsmQuestionListfinal);
				    
				    //set2
				    Set<QuestionDetailsPojo> tsmQuestionListfinalForSet2=new HashSet<QuestionDetailsPojo>();
				    for(int i=0;i<6;i++)
				    {
				    	select=randomGenerator.nextInt(tsmQuestionList.size());
				    	QuestionDetailsPojo qid=tsmQuestionList.get(select);
				    	tsmQuestionListfinalForSet2.add(qid);
				    	
				    	tsmQuestionList.remove(select);
				    System.out.println("tsmQuestionList:::"+tsmQuestionList.size());
				    }
				    session.setAttribute("allQuestSet2", tsmQuestionListfinalForSet2);
				  Set<QuestionDetailsPojo>  tsmQuestionListfinalForSet3=new HashSet<QuestionDetailsPojo>();
				    
				  //set 3
				  for(int i=0;i<6;i++)
				    {
				    	select=randomGenerator.nextInt(tsmQuestionList.size());
				    	QuestionDetailsPojo qid=tsmQuestionList.get(select);
				    	 tsmQuestionListfinalForSet3.add(qid);
				    	
				    	 tsmQuestionList.remove(select);
				    System.out.println("tmp1QuestionList:::"+tsmQuestionList.size());
				    }
				  session.setAttribute("allQuestSet3", tsmQuestionListfinalForSet3);
				  session.setAttribute("subject", subject);
					session.setAttribute("sem", sem);
				response.sendRedirect("custom30template3.jsp");
			}
            else if(template.equals("template4")){
				

				int tsq=0;
				int tsm=0;
				
				
				 tsq=2;
				 tsm=6;
				 List<QuestionDetailsPojo> tsmQuestionList1=new ArrayList<QuestionDetailsPojo>();
				 
				 Set<QuestionDetailsPojo> tsmQuestionListfinal=new HashSet<QuestionDetailsPojo>();
				 Set<QuestionDetailsPojo> tsmQuestionListfinalForSet2=new HashSet<QuestionDetailsPojo>();
				 Set<QuestionDetailsPojo> tsmQuestionListfinalForSet3=new HashSet<QuestionDetailsPojo>();
				 
				List<QuestionDetailsPojo> easylistBytsm1=subjectDetailsDao.getEasyQuestionBytemp2(subject, tsm,fmod,tmod);
				List<QuestionDetailsPojo> mediumlistBytsm1=subjectDetailsDao.getMediumQuestionBytemp2(subject, tsm,fmod,tmod);
				List<QuestionDetailsPojo> hardlistBytsm1=subjectDetailsDao.getHardQuestionBytemp2(subject, tsm,fmod,tmod);
				tsmQuestionList1.addAll(easylistBytsm1);
				tsmQuestionList1.addAll(mediumlistBytsm1);
				tsmQuestionList1.addAll(hardlistBytsm1);
				System.out.println("tsmQuestionList1 for 6 marks before::"+tsmQuestionList1.size());
				
				 tsq=4;
				 tsm=10;
				 List<QuestionDetailsPojo> tsmQuestionList=new ArrayList<QuestionDetailsPojo>();
				List<QuestionDetailsPojo> easylistBytsm=subjectDetailsDao.getEasyQuestionBytemp2(subject, tsm,fmod,tmod);
				List<QuestionDetailsPojo> mediumlistBytsm=subjectDetailsDao.getMediumQuestionBytemp2(subject, tsm,fmod,tmod);
				List<QuestionDetailsPojo> hardlistBytsm=subjectDetailsDao.getHardQuestionBytemp2(subject, tsm,fmod,tmod);
				tsmQuestionList.addAll(easylistBytsm);
				tsmQuestionList.addAll(mediumlistBytsm);
				tsmQuestionList.addAll(hardlistBytsm);
				System.out.println("tsmQuestionList for 10 before"+tsmQuestionList.size());
				
				for(int i=0;i<2;i++)
			    {
					select=randomGenerator.nextInt(tsmQuestionList1.size());
					QuestionDetailsPojo qid=tsmQuestionList1.get(select);
			    	tsmQuestionListfinal.add(qid);
			    	
			    	tsmQuestionList1.remove(select);
			        System.out.println("tsmQuestionList1 after:::"+tsmQuestionList1.size());
			    
				    select=randomGenerator.nextInt(tsmQuestionList.size());
				    QuestionDetailsPojo qid1=tsmQuestionList.get(select);
			    	tsmQuestionListfinal.add(qid1);
		    	
		    	    tsmQuestionList.remove(select);
		            System.out.println("tsmQuestionList after:::"+tsmQuestionList.size());
			    	
			    }
				session.setAttribute("list1",tsmQuestionListfinal);
				//2nd set
				for(int i=0;i<2;i++)
			    {
					select=randomGenerator.nextInt(tsmQuestionList1.size());
					QuestionDetailsPojo qid=tsmQuestionList1.get(select);
			    	tsmQuestionListfinalForSet2.add(qid);
			    	
			    	tsmQuestionList1.remove(select);
			        System.out.println("tsmQuestionList1 after:::"+tsmQuestionList1.size());
			    
				    select=randomGenerator.nextInt(tsmQuestionList.size());
				    QuestionDetailsPojo qid1=tsmQuestionList.get(select);
				    tsmQuestionListfinalForSet2.add(qid1);
		    	
		    	    tsmQuestionList.remove(select);
		            System.out.println("tsmQuestionList after:::"+tsmQuestionList.size());
			    	
			    }
				
				session.setAttribute("list1Set2",tsmQuestionListfinalForSet2);
				//3rd Set
				for(int i=0;i<2;i++)
			    {
					select=randomGenerator.nextInt(tsmQuestionList1.size());
					QuestionDetailsPojo qid=tsmQuestionList1.get(select);
			    	tsmQuestionListfinalForSet3.add(qid);
			    	
			    	tsmQuestionList1.remove(select);
			        System.out.println("tsmQuestionList1 after:::"+tsmQuestionList1.size());
			    
				    select=randomGenerator.nextInt(tsmQuestionList.size());
				    QuestionDetailsPojo qid1=tsmQuestionList.get(select);
				    tsmQuestionListfinalForSet3.add(qid1);
		    	
		    	    tsmQuestionList.remove(select);
		            System.out.println("tsmQuestionList after:::"+tsmQuestionList.size());
			    	
			    }
				session.setAttribute("list1Set3",tsmQuestionListfinalForSet3);
				
				 Set<QuestionDetailsPojo> tsmQuestionListfor10Marks=new HashSet<QuestionDetailsPojo>();
				 Set<QuestionDetailsPojo> tsmQuestionListfor10MarksForSet2=new HashSet<QuestionDetailsPojo>();
				 Set<QuestionDetailsPojo> tsmQuestionListfor10MarksForSet3=new HashSet<QuestionDetailsPojo>();
				 
				for(int i=4;i<6;i++)
			    {
					select=randomGenerator.nextInt(tsmQuestionList.size());
			    	QuestionDetailsPojo qid=tsmQuestionList.get(select);
			    	tsmQuestionListfor10Marks.add(qid);
			    	
			    	tsmQuestionList.remove(select);
			        System.out.println("tsmQuestionList:::"+tsmQuestionList.size());
			    	
			    }
				session.setAttribute("list2",tsmQuestionListfor10Marks);
				//2nd Set
				
				for(int i=4;i<6;i++)
			    {
					select=randomGenerator.nextInt(tsmQuestionList.size());
			    	QuestionDetailsPojo qid=tsmQuestionList.get(select);
			    	tsmQuestionListfor10MarksForSet2.add(qid);
			    	
			    	tsmQuestionList.remove(select);
			        System.out.println("tsmQuestionList:::"+tsmQuestionList.size());
			    	
			    }
				session.setAttribute("list2Set2",tsmQuestionListfor10MarksForSet2);
				//3re set
				
				for(int i=4;i<6;i++)
			    {
					select=randomGenerator.nextInt(tsmQuestionList.size());
			    	QuestionDetailsPojo qid=tsmQuestionList.get(select);
			    	tsmQuestionListfor10MarksForSet3.add(qid);
			    	
			    	tsmQuestionList.remove(select);
			        System.out.println("tsmQuestionList:::"+tsmQuestionList.size());
			    	
			    }
				session.setAttribute("list2Set3",tsmQuestionListfor10MarksForSet3);
				
				 tsq=2;
				 tsm=4;
				 List<QuestionDetailsPojo> tsmQuestionList2=new ArrayList<QuestionDetailsPojo>();
				 
				 Set<QuestionDetailsPojo> tsmQuestionListfinal2=new HashSet<QuestionDetailsPojo>();
				 Set<QuestionDetailsPojo> tsmQuestionListfinalForSetfinal2=new HashSet<QuestionDetailsPojo>();
				 Set<QuestionDetailsPojo> tsmQuestionListfinalForSetfinal3=new HashSet<QuestionDetailsPojo>();
				 
				List<QuestionDetailsPojo> easylistBytsm2=subjectDetailsDao.getEasyQuestionBytemp2(subject, tsm,fmod,tmod);
				List<QuestionDetailsPojo> mediumlistBytsm2=subjectDetailsDao.getMediumQuestionBytemp2(subject, tsm,fmod,tmod);
				List<QuestionDetailsPojo> hardlistBytsm2=subjectDetailsDao.getHardQuestionBytemp2(subject, tsm,fmod,tmod);
				tsmQuestionList2.addAll(easylistBytsm2);
				tsmQuestionList2.addAll(mediumlistBytsm2);
				tsmQuestionList2.addAll(hardlistBytsm2);
				System.out.println("tsmQuestionList2 for 4 before::"+tsmQuestionList2.size());
				for(int i=0;i<2;i++)
			    {
					select=randomGenerator.nextInt(tsmQuestionList2.size());
			    	QuestionDetailsPojo qid=tsmQuestionList2.get(select);
			    	tsmQuestionListfinal2.add(qid);
			    	
			    	tsmQuestionList2.remove(select);
			        System.out.println("tsmQuestionList2 after:::"+tsmQuestionList2.size());
			    	
			    }
				session.setAttribute("list3",tsmQuestionListfinal2);
				//2 Set
				
				for(int i=0;i<2;i++)
			    {
					select=randomGenerator.nextInt(tsmQuestionList2.size());
			    	QuestionDetailsPojo qid=tsmQuestionList2.get(select);
			    	tsmQuestionListfinalForSetfinal2.add(qid);
			    	
			    	tsmQuestionList2.remove(select);
			        System.out.println("tsmQuestionList2 after:::"+tsmQuestionList2.size());
			    	
			    }
				session.setAttribute("list3Set2",tsmQuestionListfinalForSetfinal2);
				//3 Set
				
				for(int i=0;i<2;i++)
			    {
					select=randomGenerator.nextInt(tsmQuestionList2.size());
			    	QuestionDetailsPojo qid=tsmQuestionList2.get(select);
			    	tsmQuestionListfinalForSetfinal3.add(qid);
			    	
			    	tsmQuestionList2.remove(select);
			        System.out.println("tsmQuestionList2 after:::"+tsmQuestionList2.size());
			    	
			    }
				session.setAttribute("list3Set3",tsmQuestionListfinalForSetfinal3);
				
				
				session.setAttribute("subject", subject);
				session.setAttribute("sem", sem);
				
				
				response.sendRedirect("custom30template4.jsp");
			}
			
			
			
			
		}*/
	
	}

}
