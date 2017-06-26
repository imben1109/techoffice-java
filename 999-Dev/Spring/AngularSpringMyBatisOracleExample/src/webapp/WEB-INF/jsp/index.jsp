<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>Angular Spring MyBatis Oracle Example</title>
	
		<script src="resources/jquery/dist/jquery.min.js"></script>	
		<script src="resources/angular/angular.min.js"></script>
		<script src="resources/angular-animate/angular-animate.min.js"></script>
		<script src="resources/angular-sanitize/angular-sanitize.min.js"></script>
		<script src="resources/angular-route/angular-route.min.js"></script>
		<script src="resources/angular-ui-router/release/angular-ui-router.min.js"></script>
		<script src="resources/oclazyload/dist/ocLazyLoad.min.js"></script>
		<script src="resources/angular-bootstrap/ui-bootstrap-tpls.min.js"></script>
		<script src="resources/angular-ui-grid/ui-grid.min.js"></script>
	
		<link rel="stylesheet" type="text/css" href="resources/bootstrap/dist/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="resources/angular-ui-grid/ui-grid.min.css"/>
		<link ref="stylesheet" type="text/css" href="css/app.css"/>
		
		<script src="app.js"></script>
	
	</head>
	
	<body ng-app="app">
		<div class="container-fluid">
		
			<h1>Angular Spring MyBatis Oracle Example</h1>	
			<a ui-sref="main.test1">test 1</a>
			<a ui-sref="main.test2">test 2</a>
			<a ui-sref="main.test">test</a>
			<ui-view></ui-view>
			
		</div>
	</body>
</html>