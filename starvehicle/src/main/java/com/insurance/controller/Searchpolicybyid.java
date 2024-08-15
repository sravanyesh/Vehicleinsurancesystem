package com.insurance.controller;
import java.sql.Date;
import java.text.SimpleDateFormat;

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
import com.insurance.model.Vehicleinsurance;

/**
 * Servlet implementation class Searchpolicybyid
 */
@WebServlet("/Searchpolicybyid")
public class Searchpolicybyid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Searchpolicybyid() {
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
		String vehicleNo="";
		String policyId="";
		policyId=request.getParameter("policyId");
		vehicleNo=request.getParameter("vehicleNo");
		HttpSession session=request.getSession();
		String UID=(String) session.getAttribute("UID");
		int policylength=policyId.length();
		int vehicleNolength=vehicleNo.length();
		Vehicleinsurance vi=null;
		if(policylength>0 && vehicleNolength==0) {
			vi=Connectvehicleinsurance.viewpoliciesbyID(policyId,UID);
			
		}
		else if(policylength==0 && vehicleNolength>0) {
			vi=Connectvehicleinsurance.viewpoliciesbyVehicleno(vehicleNo,UID);
			
		}
		else if(policylength>0 && vehicleNolength>0) {
			vi=Connectvehicleinsurance.viewpoliciesbyID(policyId,UID);
		}
		else {
			vi=Connectvehicleinsurance.viewpoliciesbyID(policyId,UID);
			
		}
		if(vi==null) {
			request.setAttribute("Nosearch", "No Policy exists");
			RequestDispatcher rd=request.getRequestDispatcher("Searchpolicy.jsp");
			rd.forward(request, response);
			
		}
		else {
			String policyNo=vi.getPolicyNo();
			String vehicleno=vi.getVehicleNo();
			String vehicleType=vi.getVehicleType();
			String customerName=vi.getCustomerName();
			int engineNo=vi.getEngineNo();
			int chasissNo=vi.getChassisNo();
			long phoneNo=vi.getPhoneNo();
			String insuranceType=vi.getType();
			int premiumAmount=vi.getPremiumAmt();
			String fromDate=String.valueOf(vi.getFromDate());
			String toDate=String.valueOf(vi.getToDate());
			request.setAttribute("policyNo",policyNo);
			request.setAttribute("vehicleno",vehicleno);
			request.setAttribute("vehicleType",vehicleType);
			request.setAttribute("customerName",customerName);
			request.setAttribute("engineNo",engineNo);
			request.setAttribute("chasissNo",chasissNo);
			request.setAttribute("phoneNo",phoneNo);
			request.setAttribute("insuranceType",insuranceType);
			request.setAttribute("premiumAmount",premiumAmount);
			request.setAttribute("fromDate",fromDate);
			request.setAttribute("toDate",toDate);
			RequestDispatcher rd=request.getRequestDispatcher("PrintPolicy.jsp");
			rd.forward(request, response);
			
		}
		
	}

}
