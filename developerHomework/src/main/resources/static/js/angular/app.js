'use strict';

var textAppp = angular.module('textAppp', ['ui.router','angularUtils.directives.dirPagination']);

textAppp.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.when("", "/index");
    $stateProvider
    .state('index', {
        url: '/index',
        templateUrl: 'index.html',
    })
    .state('userForm', {
        url: '/userForm',
        templateUrl: 'partials/userForm.html',
        controller: 'formController'      
    });
    
});