<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<h1>WordPress OAuth</h1>
	<c:if test="${not empty sites}">
		<table border='1'>
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
				</tr>
			</thead>
			<c:forEach var="site" items="${sites}">
				<tr>
					<td><a href="site?siteId=${site['ID']}">${site['ID']}</a></td>
					<td>${site['name'] }</td>
					<td>${site['description'] }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>

</html>