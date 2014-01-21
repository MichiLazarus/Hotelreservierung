<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CustomerInterface</title>
<style type="text/css">
h1 {color:#3399CC; font-size:42px;}
body {background-color:#CCC; margin-left:100px; margin-right:100px; font-size:20px;}
div.abstand {margin-top:150px;}
div.abstand2 {margin-top:50px; margin-left:100px; margin-right:100px;}
</style>

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
<th align="left">Customer</th>
<th align="right">
<a href="index.jsp"><input type="button" value="Logout"name="Logout"/></a>
</th>
</tr>
</table>

<div class="abstand2">
<form name="SearchRoom" action="MasterServlet" method="post" onsubmit="return SearchRoomÜberprüfung()">

<table width="350"  border="1" rules="groups" cellpadding="8" style="float:left;">
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
<tfoot>
<tr>
<th></th>
<th><input type="submit" name="submit" value="SearchRoom"></th>
</tr>
</tfoot>
</table>
</form>

<form name="mybookings" action="MasterServlet" method="post" onsubmit="return CancelBookingÜberprüfung()">

<table width="350"  border="1" rules="groups" cellpadding="8" style="float:right;">
<tr>
<th align="left">MyBookings</th>
<th></th>
</tr>

<tfoot>
<tr>
<th></th>
<th align="center"><input type="submit" name="submit" value="MyBookings"></th>
</tr>
</tfoot>
</table>

</form>
</div>

<br><br><br><br><br><br><br><br>

<div class="abstand2">
<form name="ratebooking" action="MasterServlet" method="post" onsubmit="return RateBookingÜberprüfung()">
<table width="350"  border="1" rules="groups" cellpadding="8" style="float:left;">
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
<tfoot>
<tr>
<th></th>
<th align="center"><input type="submit" name="submit" value="RateBooking"></th>
</tr>
</tfoot>
</table>
</form>
</div>

</body>
</html>