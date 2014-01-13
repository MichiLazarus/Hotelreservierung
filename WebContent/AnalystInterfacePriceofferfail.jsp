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
<script type="text/javascript">
alert("Price Offer failed");
</script>
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
					<a href="index.jsp"><input type="button" value="Back" name="Back"/></a>
					</th>
				</tr>
			</table>
		</h:form>

		<h:form>
			<div class="abstand2">
				<center>
					<table width="900" border="1" rules="groups" cellpadding="8">
						<tr>
							<th align="center">Show Rating</th>
						</tr>
						<tbody>
							<tr>
								<th align="center">Roomnumber: <h:inputText id="roomnumber"
										value="" /> <h:message for="roomnumber" errorClass="error" />
								</th>
							</tr>
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

		<h:form>
			<div class="abstand2">
				<center>
					<table width="900" border="1" rules="groups" cellpadding="8">
						<tr>
							<th align="center">Show Statistic</th>
						</tr>
						<tbody>
							<tr>
								<th align="center">Show Statistic: <h:selectOneMenu
										id="statistic" value="">
										<f:selectItem id="item1" itemLabel="SeasonStatistic"
											itemValue="1" />
										<f:selectItem id="item2" itemLabel="OccupancyStatistic"
											itemValue="2" />
										<f:selectItem id="item3" itemLabel="CustomerStatistic"
											itemValue="3" />
									</h:selectOneMenu> <h:message for="roomnumber" errorClass="error" />
								</th>
							</tr>
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

		<h:form>
			<div class="abstand2">
				<center>
					<table width="900" border="1" rules="groups" cellpadding="8">
						<tr>
							<th align="center">Make Price Offer</th>
						</tr>
						<tbody>
							<tr>
								<th align="center">Roomnumber: <h:inputText id="roomnumber"
										value="" /> <h:message for="roomnumber" errorClass="error" />
									Price: <h:inputText id="priceoffer" value="" /> <h:message
										for="priceoffer" errorClass="error" />
								</th>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<th align="center"><h:commandButton value="Offer" /></th>
							</tr>
						</tfoot>
					</table>
				</center>
			</div>
		</h:form>

		<h:form>
			<div class="abstand2">
				<center>
					<table width="900" border="1" rules="groups" cellpadding="8">
						<tr>
							<th align="center">Show all Rooms</th>
						</tr>
						<tbody>
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

	</f:view>
</body>
</html>