angular.module('market-front', []).controller('appController', function ($scope, $http){
    const contextPath = 'http://localhost:8189/market/';


     $scope.loadProducts = function (){
         $http.get(contextPath + 'products')
             .then(function (response) {
                 console.log(response);
                 $scope.products = response.data;
             });
        }

     $scope.deleteProduct=function(product){
         $http.get(contextPath + 'products/delete/'+product.id)
         .then(function (response) {
            $scope.loadProducts();

              });
        }

     $scope.createNewProduct=function(){
         $http.post(contextPath + 'products', $scope.new_product)
            .then(function (response) {
                $scope.loadProducts();
                $scope.new_product=null;
            });
        }

    $scope.loadProducts();


});