<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style type="text/css">
h1 {color:#3399CC; font-size:42px;}
body {background-color:#CCC; margin-left:100px; margin-right:100px; font-size:20px;}
div.abstand {margin-top:150px;}
</style>
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
<table width="900">
<col width="250">
<col width="650">
<tr>
<th align="left"><img alt="Logo" src="Logo.png" width="100" /></th>
<th align="left"><h1>Orbit Hotel</h1></th>
</tr>
</table>
<hr>

<div class="abstand">
<center>

<form name="login" action="MasterServlet" method="post" onsubmit="return Formularüberprüfung()">

<table width="450"  border="1" rules="groups" cellpadding="8">

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
<th align="center"><input type="submit" name="submit" value="Login"></th>
</tr>
</tbody>

<tfoot>
</tfoot>
</table>
</form>

<br>
<a href="Register.jsp"><input type="button" value="Register" name="ToRegister"/></a>

</center>
</div>

</body>

</html>