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
<title>Booked Rooms</title>

<style type="text/css">
h1 {color:#FFD801; font-size:48px;}
body {background-image:url("Hintergrund-Grau.png"); margin-left:5rem; margin-right:5rem;}
div.abstand {margin-top:150px;}
#Kopfzeile {background-image:url("Kopfzeile-Schwarz.png");background-repeat:repeat-x; border-radius: 10px; font-family: 'Hammersmith One'; margin-left:5rem; margin-right:5rem; margin-top:30px;}
#Kopfzeile1 {background-image:url("Kopfzeile-Schwarz.png");background-repeat:repeat-x; font-family: 'Hammersmith One'; margin-left:5rem; margin-right:5rem; border:0px;}
#Seiteninfo {margin-left:auto; margin-right:auto;}
#Tabellenposition {margin-left:10%; margin-right:10%;}
#Tabellenformat {background-color:#E5E4E2; border-width:3px; width:90%; margin-left:auto; margin-right:auto;}
</style>

<link href='http://fonts.googleapis.com/css?family=Hammersmith+One' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/foundation.css">

</head>

<body>
<div id="Kopfzeile">
<table width="900" id="Kopfzeile1">
	<col width="150">
	<col width="750">
	<tr>
		<th align="left"><img alt="Logo" src="Logo.png" width="100" /></th>
		<th align="left"><h1>Orbit Hotel</h1></th>
	</tr>
</table>
</div>
<hr>

<table width="90%" id="Seiteninfo">
<col width=350>
<col width=650>
<tr>
<th align="left">Booked Rooms</th>
<th align="right"><a href="CustomerInterface.jsp"><input type="button" value="Back" name="Back" class="button small"/></a></th>
</tr>
</table>

<br>
<table id="Tabellenformat" rules="all">
<colgroup>
    <col width="10%">
    <col width="10%">
    <col width="10%">
    <col width="9%">
    <col width="10%">
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
<th>Cost</th>
<th>CancelBooking</th></tr>
</table>
<br>

<table id="Tabellenformat" rules="all">
<colgroup>
    <col width="10%">
    <col width="10%">
    <col width="10%">
    <col width="9%">
    <col width="10%">
    <col width="10%">
    <col width="10%">
    <col width="10%">
</colgroup>
<%
	String user = (String) session.getAttribute("person");
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
		out.println("<td name=\"payment\">" + booking.getPayment() + "</td>");
		out.println("<td name=\"money\">" + booking.getMoney() + " &euro;</td>");
		String bookingnumber = Integer.toString(booking.getBookingnumber());
		out.println("<input type=\"hidden\" name=\"bnumber\" value=" + bookingnumber + ">");
		out.println("<td>" + "<input type=\"submit\" name=\"submit\" value=\"CancelBooking\" class=\"button small\">" + "</td>");
		out.println("</form>");
		
		out.println("</tr>");
		
	}

%>
</table>




</body>

</html>