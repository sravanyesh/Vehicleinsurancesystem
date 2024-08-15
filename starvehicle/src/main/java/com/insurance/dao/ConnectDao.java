package com.insurance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import com.insurance.model.Underwriter;

public class ConnectDao {
    public static Connection connection=null;
    
    //Create Data base Connection 
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String jdbcURL = "jdbc:sqlite:C:\\Users\\dell\\MySQLiteDB";
            connection = DriverManager.getConnection(jdbcURL);
            System.out.println("connection Established");
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }
        System.out.println(connection);
       
        return connection;
      }
     
    //Creating Table
     public static void createTables(Connection conn) throws SQLException {
            try {
                String inp="CREATE TABLE IF NOT EXISTS Underwriter(underwriterId VARCHAR(30) PRIMARY KEY,name VARCHAR(30),"
                        + "dateOfBirth VARCHAR(30),joiningDate VARCHAR(30),password VARCHAR(30))";
                Statement stm = conn.createStatement();
                stm.execute(inp);
            }catch(SQLException e) {
                System.out.println("create table error");
            }
        }
     
     //Underwriter Registration 
     public static void underwriterRegister(Underwriter u) throws SQLException {
         Connection con=null;
         try {
             con=getConnection();   
             createTables(con);    
                String inp= "INSERT INTO Underwriter (underwriterId,name,dateOfBirth,joiningDate,password) VALUES (?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(inp);
                ps.setString(1,u.getUnderwriterId());
                ps.setString(2,u.getName());
                ps.setString(3,u.getDateOfBirth());
                ps.setString(4,u.getJoiningDate());
                ps.setString(5,String.valueOf(AutoGenerate.generatePassword()));
                ps.execute();
                con.close();
            }catch(Exception e){
                 System.out.println(e);
             }finally {  
                 if(con!= null) {
                     con.close();
                 }}}
     public static void vehicleinsurance() throws SQLException,ServletException{
    	 Connection con=null;
    	 con=getConnection();
    	 String sql="";
    	 
     }
     
   //get last Underwriter id
     public static String lastUnderwriterId() {
         Connection con=null;
         String a=null;
         try {
            con=getConnection();
            String inputQuerry="SELECT underwriterId FROM Underwriter ORDER BY underwriterId DESC LIMIT 1";
            Statement pstm=con.createStatement();
            ResultSet rs=pstm.executeQuery(inputQuerry);
            a=rs.getString(1);
            con.close();
         }catch(Exception e) {
             System.out.println(e);
         }
         if(a!=null) {
             return a;}
             else
             	return "INC-00000";
         
     
     
     }
     public static String lastPolicyId() {
         Connection con=null;
         String a=null;
         try {
            con=getConnection();
            String inputQuerry="SELECT policyNo FROM Vehicleinsurance ORDER BY policyNo DESC LIMIT 1";
            Statement pstm=con.createStatement();
            ResultSet rs=pstm.executeQuery(inputQuerry);
            a=rs.getString(1);
            con.close();
         }catch(Exception e) {
             System.out.println(e);
         }
         if(a!=null) {
             return a;}
             else
             	return "p-00000";
         
     
     
     }
     public static void displayRecords(Connection con) throws SQLException
 	{
    	 
    	 try {
             con=getConnection();
             
          }catch(Exception e) {
              System.out.println(e);
          }
 		String sql = "select underwriterId,name,dateOfBirth,joiningDate from Underwriter";
 		Statement stmt = connection.createStatement();
 		
 		ResultSet resultObj = stmt.executeQuery(sql);
 		
 		while(resultObj.next())
 		{
 			System.out.println(String.format("ID: %d", resultObj.getInt("underwriterId")));
 			System.out.println(String.format("Name: %s", resultObj.getString("name")));
 			System.out.println(String.format("Age: %d", resultObj.getInt("dateOfBirth")));
 			System.out.println(String.format("Salary: %d", resultObj.getInt("joiningDate")));
 		}
 	}
    //Search Underwriter
     public static Underwriter findUnderwriterById(String id)  {
         Connection conn=null;
         Underwriter underwriter=null;
         ResultSet rs=null;
         try {
            conn=getConnection();
            PreparedStatement pstm=conn.prepareStatement("SELECT underwriterId,name,dateOfBirth,joiningDate FROM Underwriter WHERE underwriterId=?");
            pstm.setString(1, id);
            rs=pstm.executeQuery();
           if(rs.next())
   underwriter=new Underwriter(rs.getString("underwriterId"), rs.getString("name"), rs.getString("dateOfBirth"),  rs.getString("joiningDate"),null);
          conn.close();
         }catch(Exception e) {
             System.out.println(e);
             System.out.println("search Underwriter issue");
             
         }
//         underwriter.setUnderwriterId(rs.getString("underwriterId"));
//         underwriter.setName(rs.getString("name"));
//         underwriter.setDateOfBirth(rs.getString("dateOfBirth"));
//         underwriter.setJoiningDate(rs.getString("joiningDate"));
        return underwriter;
     }
   //Update Underwriter
     public static int updateUnderwriter(String id,String pwd) {
    	 int rows=0;
         Connection conn=null;
         Boolean b=false;
         try {
             conn=getConnection();
             PreparedStatement pstm=conn.prepareStatement("UPDATE Underwriter SET password=? WHERE UnderwriterId=?");
             pstm.setString(1,pwd);
             pstm.setString(2,id);
             rows=pstm.executeUpdate();
             conn.close();
             
             
         }catch(Exception e) {
             System.out.println(e);
             System.out.println("update Underwriter issue");
         }
         return rows;
         
         
     }
     public static List<Underwriter> viewallunderwriters() {
    	 Connection con=null;
    	List<Underwriter> underwriters=new ArrayList<Underwriter>();
    	//underwriters=null;
    	 
    	 try {
    		 con=getConnection();
    		 System.out.println("asjfh");
    		 Statement stmt=con.createStatement();
    		 ResultSet rs=stmt.executeQuery("select underwriterId,name,dateOfBirth,joiningDate from Underwriter");
    		 Underwriter underwriter=null;
    		 while (rs.next()) {
               underwriter=new Underwriter(); 
                 underwriter.setUnderwriterId(rs.getString(1));
                 underwriter.setName(rs.getString(2));
                 underwriter.setDateOfBirth(rs.getString(3));
                 underwriter.setJoiningDate(rs.getString(4));
                 
                 underwriters.add(underwriter);
            }
    		
    		 con.close();
    	 }
    	 catch(Exception e) {
    		 e.printStackTrace();
    		 
    	 }
    	 
    	 
    	 
    	 return underwriters;
    	 
     }
   //Delete Underwriter
     public static int deleteUnderwriter(String d) {
            
         int status = 0;
             
             try {
                 Connection conn=getConnection();
                 PreparedStatement ps = conn.prepareStatement("DELETE FROM Underwriter WHERE underwriterId=?");
                 ps.setString(1,d);
                 status = ps.executeUpdate();
                 conn.close();
             } catch (Exception e) {
                 e.printStackTrace();
             }
             return status;
         }
 	
   
     

}