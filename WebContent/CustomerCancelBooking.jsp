<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hotel2013.hm.dao.RoomDAO"%>
<%@page import="hotel2013.hm.data.*"%>
<%@page import="hotel2013.hm.users.*"%>
<%@page import="hotel2013.hm.*"%>
<%@page import="java.util.Date" %>
<%@page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RequestedRooms</title>

<style type="text/css">
h1 {color:#3399CC; font-size:42px;}
body {background-color:#CCC; margin-left:100px; margin-right:100px; font-size:20px;}
div.abstand {margin-top:150px;}
</style>
</head>

<body>
<table width="900">
<col width="250">
<col width="650">
<tr>
<th align="left"><img alt="Logo" src="Logo.png" width="100" /></th>
<th align="left"><h1>Orbit Hotel</h1></th>
</tr>
</table>
<hr>

<table width="100%" cellpadding="8">
<col width=*>
<col width=*>
<tr>
<th align="left">Requested Rooms</th>
<th align="right"><a href="CustomerInterface.jsp"><input type="button" value="Back" name="Back"/></a></th>
</tr>
</table>

<br>
<table border="1" width="95%" align="center" bgcolor="#BFBFBF"  cellspacing="3%">
<colgroup>
    <col width="12%">
    <col width="10%">
    <col width="10%">
    <col width="9%">
    <col width="10%">
    <col width="10%">
    <col width="10%">
 </colgroup><tr>
<th>BookingNr</th>
<th>Roomnr</th>
<th>Start</th>
<th>End</th>
<th>NrOfPersons</th>
<th>Payment</th>
<th>CancelBooking</th></tr>
</table>
<br>

<table border="1" width="95%" align="center" bgcolor="#BFBFBF" cellspacing="3%">
<colgroup>
    <col width="12%">
    <col width="10%">
    <col width="10%">
    <col width="9%">
    <col width="10%">
    <col width="10%">
    <col width="10%">
</colgroup>
<%
	
	ArrayList <Booking> blist =  MasterServlet.getBooklist();
    
	
	for(int i = 0; i < blist.size(); i++){
		Booking booking = blist.get(i);
		
		Date bookingst = booking.getBookingstart();
		Calendar cal = Calendar.getInstance();
		cal.setTime(bookingst);
			int startmonth = cal.get(Calendar.MONTH) + 1;
			int startday = cal.get(Calendar.DAY_OF_MONTH);
			int startyear = cal.get(Calendar.YEAR);
				
		Date bookingend = booking.getBookingend();
		cal.setTime(bookingend);
			int endmonth = cal.get(Calendar.MONTH) + 1;
			int endday = cal.get(Calendar.DAY_OF_MONTH);
			int endyear = cal.get(Calendar.YEAR);
			
		out.println("<form name=\"cancelbooking\" action=\"MasterServlet\" method=\"post\">");
		out.println("<tr align=\"center\">");
		out.println("<td name=\"bookingnumber\">" + booking.getBookingnumber() + "</td>");
		out.println("<td name=\"roomnumber\">" + booking.getBroomnumber() + "</td>");
		out.println("<td name=\"bookingstart\">" + startday + "." + startmonth + "." + startyear + "</td>");
		out.println("<td name=\"bookingend\">" + endday + "." + endmonth + "." + endyear + "</td>");
		out.println("<td name=\"nop\">" + booking.getBnop() + "</td>");
		out.println("<td name=\"nop\">" + booking.getPayment() + "</td>");
		
		String bookingnumber = Integer.toString(booking.getBookingnumber());
		out.println("<input type=\"hidden\" name=\"bnumber\" value=" + bookingnumber + ">");
		out.println("<td>" + "<input type=\"submit\" name=\"submit\" value=\"CancelBooking\">" + "</td>");
		out.println("</form>");
		
		out.println("</tr>");
		
	}

%>
</table>




</body>

</html>