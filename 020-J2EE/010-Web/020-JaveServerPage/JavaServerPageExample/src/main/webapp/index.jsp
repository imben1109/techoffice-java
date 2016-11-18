<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Java Server Page Example</title>
</head>
<body>
	<h1>Java Server Page Example</h1>
	<div><% out.println("Your IP address is " + request.getRemoteAddr()); %></div>
</body>
</html>