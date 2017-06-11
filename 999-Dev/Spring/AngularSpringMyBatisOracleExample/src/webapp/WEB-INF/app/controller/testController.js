var app = angular.module("app");
app.controller("TestController", function($scope, $http){
	$scope.search = function(){
		$http({
			url: "./Test/search",
			method: "POST",
			headers: {'Content-Type': 'application/json'},
	        data: $scope.testForm
		}).then(function(response){
			
		});
		
	}
});