<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title><s:text name="welcome.title" /></title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/main.css">
</head>

<body bgcolor="white">
	
	<h2 id="detailsite"><s:text name="welcome.title" /></h2>
	
	<font color="red"> <s:actionmessage />
	</font>

	<p>
		<s:text name="welcome.message" />
	</p>

	<p>
		<s:text name="welcome.address" />
		<s:property value="firstname" />
		<s:property value="lastname" />
	</p>

	<p>
		<s:text name="welcome.success" />
	</p>

	<p>
		<a href="<s:url action="Webshop_forward"/>"> Weiter zum Shop
		</a>
	</p>

	<font color="red"> <s:actionerror label="label" />
	</font>


</body>
</html>
