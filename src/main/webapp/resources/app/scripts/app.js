angular.module('smApp', ['ngRoute']).config(['$routeProvider', function($routeProvider){
    $routeProvider
        .when('/', {
            templateUrl: 'views/main.html',
            controller: 'SmSerialsController'
        })
        .when('/serials', {
            templateUrl: 'views/main.html',
            controller: 'SmSerialsController'
        })
        .when('/serial', {
            templateUrl: 'views/serial.html',
            controller: 'SmParticularSerialController'
        })
        .when('/registration', {
            templateUrl: 'views/registration.html'
        })
        .when('/management', {
            templateUrl: 'views/management.html'
        })
        .otherwise({redirectTo: '/'});
}]);