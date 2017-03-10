<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<h1>WordPress OAuth</h1>
	<c:if test="${not empty posts}">
		<table border='1'>
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
				</tr>
			</thead>
			<c:forEach var="site" items="${posts}">
				<tr>
					<td>${site['ID']}</td>
					<td>${site['title'] }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>

</html>