package com.insurance.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class AutoGenerate {

	//Generate Id for Underwriter
    public static String generateId() {
        
        int num=removeINC(ConnectDao.lastUnderwriterId());
    if(num==0) {
    
        return String.format("INC-"+"%05d",1);
    }else {
        return String.format("INC-"+"%05d",num+1);
    }
  }
    public static String generatePolicyID() {
        
        int num=removeINC(ConnectDao.lastPolicyId());
    if(num==0) {
    
        return String.format("P-"+"%05d",1);
    }else {
        return String.format("P-"+"%05d",num+1);
    }
  }
  //remove INC- from id and give the last number
    public static int removeINC(String underwriterId) {
        String numricPart=underwriterId.substring(underwriterId.indexOf("-")+1);
       return Integer.parseInt(numricPart);    
    }
   
        public static char[] generatePassword() 
        {  
            int len=7;
            String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
            String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
            String numbers = "0123456789"; 
            String values =Capital_chars+Small_chars+numbers; 
            Random rndm_method = new Random(); 
            char[] password = new char[len]; 
            for (int i = 0; i < len;i++) 
            { 
             password[i] = values.charAt(rndm_method.nextInt(values.length())); 
            } 
            return password; 
        } 
        
        public static boolean ValidateDate(String date) {
        	LocalDate now = LocalDate.now();
    		Date currentDate = Date.valueOf(now);
    		int comparison = Date.valueOf(date).compareTo(currentDate);
    		if(comparison<0) {
    			return true;
    		}
    		
    		return false;
        }
        
        public static boolean isValidAlphanumeric(String str) {
            // Check if the string meets the length requirement
            if (str.length() < 5) {
                return false;
            }

            // Regular expression to check if the string is alphanumeric
            String alphanumericRegex = "^[a-zA-Z0-9]+$";

            // Return true if the string matches the alphanumeric pattern, otherwise false
            return str.matches(alphanumericRegex);
        }
        
    }



