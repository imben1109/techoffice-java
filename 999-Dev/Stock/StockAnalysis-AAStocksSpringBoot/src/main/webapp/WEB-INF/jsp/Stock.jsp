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
			$("#stockList").pagingTable({pageLimit: 25, enableSearchHeader: true});	
			$("#stockCsvUploadBtn").click(function(){
				var stockCsvUploadFile = $("#stockCsvUploadFile")
				if (stockCsvUploadFile 
						&& stockCsvUploadFile.length > 0 
						&& stockCsvUploadFile[0].files
						&& stockCsvUploadFile[0].files.length > 0 ){
					var file = stockCsvUploadFile[0].files[0];
					var formData = new FormData();
					formData.append('file', file);
					$.ajax({
						url: "/stock/fileUpload",
						type: "POST",
						data: formData,
			            processData: false,
			            contentType: false,
						success: function(e){alert("Uploaded");}
					});
				}
			});
		})
	</script>
</head>


<body>
	<div class="container-fluid">
		<h1>Stock List</h1>
		<div class="form-inline">
			<input id="stockCsvUploadFile" type="file" class="filestyle" data-buttonName="btn-primary"/>	
			<button id="stockCsvUploadBtn" class="btn btn-primary">Upload</button>
		</div>
		<br/>
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
	</div>
</body>

</html>