<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<!--<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" /> -->
</head>
<body>

	<h3>Please Enter Product Details</h3>
	<form:form method="POST" action="/addProduct" modelAttribute="product">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td><form:label path="productName">Product Name</form:label></td>
				<td><form:input path="productName" /></td>
			</tr>
			<tr>
				<td><form:label path="description">Product Description</form:label></td>
				<td><form:input path="description" /></td>
			</tr>

			<tr>
				<td>Catagory Type :</td>
				<td><form:select path="productType">
						<form:option value="NONE" label="--- Select ---" />
						<form:option value="juice" label="Juice" />
						<form:option value="milkShakes" label="Milk Shake" />
						<form:option value="softDrinks" label="Soft Drinks" />
						<form:option value="tonicWater" label="Tonic Water" />
						<form:option value="energyDrink" label="Energy Drink" />
					</form:select></td>
				<td><form:errors path="productType" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="specifications">Product Specifications</form:label></td>
				<td><form:input path="specifications" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>