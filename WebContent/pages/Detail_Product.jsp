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

	<h2 id="detailsite"><s:text name="product.detailview" /></h2>
	 
		<div>
					<div>
						<img alt=""
							src='${pageContext.request.contextPath}/images/<s:property value="product.image"/>'>
					</div>
					<div>
						<h3>
							<s:property value="product.name"/>
						</h3>
						<p>
							<s:text name="product.category" />
							<s:property value="product.category.name" />
						</p>
						<p>
							<s:property value="product.description" />
						</p>
						<p>
							<s:text name="product.available" />
							<s:property value="product.available" />
						</p>
						<p>
							<s:text name="product.price" />
							<s:property value="product.price" />
							€
						</p>

					</div>

		</div> <br>

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