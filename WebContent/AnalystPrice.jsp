<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="hotel2013.hm.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AnalystPrice</title>
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
		<th align="left">Price Statistic</th>
		<th align="right"><a href="AnalystInterface.jsp"><input type="button" value="Back" name="Back" class="button small"/></a></th>
	</tr>
</table>
		
<br><br>
		
<body>
<table id="Tabellenformat" rules="all">
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
	double[] stat = MasterServlet.getPstat();
	out.println("<tr><td name=\"month\">");
	out.println("Income");
	for(int i = 0; i < 12; ++i){
		out.println("<td name=\"month\" align=\"center\">" + stat[i] + " &euro;</td>");
	}
	out.println("</tr><tr><td>Preferred Payment</td>");
	for(int i = 12; i < 36; i=i+2){
		if(stat[i] == 0 && stat[i+1] == 0)
		out.println("<td align=\"center\">-</td>");
		else if(stat[i] > stat[i+1])
		out.println("<td align=\"center\">Bar</td>");
		else
		out.println("<td align=\"center\">Bar</td>");
	}
	out.println("</tr>");
	
 %>

</table>
</body>

</html>