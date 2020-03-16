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
	<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-3">
		<div class="container">
			<a href="#" class="navbar-brand mr-3"><h2>Inventory
					Management Service</h2></a>
			<button type="button" class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarCollapse">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<div class="navbar-nav">
					<a href="#" class="nav-item nav-link active">Home</a> <a href="#"
						class="nav-item nav-link">Services</a> <a href="#"
						class="nav-item nav-link">About</a> <a href="#"
						class="nav-item nav-link">Contact</a>
				</div>
				<div class="navbar-nav ml-auto">
					<a href="#" class="nav-item nav-link">Register</a> <a href="#"
						class="nav-item nav-link">Login</a>
				</div>
			</div>
		</div>
	</nav>
	<div class="container">
		<header>
			<h1>Inventory Management Application</h1>
		</header>
		<div class="starter-template">
			<h1>Stock Information</h1>
			<table
				class="table table-striped table-hover table-condensed table-bordered">
				<tr>
					<th>Stock ID</th>
					<th>Total Stock</th>
					<th>Current Stock</th>
					<th>Product Name</th>
				</tr>
				<c:forEach var="stock" items="${stocks}">
					<tr>
						<td>${stock.stockId}</td>
						<td>${stock.historyTotal}</td>
						<td>${stock.totalCurrentStock}</td>
						<td>${stock.product.productName}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>