
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="model.City"%>
<%@page import="java.util.List"%>
<%@page import="dao.CityDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Airline Booking Service</title>
</head>

<%
CityDaoImpl cityDao = new CityDaoImpl();
List<City> CityList = cityDao.showAllCity();
City city = CityList.get(1);
String cityName = city.getName();

request.setAttribute("CityList", CityList);
request.setAttribute("cityName", cityName);
%>
<body>
	<jsp:include page="/header.jsp" />
	<div class="container" style="opacity: 90%">
	<form id="form-search" action="SearchFlightsController" method="post">
			<div style="color: blue">${message}</div>
			<div class="form-row">
				<div class="form-group search">
					<label for="Source" class="text-dark font-weight-bold">From</label>
					<select class="form-control" id="sourceCategory"
						name="sourceCategory">

						<c:forEach items="${CityList}" var="city">
							<option value="${city.getName()}">${city.getName()}</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-group search" style="margin-left:5%;">
					<label for="Dest" class="text-dark font-weight-bold">To</label> <select
						class="form-control" id="destCategory" name="destCategory">
						<c:forEach items="${CityList}" var="city" varStatus="loop">
							<c:choose>
								<c:when test="${loop.count >= 2}">
									<option value="${city.getName()}" selected="selected">${city.getName()}</option>
								</c:when>
								<c:otherwise>
									<option value="${city.getName()}">${city.getName()}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group search">
				<label for="travel_date" class="text-dark font-weight-bold">Departure
					Date</label> 
				<input name="deptDate" type="text" class="form-control"
					id="deptDate" required="required"/>
			</div>

			<div class="form-group search">
				<div>
						<label for="travelClass" class="text-dark font-weight-bold">Travel-Class</label>
				</div>
			    <div>
				
					<div class="form-check-inline">
						<label class="radio-inline form-check-label"><input class="form-check-input" type="radio" value="0" name="travelClass" checked="checked" />Economy</label>
					</div>
					<div class="form-check-inline">
						<label class="radio-inline form-check-label"><input  class="form-check-input" type="radio" value="2" name="travelClass" />First Class</label>
					</div>
					<div class="form-check-inline">
						<label class="radio-inline form-check-label"><input class="form-check-input" type="radio" value="1" name="travelClass" />Business Class</label>
					</div>
				</div>	
			</div> 
			
			<div class="form-group search">
				<label for="noOfPassengers" class="text-dark font-weight-bold">No
					Of Passengers</label> <input name="noOfPassengers" type="number"
					class="form-control " placeholder="No of Travellers"
					id="noOfPassengers" required="required">
			</div>

			<div class="form-group search">
				<input class="btn, btn-success btn-lg btn-block btn-group-justified" type="submit"
					name="searchFlight" value="Search flights">
			</div>
			<span id='messageDest'></span>
	</form>

	</div>
</body>
<footer>
	<jsp:include page="/footer.jsp" />
	
	<script>
	$(function() {
		$("#deptDate").datepicker({
			dateFormat: 'yy-mm-dd',
	        changeMonth: true,
	        changeYear: true,
	        inline: true,
			minDate: 0
		});
	});
</script>

<script type="text/javascript">
	var check = function() {
		if (document.getElementById('destCategory').value == document
				.getElementById('sourceCategory').value) {
			document.getElementById('messageDest').style.color = 'red';
			document.getElementById('messageDest').innerHTML = 'Source and Destination cannot match';
		}
	}

	$(document)
			.ready(
					function() {
						$("#submit")
								.click(
										function() {

											if (document
													.getElementById('destCategory').value == document
													.getElementById('sourceCategory').value) {
												document
														.getElementById('messageDest').style.color = 'red';
												document
														.getElementById('messageDest').innerHTML = 'Source and Destination cannot match';
											}

										});
					});
</script>
<style type="text/css">
	.container {
		/* width: 50%;
		margin-left: 25%;
		margin-top: 8% */
		position: relative;
		z-index: 2;
		width: 500px;
		margin: 50px auto;
		padding: 20px;
		background: white;
	} 
</style>
</footer>
</html>