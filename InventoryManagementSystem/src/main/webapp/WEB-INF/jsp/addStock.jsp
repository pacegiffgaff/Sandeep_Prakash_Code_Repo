<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

	<h3>Please Enter Stock Details</h3>
	<form:form method="POST" action="/addStock" modelAttribute="stock">
		<table>
			<tr>
				<td><form:label path="historyTotal">Stock History</form:label></td>
				<td><form:input path="historyTotal" /></td>
			</tr>
			<tr>
				<td><form:label path="totalCurrentStock">Current Stock</form:label></td>
				<td><form:input path="totalCurrentStock" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Add Stock" /></td>
				<td><input type="submit" value="Update Stock" /></td>
			</tr>
		</table>
	</form:form>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
