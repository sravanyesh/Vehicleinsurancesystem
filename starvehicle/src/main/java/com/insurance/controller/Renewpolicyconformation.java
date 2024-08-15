package com.insurance.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.insurance.dao.AutoGenerate;
import com.insurance.dao.Connectvehicleinsurance;
import com.insurance.model.Vehicleinsurance;

/**
 * Servlet implementation class Renewpolicyconformation
 */
@WebServlet("/Renewpolicyconformation")
public class Renewpolicyconformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Renewpolicyconformation() {
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
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String UID=(String)session.getAttribute("UID");
		int premiumAmount=(int) (session.getAttribute("premiumAmount"));
		int newPremiumamt=0;
		String from=(String) session.getAttribute("fromDate");
		String to=(String) session.getAttribute("toDate");
		Date fromdate=Date.valueOf(from);
		Date todate=Date.valueOf(to);
		LocalDate date = LocalDate.now();
		Date currentDate = Date.valueOf(date);
		int comparison = fromdate.compareTo(currentDate);
		Date newfromDate=null;
		if(comparison<0) {
			System.out.println("policy expired");
		 newfromDate=currentDate;
			
		}
		else if(comparison>0) {
		 newfromDate=todate;
			
		}
		else {
			 newfromDate=currentDate;
		}
		LocalDate LocalfromDate=newfromDate.toLocalDate();
		LocalDate LocaltoDate=LocalfromDate.plusDays(365);
		
		
		String policyNo=AutoGenerate.generatePolicyID();
		String vehicleNo=(String) session.getAttribute("vehicle");
		String vehicleType=(String) session.getAttribute("vehicleType");
		String customerName=(String) session.getAttribute("customerName");
		int engineNo=(int) (session.getAttribute("engineNo"));
		int chasissNo=(int) (session.getAttribute("chasissNo"));
		long phoneNo=(long) (session.getAttribute("phoneNo"));
		String insuranceType=(String) session.getAttribute("insuranceType");
		if(vehicleType.equals("2-wheeler")) {
			newPremiumamt=2000-(premiumAmount/20);
		}
		else {
			newPremiumamt=5000-(premiumAmount/20);
		}
	
		Vehicleinsurance VI=new Vehicleinsurance(UID,policyNo,vehicleNo,vehicleType,customerName,engineNo,chasissNo,phoneNo,insuranceType,newPremiumamt,Date.valueOf(LocalfromDate),Date.valueOf(LocaltoDate));
		try {
			
			boolean flag=Connectvehicleinsurance.CreateVehicleInsurance(VI);
			if(flag) {
					String rajeev="Successfully Renewed "+" "+policyNo;
					request.setAttribute("rajeev", rajeev);
				RequestDispatcher rd=request.getRequestDispatcher("RenewPolicybyId.jsp");
				rd.include(request, response);
			}
			else {
				response.setContentType("text/html");
				out.println("Failed to Renewed Policy");
				RequestDispatcher rd=request.getRequestDispatcher("RenewPolicybyId.jsp");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
