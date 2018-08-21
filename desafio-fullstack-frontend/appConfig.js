'use strict'
const baseUrl = () => {
    let protocol = window.location.protocol
    let host = window.location.hostname
    let port = '8080'
    return `${protocol}//${host}:${port}/`
}


angular.module('appDesafioFullStack')
    .config(AppConfig)
    .constant('BASE_REST_URL', baseUrl())
    .config(($httpProvider) => {
        $httpProvider.defaults.headers.common = { 'content-type': 'application/json' };
    })

function AppConfig($routeProvider) {
    $routeProvider
        // route for the home page
        .when('/', {
            templateUrl: 'index.html',
        })
        .otherwise({redirectTo:'/'});
}