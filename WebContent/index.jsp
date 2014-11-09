<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"  %>

<html>
	<head>
	    
	</head>
	<body>
		<h2>Willkommen bei Timos Teeshop!</h2>
		
		<p>Waren Sie schon ein mal bei uns? <a href="<s:url action="Login_forward"/>">Zur Login-Seite</a> </p>
		<p> Noch keine Logindaten? 
		<a href="<s:url action="Register_forward"/>">Registrieren Sie sich jetzt!</a> </p>
		
	</body>
</html>
