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
h1 {color:#FFD801; font-size:48px;}
body {background-image:url("Hintergrund-Grau.png"); margin-left:5rem; margin-right:5rem;}
div.abstand {margin-top:150px;}
#Kopfzeile {background-image:url("Kopfzeile-Schwarz.png");background-repeat:repeat-x; border-radius: 10px; font-family: 'Hammersmith One'; margin-left:5rem; margin-right:5rem; margin-top:30px;}
#Kopfzeile1 {background-image:url("Kopfzeile-Schwarz.png");background-repeat:repeat-x; font-family: 'Hammersmith One'; margin-left:5rem; margin-right:5rem; border:0px;}
#Seiteninfo {margin-left:auto; margin-right:auto;}
#Tabellenposition {margin-left:10%; margin-right:10%;}
#Tabellenformat {background-color:#E5E4E2; border-width:3px; width:80%; margin-left:auto; margin-right:auto;}
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
<th align="left">Rating for Roomnumber:</th>

<th align="right"><a href="HotelierInterface.jsp"><input type="button" value="Back" name="Back" class="button small"/></a></th>
</tr>
</table>

<div class="panel callout radius" align="center">
<%
RoomDAO r = new RoomDAO("Rooms.ser");
ArrayList <Room> rlist = r.getRoomlist();
for(int i = 0;i<rlist.size();i++){
	if( rlist.get(i).getRoomnumber() == MasterServlet.getSroomnumber()){
		out.print("<b>" + rlist.get(i).getRoomnumber() + "</b>");
		out.print("<br><hr><br><table id=\"Tabellenformat\"><tr><td>");
		out.print(rlist.get(i).getRating());
		out.print("</td><td></td></tr></table>");
	}
}
%>
</div>
</body>

</html>