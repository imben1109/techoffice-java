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
			$("#industryDetails").pagingTable({pageLimit: 25, enableSearchHeader: true});	
			$("#updateBtn").click(function(){
				$(this).attr("disabled", true);
				$.ajax({
					url: "/IndustryDetail/update/${industrySymbol}",
					type: "GET",
		            processData: false,
		            contentType: false,
					success: $.proxy(function(e){
						$(this).attr("disabled", false);
						alert("Completed");
					}, this)
				});
			});
		})
	</script>
</head>


<body>
	<div class="container-fluid">
		<h1>Industry Detail List - ${industrySymbol}</h1>
		<div class="form-inline">
			<button id="updateBtn" class="btn btn-primary">Update</button>
		</div>
		<br/>
		<c:if test="${not empty industryDetails}">
			<table border="1" id="industryDetails">
				<thead>
					<tr>
						<th>Name</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="industryDetail" items="${industryDetails}">
					<tr>
						<td>${industryDetail.name}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>

</html>