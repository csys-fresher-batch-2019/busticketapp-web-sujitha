<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
<h3> Book Ticket</h3>
<%
HttpSession sess=request.getSession(false);
String bus_no=request.getParameter("busNo");
int amount=(Integer)sess.getAttribute("amount");
int user_id=(Integer)sess.getAttribute("userid");
%>

<form action="BusBooking">
<input type="hidden" name="userid"value="<%=user_id %>" readonly required/>
<br>
<br>
Enter Bus Number:<input type="text" name="busnumber"value="<%=bus_no%>" readonly required/>
<br>
<br>
 Number Of Tickets:<input type="number" name="numberofseats"value="numberofseats" required/>
<br>
<br>
Enter Date:<input type="date" name="date"  required>
<br>
<br>
Gender 
<input type="radio" name="gender" value="M">male
<input type="radio" name="gender" value="F">female
<br>
<br>
Select preferences:
<select name="preferences">
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
<br>
<br>
Amount:<input type="number" name="amount"value="<%=amount%>" readonly required/>
<br>
<br>
<button type="submit" class="btn btn-success">submit</button>


<br>
<br>
</form>
</div>
</body>
</html>