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
			<h1>Track Raw Materials</h1>
			<table
				class="table table-striped table-hover table-condensed table-bordered">
				<tr>
					<th>Inventory ID</th>
					<th>Inventory Name</th>
					<th>Total History</th>
					<th>Raw Material</th>
					<th>Current Inventory</th>
				</tr>
				<c:forEach var="trackrawmaterial" items="${trackrawmaterials}">
					<tr>
						<td>${trackrawmaterial.inventoryId}</td>
						<td>${trackrawmaterial.inventoryName}</td>
						<td>${trackrawmaterial.historyTotal}</td>
						<td>${trackrawmaterial.rawMaterial.rawMaterialName}
						<td>${trackrawmaterial.totalCurrentInventory}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>