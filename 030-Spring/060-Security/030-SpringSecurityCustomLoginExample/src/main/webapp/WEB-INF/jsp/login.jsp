<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>	<h1>Spring Security Custom Login Form</h1>
</title>
</head>
<body>
	<form name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST'>
		<table>
			<tr>
				<td>User Name: </td>
				<td><input type='text' name='username'/></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="password" name="password"/></td>
			</tr>
		</table>
		<input name="submit" type="submit" value="submit" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>