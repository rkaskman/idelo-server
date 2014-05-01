'use strict';

/* Services */

var iDeloServices = angular.module('iDeloServices', []);

iDeloApp.factory('Auth', function () {
    var Auth = {};

    Auth.getUserName = function() {
        return getCookie("username")
    };

    Auth.getUserId = function() {
        return getCookie("id")
    };

    Auth.isLoggedIn = function() {
        return Auth.getUserName() != "";
    };

    Auth.getUser = function() {
        var user = {};
        user.username = Auth.getUserName();
        user.id = Auth.getUserId();
        user.loggedIn = Auth.isLoggedIn();
        user.toString = function() {
             return user.id + " // " + user.username + " // " + user.loggedIn;
        }
        return user;
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

    Auth.invalidateSession = function() {
        document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
        document.cookie = "id=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
    };

    return Auth;
});



