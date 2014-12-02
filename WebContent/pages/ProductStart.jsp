<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"  %>

<html >
	<head>
		<title ><s:text name="welcome.title"/></title>
	</head>
	
	<body bgcolor="white">
	
		<h2>
		<s:text name="Produkt bearbeiten" />
		</h2>
		
		<p><s:text name="Wollen Sie ein Produkt erstellen oder ein Produkt löschen?"/></p>
		
	
		<p>
			<a href="<s:url action="Product_start" method="create"/>">
				<s:text name="Produkt erstellen"/>
			</a>
		</p>
		<p>
			<a href="<s:url action="Product_start" method="delete"/>">
				<s:text name="Produkt löschen"/>
			</a>
		</p>
		
	</body>
</html>
