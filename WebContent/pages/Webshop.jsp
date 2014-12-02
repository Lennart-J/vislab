<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="welcome.title" /></title>
<s:head />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/main.css">
</head>
<body>
	<div class="main wrapper">
		<h2>
			<s:text name="welcome.title" />
		</h2>

		<div class="search wrapper">
			<h3>Suche</h3>
			<hr>
			<s:form action="Product_search" focusElement="minPrice">
				<s:textfield type="number" name="minPrice" step="0.01" min="0"
					key="search.minprice" />
				<s:textfield type="number" name="maxPrice" step="0.01" min="0"
					key="search.maxprice" />
				<s:textfield name="name" key="search.name" />
				<s:textfield name="category" key="search.category" />
				<s:textfield name="description" key="search.description" />

				<s:submit method="search" value="Suchen" />
			</s:form>
		</div>

		<div class="products wrapper">
			<h3>Produkte</h3>
			<s:form action="CreateProduct_forward">
				<s:submit key="product.create" action="CreateProduct_forward"></s:submit>
			</s:form>
			<s:form action="DeleteProduct_forward">
				<s:submit key="product.delete" action="DeleteProduct_forward"></s:submit>
			</s:form>
			<s:form action="EditCategory_forward">
				<s:submit key="category.edit" action="EditCategory_forward"></s:submit>
			</s:form>
			<hr>

			<s:iterator value="productList" var="productList">
				<div class="product">
					<div class="product-image">
						<img alt=""
							src='${pageContext.request.contextPath}/images/<s:property value="image"/>'>
					</div>
					<div class="product-info">
						<h3>
							<a href="details?name=<s:property value="name"/>">
								<s:property value="name"/>
							</a>
						</h3>
						
						<p>
							<s:text name="product.price" />
							<s:property value="price" />
							€
						</p>

					</div>

				</div>
				<hr>
			</s:iterator>

			<font color="#2E9AFE"> <s:actionmessage label="label" />
			</font>
		</div>
	</div>
</body>
</html>