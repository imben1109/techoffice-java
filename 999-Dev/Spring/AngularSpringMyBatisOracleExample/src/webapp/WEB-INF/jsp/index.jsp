<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Angular Spring MyBatis Oracle Example</title>
		
		<script src="resources/angular/angular.min.js"></script>
		<script src="resources/angular-route/angular-route.min.js"></script>
		<script src="resources/angular-ui-router/release/angular-ui-router.min.js"></script>
		<script src="resources/oclazyload/dist/ocLazyLoad.min.js"></script>
		
		<script src="app.js"></script>
	</head>
	
	<body ng-app="app">
		 
		<h1>Angular Spring MyBatis Oracle Example</h1>
		
		<a ui-sref="test1">test 1</a>
		<a ui-sref="test2">test 2</a>
		<a ui-sref="test">test</a>
		
		<ui-view></ui-view>
		 
	</body>
</html>