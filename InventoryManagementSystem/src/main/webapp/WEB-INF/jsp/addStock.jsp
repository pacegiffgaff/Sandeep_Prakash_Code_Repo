<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Create an account</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div class="header col-md-12">
			<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-3">
				<div class="container">
					<a href="#" class="navbar-brand mr-3" style="font-size: 24px">Inventory
						Management Service</a>
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
					</div>
				</div>
			</nav>
		</div>
		<div class="sideNav col-md-3">
			<%@include file="sidenavbar.jsp"%>
		</div>
		<div class="content col-md-9">
			<h3>Enter Stock Details</h3>
			<form:form method="POST" action="/stock" modelAttribute="stockForm">

				<form:label path="productName">Total Stock</form:label>
			    <form:select path="productName" class="form-control" placeholder="Product Name">
                        <form:options items="${productNames}" />
                    </form:select>

				<form:label path="quantity">Current Stock</form:label>
				<form:input type="text" path="quantity"
					class="form-control" placeholder="Quantity" />

				<button type="submit" class="btn btn-primary"
					style="margin-top: 9px" name="action" value="add">Add Stock</button>

				<button type="submit" class="btn btn-primary"
					style="margin-top: 9px" name="action" value="delete">Delete Stock</button>
			</form:form>
			<div class="content col-md-9" class="starter-template">
            		    <c:if test="${not empty stock}">
                    			<h1>Products in Stock</h1>
                    			<table
                    				class="table table-striped table-hover table-condensed table-bordered">
                    				<tr>
                    					<th>Stock Id</th>
                    					<th>Product Name</th>
                    					<th>Current Stock</th>
                    					<th>Total Stock in History</th>
                    				</tr>
                    					<tr>
                    						<td>${stock.stockId}</td>
                    						<td>${stock.product.productName}</td>
                    						<td>${stock.totalCurrentStock}</td>
                    						<td>${stock.historyTotal}</td>
                    					</tr>
                    			</table>
                    	</c:if>
                    </div>
			<script type="text/javascript"
				src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		</div>
	</div>

</body>
</html>
