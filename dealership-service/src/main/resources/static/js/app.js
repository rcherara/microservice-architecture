angular.module('SpringDealership', ['dealerships', 'errors', 'status', 'ngRoute', 'ui.directives']).
    config(function ($locationProvider, $routeProvider) {
         $locationProvider.html5Mode(true);

        $routeProvider.when('/errors', {
            controller: 'ErrorsController',
            templateUrl: 'templates/errors.html'
        });
        $routeProvider.otherwise({
            controller: 'DealershipController',
            templateUrl: 'templates/dealerships.html'
        });
    }
);
