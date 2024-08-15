<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Vehicle Insurance</title>
   
    
    <style>
        .container {
    width: 50%;
    margin: 50px auto;
    padding: 20px;
    border: 1px solid black;
    border-radius: 5px;
}

.form-group {
    margin-bottom: 15px;
}

label {
    display: block;
    font-weight: bold;
}

input[type="text"],
input[type="tel"],
input[type="number"],
select,
input[type="date"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
    font-size: 16px;
    margin-top: 5px;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}
.isk{
align-content: right;
background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    text-decoration: none;
}
.i1{
margin-left:165px;}
button:hover {
    background-color: #45a049;
}
body{

background-color: #f4f4f4;
        background-position: center;
        background-size: cover;
        background-repeat: no-repeat;
        background-attachment: fixed;
        display: flex;
        align-items: center;
        justify-content: center;
         font-family: "Poppins", sans-serif;
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
   
    <div class="container">
 <%@include file="Message.jsp" %>
        <h2>New Vehicle Insurance</h2>
        <form action="Vehicleinsurance" method="post" id="insuranceForm">
            <div class="form-group">
                <label for="vehicleNo">Vehicle No:</label>
                <input type="text" id="vehicleNo" name="vehicleNo" maxlength="10" required>
            </div>
            <div class="form-group">
                <label for="vehicleType">Vehicle Type:</label>
                <select id="vehicleType" name="vehicleType" required>
                    <option value="2-wheeler">2-wheeler</option>
                    <option value="4-wheeler">4-wheeler</option>
                </select>
            </div>
            <div class="form-group">
                <label for="customerName">Customer Name:</label>
                <input type="text" id="customerName" name="customerName" maxlength="20" required>
            </div>
            <div class="form-group">
                <label for="engineNo">Engine No:</label>
                <input type="number" id="engineNo" name="engineNo" maxlength="8" oninput="enforceMaxLength(event)" required>
            </div>
            <div class="form-group">
                <label for="chasisNo">Chassis No:</label>
                <input type="number" id="chasisNo" name="chasissNo" maxlength="8" oninput="enforceMaxLength(event)" required>
            </div>
            <div class="form-group">
                <label for="phoneNo">Phone No:</label>
                <input type="number" id="phoneNo" name="phoneNo" pattern="[0-9]{10}" oninput="enforceMaxLength(event)" maxlength="10"required>
            </div>
            <div class="form-group">
                <label for="insuranceType">Type:</label>
                <select id="insuranceType" name="insuranceType" required>
                    <option value="Full Insurance">Full Insurance</option>
                    <option value="Third Party">Third Party</option>
                </select>
            </div>
            <div class="form-group">
                <label for="fromDate">From Date:</label>
                <input type="date" id="fromDate" name="fromDate" onchange="setToDate()"  required>
            </div>
            <div class="form-group">
                <label for="toDate">To Date:</label>
                <input type="date" id="toDate" name="toDate" required>
            </div>
            <div class="form-group">
                <label for="premiumAmnt">Premium Amount:</label>
                <input type="number" id="premiumAmnt" name="premiumAmnt"  required >
            </div>
            <button type="button" onclick="calculatePremium()">Calculate Premium</button>
            <button type="submit">Submit</button>
           
            <a href="UnderwriterMenu.jsp" class="isk">Back to Menu</a>
           
        </form>
    </div>
     <script>
        function calculatePremium() {
    var vehicleType = document.getElementById("vehicleType").value;
    var premiumAmntInput = document.getElementById("premiumAmnt");

   
    var vehicleValue=vehicleType==="2-wheeler"? 40000:100000
    var premiumPercentage = vehicleType === "2-wheeler" ? 2.5 : 3.5; 

    var premiumAmnt = (vehicleValue * premiumPercentage) / 100;
    premiumAmntInput.value = premiumAmnt.toFixed(0);
}
        function setToDate() {
            var fromDate = new Date(document.getElementById("fromDate").value);
            var toDate = new Date(fromDate);
            toDate.setFullYear(toDate.getFullYear() + 1);

            var dd = String(toDate.getDate()).padStart(2, '0');
            var mm = String(toDate.getMonth() + 1).padStart(2, '0'); 
            var yyyy = toDate.getFullYear();

            var formattedToDate = yyyy + '-' + mm + '-' + dd;
            document.getElementById("toDate").value = formattedToDate;
        }
        function enforceMaxLength(event) {
            var input = event.target;
            if (input.value.length > input.maxLength) {
                input.value = input.value.slice(0, input.maxLength);
            }
        }
    </script>
</body>
</html>
