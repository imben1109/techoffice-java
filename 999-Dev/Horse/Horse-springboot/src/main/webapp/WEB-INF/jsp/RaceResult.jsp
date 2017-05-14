<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="en">
<head>
	<script src="/lib/jquery-3.2.0.min.js"></script>
	<link rel="stylesheet" href="/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="/lib/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"/>
	<script type="text/javascript" src="/lib/bootstrap-filestyle-1.2.1/src/bootstrap-filestyle.min.js"> </script>
	<script src="/js/bootstrapPagingtable.js"></script>
	<script>
		$(function(){
			$("#raceResultTable").pagingTable({pageLimit: 25, enableSearchHeader: true});	
		});
	</script>
</head>
<body>
	<h1>Race Date</h1>
	<c:if test="${not empty raceResults }">
		<table id="raceResultTable">
			<thead>
				<tr>
					<th>ID</th>
					<th>Date</th>
					<th>Venue</th>
					<th>Race Num</th>
					<th>Class</th>
					<th>Distance</th>
					<th>Range</th>
					<th>Going</th>
					<th>Name</th>
					<th>Course</th>
					<th>Reward</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="raceResult" items="${raceResults}">
				<tr>
					<td>${raceResult.id}</td>
					<td><fmt:formatDate value="${raceResult.raceDate }" pattern="yyyy-MM-dd" /></td>
					<td>${raceResult.venue }</td>
					<td>${raceResult.raceNum }</td>
					<td>${raceResult.raceClass }</td>
					<td>${raceResult.distance }</td>
					<td>${raceResult.rtgRange }</td>
					<td>${raceResult.going }</td>
					<td>${raceResult.raceName }</td>
					<td>${raceResult.course }</td>
					<td>${raceResult.reward }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>

</html>