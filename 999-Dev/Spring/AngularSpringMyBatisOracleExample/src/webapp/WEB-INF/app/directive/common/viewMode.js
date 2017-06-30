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
			$scope.domNodeInsertedFn = function(event){
				if ($scope.isViewMode){
					$timeout(function(){
						var target = angular.element(event.target);
						var inputs = target.find("input");
						inputs.attr("disabled", "true")
						inputs.addClass("viewModeDisabled");
						var buttons = target.find("button");
						buttons.hide();
						buttons.addClass("viewModeDisabled");
						console.log(target);
					}, 0);
				}
			};
			
			$scope.view = function (){
				var inputs = $element.find("input");
				inputs.attr("disabled", "true")
				inputs.addClass("viewModeDisabled");
				var buttons = $element.find("button");
				buttons.hide();
				buttons.addClass("viewModeDisabled");
				$scope.isViewMode = true;
			};
			
			$scope.edit= function(){
				var inputs = $element.find("input.viewModeDisabled");
				inputs.removeAttr("disabled");
				inputs.removeClass("viewModeDisabled");
				var buttons = $element.find("button.viewModeDisabled");
				buttons.show();
				buttons.removeClass("viewModeDisabled");
				$scope.isViewMode = false;
				$element.off("DOMNodeInserted", $scope.domNodeInsertedFn);
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