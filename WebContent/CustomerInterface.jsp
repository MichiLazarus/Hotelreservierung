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
div.abstand2 {margin-top:50px;}
</style>
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
<th align="right"><a href="index.jsp"><input type="button" value="Back" name="Back"/></a></th>
</tr>
</table>


<form name="searchroom" action="MasterServlet" method="post" onsubmit="return Formularüberprüfung()">

<div class="abstand2">
<table width="350"  border="1" rules="groups" cellpadding="8" style="float:left;">
<tr>
<th>Search Room</th>
<th></th>
</tr>
<tbody>

<tr>
<th align="left">Price:</th>
<th><input type="text" name="price" size="22" maxlength="40"></th>
</tr>

<tr>
<th align="left">Equipment:</th>
<th><select name="equipment">
				 <option value="1">Superior Suite</option>
				 <option value="2">Business Suite</option>
 				 <option value="3">High Class Room</option>
 				 <option value="4">Economy Class Room</option>
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
<th><input type="submit" name="searchroom" value="SearchRoom"></th>
</tr>
</tfoot>
</table>
</div>
</form>


<form name="cancelbooking" action="MasterServlet" method="post" onsubmit="return Formularüberprüfung()">
<div class="abstand2" align="right">

<table width="350"  border="1" rules="groups" cellpadding="8" style="float:right;">
<tr>
<th align="center">Cancel Booking</th>
</tr>
<tbody>
<tr>
<th align="center">Booking number:
<h:inputText id="bookingnumber" value=""/>
<h:message for="bookingnumber" errorClass="error" />
</th>
</tr>
</tbody>
<tfoot>
<tr>
<th align="center"><h:commandButton value="Cancel"/></th>
</tr>
</tfoot>
</table>

</div>
</form>



<h:form>
<div class="abstand2">
<center>
<table width="900"  border="1" rules="groups" cellpadding="8">
<tr>
<th align="center">Rate Booking</th>
</tr>
<tbody>
<tr>
<th align="center">Booking number:
<h:inputText id="bookingnumber" value=""/>
<h:message for="bookingnumber" errorClass="error" />
</th>
</tr>
<tr>
<th>Rating text:</th>
</tr>
<tr>
<th align="center"> 
<h:inputTextarea id="rating" value="" cols="50" rows="10"/>
<h:message for="rating" errorClass="error" />
</th>
</tr>
</tbody>
<tfoot>
<tr>
<th align="center"><h:commandButton value="Rate"/></th>
</tr>
</tfoot>
</table>
</center>
</div>
</h:form>

</body>
</html>