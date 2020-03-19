<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	  <meta name="_csrf" content="${_csrf.token}"/>
        <!-- default header name is X-CSRF-TOKEN -->
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
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
							<a href="#" class="nav-item nav-link active">Home</a> <a href="/cart"
								class="nav-item nav-link">Cart</a>
						</div>
					</div>
				</div>
			</nav>
		</div>
		<div class="sideNav col-md-3">
			<%@include file="sidenavbar.jsp"%>
		</div>

		<div class="content col-md-9">
			<header>
				<h3>Cart </h3>
			</header>
			<div class="starter-template">
			<form:form method="post" action="/order" modelAttribute="orderForm">
				<table
					class="table table-striped table-hover table-condensed table-bordered">
					<tr>
						<th>Product Name</th>
						<th>Product Quantity</th>
						<th>            </th>
					</tr>
					<c:if test="${not empty orderForm.orderMap}">
					<c:forEach items="${orderForm.orderMap}" var="orderMap" varStatus="status">
                    		<tr>
                    			<td>${orderMap.key}</td>
                    			<td><input name="orderMap['${orderMap.key}']" value="${orderMap.value}"/></td>
                    		</tr>
                    	</c:forEach>
                    	</c:if>
				</table>
				<button type="submit" class="btn btn-primary"
                					style="margin-top: 9px" >Place Order</button>
				</form:form>
			</div>

		</div>

		<script type="text/javascript"
			src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</div>
</body>

</html>


