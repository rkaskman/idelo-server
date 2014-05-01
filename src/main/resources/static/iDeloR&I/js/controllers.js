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

iDeloControllers.controller('MyComplaintsCtrl', [
		'$scope',
		'$routeParams',
		'$http','Auth',
		function($scope, $routeParams, $http, Auth) {
			$http.get('/get-complaint/' + Auth.getUser()).success(
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

iDeloControllers.controller('LoginCtrl', ['$scope', '$location', 'Auth', function($scope,$location, Auth) {
        $scope.showUserMenu = true;
        $scope.showAdminMenu = false;
        $scope.userName = getUserName();


        $scope.doAdminLogin = function() {
            $scope.showUserMenu = false;
            $scope.showAdminMenu = true;
            $location.path("/");
        };

        $scope.doSignIn = function(username) {
            document.cookie="username="+username;
        };

        $scope.logout = function(username) {
            document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
        };

        function getUserName() {
            return getCookie("username")
        };

        function getCookie(cname)
        {
            var name = cname + "=";
            var ca = document.cookie.split(';');
            for(var i=0; i<ca.length; i++)
            {
                var c = ca[i].trim();
                if (c.indexOf(name)==0) return c.substring(name.length,c.length);
            }
            return "";
        }
} ]);

