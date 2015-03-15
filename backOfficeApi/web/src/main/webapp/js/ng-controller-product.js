var app = angular.module("backOffice", []);

function productController($scope, $http) {

    $scope.products = null;
    $scope.categoriesArray = null;
    $scope.detailedProduct = null;
        $scope.category = null;
    $http({
        url: "rest/categories/",
        method: "GET",
        headers: {
            'Content-Type': 'application/json'
        },
        data: {}
    }).success(function (data, status, headers, config) {
        $scope.categoriesArray = data.categories;
    }).error(function (data, status, headers, config) {
        alert("Erreur : Code status HTTP :" + status);
    });

    $scope.mailto = function () {
        var mailBody = window.location + "%0A%0A";
        window.location = 'mailto:nbouad@gmail.com?subject=Question sur les produits&cc=yannick.grenzinger@gmail.com&body=' + mailBody;
    };

    $scope.displayProductDetails = function(product) {
        $scope.detailedProduct = product;
    };

    $scope.searchAllProducts = function (selectedCategory) {
        $http({
            url: "rest/categories/"+selectedCategory.id + "/products",
            method: "GET",
            headers: {
                'Content-Type': 'application/json'
            },
            data: {}
        }).success(function (data, status, headers, config) {
            $scope.products = data.products;
        }).error(function (data, status, headers, config) {
            alert("Erreur : Code status HTTP :" + status);
        });
    };
}
