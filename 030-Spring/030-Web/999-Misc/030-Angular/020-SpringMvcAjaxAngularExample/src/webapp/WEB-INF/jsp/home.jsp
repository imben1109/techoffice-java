<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
		<script>
			var app = angular.module('app', []);
			
			app.config(function($httpProvider){
				$httpProvider.interceptors.push(function($q) {
					return {
						request: function(config) {
							return config;
						},
						response: function(config){
							return config;
						},
						responseError: function(rejection){
							alert("error");
							return $q.reject(rejection);
						}
					};
				});
			});
			
			app.controller('TestController', function TestController($scope, $http) {
				
				$scope.getString = function(){
					$http({
						url: "./getString"
					}).success(function(data){
						alert(data);
					})
				};
				
				$scope.getStringWithError = function(){
					$http({
						url: "./getStringWithError"
					}).success(function(data){
						alert(data);
					})
				};
				
				$scope.getMap = function(){
					$http({
						url: "./getMap"
					}).success(function(data){
						alert(data.key)
					})
				};
				
				$scope.getMapWithError = function(){
					$http({
						url: "./getMapWithError"
					}).success(function(data){
						alert(data.key)
					})
				};
				
			});
		</script>
	</head>
	<body>
		<h1>Spring MVC Download</h1>
		<div ng-app="app" ng-controller="TestController">
			<button ng-click="getString()">getString</button>
			<button ng-click="getStringWithError()">getStringWithError</button>
			<button ng-click="getMap()">getMap</button>
			<button ng-click="getMapWithError()">getMapWithError</button>
		</div>
	</body>
</html>
