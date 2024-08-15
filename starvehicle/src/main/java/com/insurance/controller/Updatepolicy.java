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

import com.insurance.dao.Connectvehicleinsurance;

/**
 * Servlet implementation class Updatepolicy
 */
@WebServlet("/Updatepolicy")
public class Updatepolicy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatepolicy() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String UID=(String) session.getAttribute("UID");
		String policyId=request.getParameter("policyId");
		boolean checkpolicyId=Connectvehicleinsurance.FetchpolicyId(policyId);
		if(checkpolicyId) {
			String insuranceType=Connectvehicleinsurance.Fetchinsurancetype(policyId);
			if(insuranceType.equals("Third Party")) {
				
				request.setAttribute("Noprovision", "No provision to change from third party to full insurance");
				RequestDispatcher rd=request.getRequestDispatcher("Updatepolicy.jsp");
				rd.include(request, response);
			}
			else {
				boolean check=Connectvehicleinsurance.Updateinsurancetype(policyId,UID);
				if(check) {
					
					request.setAttribute("updatedpolicy", "Successfully changed from full to third party");
					RequestDispatcher rd=request.getRequestDispatcher("Updatepolicy.jsp");
					rd.include(request, response);
				}
				else {
					
					request.setAttribute("falsepolicy", "No such PolicyId exist");
					RequestDispatcher rd=request.getRequestDispatcher("Updatepolicy.jsp");
					rd.include(request, response);
				}
			}
		}
		else {
			
			request.setAttribute("falsepolicy", "No such PolicyId exist");
			RequestDispatcher rd=request.getRequestDispatcher("Updatepolicy.jsp");
			rd.include(request, response);
		}
		
	}

}
