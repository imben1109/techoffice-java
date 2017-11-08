var app = angular.module("app");

app.controller("TestController", function($scope, $http, gridService){
	$scope.search = function(){
		$http({
			url: "./Test/search",
			method: "POST",
			headers: {'Content-Type': 'application/json'},
	        data: $scope.testForm
		}).then(function(response){
			$scope.gridOption.data = response.data;
		});
		
	};

	$scope.testing = "test";
	
	$scope.gridRowDbClick = function(row){
		debugger;
	};
	
	$scope.gridOption = {
		columnDefs: [
		    {
			  name: 'id',
			  field: 'id'
			}
			,{
			  name: 'age',
			  field: 'age'
			}
			,{
			  name: 'address',
			  field: 'address'
			}
			,{
			  name: 'phone',
			  field: 'phone'
			}
		],
		rowTemplate: gridService.getDbClickRowTemplate("gridRowDbClick") 
	};
	
});