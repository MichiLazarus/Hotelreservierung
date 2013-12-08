<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<style type="text/css">
h1 {color:#3399CC; font-size:42px;}
body {background-color:#CCC; margin-left:100px; margin-right:100px; font-size:20px;}
div.abstand {margin-top:150px;}
</style>

<script type="text/javascript">
function Formularüberprüfung () {
  if (document.Formular.username.value == "") {
    alert("Please enter username!");
    document.Formular.usenamer.focus();
    return false;
  }
  if (document.Formular.password.value == "") {
    alert("Please enter password!");
    document.Formular.password.focus();
    return false;
  }
  if (document.Formular.fullName.value == "") {
	    alert("Please enter full name!");
	    document.Formular.fullName.focus();
	    return false;
	  }
  if (document.Formular.email.value == "") {
    alert("Please enter email!");
    document.Formular.email.focus();
    return false;
  }
  if (document.Formular.email.value.indexOf("@") == -1) {
    alert("Not an email-adress!");
    document.Formular.email.focus();
    return false;
  }
  if (document.Formular.birthday.value == "") {
    alert("Please enter birthday!");
    document.Formular.birthday.focus();
    return false;
  }
}

function Alert(){
	 alert('User Registered');
}
</script>

</head>
<body>

<f:view>
<table width="900">
<col width="250">
<col width="650">
<tr>
<th align="left"><img alt="Logo" src="Logo.png" width="100" /></th>
<th align="left"><h1>Orbit Hotel</h1></th>
</tr>
</table>
<hr>

<h:form>
<table width="100%" cellpadding="8">
<col width=*>
<col width=*>
<tr>
<th align="left">Register</th>
<th align="right"><h:commandButton value="Back" action="Login.jsp" /></th>
</tr>
</table>
</h:form>

<p>Please enter your register data:</p>


<form name="Formular" action="CustomerInterface.jsp" method="post" onsubmit="return Formularüberprüfung()">
<table width="500">
<col width="250">
<col width="250">
<tr>
<th align="left">Username:</th>
<th align="left"><input type="text" size="40" name="username"></th>
</tr>
<tr>
<th align="left">Password:</th>
<th align="left"><input type="text" size="40" name="password"></th>
</tr>
<tr>
<th align="left">FullName:</th>
<th align="left"><input type="text" size="40" name="fullName"></th>
</tr>
<tr>
<th align="left">E-Mail:</th>
<th align="left"><input type="text" size="40" name="email"></th>
</tr>
<tr>
<th align="left">Birthday:</th>
<th align="left"><input type="text" size="40" name="birthday"></th>
</tr>
<tr>
<th align="left"></th>
<th align="left"><input type="submit" onclick="return Alert()" value="Confirm"><input type="reset" value="Cancel"></th>
</tr>
</table>
</form>


</f:view>
</body>
</html>