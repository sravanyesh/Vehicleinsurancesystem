package com.insurance.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.insurance.dao.AutoGenerate;
import com.insurance.dao.Connectvehicleinsurance;
import com.insurance.model.Underwriter;
import com.insurance.model.Vehicleinsurance;

/**
 * Servlet implementation class VehicleinsuranceServlet
 */
@WebServlet("/Vehicleinsurance")
public class VehicleinsuranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleinsuranceServlet() {
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
		String policyNo=AutoGenerate.generatePolicyID();
		String vehicleNo=request.getParameter("vehicleNo");
		String vehicleType=request.getParameter("vehicleType");
		String customerName=request.getParameter("customerName");
		int engineNo=Integer.parseInt(request.getParameter("engineNo"));
		int chasissNo=Integer.parseInt(request.getParameter("chasissNo"));
		long phoneNo=Long.parseLong(request.getParameter("phoneNo"));
		String insuranceType=request.getParameter("insuranceType");
		int premiumAmount=Integer.parseInt(request.getParameter("premiumAmnt"));
		Date fromDate=Date.valueOf(request.getParameter("fromDate"));
		Date toDate=Date.valueOf(request.getParameter("toDate"));
		HttpSession session=request.getSession();
		String ID=(String) session.getAttribute("UID");
		System.out.println(ID);
		try {
		if(String.valueOf(phoneNo).length()<10 || String.valueOf(phoneNo).length()>=11 ) {
			request.setAttribute("Phone","In valid PhoneNo");
			RequestDispatcher rd=request.getRequestDispatcher("Createvehicleinsurance.jsp");
			rd.include(request, response);
		}
		
		else {
			if(String.valueOf(premiumAmount).length()==0 || premiumAmount==0) {
				request.setAttribute("PrmAmt","PremiumAmount Can't be null");
				RequestDispatcher rd=request.getRequestDispatcher("Createvehicleinsurance.jsp");
				rd.include(request, response);
				
			}
			else {
		Vehicleinsurance VI=new Vehicleinsurance(ID,policyNo,vehicleNo,vehicleType,customerName,engineNo,chasissNo,phoneNo,insuranceType,premiumAmount,fromDate,toDate);
		
			boolean b=Connectvehicleinsurance.CreateVehicleInsurance(VI);

			if(b) {
				request.setAttribute("CreateVehicle","Policy Successfully Created   "+"PolicyNo: "+policyNo);
				
				
			}
			else {
				
				request.setAttribute("CreateVehicleFailed", "Failed to create policy");
				
			}
			RequestDispatcher rd=request.getRequestDispatcher("Createvehicleinsurance.jsp");
			rd.include(request, response);
		}
		}
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
