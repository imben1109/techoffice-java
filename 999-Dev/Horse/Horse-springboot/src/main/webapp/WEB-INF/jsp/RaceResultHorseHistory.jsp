<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
	<script src="/lib/jquery-3.2.0.min.js"></script>
	<link rel="stylesheet" href="/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="/lib/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css"/>
	<script type="text/javascript" src="/lib/bootstrap-filestyle-1.2.1/src/bootstrap-filestyle.min.js"> </script>
	<script src="/js/bootstrapPagingtable.js"></script>
	<script>
		$(function(){
			$("#raceResultHorseTable").pagingTable({pageLimit: 25, enableSearchHeader: true});	
		});
	</script>
</head>
<body>
	<div class="container-fluid">
		<h1>Race Date</h1>
		<br/>
		<c:if test="${not empty raceResultHorses }">
			<table id="raceResultHorseTable">
				<thead>
					<tr>
						<th>ID</th>	
						<th>Name</th>
						<th>Place</th>
						<th>Jockey</th>
						<th>Trainer</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="raceResultHorse" items="${raceResultHorses}">
					<tr>
						<td><a href="/RaceResultHorse/${raceResultHorse.raceResult.id}" >${raceResultHorse.raceResult.id}</a></td>
						<fmt:formatDate value="${raceResultHorse.raceResult.raceDate}" var="formattedRaceDate" pattern="yyyy-MM-dd"/>
						<td>${formattedRaceDate}</td>
						<td>${raceResultHorse.place }</td>
						<td>${raceResultHorse.jockey }</td>
						<td>${raceResultHorse.trainer }</td>
						
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<!-- End of Fluid Container -->
	</div>
</body>

</html>