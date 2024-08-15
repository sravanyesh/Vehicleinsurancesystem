package com.insurance.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.insurance.dao.ConnectDao;
import com.insurance.model.Underwriter;

@WebServlet("/Searchunderwriter")
public class Searchunderwriter extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
    public Searchunderwriter() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	//	HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		
	String Id=request.getParameter("U_ID");	
	System.out.println(Id);
	ResultSet rs=null;

	
		try {
			Underwriter search=null;
			 search = ConnectDao.findUnderwriterById(Id);
			if(search!=null) {
				String U_id=search.getUnderwriterId();
				String U_name=search.getName();
				String U_DOB=search.getDateOfBirth();
				String U_DOJ=search.getJoiningDate();
				System.out.println(U_DOB);
				System.out.println(U_DOJ);
				request .setAttribute("U_id", U_id);
				request.setAttribute("U_name", U_name);
				request.setAttribute("U_DOB", U_DOB);
				request.setAttribute("U_DOJ", U_DOJ);
				RequestDispatcher rd=request.getRequestDispatcher("printunderwriterId.jsp");
				rd.include(request, response);
				
				
				
			}
			else {
				request.setAttribute("searchunderwriter", "No such UnderWriterExists");
				RequestDispatcher rd=request.getRequestDispatcher("searchunderwriterbyid.jsp");
				rd.include(request, response);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		
	
		
	

}
}
