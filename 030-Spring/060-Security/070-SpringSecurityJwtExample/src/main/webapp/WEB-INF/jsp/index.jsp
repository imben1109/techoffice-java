<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Spring Security JWT Example</title>
	<script type="text/javascript" src="webjars/angularjs/1.7.5/angular.js"></script>
	<script type="text/javascript">
		var app = angular.module("app", []);
		app	.controller("appController",function($scope, $http){
			$scope.submit = function(){
				console.log("logging login form");
				console.log($scope.loginForm);
				$http.post("./auth", $scope.loginForm).then(
					function(response){
						console.log("logging authentication success response");
						console.log(response);
					},
					function(response){
						console.log("logging authentication failed response");
						console.log(response);
						alert(response);
					}
				)
			};
		});
	</script>
</head>
<body ng-app="app" ng-controller="appController">
	<h1>Spring Security JWT Example</h1>
	<form >
		<table>
			<tr>
				<td><span>User Name: </span></td>
				<td><input type="text" ng-model="loginForm.username"/></td>
			</tr>
			<tr>
				<td><span>Password: </span></td>
				<td><input type="text" ng-model="loginForm.password"/></td>
			</tr>
			<tr colspan="2">
				<td><button type="button" ng-click="submit()">Submit</button></td>
			</tr>
		</table>
	</form>
</body>
</html>