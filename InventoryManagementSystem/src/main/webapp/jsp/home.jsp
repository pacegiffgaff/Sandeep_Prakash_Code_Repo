<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
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
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<ul class="nav nav-pills a nav-tabblock flex-column">
				<li class="nav-item "><a class="nav-link " href="#">Add/update</a>
				</li>
				
			</ul>


			<ul class="nav nav-pills a nav-tabblock flex-column">
				<li class="nav-item"><a class="nav-link " href="#">WareHouse</a>
				</li>

			</ul>
			<ul class="nav nav-pills a nav-tabblock flex-column">
				<li class="nav-item"><a class="nav-link " href="#">Production
						and Quality</a></li>

			</ul>
			<ul class="nav nav-pills a nav-tabblock flex-column">
				<li class="nav-item"><a class="nav-link " href="#">Product
						Shipping Address</a></li>

			</ul>
			<ul class="nav nav-pills a nav-tabblock flex-column">
				<li class="nav-item"><a class="nav-link " href="#">Address
						List</a></li>

			</ul>
			<ul class="nav nav-pills a nav-tabblock flex-column">
				<li class="nav-item"><a class="nav-link"
					onclick="document.forms['logoutForm'].submit()">Logout</a></li>

			</ul>

			<!-- 
			<div>
				<button class="btn btn-lg btn-tabborder btn-tabblock"
					onclick="document.forms['logoutForm'].submit()">Logout</button>
			</div>
 -->
		</c:if>

		<footer>
			<div class="row">
				<div class="col-md-6">
					<p>Copyright &copy; 2020 Inventory Management Service</p>
				</div>
				<div class="col-md-6 text-md-right">
					<a href="#" class="text-dark">Terms of Use</a> <span
						class="text-muted mx-2">|</span> <a href="#" class="text-dark">Privacy
						Policy</a>
				</div>
			</div>
		</footer>
	</div>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>