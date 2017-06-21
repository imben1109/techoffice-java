var app = angular.module("app");

app.directive("test", function(){
	return {
		link: function(scope, elm, attrs){
			debugger;
		}
	};
});