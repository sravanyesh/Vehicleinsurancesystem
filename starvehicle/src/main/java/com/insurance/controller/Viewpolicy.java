package com.insurance.controller;
import com.insurance.model.*;
import com.insurance.dao.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insurance.dao.ConnectDao;

/**
 * Servlet implementation class Viewpolicy
 */
@WebServlet("/viewpolicy")
public class Viewpolicy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewpolicy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		List<Vehicleinsurance> policy_list=new ArrayList<Vehicleinsurance>();
		policy_list=Connectvehicleinsurance.viewallpolicies();
		out.print("<table border='1' width='100%'  ");
	    out.print("<tr><th>PolicyNo</th><th>VehicleNo</th><th>VehicleType</th><th>Customername</th><th>EngineNo</th><th>ChasissNo</th><th>PhoneNo</th><th>InsuranceType</th><th>PremiumAmount</th><th>FromDate</th><th>Todate</th></tr>");
	    for (Vehicleinsurance s:policy_list) {
	    out.print("<tr><td>"+s.getPolicyNo()+"</td><td>"+s.getVehicleNo()+"</td><td>"+s.getVehicleType()+"</td><td>"+s.getCustomerName()+"</td><td>"+s.getEngineNo()+"</td><td>"+s.getChassisNo()+"</td><td>"+s.getPhoneNo()+"</td><td>"+s.getType()+"</td><td>"+s.getPremiumAmt()+"</td><td>"+s.getFromDate()+"</td><td>"+s.getToDate()+"</td></tr>"); }       
	    out.print("</table>");
	    out.print("<a href='UnderwriterMenu.jsp'>MENU</a>");
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
