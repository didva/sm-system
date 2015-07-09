angular.module('smApp').controller('SmSerialsController', ['$location', '$http', '$scope', '$routeParams', function($location, $http, $scope, $routeParams) {
    $scope.$routeParams = $routeParams;
    $http.get('/sm-system/rest/serials').success(function(data){
        $scope.serials = data;
    });

    $scope.isSelected = function(serialId) {
        return $location.path() == '/serial' && serialId == $routeParams.serialId;
    }
}]);