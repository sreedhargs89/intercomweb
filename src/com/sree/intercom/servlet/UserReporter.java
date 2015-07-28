package com.sree.intercom.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sree.intercom.util.Constants;
import com.sree.intercom.util.User;
import com.sree.intercom.util.UserLoader;

/**
 * Servlet implementation class Test
 */
@WebServlet("/UserReporter")
public class UserReporter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReporter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		float distance = (null == request.getParameter("distance"))?Constants.COVERAGE_DISTANCE:Float.parseFloat(request.getParameter("distance"));
		List<User> desiredUsers = UserLoader.LoadUserData(distance, Constants.DISTANCE_UNIT,Constants.USER_DATA_SOURCE_FILE);
		Collections.sort(desiredUsers);

		
		PrintWriter writer = response.getWriter();        
	        writer.println("<html>");
	        writer.println("<head>");
	        writer.println("<title>List of Users with in the defined distance</title>");
	        writer.println("</head>");
	        writer.println("<body bgcolor=white>");

	        writer.println("<table border=\"1\" cellpadding=\"10\">");
	        writer.println("<tr>");
	        writer.println("<td>");
	        writer.println("<h4>ID</h4>");
	        writer.println("</td>");
	        writer.println("<td>");
	        writer.println("<h4>Name</h4>");
	        writer.println("</td>");
	        writer.println("<td>");
	        writer.println("<h4>Distance in "+Constants.DISTANCE_UNIT+"</h4>");
	        writer.println("</td>");
	        writer.println("</tr>");

	        for (User user : desiredUsers) {
	        	writer.println("<tr>");
		        writer.println("<td>");
		        writer.println(user.getId());
		        writer.println("</td>");
		        writer.println("<td>");
		        writer.println(user.getName());
		        writer.println("</td>");
		        writer.println("<td>");
		        writer.println(user.getDistance());
		        writer.println("</td>");
	        	writer.println("</tr>");
	        }
	        writer.println("</table>");
	        writer.println("</body>");
	        writer.println("</html>");
	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
