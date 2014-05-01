'use strict';

/* App Module */

var iDeloApp = angular.module('iDeloApp',
    [ 'ngRoute', 'iDeloControllers', 'iDeloServices']);

iDeloApp.config([ '$routeProvider', function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'indexInfo.html'
    }).when('/complaints/:citizenId', {
        templateUrl: 'complaints.html',
        controller: 'ComplaintsCtrl'
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
    }).otherwise({
        redirectTo: '/allComplaints'
    });
} ]);

iDeloApp.run([ '$rootScope', '$location',
    function ($rootScope, $location) {
        $rootScope.$on('$routeChangeStart', function () {
            console.log("Route changed");
        });
    } ]);

