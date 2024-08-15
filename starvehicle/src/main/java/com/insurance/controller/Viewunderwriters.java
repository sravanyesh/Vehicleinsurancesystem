package com.insurance.controller;





import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.insurance.dao.ConnectDao;
import com.insurance.model.Underwriter;

@WebServlet("/viewunderwriters")
public class Viewunderwriters extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Viewunderwriters() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	//	HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
	List<Underwriter> underwriter_list=new ArrayList<Underwriter>();
	underwriter_list=ConnectDao.viewallunderwriters();
	out.print("<table border='1' width='100%'  ");
    out.print("<tr><th>Id</th><th>Name</th><th>DOB</th><th>DOJ</th></tr>");
    for (Underwriter s:underwriter_list) {
    out.print("<tr><td>"+s.getUnderwriterId()+"</td><td>"+s.getName()+"</td><td>"+s.getDateOfBirth()+"</td><td>"+s.getJoiningDate()+"</td></tr>"); }       
    out.print("</table>");
    out.print("<a href='u3.jsp'>MENU</a>");

	
		
	
	
		
	
		
	


	}
}


