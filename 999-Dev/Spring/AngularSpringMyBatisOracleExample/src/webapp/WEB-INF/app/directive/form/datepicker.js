var app = angular.module("app");

app.directive("datepicker", function($templateCache){
	return {
		scope: {
			dt: "=ngModel",
		},
		template: $templateCache.get('datepicker.html'),
		controller: function($scope, uibDateParser){
			$scope.popup = {
				opened: false
			};
			
			$scope.open = function() {
				$scope.popup.opened = true;
			};
		}
	};
});