<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="Teemos Teeshop" /></title>
<s:head />
</head>
<body>

	<h2>
		<s:text name="Kategorie bearbeiten" />
	</h2>

	<s:form action="Category_edit" focusElement="name">
		<s:textfield name="name" key="prompt.category" size="20" />
		<br>

		<s:submit method="create" value="Erstellen" name="create" />
		<s:submit method="delete" value="Löschen" name="delete" />
	</s:form>
	<p> 
		<a href="<s:url action="Navigate_Back"/>">
			<s:text name="Zurück zur Suche"/>
		</a>
	</p>
	<font color="red">
		<s:actionerror label="label" />
	</font>
<<<<<<< HEAD
	<font color="blue">
		<s:actionmessage label="label" />
	</font>
	
=======
	<font color="red">
	 	<s:actionmessage/>
	 </font>

>>>>>>> 033b2292f8cc1406f49c7faa72cb2ee660f4aa41
</body>
</html>