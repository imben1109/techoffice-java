var app = angular.module("app");

app.directive("datepicker", function($templateCache){
	return {
		scope: {
			dt: "=ngModel",
		},
		templateUrl: "directive/form/datepicker.html",
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