(function (ng) {

    var mainApp = ng.module('mainApp', [
        'consultorioModule',
        'ngRoute'
    ]);

    mainApp.config(['$routeProvider', function ($routeProvider) {
            $routeProvider
                .when('/consult', {
                    templateUrl: 'src/modules/consultorio/consultorio.tpl.html',
                    controller: 'consultorioCtrl',
                    controllerAs: 'ctrl'
                })
                .otherwise('/consult');
        }]);
})(window.angular);
