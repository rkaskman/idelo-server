'use strict';

/* Services */

var iDeloServices = angular.module('iDeloServices', []);

iDeloApp.factory('Auth', function () {
    var user;
    return {
        setUser: function (aUser) {
            user = aUser;
        },
        getUser: function () {
            return user;
        },
        isLoggedIn: function () {
            return (user) ? user : false;
        }
    }
});

iDeloServices.factory('App', [ '$scope', '$location', 'Auth',
    function ($scope, $location, Auth) {

        $scope.$on('$routeChangeSuccess', function (event, current, previous, rejection) {
            console.log("Route changed From App Service");
        });

        $scope.$watch(Auth.isLoggedIn, function (value, oldValue) {
            if (!value && oldValue) {
                console.log("Disconnect");
                $location.path('/');
            }

            if (value) {
                console.log("Connect")
                $location.path('/');
            }

        }, true);
}]);

