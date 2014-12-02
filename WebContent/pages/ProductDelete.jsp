<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="Teemos Teeshop" /></title>
<s:head />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/main.css">
</head>
<body>

	<h2>
		<s:text name="Produkt löschen" />
	</h2>

	<s:form action="Product_delete" focusElement="name">
		<s:textfield name="name" key="prompt.product" size="20" />
		<br>

		<s:submit method="delete" value="Löschen" name="delete" />
	</s:form>

	<font color="red"> <s:actionerror label="label" />
	</font>
	<font color="red">
	 	<s:actionmessage/>
	 </font>

</body>
</html>