<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CustomerInterface</title>
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
function SearchRoomÜberprüfung () {
  if ((document.SearchRoom.price.value == "") || isNaN(document.SearchRoom.price.value) || (document.SearchRoom.price.value < 0)) {
    if(document.SearchRoom.price.value != "*"){
		alert("Please enter a valid price!");
	    document.SearchRoom.price.focus();
	    return false;
    }
  }
}

function CancelBookingÜberprüfung () {
	  if ((document.cancelbooking.bookingnumber.value == "") || isNaN(document.cancelbooking.bookingnumber.value)) {
	    alert("Please enter a booking number!");
	    document.cancelbooking.bookingnumber.focus();
	    return false;
	  }
	}
	
function RateBookingÜberprüfung () {
	  if ((document.ratebooking.bookingnumber.value == "") || isNaN(document.ratebooking.bookingnumber.value)) {
	    alert("Please enter a booking number!");
	    document.ratebooking.bookingnumber.focus();
	    return false;
	  }
	  if (document.ratebooking.ratearea.value == "") {
		    alert("Please enter a rating message!");
		    document.ratebooking.ratearea.focus();
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
<th align="left">Customer</th>
<th align="right"><form action="MasterServlet" name="Logout" method="post"><input type="submit" value="Logout" name="submit" class="button small"/></form></th>
</tr>
</table>

<form name="SearchRoom" action="MasterServlet" method="post" onsubmit="return SearchRoomÜberprüfung()">

<table width="350"  border="1" rules="groups" cellpadding="8" style="float:left;" id="Tabellenposition">
<tr>
<th align="left">Search Room</th>
<th></th>
</tr>
<tbody>

<tr>
<th align="left">Price:</th>
<th><input type="text" name="price" size="22" maxlength="40" value="*"></th>
</tr>

<tr>
<th align="left">Equipment:</th>
<th><select name="equipment">
				 <option value="Default">*</option>
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
<tfoot style="background-color: #B6B6B4">
<tr>
<th></th>
<th><input type="submit" name="submit" value="SearchRoom" class="button tiny"></th>
</tr>
</tfoot>
</table>
</form>


<form name="mybookings" action="MasterServlet" method="post" onsubmit="return CancelBookingÜberprüfung()">
<table width="350"  border="1" rules="groups" cellpadding="8" style="float:right;" id="Tabellenposition">
<tr>
<th align="left">MyBookings</th>
<th></th>
</tr>

<tfoot style="background-color: #B6B6B4">
<tr>
<th><input type="submit" name="submit" value="MyBookings" class="button tiny"></th>
<td></td>
</tr>
</tfoot>
</table>

</form>

<div align="center">
<form name="ratebooking" action="MasterServlet" method="post" onsubmit="return RateBookingÜberprüfung()">
<table width="350"  border="1" rules="groups" cellpadding="8">
<tr>
<th align="left">Rate Booking</th>
<th></th>
</tr>
<tbody>
<tr>
<th align="left">Booking number:</th>
<th><input type="text" name="bookingnumber" size="26" maxlength="40"></th>
</tr>
<tr>
<th align="left">Rating text:</th>
<th><textarea rows="4" placeholder="Insert Rating here..." name="ratearea"></textarea></th>
</tr>

</tbody>
<tfoot style="background-color: #B6B6B4">
<tr>
<th></th>
<th><input type="submit" name="submit" value="RateBooking" class="button tiny"></th>
</tr>
</tfoot>
</table>
</form>
</div>

<script type="text/javascript">
alert("Operation Failed!");
</script>

</body>
</html>