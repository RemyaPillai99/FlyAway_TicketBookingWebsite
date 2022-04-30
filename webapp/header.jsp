<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

  <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js" type="text/javascript"></script>
    <script src="https://ajax.aspnetcdn.com/ajax/jquery.ui/1.12.1/jquery-ui.min.js" type="text/javascript"></script>
    <link href="https://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  <style>
.navbar {
  z-index: 2;
}
</style>

<nav class="navbar navbar-dark bg-dark navbar-expand-sm">
<a class="navbar-brand" href="#">
    <img src="static/images/background/airplane.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
    Fly Away
  </a>
 <ul class="nav nav-pills" role="tablist">
    <li class="nav-item"><a class="nav-link" href="homePage.jsp">Home Page</a></li>
    <li  class="nav-item"><a class="nav-link" href="searchFlights.jsp">Book Flight</a></li>  
    <li class="nav-item"><a class="nav-link" href="Login.jsp">Login</a></li>
     <li class="nav-item"><a class="nav-link" href="<%request.getContextPath();%>/FlyAway/LogOutServlet">
    <img src="static/images/background/Logout.png" width="30" height="30" class="d-inline-block align-top" alt="">
    Logout</a>
  </li> 
 </ul>

 </nav>


</html>