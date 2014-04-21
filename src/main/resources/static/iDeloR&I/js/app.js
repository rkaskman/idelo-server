var iDeloApp = angular.module('iDeloApp',
		[ 'ngRoute', 'complaintsControllers' ]);

iDeloApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'indexInfo.html'
	}).when('/complaints/:citizenId', {
		templateUrl : 'complaints.html',
		controller : 'ComplaintsCtrl'
	}).when('/allCitizens', {
		templateUrl : 'allCitizens.html',
		controller : 'CitizensCtrl'
	}).when('/myComplaints', {
		templateUrl : 'myComplaints.html',
		controller : 'MyComplaintsCtrl'
	}).when('/newComplaint', {
		templateUrl : 'newComplaint.html'
	}).when('/citizen/:citizenId', {
		templateUrl : 'citizen.html',
		controller : 'CitizenCtrl'
	}).when('/complaint', {
		templateUrl : 'complaint.html'
	}).when('/search/:query', {
		templateUrl : 'search.html',
		controller : 'SearchCtrl'
	}).when('/search', {
		templateUrl : 'search.html',
		controller : 'SearchCtrl'
	}).when('/newComplaintType', {
        templateUrl : 'newCrimeTypeAddition.html'
	}).when('/asAdmin', {
		templateUrl : 'indexInfo.html',
		controller : 'LoginCtrl'
	}).otherwise({
		redirectTo : '/allComplaints'
	});
} ]);

iDeloApp.factory('Auth', function() {
	var user;
	return {
		setUser : function(aUser) {
			user = aUser;
		},
		getUser : function() {
			return user;
		},
		isLoggedIn : function() {
			return (user) ? user : false;
		}
	}
})

iDeloApp.run([ '$rootScope', '$location', 'Auth',
		function($rootScope, $location, Auth) {
			$rootScope.$on('$routeChangeStart', function() {
				if (!Auth.isLoggedIn()) {
					Auth.setUser(0);
					console.log('USER');
					$("li#user-complaints").show();
					$("li#user-new-complaint").show();
				} else if (Auth.getUser() === 12) {
					$("li#user-complaints").hide();
					$("li#user-new-complaint").hide();
					$("li#citizen-registry").show();
					$("li#all-citizens").show();
					$("li#new-crime-add").show();
				}
			});
		} ]);