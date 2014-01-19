<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AnalystInterface</title>
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
					<th align="left">Analyst</th>
					<th align="right">
					<a href="index.jsp"><input type="button" value="Logout" name="Logout"/></a>
					</th>
				</tr>
			</table>
		</h:form>

		<h:form>
			<div class="abstand2">
<form name="showrating" action="MasterServlet" method="post" onsubmit="return ShowRatingÜberprüfung()">
<table width="350"  border="1" rules="groups" cellpadding="8" style="float:left;">
<tr>
<th align="left">Show Rating</th>
<th></th>
</tr>
<tbody>
<tr>
<th align="left">Room number:</th>
<th><input type="text" name="roomnumber" size="22" maxlength="40"></th>
</tr>

</tbody>
<tfoot>
<tr>
<th></th>
<th align="center"><input type="submit" name="submit" value="ShowRatingAnalyst"></th>
</tr>
</tfoot>
</table>
</form>
</div>
		</h:form>

		<h:form>
			<div class="abstand2">
				<center>
					<table width="900" border="1" rules="groups" cellpadding="8">
						<tr>
							<th align="center">Show Statistic</th>
						</tr>
						<tbody>
							<tr>
								<th align="left">
										SeasonStatistic:
										<form name="ShowStatistic" action="MasterServlet" method="post" onsubmit="">

								
								<tr>
<th align="left">Year:</th>
<th align="center"><select name="year">
				 <option value="2014">2014</option>
				 <option value="2015">2015</option>
				 <option value="2016">2016</option>
			     </select></th>
			     <th><input type="submit" name="submit" value="SeasonStatistic"></th>
							</th></tr>
			     
							</tr>
				<th align="left">
					OccupancyStatistic
					<input type="submit" name="submit" value="PriceStatistic">
					</th>
					<th align="left">
					OccupancyStatistic
					<input type="submit" name="submit" value="OccStatistic">
					</th>
					
							</form>
						</tbody>
						<tfoot>
							<tr>
								<th align="center"><h:commandButton value="Show" /></th>
							</tr>
						</tfoot>
					</table>
				</center>
			</div>
		</h:form>



		<div class="abstand2">
<form name="showallrooms" action="AnalystShowAllRooms.jsp" method="post">

<table width="350"  border="1" rules="groups" cellpadding="8" style="float:left;">
<tr>
<th align="left">Show all Rooms</th>
<th></th>
</tr>
<tfoot>
<tr>
<th></th>
<th><input type="submit" name="submit" value="Show all Rooms"></th>
</tr>
</tfoot>
</table>
</form>
</div>

	</f:view>
</body>
</html>