<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>
	<div class="container">
		<header>
			<h1>Inventory Management Application</h1>
		</header>
		<div class="starter-template">
			<h1>Product List</h1>
			<table
				class="table table-striped table-hover table-condensed table-bordered">
				<tr>
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Product Description</th>
					<th>Product Type</th>
				</tr>
				<c:forEach var="products" items="${products}">
					<tr>
						<td>${products.productId}</td>
						<td>${products.productName}</td>
						<td>${products.description}</td>
						<td>${products.productType}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>