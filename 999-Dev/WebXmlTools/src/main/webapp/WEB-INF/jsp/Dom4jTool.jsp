<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
	<title>Dom4j Tool</title>
	<style>
		#xml {
			width: 500px;
			height: 500px;
		}
		
		#parsedXml {
			width: 500px;
			height: 500px;
		}
	</style>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script>
		$(function(){
			$("#parseBtn").click(function(){
				var xml = $("#xml").val();
				$.ajax({
					type: "POST",
					url: "/parse",
					data: {"xml": xml},
					success: function(response) {
						$("#parsedXml").val(response.xml)
					}
				});
			});
		});
	</script>
</head>
<body>
	<h1>Dom4j Tools</h1>
	<table>
		<tr>
			<td>Input</td>
			<td>Output</td>
		</tr>
		<tr>
			<td>
				<textarea id="xml"></textarea>		
			</td>
			<td>
				<textarea id="parsedXml"></textarea>	
			</td>
		</tr>
		<tr>
			<td colspan='2'>
				<input type="button" id="parseBtn" value="Parse"/>		
			</td>
		<tr>
	</table>
	<br/>
	<div>
		<div>Note:</div>
		This tools is bulit on Dom4j to provide manipulation of XML document. The XML document parsed from Dom4j would be different from the original input. 
	</div>
</body>
</html>