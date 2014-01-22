<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style type="text/css">
h1 {color:#FFD801; font-size:48px;}
body {background-image:url("Hintergrund-Grau.png"); margin-left:5rem; margin-right:5rem;}
div.abstand {margin-top:150px;}
#Kopfzeile {background-image:url("Kopfzeile-Schwarz.png");background-repeat:repeat-x; border-radius: 10px; font-family: 'Hammersmith One'; margin-left:5rem; margin-right:5rem; margin-top:30px;}
#Kopfzeile1 {background-image:url("Kopfzeile-Schwarz.png");background-repeat:repeat-x; font-family: 'Hammersmith One'; margin-left:5rem; margin-right:5rem; border:0px;}
</style>

<link href='http://fonts.googleapis.com/css?family=Hammersmith+One' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/foundation.css">

<script type="text/javascript">
function Formularüberprüfung () {
  if (document.login.username.value == "") {
    alert("Please enter username!");
    document.login.username.focus();
    return false;
  }
  if (document.login.password.value == "") {
    alert("Please enter password!");
    document.login.password.focus();
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

<div class="abstand">
<center>

<form name="login" action="MasterServlet" method="post" onsubmit="return Formularüberprüfung()">

<table width="450" rules="groups" cellpadding="8">

<tr>
<th align="center">Login</th>
</tr>

<tbody>
	<tr>
		<th align="center">Username</th>
	</tr>
	<tr>
		<th align="center">
		<input type="text" name="username" size="40" maxlength="40">
		</th>
	</tr>
	<tr>
		<th align="center">Password</th>
	</tr>
	<tr>
		<th align="center">
		<input type="password" name="password" size="40" maxlength="40">
		</th>
	</tr>
	
	<tr>
		<th>
		<font color="red" size="-0.5">Falsche Eingabe!</font>
		</th>
	</tr>
	
</tbody>

<tfoot style="background-color: #B6B6B4">
	<tr>
		<th style="text-align: center"><input type="submit" name="submit" value="Login" class="button tiny"></th>
	</tr>
</tfoot>

</table>
</form>

<br>
<a href="Register.jsp"><input type="button" value="Register" name="ToRegister" class="button"/></a>
</center>
</div>

</body>
</html>