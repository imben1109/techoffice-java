<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<h1>Race Date</h1>
	<c:if test="${not empty raceResultQueues }">
		<table>
			<tbody>
				<c:forEach var="raceResultQueue" items="${raceResultQueues}">
				<tr>
					<td>${raceResultQueue.raceDate }</td>
					<td>${raceResultQueue.raceNum }</td>
					<td>${raceResultQueue.location }</td>
					<td>${raceResultQueue.raceType }</td>
					<td>${raceResultQueue.venue }</td>
					<td>${raceResultQueue.runInd }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>

</html>