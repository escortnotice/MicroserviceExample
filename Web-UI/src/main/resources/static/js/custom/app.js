 var app = angular.module('myApp', []);

/** Controller 1  -------Starts---------- **/
 app.controller('myCtrl', function($scope, $http) {

     //get stockQuotes
     $scope.getStocks = function() {
         $http.get("http://localhost:8761/api/db-service/rest/db/userstockquotes/" + $scope.username)
             .then(function(response) {
                 console.log("Getting Stock Quotes call successful");
                 $scope.stockQuotes = response.data;
             }, function(response) {
                 console.log("Error occured while getting stocks");
                 $scope.stockQuotes = "";
             });
     };

     //add stocks
     $scope.addStocks = function() {
         var dataToAdd = {
             userName: $scope.username,
             quotes: [$scope.stocks]
         };
         $http.post("http://localhost:8761/api/db-service/rest/db/userstockquotes/add", dataToAdd)
             .then(function(response) {
                 console.log("Getting Stock Quotes call successful");
                 $scope.stockQuotes = response.data;
             }, function(response) {
                 console.log("Error occured while getting stocks");
                 $scope.stockQuotes = "";
             });
     };
 });
 /** Controller 1 ---------- Ends ----------- **/