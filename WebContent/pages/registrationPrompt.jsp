<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"  %>

<html>
	<head>
		<title><s:text name="welcome.title"/></title>
		<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/main.css">
	</head>
	
	<body bgcolor="white">
		
		<fieldset>
			<legend> Leider ist etwas schief gelaufen</legend>
			<s:actionerror label="label" />
		</fieldset>
		
		<p>
			<s:property value="username"/>, 
			<a href="<s:url action="Register_forward"/>">
				<s:text name="registration.message"/>
			</a>
		</p>
	 	

	</body>
</html>
