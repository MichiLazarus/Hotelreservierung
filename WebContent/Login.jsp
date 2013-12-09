<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
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
<div class="abstand">
<center>
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
<h:inputText id="username" value="#{usercontroller.username}"/>
<h:message for="username" errorClass="error" />
</th>
</tr>
<tr>
<th align="center">Password</th>
</tr>
<tr>
<th align="center">
<h:inputSecret id="password" value="#{usercontroller.password}" />
<h:message for="password" errorClass="error" />
</th>
</tr>
<tr>
<th align="center"><h:commandButton action="#{hotelmanagement.login}" value="Login"  /></th>
</tr>
</tbody>
<tfoot>
<tr>
<th align="center"><h:commandButton value="Register" action="Register.jsp" /></th>
</tr>
</tfoot>
</table>
</center>
</div>
</h:form>

</f:view>
</body>
</html>