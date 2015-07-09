angular.module('smApp').directive('smSidebar', function(){
    return {
        restrict: 'E',
        templateUrl: 'views/directives/sidebar.html',
        controller: 'SmSerialsController'
    };
});