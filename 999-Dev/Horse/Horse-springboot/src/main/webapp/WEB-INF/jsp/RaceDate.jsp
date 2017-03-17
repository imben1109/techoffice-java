<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<h1>Race Date</h1>
	<c:if test="${not empty raceDates }">
		<table>
			<tbody>
				<c:forEach var="raceDate" items="${raceDates}">
				<tr>
					<td>${raceDate.raceDate }</td>
					<td>${raceDate.raceType }</td>
					<td>${raceDate.raceCount }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>

</html>