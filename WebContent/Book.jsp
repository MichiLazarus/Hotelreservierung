<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="hotel2013.hm.*" %>
<%@ page import="hotel2013.hm.data.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking</title>

<style type="text/css">
h1 {color:#3399CC; font-size:42px;}
body {background-color:#CCC; margin-left:100px; margin-right:100px; font-size:20px;}
div.abstand {margin-top:150px;}
</style>

<script type="text/javascript">
function Bookingüberprüfung () {
	var bookingstart = document.book.bookingstart.value;
	var bookingend = document.book.bookingend.value;

  if (bookingstart.length != 10 || bookingstart.charAt(2) != "." || bookingstart.charAt(5) != "." 
		  || isNaN(bookingstart.substring(0,2)) || isNaN(bookingstart.substring(3,5)) || isNaN(bookingstart.substr(6,4))
		  || bookingstart.substring(0,2) > 31 || bookingstart.substring(3,5) > 12 ) {
    alert("Please enter valid Bookingtstart (DD.MM.YYYY)!");
    document.book.bookingstart.focus();
    return false;
  }
  
  if (bookingend.length != 10 || bookingend.charAt(2) != "." || bookingend.charAt(5) != "." 
	  || isNaN(bookingend.substring(0,2)) || isNaN(bookingend.substring(3,5)) || isNaN(bookingend.substr(6,4))
	  || bookingend.substring(0,2) > 31 || bookingend.substring(3,5) > 12 ) {
	alert("Please enter valid bookingend (DD.MM.YYYY)!");
	document.book.bookingend.focus();
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
<th align="left">Booking</th>
<th align="right"><a href="CustomerSearchRooms.jsp"><input type="button" value="Back" name="Back"/></a></th>
</tr>
</table>

<p>Please enter your booking data:</p>

<form name="book" action="MasterServlet" method="post" onsubmit="return Bookingüberprüfung()">
<table width="500">
<col width="250">
<col width="250">

<tr>
<th align="left">Bookingstart</th>
<th align="left"><input type="text" name="bookingstart" size="40" maxlength="40" value="DD.MM.YYYY"></th>
</tr>
<tr>
<th align="left">Bookingend</th>
<th align="left"><input type="text" name="bookingend" size="40" maxlength="40" value="DD.MM.YYYY"></th>
</tr>
<tr>
<th align="left">Payment-Method</th>
<th align="left"><select name="payment">
				 <option value="Bar">Bar</option>
 				 <option value="CreditCard">CreditCard</option>
			     </select></th>
</tr>
<tr>
<th align="left">Number of Persons:</th>
<th align="right"><select name="bnop">
				 <option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option>
				 <option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option>
 				 <option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option>
			     </select></th></tr>


<%
    out.println("<input type=\"hidden\" name=\"user\" value=" + MasterServlet.getUser() + ">");
	String rnumber = Integer.toString(MasterServlet.getSroomnumber());
	out.println("<input type=\"hidden\" name=\"broomnumber\" value=" + rnumber + ">");
	out.println(MasterServlet.getSroomnumber());%>

<tr>
<th align="left"></th>
<th align="left"><input type="submit" name="submit" value="Finish"><input type="reset" value="Cancel"></th>
</tr>
</table>
</form>

</body>
</html>