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
			<h1>Product Information</h1>
		</header>
		<div class="starter-template">
			<table
				class="table table-striped table-hover table-condensed table-bordered">
				<tr>
					<th>Product ID :</th>
					<th>Product Name</th>
					<th>Product Description</th>
					<th>Product Type</th>
					<th>Product Specification</th>
				</tr>
				<c:forEach var="viewproduct" items="${viewallproducts}">
				<tr>
					<td>${viewproduct.productId}</td>
					<td>${viewproduct.productName}</td>
					<td>${viewproduct.description}</td>
					<td>${viewproduct.productType}</td>
					<td>${viewproduct.specifications}</td>
				</tr>
				</c:forEach>
			</table>
		</div>

	</div>

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>


