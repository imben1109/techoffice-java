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
			$("#priceBatchList").pagingTable({pageLimit: 25, enableSearchHeader: true});	
		})
	</script>
</head>


<body>
	<h1>Price Batch List</h1>

	<c:if test="${not empty priceBatchList}">
		<table border="1" id="priceBatchList">
			<thead>
				<tr>
					<th>Code</th>
					<th>Name</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="priceBatch" items="${priceBatchList}">
				<tr>
					<td>${priceBatch.stockCode}</td>
					<td>${priceBatch.lastExecuted}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>

</html>