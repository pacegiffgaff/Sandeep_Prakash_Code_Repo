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
						<div class="navbar-nav ml-auto">
							<a href="#" class="nav-item nav-link">Register</a> <a href="#"
								class="nav-item nav-link">Login</a>
						</div>
					</div>
				</div>
			</nav>
		</div>
		<div class="sideNav col-md-3">
			<%@include file="sidenavbar.jsp"%>
		</div>
		<div class="content col-md-9">
			<h3>Enter Product Details</h3>
			<form:form method="POST" action="/addproduct"
				modelAttribute="product">
				<form:errors path="*" cssClass="errorblock" element="div" />

				<form:label path="productName">Product Name</form:label>
				<form:input type="text" path="productName" class="form-control"
					placeholder="Enter Product Name" />

				<form:label path="description">Product Description</form:label>
				<form:input type="text" path="description" class="form-control"
					placeholder="Product Description" />

				<form:label path="productType">Catagory Type</form:label>
				<form:select class="form-control" path="productType">
					<form:option value="NONE" label="--- Select ---" />
					<form:option value="juice" label="Juice" />
					<form:option value="milkShakes" label="Milk Shake" />
					<form:option value="softDrinks" label="Soft Drinks" />
					<form:option value="tonicWater" label="Tonic Water" />
					<form:option value="energyDrink" label="Energy Drink" />
				</form:select>

				<form:label path="specifications">Product Specifications</form:label>
				<form:input type="text" class="form-control" path="specifications"
					placeholder="Product Specifications" />

				<button type="submit" class="btn btn-primary"
					style="margin-top: 9px">Submit</button>


			</form:form>
			<script type="text/javascript"
				src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		</div>

	</div>
</body>
</html>