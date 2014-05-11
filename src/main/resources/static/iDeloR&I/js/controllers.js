'use strict';

/* Controllers */

var iDeloControllers = angular.module('iDeloControllers', []);

iDeloControllers.controller('ComplaintsCtrl', [
		'$scope',
		'$routeParams',
		'$http',
		function($scope, $routeParams, $http) {
			$http.get('/get-complaint/' + $routeParams.citizenId)
					.success(function(data) {
						$scope.complaints = data;
					});
		} ]);

iDeloControllers.controller('ComplaintCtrl', [
    '$scope',
    '$routeParams',
    '$http',
    function($scope, $routeParams, $http) {
        $http.get('/getComplaintByComplaintId/' + $routeParams.complaintId)
            .success(function(data) {
                $scope.complaint = data;
                console.log(data);
            });
    } ]);

iDeloControllers.controller('MyComplaintsCtrl', [
		'$scope',
		'$routeParams',
		'$http','Auth',
		function($scope, $routeParams, $http, Auth) {
			$http.get('/get-complaint/' + Auth.getUserId()).success(
					function(data) {
						$scope.complaints = data;
					});
		} ]);

iDeloControllers.controller('CitizensCtrl', [ '$scope', '$http',
		function($scope, $http) {
			$http.get('/get-all-citizen').success(function(data) {
				$scope.citizens = data;
			});
			$scope.orderProp = 'type';
		} ]);

iDeloControllers.controller('CitizenCtrl', [
		'$scope',
		'$routeParams',
		'$http',
		function($scope, $routeParams, $http) {
			$http.get('/get-citizen/' + $routeParams.citizenId)
					.success(function(data) {
						$scope.citizen = data;
					});
		} ]);

iDeloControllers.controller('SearchCtrl', [ '$scope', '$routeParams', '$http',
		function($scope, $routeParams, $http) {
				$http.get('/search/'+$routeParams.query).success(function(data) {
					$scope.result = data;
				});
		} ]);

iDeloControllers.controller('LoginCtrl', ['$scope', '$location', 'Auth', function($scope,$location, Auth) {
        $scope.showUserMenu = true;
        $scope.showAdminMenu = false;
        $scope.userName = Auth.getUserName();
        $scope.userId = Auth.getUserId();


        $scope.doAdminLogin = function() {
            $scope.showUserMenu = false;
            $scope.showAdminMenu = true;
            $location.path("/");
        };

        $scope.logout = function(username) {
            Auth.invalidateSession();
        };

} ]);

