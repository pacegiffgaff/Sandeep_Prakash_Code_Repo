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
			<h1>Submitted Product Informatio</h1>
		</header>
		<div class="starter-template">
			<table
				class="table table-striped table-hover table-condensed table-bordered">
				<tr>
					<th>Product ID :</th>
					<th>Total Stock</th>
					<th>Current Stock </th>
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




<body>
    <h2>Submitted Employee Information</h2>
    <table>
        <tr>
            <td>Product Name :</td>
            <td>${productName}</td>
        </tr>
        <tr>
            <td>Product ID :</td>
            <td>${productId}</td>
        </tr>
        <tr>
            <td>Contact Number :</td>
            <td>${contactNumber}</td>
        </tr>
    </table>
</body>



 <tr>
                    <td><form:label path="productName">Product Name</form:label></td>
                    <td><form:input path="productName"/></td>
                </tr>
                <tr>
                    <td><form:label path="description">Product Description</form:label></td>
                    <td><form:input path="description"/></td>
                </tr>
                <tr>
                    <td><form:label path="productType">Product Type</form:label></td>
                    <td><form:input path="productType"/></td>
                </tr>
                 <tr>
                    <td><form:label path="specifications">Product Specifications</form:label></td>
                    <td><form:input path="specifications"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="productComponentList.quantity">
                      Quantity</form:label></td>
                    <td><form:input path="productComponentList.quantity"/></td>
                </tr>
                 <tr>
                    <td><form:label path="productComponentList.rawMaterial.rawMaterialName">
                      Raw Materials</form:label></td>
                    <td><form:input path="productComponentList.rawMaterial.rawMaterialName"/></td>
                </tr>
                