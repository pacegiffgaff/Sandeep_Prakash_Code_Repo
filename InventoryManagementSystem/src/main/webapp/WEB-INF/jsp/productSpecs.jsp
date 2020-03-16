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
			<h1>Raw Materials</h1>
			<table
				class="table table-striped table-hover table-condensed table-bordered">
				<tr>
					<th>Product Id</th>
					<th>Product Image</th>
					<th>Product Name</th>
					<th>Raw Materials</th>
					<th>Raw Material Specifications</th>
				</tr>
				<c:forEach var="productSpec" items="${productSpecs}">
					<tr>
						<td>${productSpec.productId}</td>
						<td><img alt="Apple Juice" src="/images/appleJuice.png"
							width="40%" height="40%" /></td>
						<td>${productSpec.productName}</td>
						<td><c:forEach var="productComponent"
								items="${productSpec.productComponentList}">
						${productComponent.rawMaterial.rawMaterialName}<br>
							</c:forEach></td>
						<td>${productSpec.specifications}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>