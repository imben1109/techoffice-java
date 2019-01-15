<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

	<head>
		<script type="text/javascript" src="webjars/angularjs/1.7.5/angular.js"></script>
		<script type="text/javascript">
			var app = angular.module("app", []);
			app.controller("appController",function($scope, $http){
				
				$scope.submit = function(){
					$http.post("./customer/update", 
						$scope.customer
					).then(function(response){
						debugger;
					});	
				};
				
			});
		</script>
	</head>

	<body ng-app="app" ng-controller="appController">
		<form ng-submit="submit()">
			<table>
				<tr>
					<td><span>User Name: </span></td>
					<td><input type="text" ng-model="customer.firstName"/></td>
				</tr>
				<tr>
					<td><span>Password: </span></td>
					<td><input type="text" ng-model="customer.lastName"/></td>
				</tr>
				<tr colspan="2">
					<td><button type="submit" >Submit</button></td>
				</tr>
			</table>
		</form>
	</body>

</html>