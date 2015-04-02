var app = angular.module("backOffice", []);

function categoryController($scope, $http) {
    var categories = [];
    $scope.nbCategories = null;
    $scope.categoriesLabel = [];
    $scope.labelCategory = null;
    $scope.nbCategoriesArray = [{row: '1'}, {row: '2'}, {row: '3'}, {row: '4'}, {row: '5'}, {row: '6'}, {row: '7'}, {row: '8'}, {row: '9'}];
    $scope.nbCategoriesSelectedArray = [];
    $scope.categories;
    $scope.detailedCategory;

    $scope.saveCategory=function() {
        if (validateCategories()) {
            $http({
                url: "rest/categories/",
                method: "POST",
                headers: {
                    'Content-Type': 'application/json'
                },
                data: {
                    categories:  categories
                }
            }).success(function (data, status, headers, config) {
                $scope.categories = data.categories;
                $scope.nbCategories = null;
                $scope.nbCategoriesSelectedArray = [];
            }).error(function (data, status, headers, config) {
                alert("Erreur : Code status HTTP :" + status);
                }
            );
        }
        else {
            alert("Veuillez renseigner les catégories à créer");
        }
    }

    $scope.displayCategoryDetails = function(category) {
        $scope.detailedCategory = category;
    };

    $scope.searchAllCategories = function() {
        $scope.categories = null;
        $scope.detailedCategory = null;

        $http({
            url: "rest/categories/",
            method: "GET",
            headers: {
                'Content-Type': 'application/json'
            },
            data: {}
        }).success(function (data, status, headers, config) {
            $scope.categories = data.categories;
        }).error(function (data, status, headers, config) {
            alert("Erreur : Code status HTTP :" + status);
        });
    };


    $scope.createNbCategoriesSelectedArray=function(){
        $scope.nbCategoriesSelectedArray = [];
        $scope.categoriesLabel = [];
        $scope.products = null;
        $scope.detailedProduct = null;
        for(var i=1;i<=$scope.nbCategories.row;i++) {
            $scope.nbCategoriesSelectedArray.push(i);
            $scope.categoriesLabel.push({row: i, name:""});
            if ( $("#labelCat" + i).val() != null) {
                $("#labelCat" + i).val("");
            }
        }
        $scope.resetCategories();
    }

    $scope.resetCategories = function () {
        if (categories.length > 0) {
            for (var i=categories.length-1; i<0; i--){
                 categories = categories.splice(i,1);
            }
            categories = categories.splice(0,0);
        }
    };

    $scope.updateCategories=function(categoryRow){
        $scope.categoriesLabel[categoryRow - 1].name = $("#labelCat" + categoryRow).val();
        categories[categoryRow - 1] = $("#labelCat" + categoryRow).val();
    }


    $scope.mailto = function () {
        var mailBody = window.location + "%0A%0A";
        window.location = 'mailto:nbouad@gmail.com?subject=Question sur les catégories&cc=yannick.grenzinger@gmail.com&body=' + mailBody;
    };

    var validateCategories=function(){
        for(var i=0;i<$scope.nbCategories.row;i++) {
            if ($scope.categoriesLabel[i].name == null || $scope.categoriesLabel[i].name === "") {
                return false;
            }
        }
        return true;
    }
}
