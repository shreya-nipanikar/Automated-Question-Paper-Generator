package com.fuzzyAQP.servlet;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.fuzzyAQP.dao.CounsilDetailsDao;
import com.fuzzyAQP.dao.CounsilDetailsDaoImpl;
import com.fuzzyAQP.dao.SubjectDetailsDao;
import com.fuzzyAQP.dao.SubjectDetailsDaoImpl;
import com.fuzzyAQP.dao.TeacherDetailsDao;
import com.fuzzyAQP.dao.TeacherDetailsDaoImpl;
import com.fuzzyAQP.pojo.CounsilDetailsPojo;
import com.fuzzyAQP.pojo.CustomizePojo;
import com.fuzzyAQP.pojo.PaperSetDetailsPojo;
import com.fuzzyAQP.pojo.PaperSetEncryptPojo;
import com.fuzzyAQP.pojo.QuestionDetailsPojo;
import com.fuzzyAQP.pojo.SubjectDetailsPojo;
import com.fuzzyAQP.pojo.TeacherDetailsPojo;
import com.fuzzyAQP.utility.AESencryptDecrypt;
import com.fuzzyAQP.utility.Constant;
import com.fuzzyAQP.utility.EmailUtility;
import com.google.gson.Gson;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * Servlet implementation class GenerateQuestionPaper
 */
@MultipartConfig
public class GeneratePDFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeneratePDFServlet() {
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
		CounsilDetailsDao counsilDetailsDao=new CounsilDetailsDaoImpl();
		  
		
	
		if(action!=null && action.equals("template1for30"))
		{
			long teacher_id=(long) session.getAttribute("teacher_id");
			String date=(String) session.getAttribute("date");
			String subject=(String) session.getAttribute("subject");
			double time=time=(double) session.getAttribute("time");
			String set=request.getParameter("set");
			System.out.println("set"+set);
			String markingScheme=request.getParameter("scheme");
			System.out.println("markingScheme"+markingScheme);
			List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("temSet1");
			List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("temSet2");
			List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("temSet3");
			String sub=(String) session.getAttribute("subject");
			String sem=(String) session.getAttribute("sem");
			System.out.println("size pdf"+set1.size());
			 //Iterator<QuestionDetailsPojo> itr = set1.iterator();
			
			try {
	        	 OutputStream file = new FileOutputStream(new File("D://fuzzyQuestionPaper//template1for30marks"+sub+""+set+".pdf"));
				 String SRC="D://fuzzyQuestionPaper//template1for30marks"+sub+""+set+".pdf";
	        	 Document document1 = new Document();
					PdfWriter writer1 = PdfWriter.getInstance(document1, file);

					StringBuilder htmlString = new StringBuilder();
					
					htmlString.append(new String("<table border='0' align='center' width='100%'> "));
					
					 
					htmlString.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
					htmlString.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
					htmlString.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
     				htmlString.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
						 
				
					htmlString.append(new String("</table>"));
					
					
				//	htmlString.append(new String("<html><body> <table  align='center' width='100%'> "));
					htmlString.append(new String("<html><body> "));
					
					htmlString.append(new String("<table border='0' align='center' width='100%'> "));
					char ch='a';
					int count=1;
					/* while (itr.hasNext()) {*/
					 if(set.equals("Set1"))
					 {
						 if(set.equals("Set1"))
						 {
					for(int i=0;i<set1.size();i++){
						
					htmlString.append(new String("<tr><td style='padding: 10px'>Q "+count+". "+ch+")"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>[6]</td></tr>"));
					if(set1.get(i).getImg() !=null)
					{
						String img_name=set1.get(i).getImg();
						System.out.println("in pdf"+img_name);
						htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
					}
					
					if(i==1 || i==5)
					{
						count++;
					}
					if(i==0 || i==3 || i==7)
					{
						htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
					}
					if(i==2 || i==4 || i==6 || i==8)
					{
						ch++;
					}
					if(i==3 || i==5 || i==7)
					{
						ch='a';
					}
					}
					 }
					 if(markingScheme.equals("markSet1")){
					 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template1for30marksMarkingScheme"+sub+""+set+".pdf"));
					 String SRC2="D://fuzzyQuestionPaper//template1for30marksMarkingScheme"+sub+""+set+".pdf";
		        	 Document document2 = new Document();
						PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
						StringBuilder htmlString1 = new StringBuilder();
						htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
						
						 
						htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
						htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
						htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
	     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
					
						htmlString1.append(new String("</table>"));
						htmlString1.append(new String("<html><body> "));
						
						htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
						htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
						 count=1;
						for(int i=0;i<set1.size();i++){
							
							htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getText_type()+"</td></tr>"));
	                         count++;
							}
						htmlString1.append(new String("</table>"));
						htmlString1.append(new String("</body></html>"));
		

						document2.open();
						InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
						XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
						document2.close();
						file2.close();
						
						String name=null;
						session.setAttribute("SRC", SRC2);
					 	File file1 = new File(SRC2);
				        file1.getParentFile().mkdirs();
				        try {
				        	AESencryptDecrypt aes=new AESencryptDecrypt();
				        	name=aes.encrypt(file1);
				        	file1.delete();
						} catch (DocumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				        
				        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
				        pe.setDate(date);
				        pe.setSet_name(name);
				        pe.setSubject(subject);
				        pe.setTeacher_id(teacher_id);
				        pe.setTime(time);
				        
				        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
				        
				        if(x1)
				        {
				        	System.out.println(".................................");
				        }
					 }
					
			       }
					 else if(set.equals("Set2"))
					 {
						 if(set.equals("Set2")){
					for(int i=0;i<set2.size();i++){
						
					htmlString.append(new String("<tr><td style='padding: 10px'>Q "+count+". "+ch+")"+set2.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>[6]</td></tr>"));
					if(set2.get(i).getImg() !=null)
					{
						String img_name=set2.get(i).getImg();
						System.out.println("in pdf"+img_name);
						htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
					}
					
					if(i==1 || i==5)
					{
						count++;
					}
					if(i==0 || i==3 || i==7)
					{
						htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
					}
					if(i==2 || i==4 || i==6 || i==8)
					{
						ch++;
					}
					if(i==3 || i==5 || i==7)
					{
						ch='a';
					}
					}
					}
						 if(markingScheme.equals("markSet2")){
							 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template1for30marksMarkingScheme"+sub+""+set+".pdf"));
							 String SRC2="D://fuzzyQuestionPaper//template1for30marksMarkingScheme"+sub+""+set+".pdf";
				        	 Document document2 = new Document();
								PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
								StringBuilder htmlString1 = new StringBuilder();
								htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
								
								 
								htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
			     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
							
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("<html><body> "));
								
								htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
								htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
								 count=1;
								for(int i=0;i<set2.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set2.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set2.get(i).getText_type()+"</td></tr>"));
			                         count++;
									}
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("</body></html>"));
				

								document2.open();
								InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
								XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
								document2.close();
								file2.close();
								
								String name=null;
								session.setAttribute("SRC", SRC2);
							 	File file1 = new File(SRC2);
						        file1.getParentFile().mkdirs();
						        try {
						        	AESencryptDecrypt aes=new AESencryptDecrypt();
						        	name=aes.encrypt(file1);
						        	file1.delete();
								} catch (DocumentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        
						        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
						        pe.setDate(date);
						        pe.setSet_name(name);
						        pe.setSubject(subject);
						        pe.setTeacher_id(teacher_id);
						        pe.setTime(time);
						        
						        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
						        
						        if(x1)
						        {
						        	System.out.println(".................................");
						        }
							 }
							

						 
			       }
					 else if(set.equals("Set3"))
					 {
						 if(set.equals("Set3"))
						 {
					for(int i=0;i<set3.size();i++){
						
					htmlString.append(new String("<tr><td style='padding: 10px'>Q "+count+". "+ch+")"+set3.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>[6]</td></tr>"));
					if(set3.get(i).getImg() !=null)
					{
						String img_name=set3.get(i).getImg();
						System.out.println("in pdf"+img_name);
						htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
					}
					
					if(i==1 || i==5)
					{
						count++;
					}
					if(i==0 || i==3 || i==7)
					{
						htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
					}
					if(i==2 || i==4 || i==6 || i==8)
					{
						ch++;
					}
					if(i==3 || i==5 || i==7)
					{
						ch='a';
					}
					
					}
			       }
						 if(markingScheme.equals("markSet3")){
							 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template1for30marksMarkingScheme"+sub+""+set+".pdf"));
							 String SRC2="D://fuzzyQuestionPaper//template1for30marksMarkingScheme"+sub+""+set+".pdf";
				        	 Document document2 = new Document();
								PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
								StringBuilder htmlString1 = new StringBuilder();
								htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
								
								 
								htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
			     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
							
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("<html><body> "));
								
								htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
								htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
								 count=1;
								for(int i=0;i<set3.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set3.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set3.get(i).getText_type()+"</td></tr>"));
			                         count++;
									}
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("</body></html>"));
				

								document2.open();
								InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
								XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
								document2.close();
								file2.close();
								
								String name=null;
								session.setAttribute("SRC", SRC2);
							 	File file1 = new File(SRC2);
						        file1.getParentFile().mkdirs();
						        try {
						        	AESencryptDecrypt aes=new AESencryptDecrypt();
						        	name=aes.encrypt(file1);
						        	file1.delete();
								} catch (DocumentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        
						        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
						        pe.setDate(date);
						        pe.setSet_name(name);
						        pe.setSubject(subject);
						        pe.setTeacher_id(teacher_id);
						        pe.setTime(time);
						        
						        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
						        
						        if(x1)
						        {
						        	System.out.println(".................................");
						        }
							 }
							
					 }
					htmlString.append(new String("</table>"));
					htmlString.append(new String("</body></html>"));
	

					document1.open();
					InputStream is = new ByteArrayInputStream(htmlString.toString().getBytes());
					XMLWorkerHelper.getInstance().parseXHtml(writer1, document1, is);
					document1.close();
					file.close();
					
					String name=null;
					session.setAttribute("SRC", SRC);
				 	File file1 = new File(SRC);
			        file1.getParentFile().mkdirs();
			        try {
			        	AESencryptDecrypt aes=new AESencryptDecrypt();
			        	name=aes.encrypt(file1);
			        	file1.delete();
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
			        pe.setDate(date);
			        pe.setSet_name(name);
			        pe.setSubject(subject);
			        pe.setTeacher_id(teacher_id);
			        pe.setTime(time);
			        
			        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
			        
			        if(x1)
			        {
			        	System.out.println(".................................");
			        }
						
	        	} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
			
			
			
			
			
	        	
	        	response.sendRedirect("SubjectServlet?action=template1dataSet1");
		}
		
		
		else if(action!=null && action.equals("template2for30"))
		{
			long teacher_id=(long) session.getAttribute("teacher_id");
			String date=(String) session.getAttribute("date");
			String subject=(String) session.getAttribute("subject");
			double time=time=(double) session.getAttribute("time");
			String set=request.getParameter("set");
			System.out.println("set"+set);
			String markingScheme=request.getParameter("scheme");
			String sub=(String) session.getAttribute("subject");
			String sem=(String) session.getAttribute("sem");
			//System.out.println("size pdf"+set1.size());
			 //Iterator<QuestionDetailsPojo> itr = set1.iterator();
			
			try {
	        	 OutputStream file = new FileOutputStream(new File("D://fuzzyQuestionPaper//template2for30marks"+sub+""+set+".pdf"));
	        	 String SRC="D://fuzzyQuestionPaper//template2for30marks"+sub+""+set+".pdf";	
	        	 Document document1 = new Document();
					PdfWriter writer1 = PdfWriter.getInstance(document1, file);
					StringBuilder htmlString = new StringBuilder();
					 int marks=0;
					htmlString.append(new String("<table border='0' align='center' width='100%'> "));
					
					 
					htmlString.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
					htmlString.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
					htmlString.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
     				htmlString.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
						 
				
					htmlString.append(new String("</table>"));
					
					
				//	htmlString.append(new String("<html><body> <table  align='center' width='100%'> "));
					htmlString.append(new String("<html><body> "));
					
					htmlString.append(new String("<table border='0' align='center' width='100%'> "));
					char ch='a';
					int count=1;
					/* while (itr.hasNext()) {*/
					if(set.equals("Set1"))
					{
						List<QuestionDetailsPojo> List1=(List<QuestionDetailsPojo>) session.getAttribute("allqus");
					     List<QuestionDetailsPojo> List2=(List<QuestionDetailsPojo>) session.getAttribute("allqus1");
						 List<QuestionDetailsPojo> List3=(List<QuestionDetailsPojo>) session.getAttribute("allqus2");
						if(set.equals("Set1"))
						 {
						 
						
					for(int i=0;i<List1.size();i++){
						marks=(int) List1.get(i).getMarks();
					htmlString.append(new String("<tr><td style='padding: 10px'>Q 1.a )"+List1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
					if(List1.get(i).getImg() !=null)
					{
						String img_name=List1.get(i).getImg();
						System.out.println("in pdf"+img_name);
						htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
					}
					
					if(i==0 )
					{
						htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
					}
					
					}
					for(int i=0;i<List2.size();i++){
						marks=(int) List2.get(i).getMarks();
					htmlString.append(new String("<tr><td style='padding: 10px'>Q 2.a )"+List2.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
					if(List2.get(i).getImg() !=null)
					{
						String img_name=List2.get(i).getImg();
						System.out.println("in pdf"+img_name);
						htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
					}
					if(i==0)
					{
						htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
					}
					
					}
					for(int i=0;i<List3.size();i++){
						marks=(int) List3.get(i).getMarks();
					htmlString.append(new String("<tr><td style='padding: 10px'>Q 3.a )"+List3.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>[0"+marks+"]</td></tr>"));
					if(List3.get(i).getImg() !=null)
					{
						String img_name=List3.get(i).getImg();
						System.out.println("in pdf"+img_name);
						htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
					}
					if(i==0)
					{
						htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
					}
					}
					
			       }
						 if(markingScheme.equals("markSet1")){
							 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template2for30marksMarkingScheme"+sub+""+set+".pdf"));
							 String SRC2="D://fuzzyQuestionPaper//template2for30marksMarkingScheme"+sub+""+set+".pdf";
				        	 Document document2 = new Document();
								PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
								StringBuilder htmlString1 = new StringBuilder();
								htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
								
								 
								htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
			     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
							
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("<html><body> "));
								
								htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
								htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
								 count=1;
								for(int i=0;i<List1.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+List1.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+List1.get(i).getText_type()+"</td></tr>"));
			                         count++;
									}
								for(int i=0;i<List2.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+List2.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+List2.get(i).getText_type()+"</td></tr>"));
			                         count++;
									}
								for(int i=0;i<List3.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+List3.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+List3.get(i).getText_type()+"</td></tr>"));
			                         count++;
									}
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("</body></html>"));
				

								document2.open();
								InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
								XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
								document2.close();
								file2.close();
								
								String name=null;
								session.setAttribute("SRC", SRC2);
							 	File file1 = new File(SRC2);
						        file1.getParentFile().mkdirs();
						        try {
						        	AESencryptDecrypt aes=new AESencryptDecrypt();
						        	name=aes.encrypt(file1);
						        	file1.delete();
								} catch (DocumentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        
						        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
						        pe.setDate(date);
						        pe.setSet_name(name);
						        pe.setSubject(subject);
						        pe.setTeacher_id(teacher_id);
						        pe.setTime(time);
						        
						        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
						        
						        if(x1)
						        {
						        	System.out.println(".................................");
						        }
							 }
							
					}
					 else if(set.equals("Set2"))
					 {
						 
						 List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("allqusSet2");
						 List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("allqus1Set2");
						 List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("allqus2Set2");
						 if(set.equals("Set2"))
						 {
						 for(int i=0;i<set1.size();i++){
						marks=(int) set1.get(i).getMarks();
					htmlString.append(new String("<tr><td style='padding: 10px'>Q 1.a )"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
					if(set1.get(i).getImg() !=null)
					{
						String img_name=set1.get(i).getImg();
						System.out.println("in pdf"+img_name);
						htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
					}
					if(i==0)
					{
						htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
					}
					}
					for(int i=0;i<set2.size();i++){
						marks=(int) set2.get(i).getMarks();
						htmlString.append(new String("<tr><td style='padding: 10px'>Q 2.a )"+set2.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
						if(set2.get(i).getImg() !=null)
						{
							String img_name=set2.get(i).getImg();
							System.out.println("in pdf"+img_name);
							htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
						}
						if(i==0)
						{
							htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
						}
					}
					for(int i=0;i<set3.size();i++){
						marks=(int) set3.get(i).getMarks();
						htmlString.append(new String("<tr><td style='padding: 10px'>Q 3.a )"+set3.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>[0"+marks+"]</td></tr>"));
						if(set3.get(i).getImg() !=null)
						{
							String img_name=set3.get(i).getImg();
							System.out.println("in pdf"+img_name);
							htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
						}
						if(i==0)
						{
							htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
						}	
					}
			       }
						 if(markingScheme.equals("markSet2")){
							 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template2for30marksMarkingScheme"+sub+""+set+".pdf"));
							 String SRC2="D://fuzzyQuestionPaper//template2for30marksMarkingScheme"+sub+""+set+".pdf";
				        	 Document document2 = new Document();
								PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
								StringBuilder htmlString1 = new StringBuilder();
								htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
								
								 
								htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
			     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
							
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("<html><body> "));
								
								htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
								htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
								 count=1;
								for(int i=0;i<set1.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getText_type()+"</td></tr>"));
			                         count++;
									}
								for(int i=0;i<set2.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set2.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set2.get(i).getText_type()+"</td></tr>"));
			                         count++;
									}
								for(int i=0;i<set3.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set3.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set3.get(i).getText_type()+"</td></tr>"));
								     count++;
									}
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("</body></html>"));
				

								document2.open();
								InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
								XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
								document2.close();
								file2.close();
								
								String name=null;
								session.setAttribute("SRC", SRC2);
							 	File file1 = new File(SRC2);
						        file1.getParentFile().mkdirs();
						        try {
						        	AESencryptDecrypt aes=new AESencryptDecrypt();
						        	name=aes.encrypt(file1);
						        	file1.delete();
								} catch (DocumentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        
						        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
						        pe.setDate(date);
						        pe.setSet_name(name);
						        pe.setSubject(subject);
						        pe.setTeacher_id(teacher_id);
						        pe.setTime(time);
						        
						        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
						        
						        if(x1)
						        {
						        	System.out.println(".................................");
						        }
							 }
					 }
					 else if(set.equals("Set3"))
					 {
						
						 List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("allqusSet3");
						 List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("allqus1Set3");
						 List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("allqus2Set3");
						 if(set.equals("Set3"))
						 {
						 for(int i=0;i<set1.size();i++){
						marks=(int) set1.get(i).getMarks();
						htmlString.append(new String("<tr><td style='padding: 10px'>Q 1.a )"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
						if(set1.get(i).getImg() !=null)
						{
							String img_name=set1.get(i).getImg();
							System.out.println("in pdf"+img_name);
							htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
						}
						if(i==0)
						{
							htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
						}
						}
						for(int i=0;i<set2.size();i++){
						marks=(int) set2.get(i).getMarks();
						htmlString.append(new String("<tr><td style='padding: 10px'>Q 2.a )"+set2.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
						if(set2.get(i).getImg() !=null)
						{
							String img_name=set2.get(i).getImg();
							System.out.println("in pdf"+img_name);
							htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
						}
						
						if(i==0)
						{
							htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
						}	
					}
					for(int i=0;i<set3.size();i++){
						marks=(int) set3.get(i).getMarks();
						htmlString.append(new String("<tr><td style='padding: 10px'>Q 3.a )"+set3.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>[0"+marks+"]</td></tr>"));
						if(set3.get(i).getImg() !=null)
						{
							String img_name=set3.get(i).getImg();
							System.out.println("in pdf"+img_name);
							htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
						}
						if(i==0)
						{
							htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
						}	
					}
			       }
						 if(markingScheme.equals("markSet3")){
							 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template2for30marksMarkingScheme"+sub+""+set+".pdf"));
							 String SRC2="D://fuzzyQuestionPaper//template2for30marksMarkingScheme"+sub+""+set+".pdf";
				        	 Document document2 = new Document();
								PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
								StringBuilder htmlString1 = new StringBuilder();
								htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
								
								 
								htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
			     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
							
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("<html><body> "));
								
								htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
								htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
								 count=1;
								for(int i=0;i<set1.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getText_type()+"</td></tr>"));
			                         count++;
									}
								for(int i=0;i<set2.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set2.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set2.get(i).getText_type()+"</td></tr>"));
			                         count++;
									}
								for(int i=0;i<set3.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set3.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set3.get(i).getText_type()+"</td></tr>"));
								     count++;
									}
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("</body></html>"));
				

