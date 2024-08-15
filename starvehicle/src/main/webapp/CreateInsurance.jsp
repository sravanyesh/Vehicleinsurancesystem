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
    border: 1px solid #ccc;
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

button:hover {
    background-color: #45a049;
}

   </style>
</head>
<body>
    <div class="container">
        <h2>New Vehicle Insurance</h2>
        <form action="#" method="post">
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
                <input type="text" id="customerName" name="customerName" maxlength="50" required>
            </div>
            <div class="form-group">
                <label for="engineNo">Engine No:</label>
                <input type="number" id="engineNo" name="engineNo" required>
            </div>
            <div class="form-group">
                <label for="chasisNo">Chasis No:</label>
                <input type="number" id="chasisNo" name="chasisNo" required>
            </div>
            <div class="form-group">
                <label for="phoneNo">Phone No:</label>
                <input type="number" id="phoneNo" name="phoneNo" pattern="[0-9]{10}" required>
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
                <input type="date" id="fromDate" name="fromDate" required>
            </div>
            <div class="form-group">
                <label for="toDate">To Date:</label>
                <input type="date" id="toDate" name="toDate" required>
            </div>
            <div class="form-group">
                <label for="premiumAmnt">Premium Amount:</label>
                <input type="number" id="premiumAmnt" name="premiumAmnt" >
            </div>
           
            <button type="submit">Submit</button>
        </form>
    </div>
</body>
</html>
