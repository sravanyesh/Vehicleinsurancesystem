package com.insurance.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insurance.dao.ConnectDao;

/**
 * Servlet implementation class Deleteunderwriter
 */
@WebServlet("/Deleteunderwriter")
public class Deleteunderwriter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deleteunderwriter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String Id=request.getParameter("U_ID");
		int res=ConnectDao.deleteUnderwriter(Id);
		if(res>0) {
			request.setAttribute("DeleteID", "Successfully Deleted");
			
			
		}
		else {
			request.setAttribute("Deletefail", "Invalid Id");
			
		}
		RequestDispatcher rd=request.getRequestDispatcher("Deleteunderwriter.jsp");
		rd.include(request, response);
	}

}
