var app = angular.module("backOffice", []);

function dashboardController($scope, $http) {
    $http({
        url: "admin/version/",
        method: "GET"
    }).success(function (data, status, headers, config) {
        $scope.backOffice = {};
        if (data["Specification-Version"] != null) {
            $scope.backOffice.version = data["Specification-Version"];
        } else {
            $scope.backOffice.version = "? Version"
        }
        if (data["Build-Time"] != null) {
            $scope.backOffice.buildTime = data["Build-Time"];
        } else {
            $scope.backOffice.buildTime = "? Time"
        }
    }).error(function (data, status, headers, config) {
        alert('Erreur Technique: Failed to load admin version - Technical error - ' + status);
    });
}