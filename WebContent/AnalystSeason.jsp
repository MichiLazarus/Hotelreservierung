<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="hotel2013.hm.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AnalystSeason</title>
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
		<th align="left">Season Statistic</th>
		<th align="right"><a href="AnalystInterface.jsp"><input type="button" value="Back" name="Back" class="button small"/></a></th>
	</tr>
</table>

<br><br>

<body>
<table id="Tabellenformat" rules="all" rules="groups">
<colgroup>
    <col width="10%">
    <col width="7%">
    <col width="7%">
    <col width="7%">
    <col width="7%">
    <col width="7%">
    <col width="7%">
    <col width="7%">
    <col width="7%">
    <col width="7%">
    <col width="7%">
    <col width="7%">
    <col width="7%">
 </colgroup><tr>
<th></th>
<th>Jan</th>
<th>Feb</th>
<th>Mar</th>
<th>Apr</th>
<th>May</th>
<th>Jun</th>
<th>Jul</th>
<th>Aug</th>
<th>Sep</th>
<th>Oct</th>
<th>Nov</th>
<th>Dec</th>
</tr>

<%
	int [][] stat = MasterServlet.getSstat();
	int sumbookings = 0;
	int sumcustomers = 0;
	
	out.println("<tbody><tr>");
	out.println("<td>Bookings</td>");
	for(int i = 0; i < 12; ++i){
		out.println("<td name=\"month\" align=\"center\">" + stat[0][i] + "</td>");
		sumbookings += stat[0][i];
	}
	out.println("</tr><tr>");
	out.println("<td>Number of Customers</td>");
	for(int i = 0; i< 12; ++i){
		out.println("<td name=\"CustNo\" align=\"center\">" + stat[1][i] + "</td>");
		sumcustomers += stat[1][i];
	}
	out.println("</tr></tbody><tfoot style=\"background-color: #B6B6B4\">");
	out.println("<tr><th>Bookings in total</th><td style=\"text-align:center\">" + sumbookings + "</td></tr>");
	out.println("<tr><th>Customer in total</th><td style=\"text-align:center\">" + sumcustomers + "</td></tr></tfoot>");
	
 %>

</table>
</body>

</html>