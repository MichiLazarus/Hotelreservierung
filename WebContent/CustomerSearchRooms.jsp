<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hotel2013.hm.dao.RoomDAO"%>
<%@page import="hotel2013.hm.data.*"%>
<%@page import="hotel2013.hm.users.*"%>
<%@page import="hotel2013.hm.*"%>

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
<table border="1" width="95%" align="center" bgcolor="#BFBFBF">
<colgroup>
    <col width="15%">
    <col width="22%">
    <col width="20%">
    <col width="18%">
    <col width="15%">
    <col width="20%">
 </colgroup><tr>
<th>Roomnr</th>
<th>Equipment</th>
<th>NrOfPersons</th>
<th>Price</th>
<th>Rating</th>
<th>Book</th></tr>
</table>
<br>

<table border="1" width="95%" align="center" bgcolor="#BFBFBF">
<colgroup>
    <col width="15%">
    <col width="22%">
    <col width="20%">
    <col width="18%">
    <col width="15%">
    <col width="20%">
</colgroup>
<%
	
	ArrayList <Room> rlist =  MasterServlet.getRoomlist();
    
	
	for(int i = 0; i < rlist.size(); i++){
		Room room = rlist.get(i);
		String str = room.getRating();
		char [] temp = str.toCharArray();
		String rating = new String(temp,0,19);
		
		out.println("<form name=\"book\" action=\"MasterServlet\" method=\"post\">");
		out.println("<tr align=\"center\">");
		out.println("<td name=\"roomnumber\">" + room.getRoomnumber() + "</td>");
		out.println("<td name=\"equipment\">" + room.getEquipment() + "</td>");
		out.println("<td name=\"nop\">" + room.getNop() + "</td>");
		out.println("<td name=\"price\">" + room.getPrice() + " Euro" + "</td>");
		out.println("<td name=\"rating\">" + rating + "...</td>");
		
		String rnumber = Integer.toString(room.getRoomnumber());
	
		out.println("<input type=\"hidden\" name=\"user\" value=" + MasterServlet.getUser()+ ">");
		out.println("<input type=\"hidden\" name=\"rnumber\" value=" + rnumber + ">");
		out.println("<td>" + "<input type=\"submit\" name=\"submit\" value=\"Book\">" + "</td>");
		out.println("</form>");
		
		out.println("</tr>");
		
	}

%>
</table>




</body>

</html>