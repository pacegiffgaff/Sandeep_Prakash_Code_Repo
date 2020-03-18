<%-- <!DOCTYPE html>

<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
</head>
 --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${pageContext.request.userPrincipal.name != null}">
	<form id="logoutForm" method="POST" action="${contextPath}/logout">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<nav class="navbar navbar-inverse">

		<ul class="nav sidebar-nav" style="color: #eee">

			<li data-toggle="collapse" data-target="#products"
				class="active collapsed"><a href="#">Add/update Product<span
					class="arrow"></span></a></li>
			<ul class="sub-menu collapse" id="products" style="height: 0px;">
				<li class="active"><a href="/product">Add product</a></li>
				<li><a href="/viewallproducts">View All products</a></li>
				<li><a href="#">Update product</a></li>
			</ul>
			<li data-toggle="collapse" data-target="#warehouse"><a href="#">Manage
					Ware House</a></li>
			<ul class="sub-menu collapse" id="warehouse" style="height: 0px;">
				<li data-toggle="collapse" data-target="#rawMaterials"><a
					href="#">Raw Materials</a></li>
				<ul class="sub-menu collapse" id="rawMaterials" style="height: 0px;">
					<li><a href="/inventoryForm">Add Raw Materials</a></li>
					<li><a href="/inventory">Track Raw Materials</a></li>
					<li><a href="/productSpecs">Product Specs</a></li>
				</ul>

				<li data-toggle="collapse" data-target="#stock"><a href="#">Stock</a></li>
				<ul class="sub-menu collapse" id="stock" style="height: 0px;">
					<li><a href="/addStock">Add Stock</a></li>
					<li><a href="/stocks">View Stock</a></li>
				</ul>
			</ul>

			<li><a href="#">Production</a></li>
			<li><a href="/order">Order</a></li>
			<li><a onclick="document.forms['logoutForm'].submit()">Logout</a></li>

		</ul>
	</nav>

</c:if>

<!-- </body>

</html> -->

<!-- <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
  ...
  <li class="dropdown-submenu">
    <a tabindex="-1" href="#">More options</a>
    <ul class="dropdown-menu"> -->

<!--  <li class="dropdown-submenu">
    <a tabindex="-1" href="#">More options</a>
    <ul class="dropdo
    wn-menu"> -->
<!-- 
    <li><a href="#">Add product</a>
			</li>
			<li><a href="#">view product</a>
			</li>
			<li><a href="#">view All products</a>
			</li>
			<li><a href="#">Delete product</a>
			</li> -->
<!-- 		
			
			<div class="menu-list">
  
            <ul id="menu-content" class="menu-content collapse out">
                <li>
                  <a href="#">
                  <i class="fa fa-dashboard fa-lg"></i> Dashboard
                  </a>
                </li>

                <li data-toggle="collapse" data-target="#products" class="active collapsed">
                  <a href="#"><i class="fa fa-gift fa-lg"></i> UI Elements <span class="arrow"></span></a>
                </li>
                <ul class="sub-menu collapse" id="products" style="height: 0px;">
                    <li class="active"><a href="#">CSS3 Animation</a></li>
                    <li><a href="#">General</a></li>
                    <li><a href="#">Buttons</a></li>
                    <li><a href="#">Tabs &amp; Accordions</a></li>
                    <li><a href="#">Typography</a></li>
                    <li><a href="#">FontAwesome</a></li>
                    <li><a href="#">Slider</a></li>
                    <li><a href="#">Panels</a></li>
                    <li><a href="#">Widgets</a></li>
                    <li><a href="#">Bootstrap Model</a></li>
                </ul>


                <li data-toggle="collapse" data-target="#service" class="collapsed">
                  <a href="#"><i class="fa fa-globe fa-lg"></i> Services <span class="arrow"></span></a>
                </li>  
                <ul class="sub-menu collapse" id="service">
                  <li>New Service 1</li>
                  <li>New Service 2</li>
                  <li>New Service 3</li>
                </ul>


                <li data-toggle="collapse" data-target="#new" class="collapsed">
                  <a href="#"><i class="fa fa-car fa-lg"></i> New <span class="arrow"></span></a>
                </li>
                <ul class="sub-menu collapse" id="new">
                  <li>New New 1</li>
                  <li>New New 2</li>
                  <li>New New 3</li>
                </ul> -->

<!-- 
                 <li>
                  <a href="#">
                  <i class="fa fa-user fa-lg"></i> Profile
                  </a>
                  </li>

                 <li>
                  <a href="#">
                  <i class="fa fa-users fa-lg"></i> Users
                  </a>
                </li>
            </ul>
     </div> -->