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
<th align="left">All Rooms</th>
<th align="right"><a href="HotelierInterface.jsp"><input type="button" value="Back" name="Back" class="button small"/></a></th>
</tr>
</table>

<br>
<table id="Tabellenformat" rules="all">
<colgroup>
    <col width="13%">
    <col width="19%">
    <col width="15%">
    <col width="13%">
    <col width="13%">
    <col width="13%">
    <col width="17%">
 </colgroup><tr>
<th>Roomnr</th>
<th>Equipment</th>
<th>NrOfPersons</th>
<th>Price</th>
<th>OfferedPrice</th>
<th>Rating</th>
<th>Edit</th></tr>
</table>
<br>


<table id="Tabellenformat" rules="all">
<colgroup>
    <col width="13%">
    <col width="19%">
    <col width="15%">
    <col width="13%">
    <col width="13%">
    <col width="13%">
    <col width="17%">
</colgroup>
<%
    RoomDAO r = new RoomDAO("Rooms.ser");
	ArrayList <Room> rlist =  r.getRoomlist();
	String rating;
	char [] temp;
	String str;
	for(int i = 0; i < rlist.size(); i++){
		Room room = rlist.get(i);
		
		str = room.getRating();
		if(str.length() <19)
			rating = str;
		else{
		temp = str.toCharArray();
		rating = new String(temp,0,19);
		}

		out.println("<form name=\"EditRoom\" action=\"MasterServlet\" method=\"post\">");
		out.println("<tr align=\"center\">");
		
		out.println("<td name=\"roomnumber\">" + room.getRoomnumber() + "</td>");
		out.println("<td name=\"equipment\">" + room.getEquipment() + "</td>");
		out.println("<td name=\"nop\">" + room.getNop() + "</td>");
		out.println("<td name=\"price\">" + room.getPrice() + " &euro;" + "</td>");
		if(room.getPriceOffer() != 0)
		out.println("<td name=\"priceoffer\">" + room.getPriceOffer() + " &euro;" + "</td>");
		else
		out.println("<td name=\"priceoffer\">" + "-" + "</td>");
		
		out.println("<td name=\"rating\">" + rating + "...</td>");
		
		String rnumber = Integer.toString(room.getRoomnumber());
		String price = Double.toString(room.getPrice());
		String equipment = room.getEquipment();
		String nop = Integer.toString(room.getNop());
		
		out.println("<input type=\"hidden\" name=\"rnumber\" value=" + rnumber + ">");
		out.println("<input type=\"hidden\" name=\"price\" value=" + price + ">");
		out.println("<input type=\"hidden\" name=\"equipment\" value=" + equipment + ">");
		out.println("<input type=\"hidden\" name=\"nop\" value=" + nop + ">");
		
		out.println("<td>" + "<input type=\"submit\" name=\"submit\" value=\"EditRoom\" class=\"button tiny\">" + "</td>");
		
		
		out.println("</tr>");
		out.println("</form>");
		
	}

%>
</table>


</body>

</html>