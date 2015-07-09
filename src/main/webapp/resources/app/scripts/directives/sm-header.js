angular.module('smApp')
    .directive('smHeader', function(){
        return {
            restrict: 'E',
            templateUrl: 'views/directives/header.html'
        };
    });