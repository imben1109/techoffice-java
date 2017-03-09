<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<h1>Stock List</h1>
	<c:if test="${not empty stocks}">
		<table border="1" id="stockList">
			<thead>
				<tr>
					<th>Code</th>
					<th>Name</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="stock" items="${stocks}">
				<tr>
					<td>${stock.stockCode}</td>
					<td>${stock.name}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>

</html>