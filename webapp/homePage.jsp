<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">

 label, a {
	font-size: x-large;
	color: black;
}

.banner-heading {
    letter-spacing: 1rem;
    text-shadow: .1rem .1rem .8rem rgba(0, 0, 0, .4);
   font-size:  xxx-large;
}
.container {

	position: relative;
	z-index: 2;

}

</style>
</head>
<body>
	<jsp:include page="/header.jsp" />
	
	<div class="container">

		<div class="col text-center">
			<h3
				class="text-uppercase font-weight-bold display-4  banner-heading">welcome
				to fly Away</h3>
			<a href="searchFlights.jsp"
				class="btn btn-lg btn-outline-primary text-uppercase px-8">
				Book flight
			</a>
		
		</div>
	</div>

	<div id="bg">
		<img src="static/images/background/background.jpg" alt="">
	</div>
</body>
<footer>
	<jsp:include page="/footer.jsp" />
</footer>
</html>