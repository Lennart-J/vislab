<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="welcome.title"/></title>
	<s:head/>
	<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/main.css">
</head>
<body>

	<h2 id="detailsite"><s:text name="welcome.title" /></h2>
	 
	<s:form action="User_register" focusElement="username" >
		<s:textfield name="username" key="prompt.username" size="20"/>
		<s:password name="password" key="prompt.password" size="20"/>
		<s:textfield name="lastname" key="prompt.lastname" size="20"/>
		<s:textfield name="firstname" key="prompt.firstname" size="20"/><br>
		
		<s:submit method="execute" value="Registrieren" align="center"/>
	</s:form>
	 
	 <font color="red">
	 	<s:actionerror label="label" />
	 </font>
	 
 </body>
</html>