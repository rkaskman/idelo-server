'use strict';

/* Controllers */

var iDeloControllers = angular.module('iDeloControllers', []);

iDeloControllers.controller('ComplaintsCtrl', [
		'$scope',
		'$routeParams',
		'$http',
		function($scope, $routeParams, $http ) {
			$http.get('/get-complaint/' + $routeParams.citizenId)
					.success(function(data) {
						$scope.complaints = data;
					});
            $http.get('/getAllViolationTypes')
                .success(function(data) {
                    $scope.allViolationTypes = data;
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


                var latitude  = $scope.complaint.locationLatitude;
                var longitude = $scope.complaint.locationLongitude;


                        loadScript();

//            $('#mapHolder').append('<map zoom="11" center="[' + latitude + ', ' + longitude + ']"><marker position="[' + latitude + ', ' + longitude + ']" title="Violation spot" animation="Animation.BOUNCE"></marker></map>');



                function loadScript() {
                    var script = document.createElement('script');
                    script.type = 'text/javascript';

                    script.src = 'https://maps.googleapis.com/maps/api/js?v=AIzaSyCzYjvCXkNylxgzNlWHmuWwSmJmWeqm61k&sensor=false&' +
                        'callback=loadMapWrapper';
                    document.body.appendChild(script);
                }


                // workaround to place into callback

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

iDeloControllers.controller('SearchCtrl', [ '$scope', '$routeParams', '$http', '$location', 'Search',
    function($scope, $routeParams, $http, $location, Search) {
            $scope.result = Search.result;
            $scope.sexOfUser = "male";

            if($routeParams.query != undefined ){
                $http.get('/search/'+$routeParams.query).success(function(data) {
                        $scope.result = data;
                });
            }


            $scope.doUserSearch = function () {
                var request = {
                    nameOfUser: $scope.nameOfUser,
                    sexOfUser: $scope.sexOfUser,
                    dateOfUser: $scope.dateOfUser,
                    addressOfUser: $scope.addressOfUser
                };

                $http({
                        url: '/advancedUserSearch/',
                        method: "POST",
                        data: $.param(request),
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
                        }
                    }).success(function (data) {
                        Search.result = data;
                        $location.path("/search");
                });
            };

            $scope.doViolationSearch = function () {
                var request = {
                    nameOfEpisode: $scope.nameOfEpisode,
                    date: $scope.date,
                    tags: $scope.tags,
                    location: $scope.location,
                    description: $scope.description
                };

                $http({
                        url: '/advancedComplaintSearch/',
                        method: "POST",
                        data: $.param(request),
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
                        }
                    }).success(function (data) {
                    Search.result = data;
                    $location.path("/search");
                });
            }

        }
]);

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

        $scope.logout = function() {
            Auth.invalidateSession();
        };

} ]);

