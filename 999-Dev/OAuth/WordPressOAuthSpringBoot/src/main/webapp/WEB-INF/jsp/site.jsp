<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<h1>WordPress OAuth</h1>
	<c:if test="${not empty posts}">
		<div><b>Total Number of Posts: </b>${posts.size()}</div>
		<table border='1'>
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Type</th>
					<th>Date</th>
					<th>Modified</th>
				</tr>
			</thead>
			<c:forEach var="site" items="${posts}">
				<tr>
					<td>${site['ID']}</td>
					<td><a href="${site['URL'] }">${site['title'] }</a></td>
					<td>${site['type'] }</td>
					<td>${site['date'] }</td>
					<td>${site['modified'] }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>

</html>