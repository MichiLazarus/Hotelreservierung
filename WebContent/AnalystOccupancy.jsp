<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="hotel2013.hm.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AnalystPrice</title>
<style type="text/css">
h1 {
	color: #3399CC;
	font-size: 42px;
}

body {
	background-color: #CCC;
	margin-left: 100px;
	margin-right: 100px;
	font-size: 20px;
}

div.abstand {
	margin-top: 150px;
}

div.abstand2 {
	margin-top: 50px;
}
</style>
</head>

<body>
	<f:view>
		<table width="900">
			<col width="250">
			<col width="650">
			<tr>
				<th align="left"><img alt="Logo" src="Logo.png" width="100" /></th>
				<th align="left"><h1>Orbit Hotel</h1></th>
			</tr>
		</table>
		<hr>
		<h:form>
			<table width="100%" cellpadding="8">
				<col width=*>
				<col width=*>
				<tr>
					<th align="left">OccupancyStatistic</th>
					<th align="right"><a href="AnalystInterface.jsp"><input type="button" value="Back" name="Back"/></a>
					</th>
				</tr>
			</table>
		</h:form>

<body>
<table border="1" width="85%" align="center" bgcolor="#BFBFBF">
<colgroup>
    <col width="10%">
    <col width="7%">

 </colgroup><tr>
<th></th>
<th>Roomnumber</th>
<th>Nr of Bookings</th>
</tr>

<%
	int[][] stat = MasterServlet.getOstat();
	out.println("<td name=\"Room\">");
	out.println("Occupancy");
	for(int i = 0; i < stat.length; ++i){
		out.println("<tr>");
		out.println("<td name=\"room\">" + stat[i][0] + "</td>");
		out.println("<td name=\"occ\">" + stat[i][1] + "</td>");
		out.println("<\tr>");
	}
	
 %>

</table>
</f:view>
</body>

</html>