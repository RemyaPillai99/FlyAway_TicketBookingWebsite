<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Information</title>
</head>
<body>
	
	<form action="BookingController" method="post">
		<jsp:include page="/header.jsp" />
			<div class="container" style="opacity: 90%">
					<label for="cardName" class="text-dark font-weight-bold">Card
						Holder Name</label> 
					<input name="cardname" type="text" class="form-control" id="cardName"
						placeholder="Enter Card Holder Name"> 
					<label for="cardNo"
						class="text-dark font-weight-bold">Card Number</label>
					 <input name="cardno" type="text" class="form-control" id="cardNo"
						placeholder="Enter Card Number"> 
					<label for="totalFare"
						class="text-dark font-weight-bold">Total Amount to be Paid</label>
					<input name="totalfare" type="text" class="form-control"
						id="totalFare"> <br />
						
					<input class="btn, btn-success btn-lg btn-block " type="submit"
						name="ConfirmPayment" value="Confirm Payment">
			</div>
	</form>			
</body>
<footer>
	<jsp:include page="/footer.jsp" />
	<style type="text/css">
	.container {
		position: relative;
		z-index: 2;
		width: 400px;/* fit-content; */
		margin: 50px auto;
		padding: 20px;
		background: white;
	} 
</style>
</footer>
</html>