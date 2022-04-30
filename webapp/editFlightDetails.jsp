<%@page import="model.TravelClass"%>
<%@page import="model.City"%>
<%@page import="dao.CityDaoImpl"%>
<%@page import="model.Airline"%>
<%@page import="java.util.List"%>
<%@page import="dao.AirlineDaoImpl"%>
<%@page import="model.Flight"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dao.FlightDetailsDaoImpl"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Selected Flight</title>
</head>
	<%
	String id = request.getParameter("no");

	out.print(request.getParameter("date"));
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	String sd = request.getParameter("date");
	Date depatureDate = null;
	try {
		depatureDate = sdf.parse(sd);

	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	FlightDetailsDaoImpl flightDetailsDaoImpl = new FlightDetailsDaoImpl();
	out.println(" ### " + Integer.valueOf(request.getParameter("no")) + depatureDate+
			request.getParameter("class"));
	 Flight f = flightDetailsDaoImpl.getFlightDetailsById(Integer.valueOf(request.getParameter("no")), depatureDate,
			request.getParameter("class"));


	AirlineDaoImpl airlineDao = new AirlineDaoImpl();
	List<Airline> Alist = airlineDao.showAllAirLine();

	request.setAttribute("Alist", Alist);

	CityDaoImpl cityDao = new CityDaoImpl();
	List<City> CityList = cityDao.showAllCity();
	request.setAttribute("CityList", CityList);

	request.setAttribute("classEnum", TravelClass.values());

	String sourceCity = f.getSource().getName();
	request.setAttribute("sourceCity", sourceCity);
	request.setAttribute("destCity", f.getDest().getName());
	request.setAttribute("travelClass", f.getTravelClass());
	request.setAttribute("fobj", f);
	
	%>
<body>

	
<jsp:include page="/header.jsp" />
	<div class="container">
	<h2>Edit Flight Details</h2>
		<form action="FlightController" method="post">
			<table class ="table table-borderless table-striped"  width="100%" > 
				<tr>
					<td>Flight no</td>
					<td>
						<input type="text" name="flightNo" size="6" value = "<%= f.getFlightNo() %>"readOnly/>
					</td> 
				</tr>
				<tr>
					<td>Airline</td>
					<td>
						 <select
						name="airlineCategory">
							<c:forEach items="${Alist}" var="al">
								<option value="${al.getAirlineId()}">${al.getAirlineName()}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td>From</td>
					<td>
					 <select
						name="sourceCategory">
							<c:forEach items="${CityList}" var="city">
								<%-- <option value="${city.getName()}">${city.getName()}</option> --%>
								<c:choose>
									<c:when test="${city.getName() == sourceCity}">
										<option value="${city.getName()}" selected="selected">${city.getName()}</option>
									</c:when>
									<c:otherwise>
										<option value="${city.getName()}">${city.getName()}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select> 
					</td>
				</tr>
				<tr>
					<td>Destination</td>
					<td>
						<!-- <input type="text" name="dest" size="30" /> --> <select
						name="destCategory">
							<c:forEach items="${CityList}" var="city">
								<c:choose>
									<c:when test="${city.getName() == destCity}">
										<option value="${city.getName()}" selected="selected">${city.getName()}</option>
									</c:when>
									<c:otherwise>
										<option value="${city.getName()}">${city.getName()}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td>Departure Date</td>
					<td><input type="text" name="depatureDate" id="depatureDate"
						size="15" value = "<%=f.getDepatureDate() %>" readonly /></td>
				</tr>
				<tr>
					<td>Flight duration</td>
					<td><input type="text" name="flightDuration" size="15"
						value="<%=f.getFlightDuration()%>" /> hrs</td>
				</tr>
				<tr>
					<td>Travel Class</td>
					<td>
						 <input type="text" name="travelClass" size="15" value= "<%= f.getTravelClass()%>"readonly /> 
					</td>
				</tr>
				<tr>
					<td>Total Seats</td>
					<td><input type="text" name="totalSeats" size="15"
						value="<%=f.getTotalSeats()%>" /></td>
				</tr>
				<tr>
					<td>Booked seats</td>
					<td><input type="text" name="bookedSeats" size="15"
						value="<%=f.getBookedSeats()%>" /></td>
				</tr>
				
				<tr>
					<td>Fare</td>
					<td><input type="text" name="fare" size="15"
						value="<%=f.getFare()%>" /> USD</td>
				</tr>
				
			</table>
			<br/>
			<input class="btn, btn-success btn-lg btn-block btn-group-justified" type="submit"
				name="EditFlight"	 value="Submit Changes">
		</form>
	</div>
</body>
<footer>
	<jsp:include page="/footer.jsp" />
	<style type="text/css">
	.container {
		/* width: 50%;
		margin-left: 25%;
		margin-top: 8% */
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