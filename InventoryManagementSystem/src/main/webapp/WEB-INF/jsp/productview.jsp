<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<!--<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" /> -->

<style>
table, th, td {
	padding: 10px;
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<div class="container">
		<header>
			<h1>Submitted Product Information</h1>
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
				<tr>
					<td>${productview.productId}</td>
					<td>${productview.productName}</td>
					<td>${productview.description}</td>
					<td>${productview.productType}</td>
					<td>${productview.specifications}</td>
				</tr>
			</table>
		</div>

	</div>

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>


