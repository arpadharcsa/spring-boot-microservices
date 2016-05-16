var appModule = angular.module('app', []);

appModule.controller('MainCtrl', ['mainService', '$scope', '$http',
    function (mainService, $scope, $http) {
        $scope.token = null;
        $scope.error = null;
        $scope.historyData = [];
        $scope.login = function () {
            $scope.error = null;
            mainService.login($scope.username,$scope.password).then(function (token) {
                    $scope.token = token;
                    $http.defaults.headers.common.Authorization = 'Bearer ' + token;
                    $scope.loadHistory();
                },
                function (error) {
                    $scope.error = "Authentication failed.";
                    $scope.username = '';
                });
        };

        $scope.loadHistory = function () {
            mainService.loadHistory().then(function (data) {
                angular.copy(data,$scope.historyData);
            });
        };

        $scope.logout = function () {
            $scope.username = '';
            $scope.token = null;
            $http.defaults.headers.common.Authorization = '';
        };

        $scope.loggedIn = function () {
            return $scope.token !== null;
        }
    }]);


appModule.service('mainService', function ($http) {
    return {
        login: function (username,password) {
            return $http.post('login/login', {username: username,password:password}).then(function (response) {
                return response.data.token;
            });
        },

        loadHistory: function () {
            return $http.get('api/gethistory').then(function (response) {
                return response.data.transactions;
            });
        }
    };
});
