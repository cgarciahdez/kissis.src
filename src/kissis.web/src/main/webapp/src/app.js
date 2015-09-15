(function (ng) {

    var mainApp = ng.module('mainApp', [
        'consultorioModule',
        'adminModule',
        'doctorModule',
        'pacienteModule',
        'especialidadModule',
        'ngRoute'
    ]);

    mainApp.config(['$routeProvider', function ($routeProvider) {
            $routeProvider
                .when('/consult', {
                    templateUrl: 'src/modules/consultorio/consultorio.tpl.html',
                    controller: 'consultorioCtrl',
                    controllerAs: 'ctrl'
                })
                .when('/admin', {
                    templateUrl: 'src/modules/admin/admin.tpl.html',
                    controller: 'adminCtrl',
                    controllerAs: 'ctrl'
                })
                .when('/especialidad', {
                    templateUrl: 'src/modules/especialidad/especialidad.tpl.html',
                    controller: 'especialidadCtrl',
                    controllerAs: 'ctrl'
                })
                .when('/paciente', {
                    templateUrl: 'src/modules/paciente/paciente.tpl.html',
                    controller: 'pacienteCtrl',
                    controllerAs: 'ctrl'
                })
                .when('/doctor', {
                    templateUrl: 'src/modules/doctor/doctor.tpl.html',
                    controller: 'doctorCtrl',
                    controllerAs: 'ctrl'
                })
                .otherwise('/#');
        }]);
})(window.angular);
