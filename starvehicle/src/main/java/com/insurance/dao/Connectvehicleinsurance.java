package com.insurance.dao;
import com.insurance.dao.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import javax.servlet.ServletException;

import com.insurance.model.Underwriter;
import com.insurance.model.Vehicleinsurance;

public class Connectvehicleinsurance {
	public static Underwriter getunderwritercredintials(String Id) {
		Underwriter underwriter=null;
		try {
			
			Connection con=null;
			 con=ConnectDao.getConnection();
			String sql="select underwriterId,password from Underwriter where underwriterId=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, Id);
			ResultSet rs=pstmt.executeQuery();
			String underwriterId_db=rs.getString("underwriterId");
			String Password_db=rs.getString("password");
			underwriter=new Underwriter(underwriterId_db,null,null,null,Password_db);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return underwriter;
	}
	//Create table for policy
	public static void CreateVehicleInsuranceTable() {
	
		try {
			
			Connection con=null;
			con=ConnectDao.getConnection();
			String sql="create table if not exists Vehicleinsurance(\r\n"
					+ "policyNo varchar(20) PRIMARY KEY,\r\n"
					+ "vehicleNo varchar(20),\r\n"
					+ "vehicleType varchar(20),\r\n"
					+ "customerName varchar(20),\r\n"
					+ "engineNo INT,\r\n"
					+ "chasissNo INT,\r\n"
					+ "phoneNo BIGINT,\r\n"
					+ "insuranceType varchar(20),\r\n"
					+ "premiumAmount INT,\r\n"
					+ "fromDate date,\r\n"
					+ "toDate date,\r\n"
					+ "underwriterId varchar(10),\r\n"
					+ " UNIQUE(policyNo),\r\n"
					+ "FOREIGN KEY (underwriterId) references Underwriter(underwriterId)\r\n"
					+ ")";
					
			Statement stmt=con.createStatement();
			stmt.execute(sql);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// insert into vehicle insurance table
	public static boolean CreateVehicleInsurance(Vehicleinsurance VI) throws SQLException {
		CreateVehicleInsuranceTable();
		String policyId=VI.getPolicyNo();
		String vehicleNo=VI.getVehicleNo();
		String vehicleType=VI.getVehicleType();
		String customerName=VI.getCustomerName();
		int engineNo=VI.getEngineNo();
		int chasissNo=VI.getChassisNo();
		long phoneNo=VI.getPhoneNo();
		String insuranceType=VI.getType();
		int premiumAmount=VI.getPremiumAmt();
		Date fromDate=VI.getFromDate();
		Date toDate=VI.getToDate();
		String ID=VI.getUnderwriterid();
		String sql="INSERT INTO Vehicleinsurance(policyNo,vehicleNo,vehicleType,customerName,engineNO,chasissNo,phoneNo,insuranceType,premiumAmount,fromDate,toDate,underwriterId)\r\n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)\r\n"
				+ "";
		Connection con=null;
		boolean b=false;
		con=ConnectDao.getConnection();
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, policyId);
		pstmt.setString(2, vehicleNo);
		pstmt.setString(3, vehicleType);
		pstmt.setString(4, customerName);
		pstmt.setInt(5, engineNo);
		pstmt.setInt(6,chasissNo);
		pstmt.setLong(7, phoneNo);
		pstmt.setString(8, insuranceType);
		pstmt.setInt(9, premiumAmount);
		pstmt.setDate(10, fromDate);
		pstmt.setDate(11, toDate);
		pstmt.setString(12, ID);
		pstmt.execute();
		 b=true;
		con.close();
		return b;
	}
	//view all policies
	 public static List<Vehicleinsurance> viewallpolicies() {
		List<Vehicleinsurance> VI=new ArrayList<Vehicleinsurance>();
		
		Connection con=null;
		try {
			con=ConnectDao.getConnection();
			String sql="select * from Vehicleinsurance";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
		
			Vehicleinsurance policy=null;
			while(rs.next()) {
				policy=new Vehicleinsurance();
				policy.setPolicyNo(rs.getString(1));
				policy.setVehicleNo(rs.getString(2));
				policy.setVehicleType(rs.getString(3));
				policy.setCustomerName(rs.getString(4));
				policy.setEngineNo(rs.getInt(5));
				policy.setChassisNo(rs.getInt(6));
				policy.setPhoneNo(rs.getLong(7));
				policy.setType(rs.getString(8));
				policy.setPremiumAmt(rs.getInt(9));
				policy.setFromDate(rs.getDate(10));
				policy.setToDate(rs.getDate(11));
				policy.setUnderwriterid(rs.getString(12));
				VI.add(policy);
					
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return VI;
		
	}
	 //check policy exists or not
	 public static boolean FetchpolicyId(String policyId)  {
		 boolean flag=false;
		 String sql="select policyNo from Vehicleinsurance where policyNo=?";
		 Connection con=null;
		 try {
			con=ConnectDao.getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, policyId);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
			String policyId_db=rs.getString("policyNo");
		     if(policyId_db.equals(policyId)) {
				flag=true;
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {  
            if(con!= null) {
                try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }}
		 
		 
		 return flag;
	 }
	 //Fetch type of insurance
	 public static String Fetchinsurancetype(String policyId) {
		 String insuranceType="";
		 String sql="select insuranceType from Vehicleinsurance where policyNo=?";
		 Connection con=null;
		 try {
			con=ConnectDao.getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, policyId);
			ResultSet rs=pstmt.executeQuery();
			insuranceType=rs.getString(1);
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 return insuranceType;
	 }
	 //Update Insurance Type
	 public static boolean Updateinsurancetype(String policyId,String UID) {
		 String sql="update Vehicleinsurance set insuranceType='Third Party' where policyNo=? AND underwriterId=?";
		 int rowseffected=0;
		 boolean flag=false;
		 Connection con=null;
		 try {
			
			con=ConnectDao.getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, policyId);
			pstmt.setString(2, UID);
			rowseffected=pstmt.executeUpdate();
			if(rowseffected>0) {
				flag=true;
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return flag;
		 
	 }
	 
	 
	 //view policy by id
	 public static Vehicleinsurance viewpoliciesbyID(String ID,String UID) {
			Vehicleinsurance policy=null;
			
			Connection con=null;
			try {
				con=ConnectDao.getConnection();
				String sql="select * from Vehicleinsurance where policyNo=? AND underwriterId=?";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1, ID);
				pstmt.setString(2, UID);
				ResultSet rs=pstmt.executeQuery();
			
			
				if(rs.next()) {
					policy=new Vehicleinsurance();
					policy.setPolicyNo(rs.getString(1));
					policy.setVehicleNo(rs.getString(2));
					policy.setVehicleType(rs.getString(3));
					policy.setCustomerName(rs.getString(4));
					policy.setEngineNo(rs.getInt(5));
					policy.setChassisNo(rs.getInt(6));
					policy.setPhoneNo(rs.getLong(7));
					policy.setType(rs.getString(8));
					policy.setPremiumAmt(rs.getInt(9));
					policy.setFromDate(rs.getDate(10));
					policy.setToDate(rs.getDate(11));
					policy.setUnderwriterid(rs.getString(12));
						
				}
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return policy;
			
		}
	 
	 // view policy by vehicle No
	 public static Vehicleinsurance viewpoliciesbyVehicleno(String No,String UID) {
			Vehicleinsurance policy=null;
			
			Connection con=null;
			try {
				con=ConnectDao.getConnection();
				String sql="select * from Vehicleinsurance where vehicleNo=? AND underwriterId=?";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1, No);
				pstmt.setString(2, UID);
				ResultSet rs=pstmt.executeQuery();
			
			
				if(rs.next()) {
					policy=new Vehicleinsurance();
					policy.setPolicyNo(rs.getString(1));
					policy.setVehicleNo(rs.getString(2));
					policy.setVehicleType(rs.getString(3));
					policy.setCustomerName(rs.getString(4));
					policy.setEngineNo(rs.getInt(5));
					policy.setChassisNo(rs.getInt(6));
					policy.setPhoneNo(rs.getLong(7));
					policy.setType(rs.getString(8));
					policy.setPremiumAmt(rs.getInt(9));
					policy.setFromDate(rs.getDate(10));
					policy.setToDate(rs.getDate(11));
					policy.setUnderwriterid(rs.getString(12));
						
				}
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return policy;
			
		}
	 public static List<List<String>> FetchVehicleSpecificUnderWriters(String ID) { 
		    List<List<String>> totallist = new ArrayList<>();
		    String sql = "SELECT U.underwriterId, U.name AS underwriterName, U.joiningDate AS underwriterDateOfJoining, V.vehicleNo, V.premiumAmount, V.fromDate, V.toDate "
		                 + "FROM UnderWriter U JOIN Vehicleinsurance V ON U.underwriterId = V.underwriterId WHERE U.underwriterId = ?";
		    try (Connection con = ConnectDao.getConnection();
		         PreparedStatement pstmt = con.prepareStatement(sql)) {
		        pstmt.setString(1, ID);
		        try (ResultSet rs = pstmt.executeQuery()) {
		            while (rs.next()) {
		                List<String> list = new ArrayList<>();
		                list.add(rs.getString("underwriterId"));
		                list.add(rs.getString("underwriterName"));
		                list.add(rs.getString("vehicleNo"));
		                list.add(rs.getString("premiumAmount"));
		                list.add(String.valueOf(rs.getDate("fromDate")));
		                list.add(String.valueOf(rs.getDate("toDate")));
		                System.out.println(rs.getString("premiumAmount"));
		                totallist.add(list);
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return totallist;
		}

}
