angular.module('smApp').controller('SmParticularSerialController', ['$http', '$scope', '$routeParams', function($http, $scope, $routeParams) {
    $http.get('/sm-system/rest/serials/' + $routeParams.serialId).success(function(data){
        $scope.serial = data;
    });
}]);