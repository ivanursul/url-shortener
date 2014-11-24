var urlShortenerControllers = angular.module('urlShortenerControllers', []);

urlShortenerControllers.controller('HomeController', [ '$scope', 'Urls',
		function($scope, Urls) {
			$scope.longUrl = "";
			$scope.shortUrl = "";
			$scope.createShortUrl = function() {
				var postObject = {};
				postObject.url = $scope.longUrl;
				Urls.save(postObject, function(data) {
					$scope.shortUrl = data.shortUrl;
					$scope.longUrl = "";
				}, function(error) {
					console.log(error);
				});
			};
		} ]);
