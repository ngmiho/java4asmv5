var app = angular.module("myApp", ['ngRoute'])
    .config(function($routeProvider) {
        $routeProvider
        .when('/home', {
            templateUrl : 'item.jsp'
        })
        .when('/detail', {
            templateUrl : 'detail.jsp'
        })
        .when('/signin', {
            templateUrl : 'login.jsp'
        })
        .when('/forgotpassword', {
            templateUrl : 'forgotPassword.jsp'
        })
        .when('/signup', {
            templateUrl : 'signup.jsp'
        })
        .when('/logoff', {
            templateUrl : 'item.jsp'
        })
        .when('/changepassword', {
            templateUrl : 'changePassword.jsp'
        })
        .when('/video', {
            templateUrl : 'video.jsp'
        })
        .when('/user', {
            templateUrl: 'user.jsp'
        })
        .when('/report', {
            templateUrl: 'statistic.jsp'
        })
        .when('/editprofile', {
            templateUrl : 'editProfile.jsp'
        })
        .otherwise({
			templateUrl: 'item.jsp'
		})
    })
    .controller("myCtrl", function ($scope) {
    });