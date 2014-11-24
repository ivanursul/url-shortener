var urlShortenerApp = angular.module('mainModule', ['ngResource', 'ngRoute', 'urlShortenerControllers']);


urlShortenerApp.factory('Urls', function ($resource, SharedProperties) {
    return $resource(SharedProperties.getApiUrl() + '/urls/:id', {}, {'query': {method: 'GET', isArray: false}});
});

urlShortenerApp.service('SharedProperties', function () {
    var apiUrl = "http://localhost:8080/url-shortener-rest-api/api";
    return {
        getApiUrl: function () {
            return apiUrl;
        }
    };
});

urlShortenerApp.config(["$routeProvider" , function ($routeProvider) {
    $routeProvider
        .when("/home", {
            templateUrl: "html/home.html",
            controller: 'HomeController'
        })
        .otherwise({redirectTo: '/home'});
}]);