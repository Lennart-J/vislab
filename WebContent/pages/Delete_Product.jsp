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

	<h2><s:text name="Produkt löschen" /></h2>
	 
	<s:form action="Product_edit" focusElement="name" >
		<s:textfield name="name" key="prompt.product" size="25" />
		
		<s:submit method="delete" value="Löschen"/>
	</s:form>
	<p> 
		<a href="<s:url action="Navigate_Back"/>">
			<s:text name="Zurück zur Suche"/>
		</a>
	</p>
	 <font color="red">
	 	<s:actionerror label="label" />
	 </font>

	<font color="blue">
		<s:actionmessage label="label" />
	</font>
			 	 
 </body>
</html>