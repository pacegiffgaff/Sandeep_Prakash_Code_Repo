<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
</head>
<body>

	<h3>Please Enter Stock Details</h3>
	<form:form method="POST" action="/addStock" modelAttribute="stock">
		<table>
			<tr>
				<td><form:label path="historyTotal">Stock History</form:label></td>
				<td><form:input path="historyTotal" /></td>
			</tr>
			<tr>
				<td><form:label path="totalCurrentStock">Current Stock</form:label></td>
				<td><form:input path="totalCurrentStock" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Add Stock" /></td>
				<td><input type="submit" value="Update Stock" /></td>
			</tr>
		</table>
	</form:form>
	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
