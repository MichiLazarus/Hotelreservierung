<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hotel2013.hm.dao.RoomDAO"%>
<%@page import="hotel2013.hm.data.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Rooms</title>

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
<th align="left">All Rooms</th>
<th align="right"><a href="HotelierInterface.jsp"><input type="button" value="Back" name="Back"/></a></th>
</tr>
</table>

<br>
<table border="1" width="95%" align="center" bgcolor="#BFBFBF"  cellspacing="3%">
<colgroup>
    <col width="12%">
    <col width="18%">
    <col width="10%">
    <col width="9%">
    <col width="10%">
    <col width="13%">
    <col width="10%">
 </colgroup>
<th>Roomnumber</th>
<th>Equipment</th>
<th>NrOfPersons</th>
<th>Price</th>
<th>OfferedPrice</th>
<th>Rating</th>
<th>Edit</th>
</table>
<br>

<form name="EditRoom" action="MasterServlet" method="post">
<table border="1" width="95%" align="center" bgcolor="#BFBFBF" cellspacing="3%">
<colgroup>
    <col width="12%">
    <col width="18%">
    <col width="10%">
    <col width="9%">
    <col width="10%">
    <col width="13%">
    <col width="10%">
</colgroup>
<%
    RoomDAO r = new RoomDAO("Rooms.ser");
	ArrayList <Room> rlist =  r.getRoomlist();
	
	for(int i = 0; i < rlist.size(); i++){
		Room room = rlist.get(i);
		
		out.println("<tr align=\"center\">");
		
		out.println("<td name=\"roomnumber\">" + room.getRoomnumber() + "</td>");
		out.println("<td name=\"equipment\">" + room.getEquipment() + "</td>");
		out.println("<td name=\"nop\">" + room.getNop() + "</td>");
		out.println("<td name=\"price\">" + room.getPrice() + " Euro" + "</td>");
		if(room.getPriceOffer() != 0)
		out.println("<td name=\"priceoffer\">" + room.getPriceOffer() + " Euro" + "</td>");
		else
		out.println("<td name=\"priceoffer\">" + "-" + "</td>");
		out.println("<td name=\"rating\">" + room.getRating() + "</td>");
		out.println("<td>" + "<input type=\"submit\" name=\"submit\" value=\"EditRoom\">" + "</td>");
		
		out.println("</tr>");
	}

%>
</table>
</form>

</body>

</html>