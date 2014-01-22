<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AnalystInterface</title>
<style type="text/css">
h1 {color:#FFD801; font-size:48px;}
body {background-image:url("Hintergrund-Grau.png"); margin-left:5rem; margin-right:5rem;}
div.abstand {margin-top:150px;}
#Kopfzeile {background-image:url("Kopfzeile-Schwarz.png");background-repeat:repeat-x; border-radius: 10px; font-family: 'Hammersmith One'; margin-left:5rem; margin-right:5rem; margin-top:30px;}
#Kopfzeile1 {background-image:url("Kopfzeile-Schwarz.png");background-repeat:repeat-x; font-family: 'Hammersmith One'; margin-left:5rem; margin-right:5rem; border:0px;}
#Seiteninfo {margin-left:auto; margin-right:auto;}
#Tabellenposition {margin-left:10%; margin-right:10%;}
</style>

<link href='http://fonts.googleapis.com/css?family=Hammersmith+One' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/foundation.css">

<script type="text/javascript">

function ShowRatingÜberprüfung () {
	if ((document.showrating.roomnumber.value == "") || isNaN(document.showrating.roomnumber.value)){
	    alert("Please enter a roomnumber!");
	    document.showrating.roomnumber.focus();
	    return false;
	}
}
</script>

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
		<th align="left">Analyst</th>
		<th align="right">
		<a href="index.jsp"><input type="button" value="Logout" name="Logout" class="button small"/></a>
		</th>
	</tr>
</table>


<form name="showrating" action="MasterServlet" method="post" onsubmit="return ShowRatingÜberprüfung()">
<table width="350"  border="1" rules="groups" cellpadding="8" style="float:left;" id="Tabellenposition">
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
<tfoot style="background-color: #B6B6B4">
<tr>
<th></th>
<th align="center"><input type="submit" name="submit" value="Show Rating" class="button tiny"></th>
</tr>
</tfoot>
</table>
</form>



<form name="showallrooms" action="AnalystShowAllRooms.jsp" method="post">
<table width="350"  border="1" rules="groups" cellpadding="8" style="float:left;" id="Tabellenposition">
	<tr>
		<th align="left">Show all Rooms</th><th></th>
	</tr>
<tfoot style="background-color: #B6B6B4">
	<tr>
		<th></th>
		<th><input type="submit" name="submit" value="Show all Rooms" class="button tiny"></th>
	</tr>
</tfoot>
</table>
</form>

<form name="ShowStatistic" action="MasterServlet" method="post">
<table width="900" border="1" rules="groups" cellpadding="8" id="Tabellenposition">
	<tr>
		<th></th>
		<th align="center">Show Statistic</th>
		<th></th>
	</tr>
<tbody>
	<tr>
		<th align="center">Season Statistic</th>
		<th align="center">Price Statistic</th>
		<th align="center">Occupancy Statistic</th>
	</tr>								
	<tr>
		<td align="left">Year: </td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td><select name="year">
				 <option value="2014">2014</option>
				 <option value="2015">2015</option>
				 <option value="2016">2016</option>
		</select></td>
		<td></td>
		<td></td>
	
</tbody>
<tfoot style="background-color: #B6B6B4">
	<tr>
		<td style="text-align:center;"><input type="submit" name="submit" value="SeasonStatistic" class="button tiny"></td>
		<td style="text-align:center;"><input type="submit" name="submit" value="PriceStatistic" class="button tiny"></td>
		<td style="text-align:center;"><input type="submit" name="submit" value="OccStatistic" class="button tiny"></td>						
	</tr>
</tfoot>
</table>
</form>

<script type="text/javascript">
alert("Create Price Offer operation failed!");
</script>

</body>
</html>