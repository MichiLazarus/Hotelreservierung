<%@page import="java.util.ArrayList"%>
<%@page import="hotel2013.hm.dao.RoomDAO"%>
<%@page import="hotel2013.hm.data.*"%>
<%@page import="hotel2013.hm.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="hotel2013.hm.Hotelmanagement" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Rating</title>

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
<th align="left">Rating for Roomnumber:</th>

<th align="right"><a href="AnalystInterface.jsp"><input type="button" value="Back" name="Back"/></a></th>
</tr>
</table>

<%
RoomDAO r = new RoomDAO("Rooms.ser");
ArrayList <Room> rlist = r.getRoomlist();
for(int i = 0;i<rlist.size();i++){
	if( rlist.get(i).getRoomnumber() == MasterServlet.getSroomnumber()){
		out.print(rlist.get(i).getRoomnumber());
		out.print("<br>");
		out.print(rlist.get(i).getRating());
	}
}
%>

</body>

</html>