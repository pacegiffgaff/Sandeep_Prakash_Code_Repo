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
<link href="${contextPath}/resources/css/add.css" rel="stylesheet">
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

			<div class="container">
				<ul class="nav nav-pills a nav-tabblock flex-column">
					<li class="nav-item"><a class="nav-link"
						onclick="document.getElementById('id01').style.display='block'">Add/update</a></li>
				</ul>
				<div id="id01" class="w3-modal">
					<div class="w3-modal-content w3-card-4">
						<header class="w3-container w3-teal">
							<span
								onclick="document.getElementById('id01').style.display='none'"
								class="w3-button w3-display-topright">&times;</span>
							<h2>Add Products</h2>
						</header>
						<div class="w3-container flex-column">
							<form name="myForm" action="/action_page.php"
								onsubmit="return validateForm()" method="post">
								<table>
									<tbody>
										<tr style="height: 55px; width: 540px;">
											<td>Product Name:</td>
											<td><input type="text" name="fname"></td>
										</tr>
										<tr style="height: 55px; width: 540px;">
											<td style="width: 250px">Product Description:</td>
											<td style="padding-top: -77;"><input type="text"
												name="fname"></td>
										</tr>
										<tr style="height: 55px; width: 540px;">
											<td style="width: 250px">Product Type:</td>
											<td style="padding-top: -77;"><input type="text"
												name="fname"></td>
										</tr>
										<tr style="height: 55px; width: 540px;">
											<td style="width: 250px">Product price:</td>
											<td style="padding-top: -77;"><input type="text"
												name="fname"></td>
										</tr>
									</tbody>
								</table>
							</form>
						</div>
						<footer class="w3-container w3-teal">
							<input type="submit" value="Add Product"> <input
								type="submit" value="Update Product"> <input
								type="submit" value="Delete Product"> <input
								type="submit" value="view Product">
						</footer>
					</div>
				</div>
			</div>
			<div class="container">
				<ul class="nav nav-pills a nav-tabblock flex-column">
					<li class="nav-item"><a class="nav-link " href="#">WareHouse</a>
					</li>

				</ul>
			</div>
			<div class="container">
				<ul class="nav nav-pills a nav-tabblock flex-column">
					<li class="nav-item"><a class="nav-link " href="#">Production
							and Quality</a></li>

				</ul>
			</div>
			<div class="container">
				<ul class="nav nav-pills a nav-tabblock flex-column">
					<li class="nav-item"><a class="nav-link " href="#">Product
							Shipping Address</a></li>

				</ul>
			</div>
			<div class="container">
				<ul class="nav nav-pills a nav-tabblock flex-column">
					<li class="nav-item"><a class="nav-link " href="#">Address
							List</a></li>

				</ul>
			</div>
			<div class="container">
				<ul class="nav nav-pills a nav-tabblock flex-column">
					<li class="nav-item"><a class="nav-link"
						onclick="document.forms['logoutForm'].submit()">Logout</a></li>

				</ul>
			</div>
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