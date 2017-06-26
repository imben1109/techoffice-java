var app = angular.module("app");

app.directive("viewMode", function(){
	return {
		controller: function($scope, $element){
			$scope.view = function (){
				var inputs = $element.find("input");
				inputs.attr("disabled", "true")
				inputs.addClass("viewModeDisabled");
				var buttons = $element.find("button");
				buttons.hide();
				buttons.addClass("viewModeDisabled")
			};
			
			$scope.edit= function(){
				var inputs = $element.find("input");
				var buttons = $element.find("button");
			};
		},
		compile: function(elm, attrs){
			return {
				pre: function($scope, $element, attrs){
					
					
				},
				post: function($scope, $element, attrs){
					$scope.view();
				}
			};
		}
	};
});