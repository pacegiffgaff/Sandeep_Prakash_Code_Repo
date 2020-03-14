<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<!--<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" /> -->
</head>
<body>

	<h3>Please Enter Product Details</h3>
	<form:form method="POST" action="/addrawmaterial"
		modelAttribute="rawMaterial">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td><form:label path="rawMaterialName">Raw Material Name</form:label></td>
				<td><form:input path="rawMaterialName" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>