<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home Page</title>
</head>
<body>
<h3>Admin Page</h3>
<form action="FlightController"  method="post">
<a href = "addAirline.jsp"> Add Airline</a><br/><br/>
<a href = "deleteAirplane.jsp">Delete Airline</a><br/><br/>
 <a href ="listFlights.jsp">View and Edit Flights</a><br/>
<a href="viewpassengers.jsp">View Passenger List </a><br/><br/>
</form>
</body>
</html>