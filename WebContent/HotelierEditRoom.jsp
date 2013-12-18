<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="hotel2013.hm.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HotelierInterface</title>
<style type="text/css">
h1 {color:#3399CC; font-size:42px;}
body {background-color:#CCC; margin-left:100px; margin-right:100px; font-size:20px;}
div.abstand {margin-top:150px;}
div.abstand2 {margin-top:50px; margin-left:100px; margin-right:100px;}
</style>

<script type="text/javascript">
function MakeNewOfferÜberprüfung () {
	if ((document.makenewoffer.roomnumber.value == "") || isNaN(document.makenewoffer.roomnumber.value)){
	    alert("Please enter a roomnumber!");
	    document.makenewoffer.roomnumber.focus();
	    return false;
	}
	if ((document.makenewoffer.price.value == "") || isNaN(document.makenewoffer.price.value) || (document.makenewoffer.price.value < 1)){
	    alert("Please enter a valid price!");
	    document.makenewoffer.price.focus();
	    return false;
	}
}

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


<form name="EditRoom" action="MasterServlet" method="post" onsubmit="return MakeNewOfferÜberprüfung()">

<table width="350"  border="1" rules="groups" cellpadding="8" style="float:right;">
<tr>
<th align="left">Edit Room</th>
<th></th>
</tr>
<tbody>
<tr>
<th align="left">Roomnumber:
<%
	String rnumber = Integer.toString(MasterServlet.getSroomnumber());
	out.println(rnumber);
	out.println("</th>"); 
	out.println("<input type=\"hidden\" name=\"rnumber\" value=" + rnumber + ">");
	%>
</tr>

<tr>
<th align="left">Price / Night:</th>
<th><input type="text" name="price" size="22" maxlength="40"></th>
</tr>

<tr>
<th align="left">Equipment:</th>
<th><select name="equipment">
				 <option value="Superior Suite">Superior Suite</option>
				 <option value="Business Suite">Business Suite</option>
 				 <option value="High Class Room">High Class Room</option>
 				 <option value="Economy Class Room">Economy Class Room</option>
			     </select></th></tr>

<tr>
<th align="left">Number of Persons:</th>
<th align="right"><select name="nop">
				 <option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option>
				 <option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option>
 				 <option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option>
			     </select></th></tr>

</tbody>
<tfoot>
<tr>
<th></th>
<th align="center"><input type="submit" name="submit" value="FinishEdit"></th>
</tr>
</tfoot>
</table>

</form>
</div>

<br><br>


</body>
</html>