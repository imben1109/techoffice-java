var app = angular.module("app", [ 'ui.router', 'ngRoute', 'oc.lazyLoad', 
                                  'ngAnimate', 'ngSanitize', 'ui.bootstrap']);

app.config(function($stateProvider, $locationProvider, $routeProvider, $ocLazyLoadProvider ) {
	
	$stateProvider.state({
		name: "main",
		url: "/"
	});
	
	$stateProvider.state({
		name: "main.test1",
		url: "test1",
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
		name: "main.test2",
		url: "test2",
		template: "<div>test 2</div>"
	});
	
	$stateProvider.state({
		name: "main.test",
		url: "test",
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

app.run(function($ocLazyLoad, $templateCache, $http){
	$ocLazyLoad.load({
		files: ['directive/form/datepicker.js', 'directive/form/test.js']
	});
	
	$http.get("directive/form/datepicker.html").then(function(response){
		$templateCache.put('datepicker.html', response.data);
	});
	

})