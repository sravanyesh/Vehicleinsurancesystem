<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UnderWriter Details</title>
    <style>
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
        .navigation a {
            color: white;
            background-color: #0275d8;
            padding: 10px 15px;
            border-radius: 4px;
            text-decoration: none;
            margin-right: 10px;
        }
        .navigation a:hover {
            background-color: #025aa5;
        }
        h2 {
        text-align: center;
    }
    </style>
</head>
<body>
<%

String policyNo=(String)request.getAttribute("policyNo");
String vehicleno=(String)request.getAttribute("vehicleno");
String vehicleType=(String)request.getAttribute("vehicleType");
String customerName=(String)request.getAttribute("customerName");
int engineNo=(int)request.getAttribute("engineNo");
int chasissNo=(int)request.getAttribute("chasissNo");
long phoneNo=(long)request.getAttribute("phoneNo");
String insuranceType=(String)request.getAttribute("insuranceType");
int premiumAmount=(int)request.getAttribute("premiumAmount");
String fromDate=(String)request.getAttribute("fromDate");
String toDate=(String)request.getAttribute("toDate");

%>
<div class="container">
    <h2>Policy Details</h2>
    <ul>
            <li>Policy No:      <%=policyNo %></li>
            <li>Vehicle No:     <%=vehicleno %></li>
            <li>Vehicle Type:   <%=vehicleType %></li>
            <li>Customer Name:  <%=customerName %></li>
            <li>Engine No:      <%=engineNo %></li>
            <li>Chassis No:     <%=chasissNo %></li>
            <li>Phone No:       <%=phoneNo %></li>
            <li>Insurance Type: <%=insuranceType %></li>
            <li>Premium Amount: <%=premiumAmount %></li>
            <li>From Date:      <%=fromDate %></li>
            <li>To Date:        <%=toDate %></li>
    </ul>
    <div class="navigation">
    	
        <a href="Searchpolicy.jsp">Back</a>
        
    </div>
</div>
</body>
</html>
