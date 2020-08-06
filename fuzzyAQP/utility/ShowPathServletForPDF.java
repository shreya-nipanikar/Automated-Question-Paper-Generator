package com.fuzzyAQP.utility;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;



/**
 * Servlet implementation class ShowPathServlet
 */
@WebServlet("/ShowPathServletForPDF")
public class ShowPathServletForPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPathServletForPDF() {
        super();
        // TODO Auto-generated constructor stub
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
		
		String pdfName=request.getParameter("pdfName");
        System.out.println("pdfName"+pdfName);
        ServletContext context = request.getSession().getServletContext();
          File pdfFile = new File(Constant.USER_FILE_LOCATIONPDF+""+pdfName);
          byte[] pdfByteArray;
       try {
           pdfByteArray = FileUtils.readFileToByteArray(pdfFile);
           
          response.setContentType("application/pdf");
          response.getOutputStream().write(pdfByteArray);
          response.getOutputStream().flush();
          
       } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }



	
	}

}
