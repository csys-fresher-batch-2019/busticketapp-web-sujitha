<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.sujitha.busticketapp.model.BusList"%>
<%@ page import="com.sujitha.busticketapp.dao.BusListDAO"%> 
<%@ page import="com.sujitha.busticketapp.dao.impl.BusListDAOImpl" %> 
<%@ page import ="com.sujitha.busticketapp.dto.BusesDetails"%>
<%@ page import="java.util.List" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h2>BusList</h2>
 
 <br>
 <br>
 <%
 BusListDAOImpl bl= new BusListDAOImpl();
List<BusesDetails> bus = (List<BusesDetails>)request.getAttribute("Bus_list");
 %>
 <br>
 <br>
 <table class="table table-bordered"> 
 <thead >
 <tr>
 <th>BusNumber</th>
 <th>BusName</th>
 <th>TotalSeats</th>
 <th>SeatType</th>
 <th>StartTime</th>
 <th>EndTime</th>
 <th>Fare</th>
 <th></th>
 </tr>
 </thead>
 
 <%
 if ( bus != null){
 for(BusesDetails b:bus){
 %><tr>
 
 <td><%=b.getBusNum()  %></td>
 <td><%=b.getBusName() %></td>
 <td><%=b.getNoOfSeats() %></td>
 <td><%=b.getSeatType() %></td>
 <td><%=b.getStartTime()%></td>
 <td><%=b.getEndTime() %></td>
 <td><%=b.getFair() %></td>
<td><a href="BookingDetail.jsp?busNo=<%=b.getBusNum() %>" class="btn btn-success">Book</a></td>

 </tr><% 
   HttpSession sess=request.getSession();
	      sess.setAttribute("busNo",b.getBusNum());
	      sess.setAttribute("amount",b.getFair());
 }}%>
 </table>
 
<button type="submit">submit</button>

</form>
</body>
</html>