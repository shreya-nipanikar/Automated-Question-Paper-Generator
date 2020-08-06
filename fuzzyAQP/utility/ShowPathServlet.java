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
@WebServlet("/ShowPathServlet")
public class ShowPathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPathServlet() {
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
		
		String imageName=request.getParameter("imageName");
        System.out.println("image_name"+imageName);
        ServletContext context = request.getSession().getServletContext();
          File imageFile = new File(Constant.USER_FILE_LOCATION+""+imageName);
          byte[] imageByteArray;
       try {
           imageByteArray = FileUtils.readFileToByteArray(imageFile);
       
          response.setContentType("image/jpeg");
          response.getOutputStream().write(imageByteArray);
          response.getOutputStream().flush();
          
       } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }



	
	}

}
