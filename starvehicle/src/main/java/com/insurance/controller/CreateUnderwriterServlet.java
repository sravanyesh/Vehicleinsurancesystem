package com.insurance.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add")
public class CreateUnderwriterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CreateUnderwriterServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		session.setAttribute("adminuser", "admin");
		if(username.equals("admin") && password.equals("admin123")) {
			session.setAttribute("msg", "Login Successful");
			RequestDispatcher rd=request.getRequestDispatcher("u3.jsp");
			System.out.println("working.");
			rd.include(request, response);
			return;
		
		}
		else {
			session.setAttribute("Fadmin", "failed");
			RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
			rd.include(request, response);
			return;
		}
//		String ID=" "+request.getParameter("ID");
//		String name=request.getParameter("Name");
//		String dateOfBirth=request.getParameter("Date");
//		String joiningDate=request.getParameter("Date1");
//		System.out.println(ID+name+dateOfBirth+joiningDate);
//		Underwriter uw=new Underwriter(ID,name,dateOfBirth,joiningDate,null);
//		try {
//			ConnectDao.underwriterRegister(uw);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
	}
//	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
//		String s=request.getParameter("AdminLogin");
//		System.out.println("value"+s);
//	}

}
