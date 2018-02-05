<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
		<script>
			var app = angular.module('app', []);
			app.controller('TestController', function TestController($scope, $http) {
				$scope.download = function(){
					$http({
						url: "./httpEntityFileDownload"
					}).success(function(data){
						debugger;
					})
				}
			});
		</script>
	</head>
	<body>
		<h1>Spring MVC Download</h1>
		<div ng-app="app" ng-controller="TestController">
			<button ng-click="download()">download</button>
		</div>
	</body>
</html>
