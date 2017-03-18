<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
	<script src="/lib/jquery-3.2.0.min.js"></script>
	<link rel="stylesheet" href="/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="/lib/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"/>
	<script type="text/javascript" src="/lib/bootstrap-filestyle-1.2.1/src/bootstrap-filestyle.min.js"> </script>
	<script src="/js/bootstrapPagingtable.js"></script>
	<script>
		$(function(){
			$("#industryTable").pagingTable({pageLimit: 25, enableSearchHeader: true});
		});
	</script>
</head>
<body>
	<div class="container-fluid">
		<h1>Stock Analysis - Industry</h1>
		<a href="/Industry/updateIndustryList">Update Industry List</a>
		<c:if test="${not empty industryList }">
			<table id="industryTable">
				<c:forEach var="industry" items="${industryList }">
					<tr>
						<td>${industry.name }</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>

</html>