<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Create an account</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/inventoryMgmt/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<h1 style="background-color: Tomato;"></h1>
			</form>
			<h1>Welcome to inventory Management Service</h1>

			<a href="/html/productform.html">Add Product</a>

			<h4>
				<a onclick="document.forms['logoutForm'].submit()">Logout</a>
			</h4>
		</c:if>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>