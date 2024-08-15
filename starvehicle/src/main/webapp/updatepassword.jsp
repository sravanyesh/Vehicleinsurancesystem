<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Update UnderWriter Password</title>
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
    input[type=text], input[type=password], input[type=submit] {
        width: 100%;
        padding: 10px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    input[type=submit] {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    input[type=submit]:hover {
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
     .alert {
            padding: 15px;
            margin: 20px;
            border-radius: 5px;
            font-size: 16px;
            position: relative;
            background-color: #4CAF50; /* Success color */
            color: #fff; /* Text color */
        }

        .close-alert {
            position: absolute;
            top: 50%;
            right: 10px;
            transform: translateY(-50%);
            cursor: pointer;
            color: #fff; /* Close button color */
        }

       
        .close-alert:hover {
            color: #ccc; /* Close button hover color */
        }
            .warning {
            background-color: #ff9800; /* Warning color */
            color: #fff; /* Text color */
        }
</style>
</head>
<body>
<div class="container">
<%@include file="Message.jsp" %>
    <h2>Update UnderWriter Password</h2>
    <form action="Updateunderwriter" method="post">
        <label for="underWriterID">Enter UnderWriter ID:</label>
        <input type="text" id="underWriterID" name="U_ID" placeholder="Enter ID here" required>

        <label for="password">New Password:</label>
        <input type="password" id="password" name="U_Password" placeholder="Enter new password" required>
        
         <label for="password">Confirm Password:</label>
        <input type="password" id="password" name="Con_pass" placeholder="Confirm password" required>
        


        <input type="submit" value="Update Password">
    </form>  

    <div class="navigation">
     
        <a href="u3.jsp">Back to Menu</a>
    </div>
</div>
</body>
</html>