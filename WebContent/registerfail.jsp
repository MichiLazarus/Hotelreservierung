<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
		 if (document.register.username.value == "" ||document.register.username.value.indexOf("+") != -1 ||document.register.username.value.indexOf("#")!= -1||document.register.username.value.indexOf("-") != -1||document.register.username.value.indexOf("*")!= -1 ||document.register.username.value.indexOf("=")!= -1
				  ||document.register.username.value.indexOf("&") != -1||document.register.username.value.indexOf("%") != -1 ||document.register.username.value.indexOf("!") != -1||document.register.username.value.indexOf("§") != -1||document.register.username.value.indexOf("(")!= -1 ||document.register.username.value.indexOf(")")!= -1
				  ||document.register.username.value.indexOf(".") != -1||document.register.username.value.indexOf(";") != -1||document.register.username.value.indexOf("ß") != -1||document.register.username.value.indexOf("<") != -1
				  ||document.register.username.value.indexOf(">") != -1||document.register.username.value.indexOf("|") != -1||document.register.username.value.indexOf("µ") != -1||document.register.username.value.indexOf("{") != -1||document.register.username.value.indexOf("}")!= -1
				  ||document.register.username.value.indexOf("[") != -1 ||document.register.username.value.indexOf("]") != -1||document.register.username.value.indexOf("@") != -1||document.register.username.value.indexOf("~") != -1||document.register.username.value.indexOf("'")!= -1) {
		    alert("Please enter valid username!");
		    document.register.username.focus();
		    return false;
		  }
		  if (document.register.password.value == "" || document.register.username.value.indexOf("+") != -1 ||document.register.username.value.indexOf("#")!= -1||document.register.username.value.indexOf("-") != -1||document.register.username.value.indexOf("*")!= -1 ||document.register.username.value.indexOf("=")!= -1
				  ||document.register.username.value.indexOf("&") != -1||document.register.username.value.indexOf("%") != -1 ||document.register.username.value.indexOf("!") != -1||document.register.username.value.indexOf("§") != -1||document.register.username.value.indexOf("(")!= -1 ||document.register.username.value.indexOf(")")!= -1
				  ||document.register.username.value.indexOf(".") != -1||document.register.username.value.indexOf(";") != -1||document.register.username.value.indexOf("ß") != -1||document.register.username.value.indexOf("<") != -1
				  ||document.register.username.value.indexOf(">") != -1||document.register.username.value.indexOf("|") != -1||document.register.username.value.indexOf("µ") != -1||document.register.username.value.indexOf("{") != -1||document.register.username.value.indexOf("}")!= -1
				  ||document.register.username.value.indexOf("[") != -1 ||document.register.username.value.indexOf("]") != -1||document.register.username.value.indexOf("@") != -1||document.register.username.value.indexOf("~") != -1||document.register.username.value.indexOf("'")!= -1) {
		    alert("Please enter password!");
		    document.register.password.focus();
		    return false;
		  }
		  if (document.register.fullname.value == "" || document.register.username.value.indexOf("+") != -1 ||document.register.username.value.indexOf("#")!= -1||document.register.username.value.indexOf("-") != -1||document.register.username.value.indexOf("*")!= -1 ||document.register.username.value.indexOf("=")!= -1
				  ||document.register.username.value.indexOf("&") != -1||document.register.username.value.indexOf("%") != -1 ||document.register.username.value.indexOf("!") != -1||document.register.username.value.indexOf("§") != -1||document.register.username.value.indexOf("(")!= -1 ||document.register.username.value.indexOf(")")!= -1
				  ||document.register.username.value.indexOf(".") != -1||document.register.username.value.indexOf(";") != -1||document.register.username.value.indexOf("ß") != -1||document.register.username.value.indexOf("<") != -1
				  ||document.register.username.value.indexOf(">") != -1||document.register.username.value.indexOf("|") != -1||document.register.username.value.indexOf("µ") != -1||document.register.username.value.indexOf("{") != -1||document.register.username.value.indexOf("}")!= -1
				  ||document.register.username.value.indexOf("[") != -1 ||document.register.username.value.indexOf("]") != -1||document.register.username.value.indexOf("@") != -1||document.register.username.value.indexOf("~") != -1||document.register.username.value.indexOf("'")!= -1       ||document.register.username.value.indexOf("0") != -1
				  ||document.register.username.value.indexOf("1") != -1 ||document.register.username.value.indexOf("2") != -1 ||document.register.username.value.indexOf("3") != -1 ||document.register.username.value.indexOf("4") != -1 ||document.register.username.value.indexOf("5") != -1 ||document.register.username.value.indexOf("6") != -1 ||document.register.username.value.indexOf("7") != -1
				  ||document.register.username.value.indexOf("8") != -1 ||document.register.username.value.indexOf("9") != -1 ) {
			    alert("Please enter full name!");
			    document.register.fullname.focus();
			    return false;
			  }
		  if (document.register.email.value == "") {
		    alert("Please enter email!");
		    document.register.email.focus();
		    return false;
		  }
			mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
		  if(!document.register.email.value.match(mailformat))  {
		    alert("Not an email-adress!");
		    document.register.email.focus();
		    return false;
		  }
		  check = /^\d{2}\.\d{2}\.\d{4}$/;

		  if(!document.register.birthday.value.match(check)) {
		    alert("Invalid date format: " + document.register.birthday.value);
		    document.register.birthday.focus();
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
<th align="left">Register</th>
<th align="right"><a href="index.jsp"><input type="button" value="Back" name="Back"/></a></th>
</tr>
</table>

<p>Please enter your register data:</p>

<form name="register" action="MasterServlet" method="post" onsubmit="return Formularüberprüfung()">
<table width="500">
<col width="250">
<col width="250">

<tr>
<th></th>
<th align="left"><font color="red" size="-0.5">User bereits vorhanden oder Sie sind unter 18!</font></th>
</tr>
<tr>
<th align="left">User-Category:</th>
<th align="left"><select name="status">
				 <option value="customer">Customer</option>
 				 <option value="hotelier">Hotelier</option>
 				 <option value="analyst">Analyst</option>
			     </select></th>
</tr>
<tr>
<th align="left">Username:</th>
<th align="left"><input type="text" name="username" size="40" maxlength="40"></th>
</tr>
<tr>
<th align="left">Password:</th>
<th align="left"><input type="text" name="password" size="40" maxlength="40"></th>
</tr>
<tr>
<th align="left">FullName:</th>
<th align="left"><input type="text" name="fullname" size="40" maxlength="40"></th>
</tr>
<tr>
<th align="left">E-Mail:</th>
<th align="left"><input type="text" size="40" maxlength="40" name="email"></th>
</tr>
<tr>
<th align="left">Sex:</th>
<th align="left"><select name="sex">
				 <option value="f">Female</option>
 				 <option value="m">Male</option>
			     </select></th>
</tr>
<tr>
<th align="left"><font size="-0.5">Birthday: (DD.MM.YYYY)</font></th>
<th align="left"><input type="text" name="birthday" size="40" maxlength="40"></th>
</tr>
<tr>
<th align="left"></th>
<th align="left"><input type="submit" name="submit" value="Register"><input type="reset" value="Cancel"></th>
</tr>
</table>
</form>

</body>
</html>