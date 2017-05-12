<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
	<script src="/lib/jquery-3.2.0.min.js"></script>
	<link rel="stylesheet" href="/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="/lib/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"/>
	<script type="text/javascript" src="/lib/bootstrap-filestyle-1.2.1/src/bootstrap-filestyle.min.js"></script>
	<script src="/js/bootstrapPagingtable.js"></script>
	<script>
		$(function(){
			$("#historicalPrice").pagingTable({pageLimit: 25, enableSearchHeader: true});	
		})
	</script>
</head>


<body>
	<h1>Historical Price - ${stockNo}</h1>

	<c:if test="${not empty prices}">
		<table border="1" id="historicalPrice">
			<thead>
				<tr>
					<th>Date</th>
					<th>Adj. Close</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="price" items="${prices}">
				<tr>
					<td>${price.priceDate}</td>
					<td>${price.adjClose}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>

</html>