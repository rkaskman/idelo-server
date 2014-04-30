var complaintsControllers = angular.module('complaintsControllers', []);

iDeloApp.controller('ComplaintsCtrl', [
		'$scope',
		'$routeParams',
		'$http',
		function($scope, $routeParams, $http) {
			$http.get('/get-complaint/' + $routeParams.citizenId)
					.success(function(data) {
						$scope.complaints = data;
					});
		} ]);

iDeloApp.controller('MyComplaintsCtrl', [
		'$scope',
		'$routeParams',
		'$http','Auth',
		function($scope, $routeParams, $http, Auth) {
			$http.get('/get-complaint/' + Auth.getUser()).success(
					function(data) {
						$scope.complaints = data;
					});
		} ]);

iDeloApp.controller('CitizensCtrl', [ '$scope', '$http',
		function($scope, $http) {
			$http.get('/get-all-citizen').success(function(data) {
				$scope.citizens = data;
			});
			$scope.orderProp = 'type';
		} ]);

iDeloApp.controller('CitizenCtrl', [
		'$scope',
		'$routeParams',
		'$http',
		function($scope, $routeParams, $http) {
			$http.get('/get-citizen/' + $routeParams.citizenId)
					.success(function(data) {
						$scope.citizen = data;
					});
		} ]);

iDeloApp.controller('SearchCtrl', [ '$scope', '$routeParams', '$http',
		function($scope, $routeParams, $http) {
			if ($routeParams.query.indexOf("sa") != -1) {
				$http.get('json/search/0.json').success(function(data) {
					$scope.result = data;
				});
			} else {
				$http.get('json/search/1.json').success(function(data) {
					$scope.result = data;
				});
			}
		} ]);

iDeloApp.controller('LoginCtrl', [ '$scope', 'Auth', function($scope, Auth) {
		Auth.setUser(12); // Update the state of the user in the app
} ]);

iDeloApp.controller('mainCtrl', [ '$scope', 'Auth', '$location',
		function($scope, Auth, $location) {
			$scope.$watch(Auth.isLoggedIn, function(value, oldValue) {
				if (!value && oldValue) {
					console.log("Disconnect");
					$location.path('/');
				}

				if (value) {
					console.log("Connect")
					$location.path('/');
				}

			}, true);
		} ]);