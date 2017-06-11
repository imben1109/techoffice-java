var app = angular.module("app", [ 'ui.router', 'ngRoute', 'oc.lazyLoad']);

app.config(function($stateProvider, $locationProvider, $routeProvider, $ocLazyLoadProvider ) {
	
	$stateProvider.state({
		name: "test1",
		url: "/test1",
		template: "<div>test 1</div>",
		controller: 'HomeController',
		resolve: {
			load: function($ocLazyLoad){
				return $ocLazyLoad.load({
					files: ['controller/homeController.js']
				});
			}
		}
	});
	
	$stateProvider.state({
		name: "test2",
		url: "/test2",
		template: "<div>test 2</div>"
	});
	
	$stateProvider.state({
		name: "test",
		url: "/test",
		templateUrl: "template/test.html",
		controller: "TestController",
		resolve: {
			load: function($ocLazyLoad){
				$ocLazyLoad.load({
					files: ['controller/testController.js']
				});
			}
		}
	});
	
});