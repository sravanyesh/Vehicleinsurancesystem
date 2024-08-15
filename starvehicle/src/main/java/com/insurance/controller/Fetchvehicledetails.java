package com.insurance.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insurance.dao.ConnectDao;
import com.insurance.dao.Connectvehicleinsurance;
import com.insurance.model.Underwriter;

/**
 * Servlet implementation class Fetchvehicledetails
 */
@WebServlet("/Fetchvehicledetails")
public class Fetchvehicledetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fetchvehicledetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
	    PrintWriter out;
	    try {
	        out = response.getWriter();
	        String ID = request.getParameter("ID");
	        
	        // Check if ID parameter is null or empty
	        if (ID == null || ID.isEmpty()) {
	            out.println("Invalid UnderWriter Id");
	            return;
	        }
	        
	        // Fetch the Underwriter by ID
	        Underwriter u = ConnectDao.findUnderwriterById(ID);
	        if (u == null) {
	           request.setAttribute("FetchUnderwriter", "No such UnderWriter Exists");
	           RequestDispatcher rd=request.getRequestDispatcher("Fetchvehicle.jsp");
	           try {
				rd.include(request, response);
				return;
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        }
	        
	        // Fetch Vehicle details specific to the UnderWriter
      List<List<String>> vehicleDetails = Connectvehicleinsurance.FetchVehicleSpecificUnderWriters(ID);
//	        if (vehicleDetails.isEmpty()) {
//	            out.println("No Vehicle is insured by the UnderWriter");
//	            return;
//	        }
	        
	        // Display the fetched Vehicle details in a table
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Vehicle Details</title>");
      out.println("<style>");
      out.println("body {");
      out.println("    font-family: 'Poppins', sans-serif;");
      out.println("    background-image: url('background6.jpg');");
      out.println("    background-color: #f4f4f4;");
      out.println("    background-position: center;");
      out.println("    background-size: cover;");
      out.println("    background-repeat: no-repeat;");
      out.println("    background-attachment: fixed;");
      out.println("    height: auto;");
      out.println("    display: flex;");
      out.println("    flex-direction: column;");
      out.println("    align-items: flex-start;");
      out.println("    justify-content: flex-start;");
      out.println("    padding: 30px;");
      out.println("}");
      out.println("div {");
      out.println("    margin: 0 auto;"); // Center the div horizontally
      out.println("    width: 80%;"); // Set the width of the div
      out.println("    padding: 10px;"); // Add padding to the div
      out.println("}");
      out.println("table { width: 100%; border-collapse: collapse; }");
      out.println("th, td { border: 1px solid #dddddd; text-align: left; padding: 8px; }");
      out.println("th { background-color: #f2f2f2; }");
      out.println("tr:nth-child(even) { background-color: #f9f9f9; }");
      out.println(".menu-button {");
      out.println("    position: absolute;");
      out.println("    top: 10px;");
      out.println("    right: 10px;");
      out.println("    padding: 8px 16px;");
      out.println("    background-color: #4CAF50;");
      out.println("    color: white;");
      out.println("    text-align: center;");
      out.println("    text-decoration: none;");
      out.println("    display: inline-block;");
      out.println("    border: none;");
      out.println("    border-radius: 4px;");
      out.println("    cursor: pointer;");
      out.println("}");
      out.println("</style>");
      out.println("</head>");
      out.println("<body>");

      // Display the fetched Vehicle details in a centered table with padding
      out.println("<div>");
      out.println("<table>");
      out.println("<tr><th>UnderWriterId</th><th>Name</th><th>VehicleNo</th><th>PremiumAmount</th><th>FromDate</th><th>ToDate</th></tr>");
      for (List<String> row : vehicleDetails) {
          out.println("<tr>");
          for (String cell : row) {
              out.println("<td>" + cell + "</td>");
          }
          out.println("</tr>");
      }
      out.println("</table>");
      out.println("</div>");

      // Convert the menu anchor tag into a button and move it to the top right corner
      out.println("<a href='Fetchvehicle.jsp' class='menu-button'>BACK</a>");

      out.println("</body>");
      out.println("</html>");
	    } 
	    
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	}


}
