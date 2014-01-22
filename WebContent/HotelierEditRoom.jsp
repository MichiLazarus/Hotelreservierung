<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="hotel2013.hm.*"%>
<%@ page import="hotel2013.hm.data.*"%>
<%@ page import="hotel2013.hm.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HotelierInterface</title>
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

<script type="text/javascript">
function MakeNewOfferÜberprüfung () {

	if ((document.EditRoom.price.value == "") || isNaN(document.EditRoom.price.value) || (document.EditRoom.price.value < 1)){
	    alert("Please enter a valid price!");
	    document.EditRoom.price.focus();
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
<th align="left">Edit Room</th>
<th align="right">
<a href="HotelierShowAllRooms.jsp"><input type="button" value="Back" name="Back" class="button small"/></a>
</th>
</tr>
</table>

<br><br>
<center>

<form name="EditRoom" action="MasterServlet" method="post" onsubmit="return MakeNewOfferÜberprüfung()">

<table width="600"  border="1" rules="groups" cellpadding="8">
<tr>
<th align="left">Edit Room</th>
<th></th><th></th>
</tr>
<tbody>
<tr>
<th align="left">Roomnumber:</th>
<%
	String rnumber = Integer.toString(MasterServlet.getSroomnumber());
	out.println("<th align=\"left\">"+rnumber+"</th>");
	out.println("<input type=\"hidden\" name=\"rnumber\" value=" + rnumber + ">");
	
	String price = Double.toString(MasterServlet.getSprice());
	String equipment = MasterServlet.getSequipment();
	String nop = Integer.toString(MasterServlet.getSnop());
	%>
</tr>

<tr>
<th align="left">Price / Night:</th>
<th align="left"><input type="text" name="price" size="22" maxlength="40">
<%out.println("<td align=\"left\">Current: " + price + "</td>");%>
</th>
</tr>

<tr>
<th align="left">Equipment:</th>
<th align="left"><select name="equipment">
	<option value="Superior Suite">Superior Suite</option>
	<option value="Business Suite">Business Suite</option>
	<option value="High Class Room">High Class Room</option>
	<option value="Economy Class Room">Economy Class Room</option>
	</select></th>
<%out.println("<td align=\"left\">Current: " + equipment + "</td>");%>
</tr>

<tr>
<th align="left">Number of Persons:</th>
<th align="left"><select name="nop">
				 <option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option>
				 <option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option>
 				 <option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option>
			     </select></th>
<%out.println("<td align=\"left\">Current: " + nop + "</td>");%>			     
</tr>

</tbody>
<tfoot style="background-color: #B6B6B4">
<tr>
<th></th>
<th><input type="submit" name="submit" value="FinishEdit" class="button small"></th>
<th></th>
</tr>
</tfoot>
</table>

</form>
</center>

</body>
</html>