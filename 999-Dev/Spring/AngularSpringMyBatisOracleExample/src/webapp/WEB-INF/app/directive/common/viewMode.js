var app = angular.module("app");

app.factory("viewModeService", function(){
	return {
		getViewModeEditBtn : function(){
			return angular.element("<button ng-click='edit()'>Edit</button>");
		}
	};
});

app.directive("viewMode", function(){
	return {
		controller: function($scope, $element, $compile, viewModeService){
			
			$scope.view = function (){
				var inputs = $element.find("input");
				inputs.attr("disabled", "true")
				inputs.addClass("viewModeDisabled");
				var buttons = $element.find("button");
				buttons.css("display", "none");
				buttons.addClass("viewModeDisabled")
			};
			
			$scope.edit= function(){
				var inputs = $element.find("input.viewModeDisabled");
				inputs.removeAttr("disabled")
				var buttons = $element.find("button.viewModeDisabled");
				buttons.css("display", "block");
			};
			
			$scope.viewModeEditBtn = $compile(viewModeService.getViewModeEditBtn())($scope);

		},
		compile: function(elm, attrs){
			return {
				pre: function($scope, $element, attrs){
					
					
				},
				post: function($scope, $element, attrs){
					$scope.view();
					$element.prepend($scope.viewModeEditBtn);
				}
			};
		}
	};
});