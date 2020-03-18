
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${pageContext.request.userPrincipal.name != null}">
	<form id="logoutForm" method="POST" action="${contextPath}/logout">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<nav class="navbar navbar-inverse">

		<ul class="nav sidebar-nav">

			<li data-toggle="collapse" data-target="#products"
				class="active collapsed"><a href="#">Add/Update Product<span
					class="arrow"></span></a></li>
			<ul class="sub-menu collapse" id="products" style="height: 0px;">
				<li class="active"><a href="/product">Add Product</a></li>
				<li><a href="/viewallproducts">View All Products</a></li>
			</ul>
			<li data-toggle="collapse" data-target="#warehouse"><a href="#">
					Ware House</a></li>
			<ul class="sub-menu collapse" id="warehouse" style="height: 0px;">
				<li data-toggle="collapse" data-target="#rawMaterials"><a
					href="#">Raw Materials</a></li>
				<ul class="sub-menu collapse" id="rawMaterials" style="height: 0px;">
					<li><a href="/inventoryForm">Add Raw Materials</a></li>
					<li><a href="/inventory">Track Raw Materials</a></li>
				</ul>

				<li data-toggle="collapse" data-target="#stock"><a href="#">Stock</a></li>
				<ul class="sub-menu collapse" id="stock" style="height: 0px;">
					<li><a href="/addStock">Add Stock</a></li>
					<li><a href="/stocks">View Stock</a></li>
				</ul>
			</ul>

			<li><a href="#">Production</a></li>
			<li><a href="/order">Order Product</a></li>
			<li><a onclick="document.forms['logoutForm'].submit()" style="color: #337AB7;">Logout</a></li>

		</ul>
	</nav>

</c:if>