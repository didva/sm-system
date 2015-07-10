angular.module('smApp').directive('smSerialsSidebar', function(){
    return {
        restrict: 'E',
        templateUrl: 'views/directives/serialsSidebar.html',
        controller: 'SmSerialsController'
    };
});