package com.insurance.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.insurance.dao.AutoGenerate;
import com.insurance.dao.ConnectDao;
import com.insurance.model.Underwriter;

@WebServlet("/Create")
public class Createwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Createwrite() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session=request.getSession();
		String ID=AutoGenerate.generateId();
		String name=request.getParameter("Name");
		String DOB=request.getParameter("Date");
		String DOJ=request.getParameter("Date1");
		boolean flag=AutoGenerate.ValidateDate(DOB);
		request.setAttribute("ID", ID);
		PrintWriter out=response.getWriter();
		if(!flag) {
			request.setAttribute("Error", "Invalid Date of birth");
			RequestDispatcher rd=request.getRequestDispatcher("createUnderwriter.jsp");
			rd.include(request, response);
		
		}
		
		else {
		Underwriter underwriter=new  Underwriter(ID,name,DOB,DOJ,null);
		try {
			ConnectDao.underwriterRegister(underwriter);
//			response.setContentType("text/html");
//			out.print("<p style=color: #ebbf2c;>Successfully Created Underwriter</p>");
			
			session.setAttribute("Message", "Underwriter Created");
			session.setAttribute("ID", ID);
			RequestDispatcher rd=request.getRequestDispatcher("createUnderwriter.jsp");
			rd.include(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		}

}
}
