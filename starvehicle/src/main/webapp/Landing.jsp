<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Home: Star Protect Vehicle System</title>
    <link rel="stylesheet" href='https://fonts.googleapis.com/css2?family=Poppins&display=swap'>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <style>
      * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: "Poppins", sans-serif;
      }

      :root {
        --primary-color: #c6c3c3;
        --second-color: #ffffff;
        --black-color: #000000;
      }

      body {
        background-image: url("background7.jpg");
        background-position: center;
        background-size: cover;
        background-repeat: no-repeat;
        background-attachment: fixed;
      }

      .container {
        width: 100%;
        min-height: 100vh;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        align-items: center;
        background-color: rgba(0, 0, 0, 0.2);
      }

      .header {
        width: 100%;
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 15px 50px;
        background-color: rgba(0, 0, 0, 0.5);
      }

      .header h1 {
        color: var(--primary-color);
      }

      .header .nav-buttons {
        display: flex;
        gap: 10px;
      }

      .header button {
        border: none;
        background-color: var(--primary-color);
        color: var(--black-color);
        border-radius: 10px;
        padding: 10px 20px;
        cursor: pointer;
        transition: background-color 0.3s;
      }

      .header button:hover {
        background-color: green;
        color:white;
        border:none;
        
      }

      .content {
        width: 80%;
        text-align: center;
        backdrop-filter: blur(7px);
        color: var(--second-color);
        background-color: rgba(0, 0, 0, 0.5);
        padding: 50px;
        border-radius: 20px;
      }

      .footer {
        width: 100%;
        padding: 10px;
        text-align: center;
        color: var(--primary-color);
        background-color: rgba(0, 0, 0, 0.5);
      }
      
    </style>
  </head>
  
  <body>
    <div class="container">
      <div class="header">
        <h1 style="color: #ebbf2c;">SPVS</h1>
        <div class="nav-buttons">
          <a href="admin.jsp" ><button>Admin Login</button></a>
          <a href="UnderwriterLoginPage.jsp"><button>UnderWriter Login</button></a>
        </div>
      </div>

      <div class="content">
        <h1 style="color: #ebbf2c;">STAR PROTECT Vehicle System</h1>
        <br>
        <h4>A vehicle management system using Java, UI, JDBC, JSP, and Servlets</h4>

      </div>

      <div class="footer">
        <p>Web Application designed by Group 12</p>
      </div>
    </div>
  </body>
</html>
