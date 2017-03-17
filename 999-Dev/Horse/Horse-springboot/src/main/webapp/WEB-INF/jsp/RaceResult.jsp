<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<h1>Race Date</h1>
	<c:if test="${not empty raceResults }">
		<table>
			<tbody>
				<c:forEach var="raceResult" items="${raceResults}">
				<tr>
					<td>${raceResult.location }</td>
					<td>${raceResult.raceDate }</td>
					<td>${raceResult.venue }</td>
					<td>${raceResult.raceNum }</td>
					<td>${raceResult.raceNo }</td>
					<td>${raceResult.raceClass }</td>
					<td>${raceResult.distance }</td>
					<td>${raceResult.rtgRange }</td>
					<td>${raceResult.going }</td>
					<td>${raceResult.raceName }</td>
					<td>${raceResult.course }</td>
					<td>${raceResult.reward }</td>
					<td>${raceResult.raceTime }</td>
					<td>${raceResult.sectionalTime }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>

</html>