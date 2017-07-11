var app = angular.module("app");

app.factory("viewModeService", function(){
	return {
		getViewModeEditBtn : function(){
			return angular.element("<button ng-click=\"edit()\">Edit</button>");
		}
	};
});

app.directive("viewMode", function($compile, viewModeService){
	return {
		controller: function($scope, $element, $compile, viewModeService, $timeout){
			
			$scope.view = function (){
				$scope.isViewMode = true;
			};
			
			$scope.edit= function(){
				$scope.isViewMode = false;
			};
			

		},
		compile: function(elm, attrs){
			return {
				pre: function($scope, $element, attrs){
					
				},
				post: function($scope, $element, attrs){
					$scope.view();
					$scope.viewModeEditBtn = $compile(viewModeService.getViewModeEditBtn())($scope);
					$element.prepend($scope.viewModeEditBtn);
					$element.on("DOMNodeInserted", $scope.domNodeInsertedFn);
				}
			};
		}
	};
});