								document2.open();
								InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
								XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
								document2.close();
								file2.close();
								
								String name=null;
								session.setAttribute("SRC", SRC2);
							 	File file1 = new File(SRC2);
						        file1.getParentFile().mkdirs();
						        try {
						        	AESencryptDecrypt aes=new AESencryptDecrypt();
						        	name=aes.encrypt(file1);
						        	file1.delete();
								} catch (DocumentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        
						        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
						        pe.setDate(date);
						        pe.setSet_name(name);
						        pe.setSubject(subject);
						        pe.setTeacher_id(teacher_id);
						        pe.setTime(time);
						        
						        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
						        
						        if(x1)
						        {
						        	System.out.println(".................................");
						        }
							 }
					 }
					htmlString.append(new String("</table>"));
					htmlString.append(new String("</body></html>"));
					document1.open();
				
					document1.open();
					InputStream is = new ByteArrayInputStream(htmlString.toString().getBytes());
					XMLWorkerHelper.getInstance().parseXHtml(writer1, document1, is);
					document1.close();
					file.close();
					
					String name=null;
					session.setAttribute("SRC", SRC);
				 	File file1 = new File(SRC);
			        file1.getParentFile().mkdirs();
			        try {
			        	AESencryptDecrypt aes=new AESencryptDecrypt();
			        	name=aes.encrypt(file1);
			        	file1.delete();
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
			        pe.setDate(date);
			        pe.setSet_name(name);
			        pe.setSubject(subject);
			        pe.setTeacher_id(teacher_id);
			        pe.setTime(time);
			        
			        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
			        
			        if(x1)
			        {
			        	System.out.println(".................................");
			        }
						
	        	} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
	        	
	        	response.sendRedirect("SubjectServlet?action=template2dataSet1");
		}
		
		else if(action!=null && action.equals("template3for30"))
		{
			long teacher_id=(long) session.getAttribute("teacher_id");
			String date=(String) session.getAttribute("date");
			String subject=(String) session.getAttribute("subject");
			double time=time=(double) session.getAttribute("time");
			String set=request.getParameter("set");
			System.out.println("set"+set);
			String markingScheme=request.getParameter("scheme");
			String sub=(String) session.getAttribute("subject");
			String sem=(String) session.getAttribute("sem");
			//System.out.println("size pdf"+set1.size());
			 //Iterator<QuestionDetailsPojo> itr = set1.iterator();
			
			try {
	        	 OutputStream file = new FileOutputStream(new File("D://fuzzyQuestionPaper//template3for30marks"+sub+""+set+".pdf"));
	        	 String SRC="D://fuzzyQuestionPaper//template3for30marks"+sub+""+set+".pdf";	
	        	 Document document1 = new Document();
					PdfWriter writer1 = PdfWriter.getInstance(document1, file);
					StringBuilder htmlString = new StringBuilder();
					 int marks=0;
					htmlString.append(new String("<table border='0' align='center' width='100%'> "));
					
					 
					htmlString.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
					htmlString.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
					htmlString.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
     				htmlString.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
						 
				
					htmlString.append(new String("</table>"));
					
					
				//	htmlString.append(new String("<html><body> <table  align='center' width='100%'> "));
					htmlString.append(new String("<html><body> "));
					
					htmlString.append(new String("<table border='0' align='center' width='100%'> "));
					int count=1;
					/* while (itr.hasNext()) {*/
					if(set.equals("Set1"))
					{
						List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("allQuest");
						if(set.equals("Set1"))
						 {
					for(int i=0;i<set1.size();i++){
						marks=(int) set1.get(i).getMarks();
					htmlString.append(new String("<tr><td style='padding: 10px'>Q "+count+".a )"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
					if(set1.get(i).getImg() !=null)
					{
						String img_name=set1.get(i).getImg();
						System.out.println("in pdf"+img_name);
						htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
					}
					if(i==0 || i==2 || i==4)
					{
						htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
					}
					if(i==1 || i==3){
						count++;
					}
					}
			       }
						 if(markingScheme.equals("markSet1")){
							 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template3for30marksMarkingScheme"+sub+""+set+".pdf"));
							 String SRC2="D://fuzzyQuestionPaper//template3for30marksMarkingScheme"+sub+""+set+".pdf";
				        	 Document document2 = new Document();
								PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
								StringBuilder htmlString1 = new StringBuilder();
								htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
								
								 
								htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
			     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
							
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("<html><body> "));
								
								htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
								htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
								 count=1;
								for(int i=0;i<set1.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getText_type()+"</td></tr>"));
			                         count++;
									}
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("</body></html>"));
				

								document2.open();
								InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
								XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
								document2.close();
								file2.close();
								
								String name=null;
								session.setAttribute("SRC", SRC2);
							 	File file1 = new File(SRC2);
						        file1.getParentFile().mkdirs();
						        try {
						        	AESencryptDecrypt aes=new AESencryptDecrypt();
						        	name=aes.encrypt(file1);
						        	file1.delete();
								} catch (DocumentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        
						        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
						        pe.setDate(date);
						        pe.setSet_name(name);
						        pe.setSubject(subject);
						        pe.setTeacher_id(teacher_id);
						        pe.setTime(time);
						        
						        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
						        
						        if(x1)
						        {
						        	System.out.println(".................................");
						        }
							 }
							

					}
					 else if(set.equals("Set2"))
					 {
					List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("allQuestSet2");
					if(set.equals("Set2"))
					 {	
					for(int i=0;i<set2.size();i++){
						marks=(int) set2.get(i).getMarks();
					htmlString.append(new String("<tr><td style='padding: 10px'>Q "+count+".a )"+set2.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
					if(set2.get(i).getImg() !=null)
					{
						String img_name=set2.get(i).getImg();
						System.out.println("in pdf"+img_name);
						htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
					}
					
					if(i==0 || i==2 || i==4)
					{
						htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
					}
					if(i==1 || i==3){
						count++;
					}
					}
			       }
					if(markingScheme.equals("markSet2")){
						 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template3for30marksMarkingScheme"+sub+""+set+".pdf"));
						 String SRC2="D://fuzzyQuestionPaper//template3for30marksMarkingScheme"+sub+""+set+".pdf";
			        	 Document document2 = new Document();
							PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
							StringBuilder htmlString1 = new StringBuilder();
							htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
							
							 
							htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
							htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
							htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
		     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
						
							htmlString1.append(new String("</table>"));
							htmlString1.append(new String("<html><body> "));
							
							htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
							htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
							 count=1;
							for(int i=0;i<set2.size();i++){
								
								htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set2.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set2.get(i).getText_type()+"</td></tr>"));
		                         count++;
								}
							htmlString1.append(new String("</table>"));
							htmlString1.append(new String("</body></html>"));
			

							document2.open();
							InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
							XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
							document2.close();
							file2.close();
							
							String name=null;
							session.setAttribute("SRC", SRC2);
						 	File file1 = new File(SRC2);
					        file1.getParentFile().mkdirs();
					        try {
					        	AESencryptDecrypt aes=new AESencryptDecrypt();
					        	name=aes.encrypt(file1);
					        	file1.delete();
							} catch (DocumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					        
					        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
					        pe.setDate(date);
					        pe.setSet_name(name);
					        pe.setSubject(subject);
					        pe.setTeacher_id(teacher_id);
					        pe.setTime(time);
					        
					        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
					        
					        if(x1)
					        {
					        	System.out.println(".................................");
					        }
						 }
						

					 }
					 else if(set.equals("Set3"))
					 {
						 
					List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("allQuestSet3");
					if(set.equals("Set3"))
					 {
					for(int i=0;i<set3.size();i++){
					marks=(int) set3.get(i).getMarks();	
					htmlString.append(new String("<tr><td style='padding: 10px'>Q "+count+".a )"+set3.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
					if(set3.get(i).getImg() !=null)
					{
						String img_name=set3.get(i).getImg();
						System.out.println("in pdf"+img_name);
						htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
					}
					if(i==0 || i==2 || i==4)
					{
						htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
					}
					if(i==1 || i==3){
						count++;
					}
					}
			       }
					
					if(markingScheme.equals("markSet3")){
						 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template3for30marksMarkingScheme"+sub+""+set+".pdf"));
						 String SRC2="D://fuzzyQuestionPaper//template3for30marksMarkingScheme"+sub+""+set+".pdf";
			        	 Document document2 = new Document();
							PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
							StringBuilder htmlString1 = new StringBuilder();
							htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
							
							 
							htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
							htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
							htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
		     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
						
							htmlString1.append(new String("</table>"));
							htmlString1.append(new String("<html><body> "));
							
							htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
							htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
							 count=1;
							for(int i=0;i<set3.size();i++){
								
								htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set3.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set3.get(i).getText_type()+"</td></tr>"));
		                         count++;
								}
							htmlString1.append(new String("</table>"));
							htmlString1.append(new String("</body></html>"));
			

							document2.open();
							InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
							XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
							document2.close();
							file2.close();
							
							String name=null;
							session.setAttribute("SRC", SRC2);
						 	File file1 = new File(SRC2);
					        file1.getParentFile().mkdirs();
					        try {
					        	AESencryptDecrypt aes=new AESencryptDecrypt();
					        	name=aes.encrypt(file1);
					        	file1.delete();
							} catch (DocumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					        
					        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
					        pe.setDate(date);
					        pe.setSet_name(name);
					        pe.setSubject(subject);
					        pe.setTeacher_id(teacher_id);
					        pe.setTime(time);
					        
					        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
					        
					        if(x1)
					        {
					        	System.out.println(".................................");
					        }
						 }
						

					 }
					htmlString.append(new String("</table>"));
					htmlString.append(new String("</body></html>"));
					
					document1.open();
					document1.open();
					InputStream is = new ByteArrayInputStream(htmlString.toString().getBytes());
					XMLWorkerHelper.getInstance().parseXHtml(writer1, document1, is);
					document1.close();
					file.close();
					
					String name=null;
					session.setAttribute("SRC", SRC);
				 	File file1 = new File(SRC);
			        file1.getParentFile().mkdirs();
			        try {
			        	AESencryptDecrypt aes=new AESencryptDecrypt();
			        	name=aes.encrypt(file1);
			        	file1.delete();
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
			        pe.setDate(date);
			        pe.setSet_name(name);
			        pe.setSubject(subject);
			        pe.setTeacher_id(teacher_id);
			        pe.setTime(time);
			        
			        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
			        
			        if(x1)
			        {
			        	System.out.println(".................................");
			        }
	        	} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
	        	
	        	response.sendRedirect("SubjectServlet?action=template3dataSet1");
		}
		else if(action!=null && action.equals("template4for30"))
		{
			long teacher_id=(long) session.getAttribute("teacher_id");
			String date=(String) session.getAttribute("date");
			String subject=(String) session.getAttribute("subject");
			double time=time=(double) session.getAttribute("time");
			String set=request.getParameter("set");
			System.out.println("set"+set);
			String markingScheme=request.getParameter("scheme");

			String sub=(String) session.getAttribute("subject");
			String sem=(String) session.getAttribute("sem");
			
			try {
	        	 OutputStream file = new FileOutputStream(new File("D://fuzzyQuestionPaper//template4for30marks"+sub+""+set+".pdf"));
	        	 String SRC="D://fuzzyQuestionPaper//template4for30marks"+sub+""+set+".pdf";	
	        	 Document document1 = new Document();
					PdfWriter writer1 = PdfWriter.getInstance(document1, file);
					StringBuilder htmlString = new StringBuilder();
					 int marks=0;
					htmlString.append(new String("<table border='0' align='center' width='100%'> "));
					
					 
					htmlString.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
					htmlString.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
					htmlString.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
     				htmlString.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
						 
				
					htmlString.append(new String("</table>"));
					
					
				//	htmlString.append(new String("<html><body> <table  align='center' width='100%'> "));
					htmlString.append(new String("<html><body> "));
					
					htmlString.append(new String("<table border='0' align='center' width='100%'> "));
					int count=0;
					char ch='a';
					/* while (itr.hasNext()) {*/
					if(set.equals("Set1"))
					{
						List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1");
						List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2");
						List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3");
						if(set.equals("Set1"))
						 {	
					for(int i=0;i<set1.size();i++){
						marks=(int) set1.get(i).getMarks();
					htmlString.append(new String("<tr><td style='padding: 10px'>Q 1."+ch+")"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
					if(set1.get(i).getImg() !=null)
					{
						String img_name=set1.get(i).getImg();
						System.out.println("in pdf"+img_name);
						htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
					}
					if(i==1)
					{
						htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
					}
					
					if(i==0 || i==2)
					{
						ch++;
					}
					if(i==1)
					{
						ch='a';
					}
					}
					for(int i=0;i<set2.size();i++){
						marks=(int) set2.get(i).getMarks();
					htmlString.append(new String("<tr><td style='padding: 10px'>Q 2.a )"+set2.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
					if(set2.get(i).getImg() !=null)
					{
						String img_name=set2.get(i).getImg();
						System.out.println("in pdf"+img_name);
						htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
					}
					if(i==0)
					{
						htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
					}
					}
					for(int i=0;i<set3.size();i++){
						marks=(int) set3.get(i).getMarks();
					htmlString.append(new String("<tr><td style='padding: 10px'>Q 3.a )"+set3.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>[0"+marks+"]</td></tr>"));
					if(set3.get(i).getImg() !=null)
					{
						String img_name=set3.get(i).getImg();
						System.out.println("in pdf"+img_name);
						htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
					}
					if(i==0)
					{
						htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
					}
					}
			       }
						 if(markingScheme.equals("markSet1")){
							 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template4for30marksMarkingScheme"+sub+""+set+".pdf"));
							 String SRC2="D://fuzzyQuestionPaper//template4for30marksMarkingScheme"+sub+""+set+".pdf";
				        	 Document document2 = new Document();
								PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
								StringBuilder htmlString1 = new StringBuilder();
								htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
								
								 
								htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
			     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
							
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("<html><body> "));
								
								htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
								htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
								 count=1;
								for(int i=0;i<set1.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getText_type()+"</td></tr>"));
			                         count++;
									}
								for(int i=0;i<set2.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set2.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set2.get(i).getText_type()+"</td></tr>"));
			                         count++;
									}
								for(int i=0;i<set3.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set3.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set3.get(i).getText_type()+"</td></tr>"));
								     count++;
									}
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("</body></html>"));
				

								document2.open();
								InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
								XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
								document2.close();
								file2.close();
								
								String name=null;
								session.setAttribute("SRC", SRC2);
							 	File file1 = new File(SRC2);
						        file1.getParentFile().mkdirs();
						        try {
						        	AESencryptDecrypt aes=new AESencryptDecrypt();
						        	name=aes.encrypt(file1);
						        	file1.delete();
								} catch (DocumentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        
						        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
						        pe.setDate(date);
						        pe.setSet_name(name);
						        pe.setSubject(subject);
						        pe.setTeacher_id(teacher_id);
						        pe.setTime(time);
						        
						        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
						        
						        if(x1)
						        {
						        	System.out.println(".................................");
						        }
							 }
					}
					 else if(set.equals("Set2"))
					 {
						    List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set2");
							List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set2");
							List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set2");
							if(set.equals("Set2"))
							 {
							for(int i=0;i<set1.size();i++){
						marks=(int) set1.get(i).getMarks();
					htmlString.append(new String("<tr><td style='padding: 10px'>Q 1."+ch+" )"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
					if(set1.get(i).getImg() !=null)
					{
						String img_name=set1.get(i).getImg();
						System.out.println("in pdf"+img_name);
						htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
					}
					if(i==1)
					{
						htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
					}
					if(i==0 || i==2 )
					{
						ch++;
					}
					if(i==1)
					{
						ch='a';
					}
					}
					for(int i=0;i<set2.size();i++){
						marks=(int) set2.get(i).getMarks();
						htmlString.append(new String("<tr><td style='padding: 10px'>Q 2.a )"+set2.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
						if(set2.get(i).getImg() !=null)
						{
							String img_name=set2.get(i).getImg();
							System.out.println("in pdf"+img_name);
							htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
						}
						if(i==0)
						{
							htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
						}	
					}
					for(int i=0;i<set3.size();i++){
						marks=(int) set3.get(i).getMarks();
						htmlString.append(new String("<tr><td style='padding: 10px'>Q 3.a )"+set3.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
						if(set3.get(i).getImg() !=null)
						{
							String img_name=set3.get(i).getImg();
							System.out.println("in pdf"+img_name);
							htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
						}
						
						if(i==0)
						{
							htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
						}
					}
							 }
							 if(markingScheme.equals("markSet2")){
								 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template4for30marksMarkingScheme"+sub+""+set+".pdf"));
								 String SRC2="D://fuzzyQuestionPaper//template4for30marksMarkingScheme"+sub+""+set+".pdf";
					        	 Document document2 = new Document();
									PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
									StringBuilder htmlString1 = new StringBuilder();
									htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
									
									 
									htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
				     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
								
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("<html><body> "));
									
									htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
									htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
									 count=1;
									for(int i=0;i<set1.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set2.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set2.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set2.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set3.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set3.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set3.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("</body></html>"));
					

									document2.open();
									InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
									XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
									document2.close();
									file2.close();
									
									String name=null;
									session.setAttribute("SRC", SRC2);
								 	File file1 = new File(SRC2);
							        file1.getParentFile().mkdirs();
							        try {
							        	AESencryptDecrypt aes=new AESencryptDecrypt();
							        	name=aes.encrypt(file1);
							        	file1.delete();
									} catch (DocumentException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							        
							        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
							        pe.setDate(date);
							        pe.setSet_name(name);
							        pe.setSubject(subject);
							        pe.setTeacher_id(teacher_id);
							        pe.setTime(time);
							        
							        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
							        
							        if(x1)
							        {
							        	System.out.println(".................................");
							        }
								 }
			       }
					 else if(set.equals("Set3"))
					 {
						    List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set3");
							List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set3");
							List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set3");
							if(set.equals("Set3"))
							 {
							for(int i=0;i<set1.size();i++){
						marks=(int) set1.get(i).getMarks();
					htmlString.append(new String("<tr><td style='padding: 10px'>Q 1. "+ch+" )"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
					if(set1.get(i).getImg() !=null)
					{
						String img_name=set1.get(i).getImg();
						System.out.println("in pdf"+img_name);
						htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
					}
					
					if(i==1)
					{
						htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
					}
					if(i==0 || i==2)
					{
						ch++;
					}
					if(i==1)
					{
						ch='a';
					}
					}
					for(int i=0;i<set2.size();i++){
						marks=(int) set2.get(i).getMarks();
						htmlString.append(new String("<tr><td style='padding: 10px'>Q 2.a )"+set2.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
						if(set2.get(i).getImg() !=null)
						{
							String img_name=set2.get(i).getImg();
							System.out.println("in pdf"+img_name);
							htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
						}
						
						if(i==0)
						{
							htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
						}	
					}
					for(int i=0;i<set3.size();i++){
						marks=(int) set3.get(i).getMarks();
						htmlString.append(new String("<tr><td style='padding: 10px'>Q 3.a )"+set3.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
						if(set3.get(i).getImg() !=null)
						{
							String img_name=set3.get(i).getImg();
							System.out.println("in pdf"+img_name);
							htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
						}
						if(i==0)
						{
							htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
						}	
					}
			       }
							 if(markingScheme.equals("markSet3")){
								 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template4for30marksMarkingScheme"+sub+""+set+".pdf"));
								 String SRC2="D://fuzzyQuestionPaper//template4for30marksMarkingScheme"+sub+""+set+".pdf";
					        	 Document document2 = new Document();
									PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
									StringBuilder htmlString1 = new StringBuilder();
									htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
									
									 
									htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
				     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
								
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("<html><body> "));
									
									htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
									htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
									 count=1;
									for(int i=0;i<set1.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set2.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set2.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set2.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set3.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set3.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set3.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("</body></html>"));
					

									document2.open();
									InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
									XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
									document2.close();
									file2.close();
									
									String name=null;
									session.setAttribute("SRC", SRC2);
								 	File file1 = new File(SRC2);
							        file1.getParentFile().mkdirs();
							        try {
							        	AESencryptDecrypt aes=new AESencryptDecrypt();
							        	name=aes.encrypt(file1);
							        	file1.delete();
									} catch (DocumentException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							        
							        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
							        pe.setDate(date);
							        pe.setSet_name(name);
							        pe.setSubject(subject);
							        pe.setTeacher_id(teacher_id);
							        pe.setTime(time);
							        
							        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
							        
							        if(x1)
							        {
							        	System.out.println(".................................");
							        }
								 }
					 }
					htmlString.append(new String("</table>"));
					htmlString.append(new String("</body></html>"));
					document1.open();
				

					document1.open();
					InputStream is = new ByteArrayInputStream(htmlString.toString().getBytes());
					XMLWorkerHelper.getInstance().parseXHtml(writer1, document1, is);
					document1.close();
					file.close();
					
					String name=null;
					session.setAttribute("SRC", SRC);
				 	File file1 = new File(SRC);
			        file1.getParentFile().mkdirs();
			        try {
			        	AESencryptDecrypt aes=new AESencryptDecrypt();
			        	name=aes.encrypt(file1);
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
			        pe.setDate(date);
			        pe.setSet_name(name);
			        pe.setSubject(subject);
			        pe.setTeacher_id(teacher_id);
			        pe.setTime(time);
			        
			        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
			        
			        if(x1)
			        {
			        	System.out.println(".................................");
			        }
	        	} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
	        	
	        	response.sendRedirect("SubjectServlet?action=template4dataSet1");
		}
		
		
		if(action!=null && action.equals("template1for80"))
		{
			long teacher_id=(long) session.getAttribute("teacher_id");
			String date=(String) session.getAttribute("date");
			String subject=(String) session.getAttribute("subject");
			double time=time=(double) session.getAttribute("time");
			String set=request.getParameter("set");
			System.out.println("set"+set);
			String markingScheme=request.getParameter("scheme");

			String sub=(String) session.getAttribute("subject");
			String sem=(String) session.getAttribute("sem");
			//System.out.println("size pdf"+set1.size());
			
			try {
	        	 OutputStream file = new FileOutputStream(new File("D://fuzzyQuestionPaper//template1for80marks"+sub+""+set+".pdf"));
	        	 String SRC="D://fuzzyQuestionPaper//template1for80marks"+sub+""+set+".pdf";	
	        	 Document document1 = new Document();
					PdfWriter writer1 = PdfWriter.getInstance(document1, file);
					StringBuilder htmlString = new StringBuilder();
					
					htmlString.append(new String("<table border='0' align='center' width='100%'> "));
					
					 
					htmlString.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
					htmlString.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
					htmlString.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 3 hour</th></tr>"));	
     				htmlString.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 80</th></tr>"));
     				htmlString.append(new String("<tr><th style='padding: 10px'>Note:</th></tr>"));	 
     				htmlString.append(new String("<tr><th style='padding: 10px'>(i) Each question carries 20 marks</th></tr>"));	
     				htmlString.append(new String("<tr><th style='padding: 10px'>(ii) Question 1 is compulsory</th></tr>"));	
     				htmlString.append(new String("<tr><th style='padding: 10px'>(iii) Attempt any three (3) from the remaining questions</th></tr>"));	
     				htmlString.append(new String("<tr><th style='padding: 10px'>(iv) Assume suitable data wherever required</th></tr>"));	
					htmlString.append(new String("</table>"));
					
					
					htmlString.append(new String("<html><body> "));
					
					htmlString.append(new String("<table border='0' align='center' width='100%'> "));
					char ch='a';
					int count=1;
					int marks=0;
					/* while (itr.hasNext()) {*/
					 if(set.equals("Set1"))
					 {
						    List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set1");
							List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set1");
							List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set1");
							List<QuestionDetailsPojo> set4=(List<QuestionDetailsPojo>) session.getAttribute("list4Set1");
							List<QuestionDetailsPojo> set5=(List<QuestionDetailsPojo>) session.getAttribute("list5Set1");
							List<QuestionDetailsPojo> set6=(List<QuestionDetailsPojo>) session.getAttribute("list6Set1");
							htmlString.append(new String("<tr><th>Q1) Attempt any four (4) questions from the following:</th></tr>"));
							if(set.equals("Set1"))
							 {
							for(int i=0;i<set1.size();i++){
								marks=(int) set1.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set1.get(i).getImg() !=null)
								{
									String img_name=set1.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 2)</th></tr>"));
							ch='a';
							for(int i=0;i<set2.size();i++){
								marks=(int) set2.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set2.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								if(set2.get(i).getImg() !=null)
								{
									String img_name=set2.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
								if(i==0)
								{
									ch++;
									/*htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));*/
								}	
							}
							htmlString.append(new String("<tr><th>Q 3)</th></tr>"));
							ch='a';
							for(int i=0;i<set3.size();i++){
								marks=(int) set3.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set3.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								if(set3.get(i).getImg() !=null)
								{
									String img_name=set3.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
								if(i==0 || i==1)
								{
									ch++;
									/*htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));*/
								}		
							}
							htmlString.append(new String("<tr><th>Q 4)</th></tr>"));
							ch='a';
							for(int i=0;i<set4.size();i++){
								marks=(int) set4.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+" )"+set4.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								if(set4.get(i).getImg() !=null)
								{
									String img_name=set4.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
								if(i==0 || i==1)
								{
									ch++;
									/*htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));*/
								}	
							}
							htmlString.append(new String("<tr><th>Q 5)</th></tr>"));
							ch='a';
							for(int i=0;i<set5.size();i++){
								marks=(int) set5.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set5.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								if(set5.get(i).getImg() !=null)
								{
									String img_name=set5.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
								if(i==0 )
								{
									ch++;
									/*htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));*/
								}	
							}
							htmlString.append(new String("<tr><th>Q 6)</th></tr>"));
							ch='a';
							for(int i=0;i<set6.size();i++){
								marks=(int) set6.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+" )"+set6.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								if(set6.get(i).getImg() !=null)
								{
									String img_name=set6.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
								if(i==0 || i==1 || i==2)
								{
									ch++;
									/*htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));*/
								}	
							}
							 }
							 if(markingScheme.equals("markSet1")){
								 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template1for80marksMarkingScheme"+sub+""+set+".pdf"));
								 String SRC2="D://fuzzyQuestionPaper//template1for80marksMarkingScheme"+sub+""+set+".pdf";
					        	 Document document2 = new Document();
									PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
									StringBuilder htmlString1 = new StringBuilder();
									htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
									
									 
									htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
				     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
								
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("<html><body> "));
									
									htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
									htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
									 count=1;
									for(int i=0;i<set1.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set2.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set2.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set2.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set3.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set3.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set3.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									for(int i=0;i<set4.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set4.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set4.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set5.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set5.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set5.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set6.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set6.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set6.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("</body></html>"));
					

									document2.open();
									InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
									XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
									document2.close();
									file2.close();
									
									String name=null;
									session.setAttribute("SRC", SRC2);
								 	File file1 = new File(SRC2);
							        file1.getParentFile().mkdirs();
							        try {
							        	AESencryptDecrypt aes=new AESencryptDecrypt();
							        	name=aes.encrypt(file1);
							        	file1.delete();
									} catch (DocumentException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							        
							        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
							        pe.setDate(date);
							        pe.setSet_name(name);
							        pe.setSubject(subject);
							        pe.setTeacher_id(teacher_id);
							        pe.setTime(time);
							        
							        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
							        
							        if(x1)
							        {
							        	System.out.println(".................................");
							        }
								 }
			         }
					 else if(set.equals("Set2"))
					 {
						    List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set2");
							List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set2");
							List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set2");
							List<QuestionDetailsPojo> set4=(List<QuestionDetailsPojo>) session.getAttribute("list4Set2");
							List<QuestionDetailsPojo> set5=(List<QuestionDetailsPojo>) session.getAttribute("list5Set2");
							List<QuestionDetailsPojo> set6=(List<QuestionDetailsPojo>) session.getAttribute("list6Set2");
							htmlString.append(new String("<tr><th>Q 1) Attempt any four (4) questions from the following:</th></tr>"));
							ch='a';
							if(set.equals("Set2"))
							 {
							for(int i=0;i<set1.size();i++){
								marks=(int) set1.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+" )"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set1.get(i).getImg() !=null)
								{
									String img_name=set1.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}	
							}
							htmlString.append(new String("<tr><th>Q 2)</th></tr>"));
							ch='a';
							for(int i=0;i<set2.size();i++){
								marks=(int) set2.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set2.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set2.get(i).getImg() !=null)
								{
									String img_name=set2.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}	
							}
							htmlString.append(new String("<tr><th>Q 3)</th></tr>"));
							ch='a';
							for(int i=0;i<set3.size();i++){
								marks=(int) set3.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set3.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set3.get(i).getImg() !=null)
								{
									String img_name=set3.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 4)</th></tr>"));
							ch='a';
							for(int i=0;i<set4.size();i++){
								marks=(int) set4.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set4.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set4.get(i).getImg() !=null)
								{
									String img_name=set4.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 5)</th></tr>"));
							ch='a';
							for(int i=0;i<set5.size();i++){
								marks=(int) set5.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set5.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set5.get(i).getImg() !=null)
								{
									String img_name=set5.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}	
							}
							htmlString.append(new String("<tr><th>Q 6)</th></tr>"));
							ch='a';
							for(int i=0;i<set6.size();i++){
								marks=(int) set6.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+" )"+set6.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set6.get(i).getImg() !=null)
								{
									String img_name=set6.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
			         }
							 if(markingScheme.equals("markSet2")){
								 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template1for80marksMarkingScheme"+sub+""+set+".pdf"));
								 String SRC2="D://fuzzyQuestionPaper//template1for80marksMarkingScheme"+sub+""+set+".pdf";
					        	 Document document2 = new Document();
									PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
									StringBuilder htmlString1 = new StringBuilder();
									htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
									
									 
									htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
				     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
								
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("<html><body> "));
									
									htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
									htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
									 count=1;
									for(int i=0;i<set1.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set2.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set2.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set2.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set3.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set3.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set3.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									for(int i=0;i<set4.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set4.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set4.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set5.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set5.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set5.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set6.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set6.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set6.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("</body></html>"));
					

									document2.open();
									InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
									XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
									document2.close();
									file2.close();
									
									String name=null;
									session.setAttribute("SRC", SRC2);
								 	File file1 = new File(SRC2);
							        file1.getParentFile().mkdirs();
							        try {
							        	AESencryptDecrypt aes=new AESencryptDecrypt();
							        	name=aes.encrypt(file1);
							        	file1.delete();
									} catch (DocumentException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							        
							        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
							        pe.setDate(date);
							        pe.setSet_name(name);
							        pe.setSubject(subject);
							        pe.setTeacher_id(teacher_id);
							        pe.setTime(time);
							        
							        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
							        
							        if(x1)
							        {
							        	System.out.println(".................................");
							        }
								 }
							
					 }
					 else if(set.equals("Set3"))
					 {
						    List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set3");
							List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set3");
							List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set3");
							List<QuestionDetailsPojo> set4=(List<QuestionDetailsPojo>) session.getAttribute("list4Set3");
							List<QuestionDetailsPojo> set5=(List<QuestionDetailsPojo>) session.getAttribute("list5Set3");
							List<QuestionDetailsPojo> set6=(List<QuestionDetailsPojo>) session.getAttribute("list6Set3");
							htmlString.append(new String("<tr><th>Q 1) Attempt any four (4) questions from the following: </th></tr>"));
							ch='a';
							if(set.equals("Set3"))
							 {
							for(int i=0;i<set1.size();i++){
								marks=(int) set1.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set1.get(i).getImg() !=null)
								{
									String img_name=set1.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 2)</th></tr>"));
							ch='a';
							for(int i=0;i<set2.size();i++){
								marks=(int) set2.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+" )"+set2.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set2.get(i).getImg() !=null)
								{
									String img_name=set2.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 3)</th></tr>"));
							ch='a';
							for(int i=0;i<set3.size();i++){
								marks=(int) set3.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set3.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set3.get(i).getImg() !=null)
								{
									String img_name=set3.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 4)</th></tr>"));
							ch='a';
							for(int i=0;i<set4.size();i++){
								marks=(int) set4.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set4.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set4.get(i).getImg() !=null)
								{
									String img_name=set4.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 5)</th></tr>"));
							ch='a';
							for(int i=0;i<set5.size();i++){
								marks=(int) set5.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+" )"+set5.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set5.get(i).getImg() !=null)
								{
									String img_name=set5.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 6)</th></tr>"));
							ch='a';
							for(int i=0;i<set6.size();i++){
								marks=(int) set6.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set6.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set6.get(i).getImg() !=null)
								{
									String img_name=set6.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
			         }
							 if(markingScheme.equals("markSet3")){
								 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template1for80marksMarkingScheme"+sub+""+set+".pdf"));
								 String SRC2="D://fuzzyQuestionPaper//template1for80marksMarkingScheme"+sub+""+set+".pdf";
					        	 Document document2 = new Document();
									PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
									StringBuilder htmlString1 = new StringBuilder();
									htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
									
									 
									htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
				     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
								
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("<html><body> "));
									
									htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
									htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
									 count=1;
									for(int i=0;i<set1.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set2.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set2.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set2.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set3.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set3.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set3.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									for(int i=0;i<set4.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set4.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set4.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set5.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set5.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set5.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set6.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set6.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set6.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("</body></html>"));
					

									document2.open();
									InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
									XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
									document2.close();
									file2.close();
									
									String name=null;
									session.setAttribute("SRC", SRC2);
								 	File file1 = new File(SRC2);
							        file1.getParentFile().mkdirs();
							        try {
							        	AESencryptDecrypt aes=new AESencryptDecrypt();
							        	name=aes.encrypt(file1);
							        	file1.delete();
									} catch (DocumentException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							        
							        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
							        pe.setDate(date);
							        pe.setSet_name(name);
							        pe.setSubject(subject);
							        pe.setTeacher_id(teacher_id);
							        pe.setTime(time);
							        
							        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
							        
							        if(x1)
							        {
							        	System.out.println(".................................");
							        }
								 }
					 }
					htmlString.append(new String("</table>"));
					htmlString.append(new String("</body></html>"));
					document1.open();
					document1.open();
					InputStream is = new ByteArrayInputStream(htmlString.toString().getBytes());
					XMLWorkerHelper.getInstance().parseXHtml(writer1, document1, is);
					document1.close();
					file.close();
						
					String name=null;
					session.setAttribute("SRC", SRC);
				 	File file1 = new File(SRC);
			        file1.getParentFile().mkdirs();
			        try {
			        	AESencryptDecrypt aes=new AESencryptDecrypt();
			        	name=aes.encrypt(file1);
			        	file1.delete();
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
			        pe.setDate(date);
			        pe.setSet_name(name);
			        pe.setSubject(subject);
			        pe.setTeacher_id(teacher_id);
			        pe.setTime(time);
			        
			        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
			        
			        if(x1)
			        {
			        	System.out.println(".................................");
			        }
	        	} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
	        	
	        	response.sendRedirect("SubjectServlet?action=template1f0r80dataSet1");
		}
		
		
		else if(action!=null && action.equals("template2for80"))
		{
			long teacher_id=(long) session.getAttribute("teacher_id");
			String date=(String) session.getAttribute("date");
			String subject=(String) session.getAttribute("subject");
			double time=time=(double) session.getAttribute("time");
			String set=request.getParameter("set");
			System.out.println("set"+set);
			String sub=(String) session.getAttribute("subject");
			String sem=(String) session.getAttribute("sem");
			String markingScheme=request.getParameter("scheme");

			//System.out.println("size pdf"+set1.size());
			
			try {
	        	 OutputStream file = new FileOutputStream(new File("D://fuzzyQuestionPaper//template2for80marks"+sub+""+set+".pdf"));
	        	 String SRC="D://fuzzyQuestionPaper//template2for80marks"+sub+""+set+".pdf";	
	        	 Document document1 = new Document();
					PdfWriter writer1 = PdfWriter.getInstance(document1, file);
					StringBuilder htmlString = new StringBuilder();
					
					htmlString.append(new String("<table border='0' align='center' width='100%'> "));
					
					 
					htmlString.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
					htmlString.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
					htmlString.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 3 hour</th></tr>"));	
     				htmlString.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 80</th></tr>"));
     				htmlString.append(new String("<tr><th style='padding: 10px'>Note:</th></tr>"));	 
     				htmlString.append(new String("<tr><th style='padding: 10px'>(i) Each question carries 20 marks</th></tr>"));	
     				htmlString.append(new String("<tr><th style='padding: 10px'>(ii) Question 1 is compulsory</th></tr>"));	
     				htmlString.append(new String("<tr><th style='padding: 10px'>(iii) Attempt any three (3) from the remaining questions</th></tr>"));	
     				htmlString.append(new String("<tr><th style='padding: 10px'>(iv) Assume suitable data wherever required</th></tr>"));	
					htmlString.append(new String("</table>"));
					
					
					htmlString.append(new String("<html><body> "));
					
					htmlString.append(new String("<table border='0' align='center' width='100%'> "));
					char ch='a';
					int count=1;
					int marks=0;
					/* while (itr.hasNext()) {*/
					 if(set.equals("Set1"))
					 {
						    List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set1");
							List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set1");
							List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set1");
							List<QuestionDetailsPojo> set4=(List<QuestionDetailsPojo>) session.getAttribute("list4Set1");
							List<QuestionDetailsPojo> set5=(List<QuestionDetailsPojo>) session.getAttribute("list5Set1");
							List<QuestionDetailsPojo> set6=(List<QuestionDetailsPojo>) session.getAttribute("list6Set1");
							htmlString.append(new String("<tr><th>Q1) </th></tr>"));
							if(set.equals("Set1"))
							 {
							for(int i=0;i<set1.size();i++){
								marks=(int) set1.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set1.get(i).getImg() !=null)
								{
									String img_name=set1.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 2)</th></tr>"));
							ch='a';
							for(int i=0;i<set2.size();i++){
								marks=(int) set2.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set2.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
									ch++;
									if(set2.get(i).getImg() !=null)
									{
										String img_name=set2.get(i).getImg();
										System.out.println("in pdf"+img_name);
										htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
									}
									/*htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));*/
									
							}
							htmlString.append(new String("<tr><th>Q 3)</th></tr>"));
							ch='a';
							for(int i=0;i<set3.size();i++){
								marks=(int) set3.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set3.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								
									ch++;
									if(set3.get(i).getImg() !=null)
									{
										String img_name=set3.get(i).getImg();
										System.out.println("in pdf"+img_name);
										htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
									}
									/*htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));*/
									
							}
							htmlString.append(new String("<tr><th>Q 4)</th></tr>"));
							ch='a';
							for(int i=0;i<set4.size();i++){
								marks=(int) set4.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+" )"+set4.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
									ch++;
									if(set4.get(i).getImg() !=null)
									{
										String img_name=set4.get(i).getImg();
										System.out.println("in pdf"+img_name);
										htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
									}
									/*htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));*/
									
							}
							htmlString.append(new String("<tr><th>Q 5)</th></tr>"));
							ch='a';
							for(int i=0;i<set5.size();i++){
								marks=(int) set5.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set5.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
									ch++;
									if(set5.get(i).getImg() !=null)
									{
										String img_name=set5.get(i).getImg();
										System.out.println("in pdf"+img_name);
										htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
									}
									/*htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));*/
									
							}
							htmlString.append(new String("<tr><th>Q 6)  Attempt any four (4) questions from the following: </th></tr>"));
							ch='a';
							for(int i=0;i<set6.size();i++){
								marks=(int) set6.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+" )"+set6.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								
									ch++;
									if(set6.get(i).getImg() !=null)
									{
										String img_name=set6.get(i).getImg();
										System.out.println("in pdf"+img_name);
										htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
									}
									/*htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));*/
								
							}
					
			         }
							 if(markingScheme.equals("markSet1")){
								 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template2for80marksMarkingScheme"+sub+""+set+".pdf"));
								 String SRC2="D://fuzzyQuestionPaper//template2for80marksMarkingScheme"+sub+""+set+".pdf";
					        	 Document document2 = new Document();
									PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
									StringBuilder htmlString1 = new StringBuilder();
									htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
									
									 
									htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
				     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
								
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("<html><body> "));
									
									htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
									htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
									 count=1;
									for(int i=0;i<set1.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set2.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set2.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set2.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set3.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set3.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set3.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									for(int i=0;i<set4.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set4.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set4.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set5.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set5.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set5.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set6.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set6.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set6.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("</body></html>"));
					

									document2.open();
									InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
									XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
									document2.close();
									file2.close();
									
									String name=null;
									session.setAttribute("SRC", SRC2);
								 	File file1 = new File(SRC2);
							        file1.getParentFile().mkdirs();
							        try {
							        	AESencryptDecrypt aes=new AESencryptDecrypt();
							        	name=aes.encrypt(file1);
							        	file1.delete();
									} catch (DocumentException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							        
							        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
							        pe.setDate(date);
							        pe.setSet_name(name);
							        pe.setSubject(subject);
							        pe.setTeacher_id(teacher_id);
							        pe.setTime(time);
							        
							        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
							        
							        if(x1)
							        {
							        	System.out.println(".................................");
							        }
								 }
					 }
					 else if(set.equals("Set2"))
					 {
						    List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set2");
							List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set2");
							List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set2");
							List<QuestionDetailsPojo> set4=(List<QuestionDetailsPojo>) session.getAttribute("list4Set2");
							List<QuestionDetailsPojo> set5=(List<QuestionDetailsPojo>) session.getAttribute("list5Set2");
							List<QuestionDetailsPojo> set6=(List<QuestionDetailsPojo>) session.getAttribute("list6Set2");
							htmlString.append(new String("<tr><th>Q 1) </th></tr>"));
							ch='a';
							if(set.equals("Set2"))
							 {
							for(int i=0;i<set1.size();i++){
								marks=(int) set1.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+" )"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set1.get(i).getImg() !=null)
								{
									String img_name=set1.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}	
							}
							htmlString.append(new String("<tr><th>Q 2)</th></tr>"));
							ch='a';
							for(int i=0;i<set2.size();i++){
								marks=(int) set2.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set2.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set2.get(i).getImg() !=null)
								{
									String img_name=set2.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}	
							}
							htmlString.append(new String("<tr><th>Q 3)</th></tr>"));
							ch='a';
							for(int i=0;i<set3.size();i++){
								marks=(int) set3.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set3.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set3.get(i).getImg() !=null)
								{
									String img_name=set3.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 4)</th></tr>"));
							ch='a';
							for(int i=0;i<set4.size();i++){
								marks=(int) set4.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set4.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set4.get(i).getImg() !=null)
								{
									String img_name=set4.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}	
							}
							htmlString.append(new String("<tr><th>Q 5)</th></tr>"));
							ch='a';
							for(int i=0;i<set5.size();i++){
								marks=(int) set5.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set5.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set5.get(i).getImg() !=null)
								{
									String img_name=set5.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 6)  Attempt any four (4) questions from the following: </th></tr>"));
							ch='a';
							for(int i=0;i<set6.size();i++){
								marks=(int) set6.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+" )"+set6.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set6.get(i).getImg() !=null)
								{
									String img_name=set6.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
								
							}
			         }
							 if(markingScheme.equals("markSet2")){
								 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template2for80marksMarkingScheme"+sub+""+set+".pdf"));
								 String SRC2="D://fuzzyQuestionPaper//template2for80marksMarkingScheme"+sub+""+set+".pdf";
					        	 Document document2 = new Document();
									PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
									StringBuilder htmlString1 = new StringBuilder();
									htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
									
									 
									htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
				     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
								
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("<html><body> "));
									
									htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
									htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
									 count=1;
									for(int i=0;i<set1.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set2.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set2.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set2.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set3.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set3.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set3.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									for(int i=0;i<set4.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set4.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set4.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set5.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set5.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set5.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set6.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set6.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set6.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("</body></html>"));
					

									document2.open();
									InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
									XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
									document2.close();
									file2.close();
									
									String name=null;
									session.setAttribute("SRC", SRC2);
								 	File file1 = new File(SRC2);
							        file1.getParentFile().mkdirs();
							        try {
							        	AESencryptDecrypt aes=new AESencryptDecrypt();
							        	name=aes.encrypt(file1);
							        	file1.delete();
									} catch (DocumentException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							        
							        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
							        pe.setDate(date);
							        pe.setSet_name(name);
							        pe.setSubject(subject);
							        pe.setTeacher_id(teacher_id);
							        pe.setTime(time);
							        
							        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
							        
							        if(x1)
							        {
							        	System.out.println(".................................");
							        }
								 }
					 }
					 else if(set.equals("Set3"))
					 {
						    List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set3");
							List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set3");
							List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set3");
							List<QuestionDetailsPojo> set4=(List<QuestionDetailsPojo>) session.getAttribute("list4Set3");
							List<QuestionDetailsPojo> set5=(List<QuestionDetailsPojo>) session.getAttribute("list5Set3");
							List<QuestionDetailsPojo> set6=(List<QuestionDetailsPojo>) session.getAttribute("list6Set3");
							htmlString.append(new String("<tr><th>Q 1)</th></tr>"));
							ch='a';
							if(set.equals("Set3"))
							 {
							for(int i=0;i<set1.size();i++){
								marks=(int) set1.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set1.get(i).getImg() !=null)
								{
									String img_name=set1.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 2)</th></tr>"));
							ch='a';
							for(int i=0;i<set2.size();i++){
								marks=(int) set2.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+" )"+set2.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set2.get(i).getImg() !=null)
								{
									String img_name=set2.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 3)</th></tr>"));
							ch='a';
							for(int i=0;i<set3.size();i++){
								marks=(int) set3.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set3.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set3.get(i).getImg() !=null)
								{
									String img_name=set3.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 4)</th></tr>"));
							ch='a';
							for(int i=0;i<set4.size();i++){
								marks=(int) set4.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set4.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set4.get(i).getImg() !=null)
								{
									String img_name=set4.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}	
							}
							htmlString.append(new String("<tr><th>Q 5)</th></tr>"));
							ch='a';
							for(int i=0;i<set5.size();i++){
								marks=(int) set5.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+" )"+set5.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set5.get(i).getImg() !=null)
								{
									String img_name=set5.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 6)  Attempt any four (4) questions from the following: </th></tr>"));
							ch='a';
							for(int i=0;i<set6.size();i++){
								marks=(int) set6.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set6.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set6.get(i).getImg() !=null)
								{
									String img_name=set6.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
			         }
							 if(markingScheme.equals("markSet3")){
								 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template2for80marksMarkingScheme"+sub+""+set+".pdf"));
								 String SRC2="D://fuzzyQuestionPaper//template2for80marksMarkingScheme"+sub+""+set+".pdf";
					        	 Document document2 = new Document();
									PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
									StringBuilder htmlString1 = new StringBuilder();
									htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
									
									 
									htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
				     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
								
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("<html><body> "));
									
									htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
									htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
									 count=1;
									for(int i=0;i<set1.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set2.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set2.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set2.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set3.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set3.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set3.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									for(int i=0;i<set4.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set4.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set4.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set5.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set5.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set5.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set6.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set6.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set6.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("</body></html>"));
					

									document2.open();
									InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
									XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
									document2.close();
									file2.close();
									
									String name=null;
									session.setAttribute("SRC", SRC2);
								 	File file1 = new File(SRC2);
							        file1.getParentFile().mkdirs();
							        try {
							        	AESencryptDecrypt aes=new AESencryptDecrypt();
							        	name=aes.encrypt(file1);
							        	file1.delete();
									} catch (DocumentException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							        
							        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
							        pe.setDate(date);
							        pe.setSet_name(name);
							        pe.setSubject(subject);
							        pe.setTeacher_id(teacher_id);
							        pe.setTime(time);
							        
							        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
							        
							        if(x1)
							        {
							        	System.out.println(".................................");
							        }
								 }
					 }
					htmlString.append(new String("</table>"));
					htmlString.append(new String("</body></html>"));
					document1.open();
					document1.open();
					InputStream is = new ByteArrayInputStream(htmlString.toString().getBytes());
					XMLWorkerHelper.getInstance().parseXHtml(writer1, document1, is);
					document1.close();
					file.close();
					
					String name=null;
					session.setAttribute("SRC", SRC);
				 	File file1 = new File(SRC);
			        file1.getParentFile().mkdirs();
			        try {
			        	AESencryptDecrypt aes=new AESencryptDecrypt();
			        	name=aes.encrypt(file1);
			        	file1.delete();
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
			        pe.setDate(date);
			        pe.setSet_name(name);
			        pe.setSubject(subject);
			        pe.setTeacher_id(teacher_id);
			        pe.setTime(time);
			        
			        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
			        
			        if(x1)
			        {
			        	System.out.println(".................................");
			        }
						
	        	} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
	        	
	        	response.sendRedirect("SubjectServlet?action=template2f0r80dataSet1");
		}
		else if(action!=null && action.equals("template3for80"))
		{
			long teacher_id=(long) session.getAttribute("teacher_id");
			String date=(String) session.getAttribute("date");
			String subject=(String) session.getAttribute("subject");
			double time=time=(double) session.getAttribute("time");
			String set=request.getParameter("set");
			System.out.println("set"+set);
			String sub=(String) session.getAttribute("subject");
			String sem=(String) session.getAttribute("sem");
			//System.out.println("size pdf"+set1.size());
			String markingScheme=request.getParameter("scheme");

			try {
	        	 OutputStream file = new FileOutputStream(new File("D://fuzzyQuestionPaper//template3for80marks"+sub+""+set+".pdf"));
	        	 String SRC="D://fuzzyQuestionPaper//template3for80marks"+sub+""+set+".pdf";	
	        	 Document document1 = new Document();
					PdfWriter writer1 = PdfWriter.getInstance(document1, file);
					StringBuilder htmlString = new StringBuilder();
					
					htmlString.append(new String("<table border='0' align='center' width='100%'> "));
					
					 
					htmlString.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
					htmlString.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
					htmlString.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 3 hour</th></tr>"));	
     				htmlString.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 80</th></tr>"));
     				htmlString.append(new String("<tr><th style='padding: 10px'>Note:</th></tr>"));	 
     				htmlString.append(new String("<tr><th style='padding: 10px'>(i) Each question carries 20 marks</th></tr>"));	
     				htmlString.append(new String("<tr><th style='padding: 10px'>(ii) Question 1 is compulsory</th></tr>"));	
     				htmlString.append(new String("<tr><th style='padding: 10px'>(iii) Attempt any three (3) from the remaining questions</th></tr>"));	
     				htmlString.append(new String("<tr><th style='padding: 10px'>(iv) Assume suitable data wherever required</th></tr>"));	
					htmlString.append(new String("</table>"));
					
					
					htmlString.append(new String("<html><body> "));
					
					htmlString.append(new String("<table border='0' align='center' width='100%'> "));
					char ch='a';
					int count=1;
					int marks=0;
					/* while (itr.hasNext()) {*/
					 if(set.equals("Set1"))
					 {
						    List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set1");
							List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set1");
							List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set1");
							List<QuestionDetailsPojo> set4=(List<QuestionDetailsPojo>) session.getAttribute("list4Set1");
							List<QuestionDetailsPojo> set5=(List<QuestionDetailsPojo>) session.getAttribute("list5Set1");
							List<QuestionDetailsPojo> set6=(List<QuestionDetailsPojo>) session.getAttribute("list6Set1");
							htmlString.append(new String("<tr><th>Q1) Attempt any four (4) questions from the following: </th></tr>"));
							if(set.equals("Set1"))
							 {
							for(int i=0;i<set1.size();i++){
								marks=(int) set1.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set1.get(i).getImg() !=null)
								{
									String img_name=set1.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 2)</th></tr>"));
							ch='a';
							for(int i=0;i<set2.size();i++){
								marks=(int) set2.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set2.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								if(set2.get(i).getImg() !=null)
								{
									String img_name=set2.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
								if(i==0)
								{
									ch++;
									/*htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));*/
								}	
							}
							htmlString.append(new String("<tr><th>Q 3)</th></tr>"));
							ch='a';
							for(int i=0;i<set3.size();i++){
								marks=(int) set3.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set3.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								if(set3.get(i).getImg() !=null)
								{
									String img_name=set3.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center>><td></td></tr>"));
								}
								if(i==0 || i==1)
								{
									ch++;
									/*htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));*/
								}		
							}
							htmlString.append(new String("<tr><th>Q 4)</th></tr>"));
							ch='a';
							for(int i=0;i<set4.size();i++){
								marks=(int) set4.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+" )"+set4.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								if(set4.get(i).getImg() !=null)
								{
									String img_name=set4.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
								if(i==0 || i==1)
								{
									ch++;
									/*htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));*/
								}	
							}
							htmlString.append(new String("<tr><th>Q 5)</th></tr>"));
							ch='a';
							for(int i=0;i<set5.size();i++){
								marks=(int) set5.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set5.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								if(set5.get(i).getImg() !=null)
								{
									String img_name=set5.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
								if(i==0 )
								{
									ch++;
									/*htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));*/
								}	
							}
							htmlString.append(new String("<tr><th>Q 6) </th></tr>"));
							ch='a';
							for(int i=0;i<set6.size();i++){
								marks=(int) set6.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+" )"+set6.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								if(set6.get(i).getImg() !=null)
								{
									String img_name=set6.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
								if(i==0 || i==1 || i==2)
								{
									ch++;
									/*htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));*/
								}	
							}
					
			         }
							 if(markingScheme.equals("markSet1")){
								 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template3for80marksMarkingScheme"+sub+""+set+".pdf"));
								 String SRC2="D://fuzzyQuestionPaper//template3for80marksMarkingScheme"+sub+""+set+".pdf";
					        	 Document document2 = new Document();
									PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
									StringBuilder htmlString1 = new StringBuilder();
									htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
									
									 
									htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
				     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
								
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("<html><body> "));
									
									htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
									htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
									 count=1;
									for(int i=0;i<set1.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set2.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set2.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set2.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set3.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set3.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set3.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									for(int i=0;i<set4.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set4.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set4.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set5.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set5.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set5.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set6.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set6.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set6.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("</body></html>"));
					

									document2.open();
									InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
									XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
									document2.close();
									file2.close();
									
									String name=null;
									session.setAttribute("SRC", SRC2);
								 	File file1 = new File(SRC2);
							        file1.getParentFile().mkdirs();
							        try {
							        	AESencryptDecrypt aes=new AESencryptDecrypt();
							        	name=aes.encrypt(file1);
							        	file1.delete();
									} catch (DocumentException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							        
							        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
							        pe.setDate(date);
							        pe.setSet_name(name);
							        pe.setSubject(subject);
							        pe.setTeacher_id(teacher_id);
							        pe.setTime(time);
							        
							        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
							        
							        if(x1)
							        {
							        	System.out.println(".................................");
							        }
								 }
					 }
					 else if(set.equals("Set2"))
					 {
						    List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set2");
							List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set2");
							List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set2");
							List<QuestionDetailsPojo> set4=(List<QuestionDetailsPojo>) session.getAttribute("list4Set2");
							List<QuestionDetailsPojo> set5=(List<QuestionDetailsPojo>) session.getAttribute("list5Set2");
							List<QuestionDetailsPojo> set6=(List<QuestionDetailsPojo>) session.getAttribute("list6Set2");
							htmlString.append(new String("<tr><th>Q 1)  Attempt any four (4) questions from the following: </th></tr>"));
							ch='a';
							if(set.equals("Set2"))
							 {
							for(int i=0;i<set1.size();i++){
								marks=(int) set1.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+" )"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set1.get(i).getImg() !=null)
								{
									String img_name=set1.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}	
							}
							htmlString.append(new String("<tr><th>Q 2)</th></tr>"));
							ch='a';
							for(int i=0;i<set2.size();i++){
								marks=(int) set2.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set2.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set2.get(i).getImg() !=null)
								{
									String img_name=set2.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 3)</th></tr>"));
							ch='a';
							for(int i=0;i<set3.size();i++){
								marks=(int) set3.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set3.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set3.get(i).getImg() !=null)
								{
									String img_name=set3.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 4)</th></tr>"));
							ch='a';
							for(int i=0;i<set4.size();i++){
								marks=(int) set4.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set4.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set4.get(i).getImg() !=null)
								{
									String img_name=set4.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 5)</th></tr>"));
							ch='a';
							for(int i=0;i<set5.size();i++){
								marks=(int) set5.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set5.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set5.get(i).getImg() !=null)
								{
									String img_name=set5.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 6)</th></tr>"));
							ch='a';
							for(int i=0;i<set6.size();i++){
								marks=(int) set6.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+" )"+set6.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set6.get(i).getImg() !=null)
								{
									String img_name=set6.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							 }
							 if(markingScheme.equals("markSet2")){
								 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template3for80marksMarkingScheme"+sub+""+set+".pdf"));
								 String SRC2="D://fuzzyQuestionPaper//template3for80marksMarkingScheme"+sub+""+set+".pdf";
					        	 Document document2 = new Document();
									PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
									StringBuilder htmlString1 = new StringBuilder();
									htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
									
									 
									htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
				     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
								
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("<html><body> "));
									
									htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
									htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
									 count=1;
									for(int i=0;i<set1.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set2.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set2.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set2.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set3.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set3.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set3.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									for(int i=0;i<set4.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set4.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set4.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set5.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set5.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set5.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set6.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set6.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set6.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("</body></html>"));
					

									document2.open();
									InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
									XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
									document2.close();
									file2.close();
									
									String name=null;
									session.setAttribute("SRC", SRC2);
								 	File file1 = new File(SRC2);
							        file1.getParentFile().mkdirs();
							        try {
							        	AESencryptDecrypt aes=new AESencryptDecrypt();
							        	name=aes.encrypt(file1);
							        	file1.delete();
									} catch (DocumentException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							        
							        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
							        pe.setDate(date);
							        pe.setSet_name(name);
							        pe.setSubject(subject);
							        pe.setTeacher_id(teacher_id);
							        pe.setTime(time);
							        
							        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
							        
							        if(x1)
							        {
							        	System.out.println(".................................");
							        }
								 }
			         }
					 else if(set.equals("Set3"))
					 {
						    List<QuestionDetailsPojo> set1=(List<QuestionDetailsPojo>) session.getAttribute("list1Set3");
							List<QuestionDetailsPojo> set2=(List<QuestionDetailsPojo>) session.getAttribute("list2Set3");
							List<QuestionDetailsPojo> set3=(List<QuestionDetailsPojo>) session.getAttribute("list3Set3");
							List<QuestionDetailsPojo> set4=(List<QuestionDetailsPojo>) session.getAttribute("list4Set3");
							List<QuestionDetailsPojo> set5=(List<QuestionDetailsPojo>) session.getAttribute("list5Set3");
							List<QuestionDetailsPojo> set6=(List<QuestionDetailsPojo>) session.getAttribute("list6Set3");
							htmlString.append(new String("<tr><th>Q 1)  Attempt any four (4) questions from the following:</th></tr>"));
							ch='a';
							if(set.equals("Set3"))
							 {
							for(int i=0;i<set1.size();i++){
								marks=(int) set1.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set1.get(i).getImg() !=null)
								{
									String img_name=set1.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 2)</th></tr>"));
							ch='a';
							for(int i=0;i<set2.size();i++){
								marks=(int) set2.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+" )"+set2.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set2.get(i).getImg() !=null)
								{
									String img_name=set2.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
									
							}
							htmlString.append(new String("<tr><th>Q 3)</th></tr>"));
							ch='a';
							for(int i=0;i<set3.size();i++){
								marks=(int) set3.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set3.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set3.get(i).getImg() !=null)
								{
									String img_name=set3.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}	
							}
							htmlString.append(new String("<tr><th>Q 4)</th></tr>"));
							ch='a';
							for(int i=0;i<set4.size();i++){
								marks=(int) set4.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set4.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set4.get(i).getImg() !=null)
								{
									String img_name=set4.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}
							}
							htmlString.append(new String("<tr><th>Q 5)</th></tr>"));
							ch='a';
							for(int i=0;i<set5.size();i++){
								marks=(int) set5.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+" )"+set5.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set5.get(i).getImg() !=null)
								{
									String img_name=set5.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}	
							}
							htmlString.append(new String("<tr><th>Q 6)</th></tr>"));
							ch='a';
							for(int i=0;i<set6.size();i++){
								marks=(int) set6.get(i).getMarks();
								htmlString.append(new String("<tr><td style='padding: 10px'>"+ch+")"+set6.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+marks+"]</td></tr>"));
								ch++;
								if(set6.get(i).getImg() !=null)
								{
									String img_name=set6.get(i).getImg();
									System.out.println("in pdf"+img_name);
									htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
								}	
							}
			         }
							 if(markingScheme.equals("markSet3")){
								 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template3for80marksMarkingScheme"+sub+""+set+".pdf"));
								 String SRC2="D://fuzzyQuestionPaper//template3for80marksMarkingScheme"+sub+""+set+".pdf";
					        	 Document document2 = new Document();
									PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
									StringBuilder htmlString1 = new StringBuilder();
									htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
									
									 
									htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
									htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
				     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
								
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("<html><body> "));
									
									htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
									htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
									 count=1;
									for(int i=0;i<set1.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set2.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set2.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set2.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set3.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set3.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set3.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									for(int i=0;i<set4.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set4.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set4.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set5.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set5.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set5.get(i).getText_type()+"</td></tr>"));
				                         count++;
										}
									for(int i=0;i<set6.size();i++){
										
										htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set6.get(i).getMarks()+"</td><td style='text-align:center;padding: 10px'>"+set6.get(i).getText_type()+"</td></tr>"));
									     count++;
										}
									htmlString1.append(new String("</table>"));
									htmlString1.append(new String("</body></html>"));
					

									document2.open();
									InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
									XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
									document2.close();
									file2.close();
									
									String name=null;
									session.setAttribute("SRC", SRC2);
								 	File file1 = new File(SRC2);
							        file1.getParentFile().mkdirs();
							        try {
							        	AESencryptDecrypt aes=new AESencryptDecrypt();
							        	name=aes.encrypt(file1);
							        	file1.delete();
									} catch (DocumentException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
							        
							        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
							        pe.setDate(date);
							        pe.setSet_name(name);
							        pe.setSubject(subject);
							        pe.setTeacher_id(teacher_id);
							        pe.setTime(time);
							        
							        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
							        
							        if(x1)
							        {
							        	System.out.println(".................................");
							        }
								 }
					 }
					htmlString.append(new String("</table>"));
					htmlString.append(new String("</body></html>"));
					document1.open();
					document1.open();
					InputStream is = new ByteArrayInputStream(htmlString.toString().getBytes());
					XMLWorkerHelper.getInstance().parseXHtml(writer1, document1, is);
					document1.close();
					file.close();
						
					String name=null;
					session.setAttribute("SRC", SRC);
				 	File file1 = new File(SRC);
			        file1.getParentFile().mkdirs();
			        try {
			        	AESencryptDecrypt aes=new AESencryptDecrypt();
			        	name=aes.encrypt(file1);
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
			        pe.setDate(date);
			        pe.setSet_name(name);
			        pe.setSubject(subject);
			        pe.setTeacher_id(teacher_id);
			        pe.setTime(time);
			        
			        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
			        
			        if(x1)
			        {
			        	System.out.println(".................................");
			        }
					
	        	} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
	        	
	        	response.sendRedirect("SubjectServlet?action=template3f0r80dataSet1");
		}
		

else if(action!=null && action.equals("sublist"))
		{
	long teacher_id=(long) session.getAttribute("teacher_id");
	
			long teacherid=Long.parseLong(request.getParameter("teacher_id"));
			System.out.println("teacherid,,,,,,,,,,,,,,"+teacherid);
			
			List<SubjectDetailsPojo> subjectList=teacherDetailsDao.getSubjectList(teacherid);
			System.out.println("subjectlist size"+subjectList.size());
			session.setAttribute("subjectList", subjectList);
			
			response.sendRedirect("viewPaper.jsp");
			
			 
			
		}
		else if(action!=null && action.equals("pdfListBySubject"))
		{
			
			String subject1=request.getParameter("subject");
			System.out.println("subject,,,,,,,,,,,,,,"+subject1);
			
			List<PaperSetEncryptPojo> pdflistbySubject=teacherDetailsDao.getPdfList(subject1);
			System.out.println("pdflistbySubject size"+pdflistbySubject.size());
			session.setAttribute("pdflistbySubject", pdflistbySubject);
		
			PrintWriter out = response.getWriter(); 
			String json = new Gson().toJson(pdflistbySubject); 
			response.setContentType("application/json"); 
			response.setCharacterEncoding("UTF-8"); 
			out.write(json);
		
			 
			
		}
		else if(action!=null && action.equals("dycryptpdf"))
		{
			String pdf=request.getParameter("pdf");
			String role=request.getParameter("role");
			 
	      
	       
			String path = "D://fuzzyQuestionPaper//"+pdf;
			System.out.println("pdf,,,,,,,,,,,,,,"+pdf);
			PaperSetEncryptPojo paperSetEncryptPojo=subjectDetailsDao.getFileDetails(pdf);
			String date=paperSetEncryptPojo.getDate();
			System.out.println("afetr dcrpt"+date);
			double timedb=paperSetEncryptPojo.getTime();
			System.out.println("afetr dcrpt"+timedb);
			
			DateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
			Date date1=new Date();
			String systemDate=sdf1.format(date1);
			System.out.println("systemDate "+systemDate);
			
			DateFormat sdf2=new SimpleDateFormat("HH:mm aa");
			Date date2=new Date();
			String systemTime=sdf2.format(date2);
			System.out.println("systemTime"+systemTime);
			String time2=systemTime.replace(":",".");
			System.out.println("time2"+time2);
			String[] splitted=time2.split("\\s+");
			String final_time=splitted[0];
			double time1=Double.parseDouble(final_time);
			System.out.println("final time"+time1);
			String username=(String) session.getAttribute("loginusername");
			if(date.equals(systemDate)){
				
				double time_differene=timedb-time1;
				System.out.println("time diffrene"+time_differene);
				if(time_differene >1)
				{
					System.out.println("in email utility");
					EmailUtility emailUtility=new EmailUtility();
                	List<CounsilDetailsPojo> list=counsilDetailsDao.getCouncileList();
                	for(int i=0;i<list.size();i++){
                		String email=list.get(i).getEmail_id();
                		
        				emailUtility.sendEmailForQuestionPaper(email, username,pdf);
                	}
					
				}
			}
			
			String encryptpdfname=(String) session.getAttribute("SRC");
			String name=null;
		 	File file1 = new File(path);
		 	File outputFile=new File("D://fuzzyDecryptQuestionPaper//paper"+System.currentTimeMillis()+".pdf");
	        //file1.getParentFile().mkdirs();
	        try {
	        	AESencryptDecrypt aes=new AESencryptDecrypt();
	        	name=aes.decrypt(file1, outputFile);
	        	System.out.println("name"+name);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				System.out.println("in exeptn doument");
				if(role.equals("teacher")){
					request.setAttribute("error", "Sorry File Not Exist!");
	  		        RequestDispatcher rd=request.getRequestDispatcher("viewPaper.jsp");
					//response.sendRedirect("viewPaper.jsp");
				}
				else if(role.equals("admin"))
				{
					request.setAttribute("error", "Sorry File Not Exist!");
	  		        RequestDispatcher rd=request.getRequestDispatcher("viewPaperByAdmin.jsp");
					//response.sendRedirect("viewPaperByAdmin.jsp");
				}
					
				else if(role.equals("subadmin"))
				{
					request.setAttribute("error", "Sorry File Not Exist!");
	  		        RequestDispatcher rd=request.getRequestDispatcher("viewPaperBySubAdmin.jsp");
					//response.sendRedirect("viewPaperBySubAdmin.jsp");
				}
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("in exeptn ");
				
				if(role.equals("teacher")){
					request.setAttribute("error", "Sorry File Not Exist!");
	  		        RequestDispatcher rd=request.getRequestDispatcher("viewPaper.jsp");
					//response.sendRedirect("viewPaper.jsp");
				}
				else if(role.equals("admin"))
				{
					request.setAttribute("error", "Sorry File Not Exist!");
	  		        RequestDispatcher rd=request.getRequestDispatcher("viewPaperByAdmin.jsp");
					//response.sendRedirect("viewPaperByAdmin.jsp");
				}
					
				else if(role.equals("subadmin"))
				{
					request.setAttribute("error", "Sorry File Not Exist!");
	  		        RequestDispatcher rd=request.getRequestDispatcher("viewPaperBySubAdmin.jsp");
					//response.sendRedirect("viewPaperBySubAdmin.jsp");
				}
				e.printStackTrace();
				
			}
	        
			if(role.equals("teacher")){
				/*outputFile.delete();
				file1.delete();*/
				session.setAttribute("name", name);
				response.sendRedirect("viewPaper.jsp");
			}
			else if(role.equals("admin"))
			{
				session.setAttribute("name", name);
				response.sendRedirect("viewPaperByAdmin.jsp");
			}
				
			else if(role.equals("subadmin"))
			{
				session.setAttribute("name", name);
				response.sendRedirect("viewPaperBySubAdmin.jsp");
			}
			 
			
		}
		else if(action!=null && action.equals("custom30tem"))
		{
			String set=request.getParameter("set");
			System.out.println("set"+set);
			String markingScheme=request.getParameter("scheme");

			String sub=(String) session.getAttribute("subject");
			String sem=(String) session.getAttribute("sem");
			
			try {
	        	 OutputStream file = new FileOutputStream(new File("D://fuzzyQuestionPaper//templateforcustom30marks"+sub+""+set+".pdf"));
	        	 String SRC="D://fuzzyQuestionPaper//templateforcustom30marks"+sub+""+set+".pdf";	
	        	 Document document1 = new Document();
					PdfWriter writer1 = PdfWriter.getInstance(document1, file);
					StringBuilder htmlString = new StringBuilder();
					 int marks=0;
					htmlString.append(new String("<table border='0' align='center' width='100%'> "));
					
					 
					htmlString.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
					htmlString.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
					htmlString.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
     				//htmlString.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
						 
				
					htmlString.append(new String("</table>"));
					
					
				//	htmlString.append(new String("<html><body> <table  align='center' width='100%'> "));
					htmlString.append(new String("<html><body> "));
					
					htmlString.append(new String("<table border='0' align='center' width='100%'> "));
					long count=0;
					long ch=0;
					String q_status="";
					/* while (itr.hasNext()) {*/
					if(set.equals("Set1"))
					{
						List<CustomizePojo> set1=(List<CustomizePojo>) session.getAttribute("lst1");
						if(set.equals("Set1"))
						 {
						for(int i=0;i<set1.size();i++){
							
						htmlString.append(new String("<tr><td style='padding: 10px'>Q "+set1.get(i).getQuestion_id()+")"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+set1.get(i).getQuestion_mark()+"]</td></tr>"));
						if(set1.get(i).getImage() !=null)
						{
							String img_name=set1.get(i).getImage();
							System.out.println("in pdf"+img_name);
							htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
						}
						q_status=set1.get(i).getQuestion_status();
						System.out.println("staus f pdf"+q_status);
						if(q_status.equals("alternate"))
						{
							htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
						}
						}
						
						 }
						 if(markingScheme.equals("markSet1")){
							 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//templateforcustom30marksMarkingScheme"+sub+""+set+".pdf"));
							 String SRC2="D://fuzzyQuestionPaper//templateforcustom30marksMarkingScheme"+sub+""+set+".pdf";
				        	 Document document2 = new Document();
								PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
								StringBuilder htmlString1 = new StringBuilder();
								htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
								
								 
								htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
			     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
							
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("<html><body> "));
								
								htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
								htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
								 count=1;
								for(int i=0;i<set1.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getQuestion_mark()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getMark_scheme()+"</td></tr>"));
			                         count++;
									}
								
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("</body></html>"));
				

								document2.open();
								InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
								XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
								document2.close();
								file2.close();
								
								String name=null;
								session.setAttribute("SRC", SRC2);
							 	File file1 = new File(SRC2);
						        file1.getParentFile().mkdirs();
						        try {
						        	AESencryptDecrypt aes=new AESencryptDecrypt();
						        	name=aes.encrypt(file1);
						        	file1.delete();
								} catch (DocumentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        long teacher_id=(long) session.getAttribute("teacher_id");
								String date=(String) session.getAttribute("date");
								String subject=(String) session.getAttribute("subject");
								double time=time=(double) session.getAttribute("time");
						        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
						        pe.setDate(date);
						        pe.setSet_name(name);
						        pe.setSubject(subject);
						        pe.setTeacher_id(teacher_id);
						        pe.setTime(time);
						        
						        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
						        
						        if(x1)
						        {
						        	System.out.println(".................................");
						        }
							 }
			       }
					 else if(set.equals("Set2"))
					 {
						 List<CustomizePojo> set1=(List<CustomizePojo>) session.getAttribute("lst2");
						 if(set.equals("Set2"))
						 {	
						 for(int i=0;i<set1.size();i++){
								
							htmlString.append(new String("<tr><td style='padding: 10px'>Q "+set1.get(i).getQuestion_id()+")"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+set1.get(i).getQuestion_mark()+"]</td></tr>"));
							if(set1.get(i).getImage() !=null)
							{
								String img_name=set1.get(i).getImage();
								System.out.println("in pdf"+img_name);
								htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
							}
							q_status=set1.get(i).getQuestion_status();
							System.out.println("staus f pdf"+q_status);
							if(q_status.equals("alternate"))
							{
								htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
							}
							}
							
			       }
						 if(markingScheme.equals("markSet2")){
							 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//template1for80marksMarkingScheme"+sub+""+set+".pdf"));
							 String SRC2="D://fuzzyQuestionPaper//template1for80marksMarkingScheme"+sub+""+set+".pdf";
				        	 Document document2 = new Document();
								PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
								StringBuilder htmlString1 = new StringBuilder();
								htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
								
								 
								htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
			     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
							
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("<html><body> "));
								
								htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
								htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
								 count=1;
								for(int i=0;i<set1.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getQuestion_mark()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getMark_scheme()+"</td></tr>"));
			                         count++;
									}
								
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("</body></html>"));
				

								document2.open();
								InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
								XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
								document2.close();
								file2.close();
								
								String name=null;
								session.setAttribute("SRC", SRC2);
							 	File file1 = new File(SRC2);
						        file1.getParentFile().mkdirs();
						        try {
						        	AESencryptDecrypt aes=new AESencryptDecrypt();
						        	name=aes.encrypt(file1);
								} catch (DocumentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        long teacher_id=(long) session.getAttribute("teacher_id");
								String date=(String) session.getAttribute("date");
								String subject=(String) session.getAttribute("subject");
								double time=time=(double) session.getAttribute("time");
						        
						        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
						        pe.setDate(date);
						        pe.setSet_name(name);
						        pe.setSubject(subject);
						        pe.setTeacher_id(teacher_id);
						        pe.setTime(time);
						        
						        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
						        
						        if(x1)
						        {
						        	System.out.println(".................................");
						        }
							 }
					 }
					 else if(set.equals("Set3"))
					 {
						 List<CustomizePojo> set1=(List<CustomizePojo>) session.getAttribute("lst3");
						 if(set.equals("Set3"))
						 {	
						 for(int i=0;i<set1.size();i++){
								
							htmlString.append(new String("<tr><td style='padding: 10px'>Q "+set1.get(i).getQuestion_id()+")"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+set1.get(i).getQuestion_mark()+"]</td></tr>"));
							if(set1.get(i).getImage() !=null)
							{
								String img_name=set1.get(i).getImage();
								System.out.println("in pdf"+img_name);
								htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
							}
							q_status=set1.get(i).getQuestion_status();
							System.out.println("staus f pdf"+q_status);
							if(q_status.equals("alternate"))
							{
								htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
							}
							}
							
			       }
						 if(markingScheme.equals("markSet1")){
							 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//templateforcustom30marksMarkingScheme"+sub+""+set+".pdf"));
							 String SRC2="D://fuzzyQuestionPaper//templateforcustom30marksMarkingScheme"+sub+""+set+".pdf";
				        	 Document document2 = new Document();
								PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
								StringBuilder htmlString1 = new StringBuilder();
								htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
								
								 
								htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
			     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
							
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("<html><body> "));
								
								htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
								htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
								 count=1;
								for(int i=0;i<set1.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getQuestion_mark()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getMark_scheme()+"</td></tr>"));
			                         count++;
									}
								
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("</body></html>"));
				

								document2.open();
								InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
								XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
								document2.close();
								file2.close();
								
								String name=null;
								session.setAttribute("SRC", SRC2);
							 	File file1 = new File(SRC2);
						        file1.getParentFile().mkdirs();
						        try {
						        	AESencryptDecrypt aes=new AESencryptDecrypt();
						        	name=aes.encrypt(file1);
						        	file1.delete();
								} catch (DocumentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        long teacher_id=(long) session.getAttribute("teacher_id");
								String date=(String) session.getAttribute("date");
								String subject=(String) session.getAttribute("subject");
								double time=time=(double) session.getAttribute("time");
						        
						        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
						        pe.setDate(date);
						        pe.setSet_name(name);
						        pe.setSubject(subject);
						        pe.setTeacher_id(teacher_id);
						        pe.setTime(time);
						        
						        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
						        
						        if(x1)
						        {
						        	System.out.println(".................................");
						        }
							 }
					 }
					htmlString.append(new String("</table>"));
					htmlString.append(new String("</body></html>"));
					document1.open();
				

					document1.open();
					InputStream is = new ByteArrayInputStream(htmlString.toString().getBytes());
					XMLWorkerHelper.getInstance().parseXHtml(writer1, document1, is);
					document1.close();
					file.close();
					
					String name=null;
					session.setAttribute("SRC", SRC);
				 	File file1 = new File(SRC);
			        file1.getParentFile().mkdirs();
			        try {
			        	AESencryptDecrypt aes=new AESencryptDecrypt();
			        	name=aes.encrypt(file1);
			        	file1.delete();
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        long teacher_id=(long) session.getAttribute("teacher_id");
					String date=(String) session.getAttribute("date");
					String subject=(String) session.getAttribute("subject");
					double time=time=(double) session.getAttribute("time");
			        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
			        pe.setDate(date);
			        pe.setSet_name(name);
			        pe.setSubject(subject);
			        pe.setTeacher_id(teacher_id);
			        pe.setTime(time);
			        
			        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
			        
			        if(x1)
			        {
			        	System.out.println(".................................");
			        }
	        	} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
	        	response.sendRedirect("SubjectServlet?action=custom30Set1");
		}
		
		
		else if(action!=null && action.equals("custom80tem"))
		{
			String set=request.getParameter("set");
			System.out.println("set"+set);
			String markingScheme=request.getParameter("scheme");

			String sub=(String) session.getAttribute("subject");
			String sem=(String) session.getAttribute("sem");
			
			try {
	        	 OutputStream file = new FileOutputStream(new File("D://fuzzyQuestionPaper//templateforcustom80marks"+sub+""+set+".pdf"));
	        	 String SRC="D://fuzzyQuestionPaper//templateforcustom80marks"+sub+""+set+".pdf";	
	        	 Document document1 = new Document();
					PdfWriter writer1 = PdfWriter.getInstance(document1, file);
					StringBuilder htmlString = new StringBuilder();
					 int marks=0;
					htmlString.append(new String("<table border='0' align='center' width='100%'> "));
					
					 
					htmlString.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
					htmlString.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
					htmlString.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
     				//htmlString.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
						 
				
					htmlString.append(new String("</table>"));
					
					
				//	htmlString.append(new String("<html><body> <table  align='center' width='100%'> "));
					htmlString.append(new String("<html><body> "));
					
					htmlString.append(new String("<table border='0' align='center' width='100%'> "));
					long count=0;
					long ch=0;
					String q_status="";
					/* while (itr.hasNext()) {*/
					if(set.equals("Set1"))
					{
						List<CustomizePojo> set1=(List<CustomizePojo>) session.getAttribute("list1");
						if(set.equals("Set1"))
						 {
						for(int i=0;i<set1.size();i++){
							
						htmlString.append(new String("<tr><td style='padding: 10px'>Q "+set1.get(i).getQuestion_id()+")"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+set1.get(i).getQuestion_mark()+"]</td></tr>"));
						if(set1.get(i).getImage() !=null)
						{
							String img_name=set1.get(i).getImage();
							System.out.println("in pdf"+img_name);
							htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
						}
						q_status=set1.get(i).getQuestion_status();
						System.out.println("staus f pdf"+q_status);
						if(q_status.equals("alternate"))
						{
							htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
						}
						}
						
						 }
						if(markingScheme.equals("markSet1")){
							 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//templateforcustom80marksMarkingScheme"+sub+""+set+".pdf"));
							 String SRC2="D://fuzzyQuestionPaper//templateforcustom80marksMarkingScheme"+sub+""+set+".pdf";
				        	 Document document2 = new Document();
								PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
								StringBuilder htmlString1 = new StringBuilder();
								htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
								
								 
								htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
			     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
							
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("<html><body> "));
								
								htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
								htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
								 count=1;
								for(int i=0;i<set1.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getQuestion_mark()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getMark_scheme()+"</td></tr>"));
			                         count++;
									}
								
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("</body></html>"));
				

								document2.open();
								InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
								XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
								document2.close();
								file2.close();
								
								String name=null;
								session.setAttribute("SRC", SRC2);
							 	File file1 = new File(SRC2);
						        file1.getParentFile().mkdirs();
						        try {
						        	AESencryptDecrypt aes=new AESencryptDecrypt();
						        	name=aes.encrypt(file1);
						        	file1.delete();
								} catch (DocumentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        long teacher_id=(long) session.getAttribute("teacher_id");
								String date=(String) session.getAttribute("date");
								String subject=(String) session.getAttribute("subject");
								double time=time=(double) session.getAttribute("time");
						        
						        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
						        pe.setDate(date);
						        pe.setSet_name(name);
						        pe.setSubject(subject);
						        pe.setTeacher_id(teacher_id);
						        pe.setTime(time);
						        
						        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
						        
						        if(x1)
						        {
						        	System.out.println(".................................");
						        }
							 }
					
			       }
					 else if(set.equals("Set2"))
					 {
						 List<CustomizePojo> set1=(List<CustomizePojo>) session.getAttribute("list2");
						 if(set.equals("Set2"))
						 {	
						 for(int i=0;i<set1.size();i++){
								
							htmlString.append(new String("<tr><td style='padding: 10px'>Q "+set1.get(i).getQuestion_id()+")"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+set1.get(i).getQuestion_mark()+"]</td></tr>"));
							if(set1.get(i).getImage() !=null)
							{
								String img_name=set1.get(i).getImage();
								System.out.println("in pdf"+img_name);
								htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
							}
							q_status=set1.get(i).getQuestion_status();
							System.out.println("staus f pdf"+q_status);
							if(q_status.equals("alternate"))
							{
								htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
							}
							}
							
						 }
						 if(markingScheme.equals("markSet2")){
							 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//templateforcustom80marksMarkingScheme"+sub+""+set+".pdf"));
							 String SRC2="D://fuzzyQuestionPaper//templateforcustom80marksMarkingScheme"+sub+""+set+".pdf";
				        	 Document document2 = new Document();
								PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
								StringBuilder htmlString1 = new StringBuilder();
								htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
								
								 
								htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
			     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
							
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("<html><body> "));
								
								htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
								htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
								 count=1;
								for(int i=0;i<set1.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getQuestion_mark()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getMark_scheme()+"</td></tr>"));
			                         count++;
									}
								
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("</body></html>"));
				

								document2.open();
								InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
								XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
								document2.close();
								file2.close();
								
								String name=null;
								session.setAttribute("SRC", SRC2);
							 	File file1 = new File(SRC2);
						        file1.getParentFile().mkdirs();
						        try {
						        	AESencryptDecrypt aes=new AESencryptDecrypt();
						        	name=aes.encrypt(file1);
						        	file1.delete();
								} catch (DocumentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        long teacher_id=(long) session.getAttribute("teacher_id");
								String date=(String) session.getAttribute("date");
								String subject=(String) session.getAttribute("subject");
								double time=time=(double) session.getAttribute("time");
						        
						        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
						        pe.setDate(date);
						        pe.setSet_name(name);
						        pe.setSubject(subject);
						        pe.setTeacher_id(teacher_id);
						        pe.setTime(time);
						        
						        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
						        
						        if(x1)
						        {
						        	System.out.println(".................................");
						        }
							 }
			       }
					 else if(set.equals("Set3"))
					 {
						 List<CustomizePojo> set1=(List<CustomizePojo>) session.getAttribute("list3");
						 if(set.equals("Set3"))
						 {	
						 for(int i=0;i<set1.size();i++){
								
							htmlString.append(new String("<tr><td style='padding: 10px'>Q "+set1.get(i).getQuestion_id()+")"+set1.get(i).getQuestion()+" </td><td style='text-align:right;padding: 10px'>["+set1.get(i).getQuestion_mark()+"]</td></tr>"));
							if(set1.get(i).getImage() !=null)
							{
								String img_name=set1.get(i).getImage();
								System.out.println("in pdf"+img_name);
								htmlString.append(new String("<tr><center><td style='padding: 10px'><img src='D://uploads//"+img_name+"' height='70px' width='70px'></img></td></center><td></td></tr>"));
							}
							q_status=set1.get(i).getQuestion_status();
							System.out.println("staus f pdf"+q_status);
							if(q_status.equals("alternate"))
							{
								htmlString.append(new String("<tr><center><td>OR</td></center></tr>"));
							}
							}
							
			       }
						 if(markingScheme.equals("markSet3")){
							 OutputStream file2 = new FileOutputStream(new File("D://fuzzyQuestionPaper//templateforcustom80marksMarkingScheme"+sub+""+set+".pdf"));
							 String SRC2="D://fuzzyQuestionPaper//templateforcustom80marksMarkingScheme"+sub+""+set+".pdf";
				        	 Document document2 = new Document();
								PdfWriter writer2 = PdfWriter.getInstance(document2, file2);
								StringBuilder htmlString1 = new StringBuilder();
								htmlString1.append(new String("<table border='0' align='center' width='100%'> "));
								
								 
								htmlString1.append(new String("<tr><th style='text-align:right;padding-left:80px;'>INTERNAL ASSESSMENT - I</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Subject:"+sub+"</th><th  style='text-align:right;padding: 10px'>Academic Year: 2017-18</th></tr>"));
								htmlString1.append(new String("<tr><th style='padding: 10px'>Class/Semester:"+sem+"</th><th style='text-align:right;padding: 10px'>Time: 1 hour</th></tr>"));	
			     				htmlString1.append(new String("<tr><th style='padding: 10px'>Division: A, B </th><th style='text-align:right;padding: 10px'>Marks: 30</th></tr>"));
							
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("<html><body> "));
								
								htmlString1.append(new String("<table border='1' align='center' width='100%'> "));
								htmlString1.append(new String(" <tr><th  style='text-align:center;padding: 10px'>Question ID</th><th  style='text-align:center;padding: 10px'>Mark Scheme</th></tr>"));
								 count=1;
								for(int i=0;i<set1.size();i++){
									
									htmlString1.append(new String("<tr><td style='padding: 10px'>Q "+count+") "+set1.get(i).getQuestion_mark()+"</td><td style='text-align:center;padding: 10px'>"+set1.get(i).getMark_scheme()+"</td></tr>"));
			                         count++;
									}
								
								htmlString1.append(new String("</table>"));
								htmlString1.append(new String("</body></html>"));
				

								document2.open();
								InputStream is1 = new ByteArrayInputStream(htmlString1.toString().getBytes());
								XMLWorkerHelper.getInstance().parseXHtml(writer2, document2, is1);
								document2.close();
								file2.close();
								
								String name=null;
								session.setAttribute("SRC", SRC2);
							 	File file1 = new File(SRC2);
						        file1.getParentFile().mkdirs();
						        try {
						        	AESencryptDecrypt aes=new AESencryptDecrypt();
						        	name=aes.encrypt(file1);
						        	file1.delete();
								} catch (DocumentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						        long teacher_id=(long) session.getAttribute("teacher_id");
								String date=(String) session.getAttribute("date");
								String subject=(String) session.getAttribute("subject");
								double time=time=(double) session.getAttribute("time");
						        
						        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
						        pe.setDate(date);
						        pe.setSet_name(name);
						        pe.setSubject(subject);
						        pe.setTeacher_id(teacher_id);
						        pe.setTime(time);
						        
						        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
						        
						        if(x1)
						        {
						        	System.out.println(".................................");
						        }
							 }
					 }
					htmlString.append(new String("</table>"));
					htmlString.append(new String("</body></html>"));
					document1.open();
				

					document1.open();
					InputStream is = new ByteArrayInputStream(htmlString.toString().getBytes());
					XMLWorkerHelper.getInstance().parseXHtml(writer1, document1, is);
					document1.close();
					file.close();
					
					String name=null;
					session.setAttribute("SRC", SRC);
				 	File file1 = new File(SRC);
			        file1.getParentFile().mkdirs();
			        try {
			        	AESencryptDecrypt aes=new AESencryptDecrypt();
			        	name=aes.encrypt(file1);
			        	file1.delete();
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        long teacher_id=(long) session.getAttribute("teacher_id");
					String date=(String) session.getAttribute("date");
					String subject=(String) session.getAttribute("subject");
					double time=time=(double) session.getAttribute("time");
			        PaperSetEncryptPojo pe=new PaperSetEncryptPojo();
			        pe.setDate(date);
			        pe.setSet_name(name);
			        pe.setSubject(subject);
			        pe.setTeacher_id(teacher_id);
			        pe.setTime(time);
			        
			        boolean x1=teacherDetailsDao.addPaperSetDetails(pe);
			        
			        if(x1)
			        {
			        	System.out.println(".................................");
			        }
	        	} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				  }
	        	response.sendRedirect("SubjectServlet?action=custom80Set1");
		}
		
		
		
		else if(action!=null && action.equals("teacherList"))
		{
			
			
			List<TeacherDetailsPojo> teacherList=teacherDetailsDao.getTeacherList();
			System.out.println("teacherList size"+teacherList.size());
			session.setAttribute("teacherList", teacherList);
			response.sendRedirect("viewPaperByAdmin.jsp");
		
		}
		
		
		else if(action!=null && action.equals("sublistForAdmin"))
		{
			long teacherid=Long.parseLong(request.getParameter("teacher_id"));
			System.out.println("teacherid,,,,,,,,,,,,,,"+teacherid);
			
			List<SubjectDetailsPojo> subjectList=teacherDetailsDao.getSubjectList(teacherid);
			System.out.println("subjectlist size"+subjectList.size());
			session.setAttribute("subjectList", subjectList);
			
			PrintWriter out = response.getWriter(); 
			String json = new Gson().toJson(subjectList); 
			response.setContentType("application/json"); 
			response.setCharacterEncoding("UTF-8"); 
			out.write(json);
		
		}
		
		else if(action!=null && action.equals("subAdminteacherListForPaper"))
		{
			
			String subadmin=(String) session.getAttribute("username");
			List<TeacherDetailsPojo> SubAdminteacherList=teacherDetailsDao.getSubadminTeacherList(subadmin);
			System.out.println("SubAdminteacherList size"+SubAdminteacherList.size());
			session.setAttribute("SubAdminteacherList", SubAdminteacherList);
			response.sendRedirect("viewPaperBySubAdmin.jsp");
		
		}
		else if(action!=null && action.equals("deleteDecryptPDF"))
		{
			String pdf_name=request.getParameter("pdf_name");
			String path = "D://fuzzyDecryptQuestionPaper//"+pdf_name;
			File file1 = new File(path);
			file1.delete();
			PrintWriter out = response.getWriter(); 
			String json = new Gson().toJson("true"); 
			response.setContentType("application/json"); 
			response.setCharacterEncoding("UTF-8"); 
			out.write(json);
		}
	}

}
