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
h1 {color:#3399CC; font-size:42px;}
body {background-color:#CCC; margin-left:100px; margin-right:100px; font-size:20px;}
div.abstand {margin-top:150px;}
div.abstand2 {margin-top:50px; margin-left:150px; margin-right:150px;}
</style>

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
<th align="left">Hotelier</th>
<th align="right">
<a href="HotelierShowAllRooms.jsp"><input type="button" value="Back" name="Back"/></a>
</th>
</tr>
</table>

<br><br>
<center>

<form name="EditRoom" action="MasterServlet" method="post" onsubmit="return MakeNewOfferÜberprüfung()">

<table width="600"  border="1" rules="groups" cellpadding="8">
<tr>
<th align="left">Edit Room</th>
<th></th>
</tr>
<tbody>
<tr>
<th align="left">Roomnumber:</th>
<%
	String rnumber = Integer.toString(MasterServlet.getSroomnumber());
	out.println("<td align=\"left\">"+rnumber+"</td>");
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
<tfoot>
<tr>
<th></th>
<th align="center"><input type="submit" name="submit" value="FinishEdit"></th>
</tr>
</tfoot>
</table>

</form>
</center>

</body>
</html>