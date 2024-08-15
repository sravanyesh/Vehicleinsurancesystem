<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RenewalPolicy</title>
</head>
<style>
    .policy-details {
        margin-top: 20px;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
      body {
            font-family: "Poppins", sans-serif;
            background-image: url("background6.jpg");
            background-color: #f4f4f4;
            background-position: center;
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            height: auto;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 30px;
        }
        .container {
            background: rgba(255, 255, 255, 0.7); 
            backdrop-filter: blur(10px);
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            width: 400px;
            margin: 0 auto;
        }
        ul {
            list-style: none;
            padding: 0;
        }
        li {
            padding: 8px;
            font-size: 16px;
            margin-bottom: 10px;
        }
        .navigation {
            margin-top: 20px;
            text-align: center;
        }
    .btn {
        color: white;
        background-color: #0275d8;
        padding: 10px 15px;
        border-radius: 4px;
        text-decoration: none;
        margin-right: 10px;
        border:none;
        font-size:medium;
    }
    .btn:hover {
        background-color: #025aa5;
    }
        h2 {
        text-align: center;
    }
    .btn_up{
    
   }
</style>
<body>
<%

String policyNo=(String)session.getAttribute("policyNo");
String vehicleno=(String)session.getAttribute("vehicle");
String vehicleType=(String)session.getAttribute("vehicleType");
String customerName=(String)session.getAttribute("customerName");
int engineNo=(int)session.getAttribute("engineNo");
int chasissNo=(int)session.getAttribute("chasissNo");
long phoneNo=(long)session.getAttribute("phoneNo");
String insuranceType=(String)session.getAttribute("insuranceType");
int premiumAmount=(int)session.getAttribute("premiumAmount");
String fromDate=(String)session.getAttribute("fromDate");
String toDate=(String)session.getAttribute("toDate");

%>
 <div id="policyDetails" class="container">
            <!-- Policy details will be displayed here -->
            <ul>
            <h2 >Policy Details</h2>
            <li>PolicyNo:<%=policyNo %></li>
            <li>VehicleNo:<%=vehicleno %></li>
             <li>VehicleType:<%=vehicleType %></li>
            <li>CustomerName:<%=customerName %></li>
            <li>EngineNo:<%=engineNo %></li>
            <li>ChasissNo:<%=chasissNo %></li>
            <li>PhoneNo:<%=phoneNo %></li>
            <li>InsuranceType:<%=insuranceType %></li>
            <li>PremiumAmount:<%=premiumAmount %></li>
            <li>FromDate:<%=fromDate %></li>
            <li>ToDate:<%=toDate %></li>
            <div class="navigation">
        <form action="Renewpolicyconformation" method="post">
        <input type="submit" value="Renew" class="btn btn_up" >    
      <a href="RenewPolicybyId.jsp" class="btn">cancel</a>
        
        </form>
        </div>
            </ul>
        </div>
        

</body>
</html>