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

import com.insurance.dao.AutoGenerate;
import com.insurance.dao.ConnectDao;
import com.insurance.model.Underwriter;

@WebServlet("/Updateunderwriter")
public class Updateunderwriter extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Updateunderwriter() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	//	HttpSession session=request.getSession();
		try {
	
	String Id=request.getParameter("U_ID");
	String password=request.getParameter("U_Password");
	String conPassword=request.getParameter("Con_pass");
	boolean b=password.equals(conPassword);
	System.out.println(b);;
	System.out.println(password+" "+conPassword);
	if(b) {
			if(AutoGenerate.isValidAlphanumeric(password)) {
				int row = ConnectDao.updateUnderwriter(Id,password);
				if(row>0) {
					request.setAttribute("Updatedsucessfully", "Successfully changed Password");
					
					
					
				}
				else {
					request.setAttribute("Failed", "Invalid Id");
					
				}
				
			}
			else {
				request.setAttribute("criteria", "Password should be alphanumeric and minimum 5 characters required");
			}
	
		
			
		}else {
			request.setAttribute("Incorrectpassword", "Password Doesn't Match");
			
		}
	RequestDispatcher rd=request.getRequestDispatcher("updatepassword.jsp");
	rd.include(request, response);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			RequestDispatcher rd=request.getRequestDispatcher("u3.jsp");
			rd.include(request, response);
			e.printStackTrace();
		}
	
	
	}
	
	
		
	


}
