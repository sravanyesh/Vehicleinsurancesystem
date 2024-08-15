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
import com.insurance.model.Vehicleinsurance;

/**
 * Servlet implementation class Renewpolicy
 */
@WebServlet("/Renewpolicy")
public class Renewpolicy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Renewpolicy() {
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
		String policyId=request.getParameter("policyNo");
		String UID=(String) session.getAttribute("UID");
		
		boolean checkpolicyId=Connectvehicleinsurance.FetchpolicyId(policyId);
		if(checkpolicyId) {
			Vehicleinsurance vi=new Vehicleinsurance();
			vi=Connectvehicleinsurance.viewpoliciesbyID(policyId,UID);
			if(vi!=null) {
			String policyNo=vi.getPolicyNo();
			String vehicleNo=vi.getVehicleNo();
			System.out.println(vehicleNo);;
			String vehicleType=vi.getVehicleType();
			String customerName=vi.getCustomerName();
			int engineNo=vi.getEngineNo();
			int chasissNo=vi.getChassisNo();
			long phoneNo=vi.getPhoneNo();
			String insuranceType=vi.getType();
			int premiumAmount=vi.getPremiumAmt();
			String fromDate=String.valueOf(vi.getFromDate());
			String toDate=String.valueOf(vi.getToDate());
			session.setAttribute("policyNo",policyNo);
			session.setAttribute("vehicle",vehicleNo);
			session.setAttribute("vehicleType",vehicleType);
			session.setAttribute("customerName",customerName);
			session.setAttribute("engineNo",engineNo);
			session.setAttribute("chasissNo",chasissNo);
			session.setAttribute("phoneNo",phoneNo);
			session.setAttribute("insuranceType",insuranceType);
			session.setAttribute("premiumAmount",premiumAmount);
			session.setAttribute("fromDate",fromDate);
			session.setAttribute("toDate",toDate);
			RequestDispatcher rd=request.getRequestDispatcher("ConfirmPolicyforRenewal.jsp");
			rd.forward(request, response);
			}
			else {
				request.setAttribute("RRpolicy" , "Incorrect policy details");
				RequestDispatcher rd=request.getRequestDispatcher("RenewPolicybyId.jsp");
				rd.include(request, response);
			}
		}
		else {
			request.setAttribute("Rpolicy","Invalid PolicyNo Try again" );
			RequestDispatcher rd=request.getRequestDispatcher("RenewPolicybyId.jsp");
			rd.include(request, response);;
			
		}
	}

}
