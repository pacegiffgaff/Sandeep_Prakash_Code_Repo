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
			<h1>Raw Materials in Inventory</h1>
			<table
				class="table table-striped table-hover table-condensed table-bordered">
				<tr>
					<th>Inventory Id</th>
					<th>Raw Material </th>
					<th>Current Inventory</th>
					<th>Total Inventory in History</th>
				</tr>
				<c:forEach var="inventoryItem" items="${inventory}">
					<tr>
						<td>${inventoryItem.inventoryId}</td>
						<td>${inventoryItem.rawMaterial.rawMaterialName}</td>
						<td>${inventoryItem.totalCurrentInventory}</td>
						<td>${inventoryItem.historyTotal}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>