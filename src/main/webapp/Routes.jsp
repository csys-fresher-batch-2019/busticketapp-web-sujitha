<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.sujitha.busticketapp.model.BusRoutes" %>   
<%@ page import="com.sujitha.busticketapp.dao.BusRoutesDAO"%> 
<%@ page import="com.sujitha.busticketapp.dao.impl.BusRoutesDAOImpl" %> 
<%@ page import="java.util.List" %>  
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h2>Select Locations</h2>
<br>
<br>

<form action="DisplayBusList">
<%
BusRoutesDAOImpl bri= new BusRoutesDAOImpl();
List<BusRoutes> fromlocation=bri.fromLocations();
%>
<br>
<br>
<%
BusRoutesDAOImpl br= new BusRoutesDAOImpl();
List<BusRoutes> tolocation=br.toLocations();
%>
<br>
<br>

Select From Location:<input type="text"  name="FromLocation" list="fromlocationlist" required>
<datalist id="fromlocationlist">
<%
for(BusRoutes s:fromlocation){
	
	%>
	<option value ="<%=s.getFromLocation() %>"><%=s.getFromLocation() %> </option>
	<%}

%>
</datalist>

Select To Location:<input type="text" name="ToLocation" list="tolocationlist" required>
<datalist id ="tolocationlist">
<%
for(BusRoutes d:tolocation){
	%>
	<option value ="<%=d.getToLocation() %>"><%=d.getToLocation() %> </option>
	<%}
%>
<br>
<br>
</datalist>
Enter Date:<input type="date" name="date" required>
<br/>
<button type="submit">submit</button>
<br>
<br>

</form>
</body>
</html>