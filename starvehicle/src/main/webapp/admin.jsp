<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Admin Login Page</title>
    <link rel="stylesheet" href='https://fonts.googleapis.com/css2?family=Poppins&display=swap'>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<style>
* {
    margin: 0;
    padding 0;
    box-sizing: border-box;
    font-family: "Poppins", sans-serif;
}



:root 
{
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

a {
    text-decoration: none;
    color: var(--second-color);
}

a:hover {
    text-decoration: underline;
}

.wrapper {
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background-color: rgba(0,0,0,0.2);
}

.login_box {
    position: relative;
    width: 450  px;
    backdrop-filter: blur(25px);
    border: 2px solid var(--primary-color);
    border-radius: 15px;
    padding: 7.5em 2.5em 4em 2.5em;
    color: var(--second-color);
    box-shadow: 0px 0px 10px 2px rgba(0,0,0,0.2);    
}

.login-header {
    position: absolute;
    top: 0;
    left: 50%;
    transform: translateX(-50%);
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: var(--primary-color);
    width: 225px;
    height: 75px;
    border-radius: 0 0 20px 20px;
}

.login-header span {
    font-size: 25px;
    color: var(--black-color);
}

.login-header::before{
    content: "";
    position: absolute;
    top: 0;
    left: -30px;
    width: 30px;
    height: 30px;
    border-top-right-radius: 50%;
    background: transparent;
    box-shadow: 15px 0 0 0 var(--primary-color);
}

.login-header::after {
    content: "";
    position: absolute;
    top: 0;
    right: -30px;
    width: 30px;
    height: 30px;
    border-top-left-radius: 50%;
    background: transparent;
    box-shadow: -15px 0 0 0 var(--primary-color);
}

.input_box {
    position: relative;
    display: flex;
    flex-direction: column;
    margin: 25px 0;
}

.input-field {
    width: 100%;
    height: 55px;
    font-size: 16px;
    background: transparent;
    color: var(--second-color);
    padding-inline: 20px 50px;
    border: 2px solid var(--primary-color);
    border-radius: 30px;
    outline: none;
}

#user {
    margin-bottom: 10px;
}

.label {
    position: absolute;
    top: 15px;
    left: 20px;
    transition: .2s;
}

.input-field:focus ~ .label,
.input-field:valid ~ .label {
    position: absolute;
    top: -10px;
    left: 20px;
    font-size: 14px;
    background-color: var(--primary-color);
    border-radius: 30px;
    color: var(--black-color);
    padding: 0 10px;
}   

i {
    position: absolute;
    top: 18px;
    right: 25px;
    font-size: 20px;
}

.input-submit {
    width: 100%;
    height: 40px;
    background: #ececec;
    font-size: 16px;
    font-weight: 500;
    border: none;
    border-radius: 30px;
    cursor: pointer;
    transition: 0.3s;
}

.input-submit:hover {
    background: #636bda;
    /*background: var(--second-color);*/
}

.register {
    text-align: center;
}

.register a {
    font-weight: 500;
}

@media only screen and(max-width: 564px) {
    .wrapper {
        padding: 20px;
    }

    .login-box {
        padding: 7.5em 1.5em 4em 1.5em;
    }
    
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

        /* Hover effect for close button */
        .close-alert:hover {
            color: #ccc; /* Close button hover color */
        }
            .warning {
            background-color: #ff9800; /* Warning color */
            color: #fff; /* Text color */
        }

</style>

  </head>
  <%@ include file="Message.jsp" %>
  <body>
<form action="add" method="post">
    <div class="wrapper">
        <div class="login_box">
            <div class="login-header">
                <span>Admin Login</span>
            </div>
        
        
            <div class="input_box">
                <input type="text" id="user" class="input-field"
                required name="username">
                <label for="user" class="label">Username</label>
                <i class='bx bxs-user'></i>
            </div>

            <div class="input_box">
                <input type="password" id="pass" class="input-field"
                required name="password">
                <label for="pass" class="label">Password</label>
                <i class='bx bxs-lock-alt' ></i>
            </div>


            <div class="input_box">
                <input type="submit" class="input-submit" value="Login">
            </div>
        
            <div class="register">
               <a href="Landing.jsp"><span> homepage</span></a> 
            </div>
        </div>
    </div>
</form>
  </body>
</html>
