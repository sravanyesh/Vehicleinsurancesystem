<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>UnderWriter MENU</title>
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


.wrapper {
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    

}

.login_box {
    position: relative;
    width: 35%;
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
    width: 265px;
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
    font-size: 14px;
    font-weight: 500;
    border: none;
    border-radius: 30px;
    cursor: pointer;
    transition: 0.3s;
}

.input-submit:hover {
    background: #3ddf45;
    /*background: var(--second-color);*/
}

.header_right {
    width: 10%;
    height: 40px;
    background: #ececec;
    font-size: 14px;
    font-weight: 500;
    border: none;
    border-radius: 30px;
    cursor: pointer;
    transition: 0.3s;
    align-content: right;
}

.header_right:hover {
    background: #3ddf45;
}


.logout {
    padding: 10px;
    
}
.alert {
            padding: 15px;
            margin: 20px;
            border-radius: 5px;
            font-size: 16px;
            position: relative;
            background-color: #4CAF50; /* Success color */
            color: #fff; 
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
  <body>
    
<header><%@ include file="Message.jsp" %> </header>
    <form action="logout" method="get">
        <div align="right" class="logout">
            <a href=""><input type="submit" value="Logout"class="header_right"></a>
        </div>
           </form>
        <div class="wrapper">
            
            <div class="login_box">
                <div class="login-header">
                    <span>UnderWriter MENU</span>
                </div>

            
                <a href="Createvehicleinsurance.jsp" ><button class="input-submit">Create a new Vehicle Insurance</button></a>
                <br><br>
                <a href="RenewPolicybyId.jsp"><button class="input-submit">Renewal of Policy</button></a>
                <br><br>
                <a href="Updatepolicy.jsp"><button class="input-submit">Change Policy Type</button></a> 
                <br><br>
                <a href="Searchpolicy.jsp"><button class="input-submit">View Policy by ID</button></a> 
                <br><br>

                      
            </div>
        </div>
 
  </body>
</html>
