<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script>
		$(function(){		
			$("#sendRequest").click(function(){
				var reqTxt = $("#reqTxt").val();
				var reqData = JSON.parse(reqTxt);
				$.ajax({
					url: "request",
					method: "POST",
				    contentType: "application/json;",
					data: JSON.stringify(reqData),
					success: function(response, status, xhr){
						$("#resMsg").html(JSON.stringify(response));
					},
					error: function(status, error){
						alert(error);
					}
				});
				
			});
		});
	</script>
</head>
<body>
	<h1>Spring MVC Jackson Mapping Example</h1>
	<button id="sendRequest">Send Request</button>
	<div>
		<textarea id="reqTxt">{"a":"a", "b":"b"}</textarea>
	</div>
	<h1>Response Message</h1>
	<div id="resMsg"></div>
</body>
</html>
