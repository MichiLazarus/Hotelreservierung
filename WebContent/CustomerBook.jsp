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
h1 {color:#FFD801; font-size:48px;}
body {background-image:url("Hintergrund-Grau.png"); margin-left:5rem; margin-right:5rem;}
div.abstand {margin-top:150px;}
#Kopfzeile {background-image:url("Kopfzeile-Schwarz.png");background-repeat:repeat-x; border-radius: 10px; font-family: 'Hammersmith One'; margin-left:5rem; margin-right:5rem; margin-top:30px;}
#Kopfzeile1 {background-image:url("Kopfzeile-Schwarz.png");background-repeat:repeat-x; font-family: 'Hammersmith One'; margin-left:5rem; margin-right:5rem; border:0px;}
#Seiteninfo {margin-left:auto; margin-right:auto;}
#Tabellenposition {margin-left:10%; margin-right:10%;}
#Tabellenformat {background-color:#E5E4E2; border-width:3px; width:70%; margin-left:auto; margin-right:auto;}
</style>

<link href='http://fonts.googleapis.com/css?family=Hammersmith+One' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/foundation.css">

<script type="text/javascript">
function Bookingueberpruefung (){

	  //Ueberpruefung, ob das Datum syntaktisch und semantisch richtig ist.
	  if((document.book.bookingstart.value.length != 10) || isNaN(document.book.bookingstart.value.substring(0,2)) || isNaN(document.book.bookingstart.value.substring(3,5)) || isNaN(document.book.bookingstart.value.substr(6,4)) || document.book.bookingstart.value.charAt(2) != "." || document.book.bookingstart.value.charAt(5) != "." ) {
		    alert("Invalid date format: Use DD.MM.YYYY");
		    document.book.bookingstart.focus();
		    return false;
	  }
	  
	  if((document.book.bookingstart.value.substring(0,2)>31) || (document.book.bookingstart.value.substring(3,5)>12) || (document.book.bookingstart.value.substr(6,4)>2016)){
		  alert("Invalid date: " + document.book.bookingstart.value + "\n Hint: You can only book before 2017 !");
		  document.book.bookingstart.focus();
		  return false;
	  }
		  
	  //Ueberpruefung, ob das Datum im Februar liegt und ob der Februar ein Schaltjahr ist.
	  if(document.book.bookingstart.value.substring(0,2)>28){
		  if(document.book.bookingstart.value.substring(3,5)==2){
		    if((document.book.bookingstart.value.substr(6,4)%4 != 0) || (document.book.bookingstart.value.substring(0,2)!=29)){
			    alert("Invalid date: " + document.book.bookingstart.value + "\n February has only 28 days exept for leapyears !");
			    document.book.bookingstart.focus();
			    return false;
		    }
  		  }
	  }
	  
	  //Ueberpruefung, ob der Tag eines Datums 31 ist und ob dieser in einem Monat mit nur 30 Tagen liegt.
	  if(document.book.bookingstart.value.substring(0,2)>30){
		  if(document.book.bookingstart.value.substring(3,5) == 4 || document.book.bookingstart.value.substring(3,5) == 6 || document.book.bookingstart.value.substring(3,5) == 9 || document.book.bookingstart.value.substring(3,5) == 11){
		    alert("Invalid date: " + document.book.bookingstart.value + "\n This month has only 30 days !");
		    document.book.bookingstart.focus();
		    return false;
	  		  }
		  }
	  
	  
	//Ueberpruefung, ob das Datum syntaktisch und semantisch richtig ist.
	  if((document.book.bookingend.value.length != 10) || isNaN(document.book.bookingend.value.substring(0,2)) || isNaN(document.book.bookingend.value.substring(3,5)) || isNaN(document.book.bookingend.value.substr(6,4)) || document.book.bookingend.value.charAt(2) != "." || document.book.bookingend.value.charAt(5) != "." ) {
		    alert("Invalid date format: Use DD.MM.YYYY");
		    document.book.bookingend.focus();
		    return false;
	  }
	  
	  if((document.book.bookingend.value.substring(0,2)>31) || (document.book.bookingend.value.substring(3,5)>12) || (document.book.bookingend.value.substr(6,4)>2016)){
		  alert("Invalid date: " + document.book.bookingend.value + "\n Hint: You can only book before 2017 !");
		  document.book.bookingend.focus();
		  return false;
	  }
		  
	  //Ueberpruefung, ob das Datum im Februar liegt und ob der Februar ein Schaltjahr ist.
	  if(document.book.bookingend.value.substring(0,2)>28){
		  if(document.book.bookingend.value.substring(3,5)==2){
		    if((document.book.bookingend.value.substr(6,4)%4 != 0) || (document.book.bookingend.value.substring(0,2)!=29)){
			    alert("Invalid date: " + document.book.bookingend.value + "\n February has only 28 days exept for leapyears !");
			    document.book.bookingend.focus();
			    return false;
		    }
  		  }
	  }
	  
	  //Ueberpruefung, ob der Tag eines Datums 31 ist und ob dieser in einem Monat mit nur 30 Tagen liegt.
	  if(document.book.bookingend.value.substring(0,2)>30){
		  if(document.book.bookingend.value.substring(3,5) == 4 || document.book.bookingend.value.substring(3,5) == 6 || document.book.bookingend.value.substring(3,5) == 9 || document.book.bookingend.value.substring(3,5) == 11){
		    alert("Invalid date: " + document.book.bookingend.value + "\n This month has only 30 days !");
		    document.book.bookingend.focus();
		    return false;
	  		  }
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
<th align="left">Booking</th>
<th align="right"><a href="CustomerSearchRooms.jsp"><input type="button" value="Back" name="Back" class="button small"/></a></th>
</tr>
<tr>
<td>
Please enter your booking data:
</td>
<td></td>
</tr>
</table>

<form name="book" action="MasterServlet" method="post" onsubmit="return Bookingueberpruefung()">
<table width="500" class="small-5 small-centered columns">
<col width="250">
<col width="250">

<tr><th align="left">Roomnr: </th>
<th align="right"><%
	String user = (String) session.getAttribute("person");
	
    out.println("<input type=\"hidden\" name=\"user\" value=" + user + ">");
	String rnumber = Integer.toString(MasterServlet.getSroomnumber());
	out.println("<input type=\"hidden\" name=\"broomnumber\" value=" + rnumber + ">");
	out.println(MasterServlet.getSroomnumber());
%></th></tr>

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

<tr>
<th align="right"><input type="submit" name="submit" value="FinishBooking" class="button small"></th>
<th align="left"><input type="reset" value="Cancel" class="button small"></th>
</tr>
</table>
</form>

</body>
</html>