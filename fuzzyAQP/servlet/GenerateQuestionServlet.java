package com.fuzzyAQP.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.fuzzyAQP.dao.SubjectDetailsDao;
import com.fuzzyAQP.dao.SubjectDetailsDaoImpl;
import com.fuzzyAQP.dao.TeacherDetailsDao;
import com.fuzzyAQP.dao.TeacherDetailsDaoImpl;
import com.fuzzyAQP.pojo.CustomizePojo;
import com.fuzzyAQP.pojo.QuestionDetailsPojo;
import com.fuzzyAQP.pojo.SubjectDetailsPojo;
import com.fuzzyAQP.utility.Constant;
import com.google.gson.Gson;

/**
 * Servlet implementation class GenerateQuestionPaper
 */
@MultipartConfig
public class GenerateQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateQuestionServlet() {
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
		System.out.println("action"+action);
		TeacherDetailsDao teacherDetailsDao=new TeacherDetailsDaoImpl();
		SubjectDetailsDao subjectDetailsDao=new SubjectDetailsDaoImpl();
		
		
	
		if(action!=null && action.equals("branchList"))
		{
			String question_id=null;
			question_id=request.getParameter("question_id");
			if(question_id !=null){
			 long question_id1=Long.parseLong(question_id);
			 session.setAttribute("question_id", question_id1);
			}
			
			List<SubjectDetailsPojo> branchList=subjectDetailsDao.getBranchList();
			System.out.println("size"+branchList.size());
			session.setAttribute("branchList", branchList);
			response.sendRedirect("addQuestion.jsp");
			
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
		
		else if(action!=null && action.equals("subjectList"))
		{
			String branch=request.getParameter("branch_name");
			String sem=request.getParameter("sem");
			long teacher_id=(long) session.getAttribute("teacher_id");
			List<SubjectDetailsPojo> subList=subjectDetailsDao.getSubjectList(branch,sem,teacher_id);
			System.out.println("size"+subList.size());
			PrintWriter out = response.getWriter();
			String json = new Gson().toJson(subList);
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
		
		else if(action!=null && action.equals("moduleCount"))
		{
			String subject=request.getParameter("subject");
			//long teacher_id=(long) session.getAttribute("teacher_id");
			int moduleCount=subjectDetailsDao.getModuleBySubject(subject);
			
			System.out.println("moduleCount"+moduleCount);
			
			PrintWriter out = response.getWriter();
			String json = new Gson().toJson(moduleCount);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);
		}
		
		
		else if(action!=null && action.equals("branchListForPaper"))
		{
			String tem=request.getParameter("template");
			System.out.println("temmm"+tem);
			session.setAttribute("temp", tem);
			String marks=request.getParameter("marks");
			System.out.println("marksss"+marks);
			session.setAttribute("marks", marks);
			List<SubjectDetailsPojo> branchList=subjectDetailsDao.getBranchList();
			System.out.println("size"+branchList.size());
			session.setAttribute("branchList", branchList);
			response.sendRedirect("generateQuestionPaper.jsp");
			
		}
		
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		System.out.println("action"+action);
		TeacherDetailsDao teacherDetailsDao=new TeacherDetailsDaoImpl();
		SubjectDetailsDao subjectDetailsDao=new SubjectDetailsDaoImpl();
		
		
	
		if(action!=null && action.equals("RegisterQuestion"))
		{
			String count=null;
			String count1=null;
			
			int new_count=0;
			int new_count1=1;
			
			String consPath=Constant.USER_FILE_LOCATION;
			count=request.getParameter("count");
			System.out.println("count"+count);
			if(!count.equals("")){
				new_count=Integer.parseInt(count);
				}
				System.out.println("new count"+new_count);
				//System.out.println("count"+(count+1));
			
			count1=request.getParameter("count1");
			System.out.println("count1"+count1);
			
			if(!count1.equals("")){
				new_count1=Integer.parseInt(count1);
				}
				System.out.println("new count1"+new_count1);
				//System.out.println("count1"+(count+1));
			
			String file=null;
			
				String branch=request.getParameter("branch");
				System.out.println("branch"+branch);
				
				String year=request.getParameter("year");
				System.out.println("year"+year);
				String sem=request.getParameter("sem");
				System.out.println("sem"+sem);
				int module=Integer.parseInt(request.getParameter("module"));
				System.out.println("module"+module);
				String subject=request.getParameter("subject");
				System.out.println("subject"+subject);
				long teacher_id=(long) session.getAttribute("teacher_id");
				System.out.println("teacher_id"+teacher_id);
				
				String difficulty=request.getParameter("difficulty");
				System.out.println("difficulty"+difficulty);
				String dificulty_text=null;
				float marks=Float.parseFloat(request.getParameter("marks"));
				if(difficulty.equals("1") || difficulty.equals("2")){
					dificulty_text="Easy";
				}
				else if(difficulty.equals("3") || difficulty.equals("4")){
					dificulty_text="Medium";
				}
				else if(difficulty.equals("5") || difficulty.equals("6")){
					dificulty_text="Difficult";
				}
				System.out.println("dificulty_text"+dificulty_text);
				QuestionDetailsPojo questionDetailsPojo=new QuestionDetailsPojo();
				questionDetailsPojo.setBranch(branch);
				questionDetailsPojo.setNo_of_module(module);
				questionDetailsPojo.setSemester(sem);
				questionDetailsPojo.setYear(year);
				questionDetailsPojo.setSubject(subject);
				questionDetailsPojo.setTeacher_id(teacher_id);
				questionDetailsPojo.setDifficulty_level(difficulty);
				//questionDetailsPojo.setQuestion(question);
				questionDetailsPojo.setDifficulty_text(dificulty_text);
				questionDetailsPojo.setMarks(marks);
				//questionDetailsPojo.setImg(file);
				
				boolean b=subjectDetailsDao.addTeacherQuestionDetails(questionDetailsPojo);
				System.out.println("bbb"+b);
				boolean b1=true;
				if(b)
				{
					String  question=null;
					//Part img=null;
					long question_id=subjectDetailsDao.getLastQuestionID();
					questionDetailsPojo.setQuestion_id(question_id);
					for(int i=0;i<=new_count;i++){
						 question=request.getParameter("question"+i);
						 if(question==null){
								question=null;
								}
						System.out.println("question"+question);
						String image_name=request.getParameter("image");
						
						System.out.println("iamge_name"+image_name);
						Part img=request.getPart("image"+i);
						System.out.println("img"+img);
						 file=getFileName(img);
						 if(file.equals("")){
							 file=null;
						    img.write(consPath+file);
						    img.delete();
						 }
						 img.write(consPath+file);
						System.out.println("filename"+file);
						questionDetailsPojo.setImg(file);
						questionDetailsPojo.setQuestion(question);
					 b1=subjectDetailsDao.addTeacherQuestionDetailsInQuestion(questionDetailsPojo);
					}
					System.out.println("b1..........."+b1);
					if(b1){
						long question_id1=subjectDetailsDao.getLastQuestionID();
						System.out.println("question_id1"+question_id1);
						questionDetailsPojo.setQuestion_id(question_id1);
						String text_type=null;
						String t_marks=null;
						double text_mark=0.0;
						for(int j=1;j<=new_count1;j++){
							text_type=request.getParameter("text_type"+j);
							 if(text_type.equals("")){
								 text_type=null;
									}
							 System.out.println("text_type"+text_type);
							 t_marks=request.getParameter("text_mark"+j);
							 if(t_marks.equals("")){
								 text_mark=0.0;
									}
							 else{
							 text_mark=Double.parseDouble(t_marks);
							 }
							 System.out.println("text_mark"+text_mark);
							 questionDetailsPojo.setText_type(text_type);
							 questionDetailsPojo.setText_marks(text_mark);
							 boolean b3=subjectDetailsDao.addTeacherQuestionDetailsInMarksScheme(questionDetailsPojo);
							 if(b3){
								 String dquestion_id=request.getParameter("dquestion_id");
								 long dquestion_id1=0;
								 System.out.println("questn id null"+dquestion_id);
								 if(!dquestion_id.equals("")){
									 
								  dquestion_id1=Long.parseLong(dquestion_id);
								 
									System.out.println("question_id fro delete"+dquestion_id1);
									
									boolean b4=subjectDetailsDao.deleteQuestion(dquestion_id1);
									
									}
								 else{
									 System.out.println("in else");
								 }
							 }
						}
						
					}
					
					response.sendRedirect("GenerateQuestionServlet?action=branchList");
				}
				
			}
		
		
		else if(action!=null && action.equals("questionList"))
		{
			//long teacher_id=(long) session.getAttribute("teacher_id");
			List<QuestionDetailsPojo> questionList=subjectDetailsDao.getAllQuestion();
			for(int i=0;i<questionList.size();i++)
			{
				System.out.println(questionList.get(i).getImg());
			}
			System.out.println("questionList size..........."+questionList.size());
			session.setAttribute("questionList", questionList);
			response.sendRedirect("questionList.jsp");
		}
		else if(action!=null && action.equals("deleteQuestion"))
		{
			long question_id=Long.parseLong(request.getParameter("question_id"));
			System.out.println("questionid frodelete"+question_id);
	     	boolean b=subjectDetailsDao.deleteQuestion(question_id);
	     	PrintWriter out = response.getWriter();
			String json = new Gson().toJson(b);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);
		}
		else if(action!=null && action.equals("questionDetailsOnID"))
		{
			long question_id=Long.parseLong(request.getParameter("question_id"));
			System.out.println("questionid for update"+question_id);
			QuestionDetailsPojo questionDetailsPojo=subjectDetailsDao.getQuestionDetails(question_id);
			PrintWriter out = response.getWriter();
			String json = new Gson().toJson(questionDetailsPojo);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(json);
		}
		else if(action!=null && action.equals("allQuestion"))
		{
			long question_id=0;
			long question=0;
			long question_marks=0;
			long question_text=0;
			String question_status=null;
			String tmp=request.getParameter("tem");
			boolean b1=subjectDetailsDao.deleteAllFromCustomize();

			List<Long> ilist=new ArrayList<Long>();
			List<CustomizePojo> queList=new ArrayList<CustomizePojo>();
			try
			{
			question=Long.parseLong(request.getParameter("id_name"));
			if(question>0){
				question_text=1;
				System.out.println("question number for first"+question);
				for(int i=1;i<=question;i++){
					question_marks=Long.parseLong(request.getParameter("marks_text"+i));
					System.out.println(question_marks);
					question_status=request.getParameter("question_status"+i);
					System.out.println(question_status);
					if(request.getParameter("question_status1"+i) !=null){
						question_status="alternate";
					}
					CustomizePojo customizePojo=new CustomizePojo();
					customizePojo.setQuestion_id(question_text);
					customizePojo.setQuestion_mark(question_marks);
					customizePojo.setQuestion_status(question_status);
					queList.add(customizePojo);
				}
			}
			
			question=Long.parseLong(request.getParameter("id_name1"));
		
			System.out.println("alter questn"+question);
			 if(question>0){
				for(int i=1;i<=question;i++){
					question_marks=Long.parseLong(request.getParameter("marks_text1"+i));
					System.out.println("alternate"+question_marks);
					question_status=request.getParameter("question_status1"+i);
					System.out.println(question_status);
					CustomizePojo customizePojo=new CustomizePojo();
					customizePojo.setQuestion_id(question_text);
					customizePojo.setQuestion_mark(question_marks);
					customizePojo.setQuestion_status("NULL");
					queList.add(customizePojo);
				}
				//System.out.println("size list"+ilist.size());
			}
			
			
			
			question=Long.parseLong(request.getParameter("id_name2"));
			System.out.println("ques for 2nd qu"+question);
             if(question>0){
            	 question_text=2;
				for(int i=1;i<=question;i++){
					question_marks=Long.parseLong(request.getParameter("marks_text2"+i));
					System.out.println(question_marks);
					question_status=request.getParameter("question_status2"+i);
					System.out.println(question_status);
					if(request.getParameter("question_status_2"+i) !=null){
						question_status="alternate";
					}
					CustomizePojo customizePojo=new CustomizePojo();
					customizePojo.setQuestion_id(question_text);
					customizePojo.setQuestion_mark(question_marks);
					customizePojo.setQuestion_status(question_status);
					queList.add(customizePojo);
				}
				//System.out.println("size list"+ilist.size());
			}
			
			question=Long.parseLong(request.getParameter("id_name_2"));
			if(question>0){
				for(int i=1;i<=question;i++){
					question_marks=Long.parseLong(request.getParameter("marks_text_2"+i));
					System.out.println("alternate second::"+question_marks);
					question_status=request.getParameter("question_status_2"+i);
					System.out.println(question_status);
					CustomizePojo customizePojo=new CustomizePojo();
					customizePojo.setQuestion_id(question_text);
					customizePojo.setQuestion_mark(question_marks);
					customizePojo.setQuestion_status("NULL");
					queList.add(customizePojo);
				}
				//System.out.println("size list"+ilist.size());
			}
			
			question=Long.parseLong(request.getParameter("id_name3"));
			if(question>0){
				question_text=3;
				for(int i=1;i<=question;i++){
					question_marks=Long.parseLong(request.getParameter("marks_text3"+i));
					System.out.println(question_marks);
					question_status=request.getParameter("question_status3"+i);
					System.out.println(question_status);
					if(request.getParameter("question_status_3"+i) !=null){
						question_status="alternate";
					}
					CustomizePojo customizePojo=new CustomizePojo();
					customizePojo.setQuestion_id(question_text);
					customizePojo.setQuestion_mark(question_marks);
					customizePojo.setQuestion_status(question_status);
					queList.add(customizePojo);
				}
				//System.out.println("size list"+ilist.size());
			}
			
			
			question=Long.parseLong(request.getParameter("id_name_3"));
			if(question>0){
				for(int i=1;i<=question;i++){
					question_marks=Long.parseLong(request.getParameter("marks_text_3"+i));
					System.out.println("alternate three::"+question_marks);
					question_status=request.getParameter("question_status_3"+i);
					System.out.println(question_status);
					CustomizePojo customizePojo=new CustomizePojo();
					customizePojo.setQuestion_id(question_text);
					customizePojo.setQuestion_mark(question_marks);
					customizePojo.setQuestion_status("NULL");
					queList.add(customizePojo);
					//ilist.add(question_marks);
				}
				//System.out.println("size list"+ilist.size());
			}
			
			question=Long.parseLong(request.getParameter("id_name4"));
			if(question>0){
				question_text=4;
				for(int i=1;i<=question;i++){
					question_marks=Long.parseLong(request.getParameter("marks_text4"+i));
					System.out.println(question_marks);
					question_status=request.getParameter("question_status4"+i);
					System.out.println(question_status);
					if(request.getParameter("question_status_4"+i) !=null){
						question_status="alternate";
					}
					CustomizePojo customizePojo=new CustomizePojo();
					customizePojo.setQuestion_id(question_text);
					customizePojo.setQuestion_mark(question_marks);
					customizePojo.setQuestion_status(question_status);
					queList.add(customizePojo);
				}
				//System.out.println("size list"+ilist.size());
			}
			
			
			question=Long.parseLong(request.getParameter("id_name_4"));
			if(question>0){
				question_text=4;
				for(int i=1;i<=question;i++){
					question_marks=Long.parseLong(request.getParameter("marks_text_4"+i));
					System.out.println("alternate four::"+question_marks);
					question_status=request.getParameter("question_status_4"+i);
					System.out.println(question_status);
					CustomizePojo customizePojo=new CustomizePojo();
					customizePojo.setQuestion_id(question_text);
					customizePojo.setQuestion_mark(question_marks);
					customizePojo.setQuestion_status("NULL");
					queList.add(customizePojo);
				}
				System.out.println("size list"+ilist.size());
			}
			
			question=Long.parseLong(request.getParameter("id_name5"));
			if(question>0){
				question_text=5;
				for(int i=1;i<=question;i++){
					question_marks=Long.parseLong(request.getParameter("marks_text5"+i));
					System.out.println(question_marks);
					question_status=request.getParameter("question_status5"+i);
					System.out.println(question_status);
					if(request.getParameter("question_status_5"+i) !=null){
						question_status="alternate";
					}
					CustomizePojo customizePojo=new CustomizePojo();
					customizePojo.setQuestion_id(question_text);
					customizePojo.setQuestion_mark(question_marks);
					customizePojo.setQuestion_status(question_status);
					queList.add(customizePojo);
				}
				//System.out.println("size list"+ilist.size());
			}
			
			question=Long.parseLong(request.getParameter("id_name_5"));
			if(question>0){
				for(int i=1;i<=question;i++){
					question_marks=Long.parseLong(request.getParameter("marks_text_5"+i));
					System.out.println("alternate five::"+question_marks);
					question_status=request.getParameter("question_status_5"+i);
					System.out.println(question_status);
					CustomizePojo customizePojo=new CustomizePojo();
					customizePojo.setQuestion_id(question_text);
					customizePojo.setQuestion_mark(question_marks);
					customizePojo.setQuestion_status("NULL");
					queList.add(customizePojo);
				}
				
			}
			boolean b=true;
			String set_status=null;
			
			for(int i=1;i<4;i++){
				set_status="set"+i;
			 b=subjectDetailsDao.saveCustoizeQuestion(queList,set_status);
			}
			System.out.println("size list"+queList.size());
			if(b){
				if(tmp.equals("Custom30tem"))
				{
					session.setAttribute("queList",queList );
					response.sendRedirect("GenerateQuestionServlet?action=branchListForPaper&template=Custom30tem&marks=custom30");
				}
				else if(tmp.equals("Custom80tem"))
				{
					session.setAttribute("queList",queList );
					response.sendRedirect("GenerateQuestionServlet?action=branchListForPaper&template=Custom80tem&marks=custom80");
				}
				
			}
			
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
	}
	
	
	
	private String getFileName(Part part) {
	   	
	   	System.out.println("headers name "+part);
	       String contentDisp = part.getHeader("content-disposition");
	       System.out.println("content-disposition header= "+contentDisp);
	       String[] tokens = contentDisp.split(";");
	       for (String token : tokens) {
	           if (token.trim().startsWith("filename")) {
	               return token.substring(token.indexOf("=") + 2, token.length()-1);
	           }
	       }
	       return "";
	   }
}
