'use strict';

/* App Module */

var iDeloApp = angular.module('iDeloApp',
    [ 'ngRoute', 'iDeloControllers', 'iDeloServices', 'directive.loading' ]);

iDeloApp.config([ '$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'indexInfo.html'
    }).when('/complaints/:citizenId', {
        templateUrl: 'complaints.html',
        controller: 'ComplaintsCtrl'
    }).when('/complaint/:complaintId', {
        templateUrl: 'complaint.html',
        controller: 'ComplaintCtrl'
    }).when('/allCitizens', {
        templateUrl: 'allCitizens.html',
        controller: 'CitizensCtrl'
    }).when('/myComplaints', {
        templateUrl: 'myComplaints.html',
        controller: 'MyComplaintsCtrl'
    }).when('/newComplaint', {
        templateUrl: 'newComplaint.html'
    }).when('/citizen/:citizenId', {
        templateUrl: 'citizen.html',
        controller: 'CitizenCtrl'
    }).when('/complaint', {
        templateUrl: 'complaint.html'
    }).when('/search/:query', {
        templateUrl: 'search.html',
        controller: 'SearchCtrl'
    }).when('/search', {
        templateUrl: 'search.html',
        controller: 'SearchCtrl'
    }).when('/newComplaintType', {
        templateUrl: 'newCrimeTypeAddition.html'
    }).when('/asAdmin', {
        templateUrl: 'indexInfo.html',
        controller: 'LoginCtrl'
    }).when('/detailed-search', {
        templateUrl: 'advancedSearch.html'
    }).otherwise({
        redirectTo: '/allComplaints'
    });
} ], ['$compileProvider', function($compileProvider) {
    var oldWhiteList = $compileProvider.imgSrcSanitizationWhitelist();
    $compileProvider.imgSrcSanitizationWhitelist(/^\s (https|ftp|file|blob):|data:image\//);
}]);

iDeloApp.run([ '$rootScope', '$location', 'Auth',
    function ($rootScope, $location, Auth) {
        $rootScope.$on('$routeChangeStart', function () {
            console.log("Route changed");
            console.log("User is " + Auth.getUser());
        });
    } ]);

