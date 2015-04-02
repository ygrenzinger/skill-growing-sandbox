var app = angular.module("backOffice", []);

function productController($scope, $http) {
    $scope.products = null;
    $scope.categoriesArray = null;
    $scope.detailedProduct = null;
    $scope.category = null;
    var creatingProduct = [];
    $scope.nbProducts = null;
    $scope.nbProductsArray = [{row: '1'}, {row: '2'}, {row: '3'}, {row: '4'}, {row: '5'}, {row: '6'}, {row: '7'}, {row: '8'}, {row: '9'}];
    $scope.nbProductsSelectedArray = [];

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

    $scope.createNbProductsSelectedArray=function(){
        $scope.nbProductsSelectedArray = [];
        $scope.products = null;
        $scope.detailedProduct = null;
        creatingProduct = [];
        for(var i=1;i<=$scope.nbProducts.row;i++) {
            $scope.nbProductsSelectedArray.push(i);
            creatingProduct.push({description:"", reference:"", composition:"", price:""})
            if ( $("#labelProd" + i).val() != null) {
                $("#labelProd" + i).val("");
            }
            if ( $("#compositionProd" + i).val() != null) {
                $("#compositionProd" + i).val("");
            }
            if ( $("#priceProd" + i).val() != null) {
                $("#priceProd" + i).val("");
            }
            if ( $("#refProd" + i).val() != null) {
                $("#refProd" + i).val("");
            }
        }
        $scope.resetCategories();
    }

    $scope.updateLabelProduct=function(productRow){
        creatingProduct[productRow - 1].description = $("#labelProd" + productRow).val();
    }

    $scope.updateRefProduct=function(productRow){
        creatingProduct[productRow - 1].reference = $("#refProd" + productRow).val();
    }

    $scope.updateCompositionProduct=function(productRow){
        creatingProduct[productRow - 1].composition = $("#compositionProd" + productRow).val();
    }

    $scope.updatePriceProduct=function(productRow){
        creatingProduct[productRow - 1].price = $("#priceProd" + productRow).val();
    }

    $scope.saveProduct=function(selectedCategory) {
        if (validateProducts()) {
            $http({
                url: "rest/categories/"+selectedCategory.id + "/products",
                method: "POST",
                headers: {
                    'Content-Type': 'application/json'
                },
                data: {
                    products:  creatingProduct
                }
            }).success(function (data, status, headers, config) {
                $scope.products = data.products;
                $scope.nbProducts = null;
                $scope.nbProductsSelectedArray = [];
            }).error(function (data, status, headers, config) {
                    alert("Erreur : Code status HTTP :" + status);
                }
            );
        }
        else {
            alert("Veuillez renseigner les produits à créer");
        }
    }

    var validateProducts=function(){
        for(var i=0;i<$scope.nbProducts.row;i++) {
            if (!creatingProduct[i].description || !creatingProduct[i].composition || !creatingProduct[i].reference || !creatingProduct[i].price) {
                return false;
            }
        }
        return true;
    }

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
