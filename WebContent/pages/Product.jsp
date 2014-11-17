<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="welcome.title"/></title>
	<s:head/>
</head>
<body>

	<h2><s:text name="Produkt bearbeiten" /></h2>
	 
	<s:form action="Product_edit" focusElement="name" >
		<s:textfield name="name" key="prompt.product" size="25" />
		
		<s:textarea name="description" key="prompt.description" rows="5" />
		<s:textfield name="price" key="prompt.price" size="25" />
		<s:textfield name="available" key="prompt.available" size="25" />
		<s:textfield name="image" key="prompt.image" size="25" /> <br>
		
		<s:submit method="create" value="Erstellen"/>
	</s:form>
	 
	 <font color="red">
	 	<s:actionerror label="label" />
	 </font>
	 
 </body>
</html>