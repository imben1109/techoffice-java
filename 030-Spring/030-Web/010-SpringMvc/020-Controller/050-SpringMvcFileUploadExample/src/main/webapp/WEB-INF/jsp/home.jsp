<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Spring MVC File Upload Example</h1>
	
	<h2>File Upload</h2>
	<form method="post" action="fileUpload" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td>File</td>
				<td><input type="file" name="file"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"></td>
			</tr>
		</table>
	</form>
	

</body>
</html>
