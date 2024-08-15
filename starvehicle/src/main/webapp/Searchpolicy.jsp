<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>View Policy</title>
<style>
    body {
        font-family: "Poppins", sans-serif;
        background-image: url("background6.jpg");
        background-color: #f4f4f4;
        background-position: center;
        background-size: cover;
        background-repeat: no-repeat;
        background-attachment: fixed;
        height: 100%;
        display: flex;
        align-items: center;
        justify-content: center;
        padding: 60px;
        margin: 0; /* Remove default margin */
        overflow: hidden; 
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
    input[type=text], button {
        width: 100%;
        padding: 10px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    button {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    button:hover {
        background-color: #45a049;
    }
    h2 {
        text-align: center;
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
     .close-alert {
            position: fixed;
            top: 10%;
            right: 28px;
            transform: translateY(-50%);
            cursor: pointer;
            
            border-radius:4px;
            color: #fff; /* Close button color */
        }
        /* Hover effect for close button */
        .close-alert:hover {
            color: #ccc; /* Close button hover color */
        }
            .warning {
            background-color: #ff9800;
            color: #fff;
            padding:8px;
            border-radius:4px;
        }
</style>
</head>
<body>
<div class="container">
<%@ include file="Message.jsp" %>
    <h2>View Policy by ID</h2>
    <form action="Searchpolicybyid" method="post">
        <label for="vehicleNo">Vehicle Number:</label>
        <input type="text" id="vehicleNo" name="vehicleNo" maxlength="10" placeholder="Enter Vehicle Number">

        <label for="policyId">Policy ID:</label>
        <input type="text" id="policyId" name="policyId" maxlength="10" placeholder="Enter Policy ID">

        <button type="submit">View Policy</button>  

        <div class="navigation">
        
            <a href="UnderwriterMenu.jsp">Back to Menu</a>
        </div>
    </form>  
</div>
</body>
</html>
