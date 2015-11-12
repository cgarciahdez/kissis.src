(function (ng) {
    var mod = ng.module('pacienteModule');

    mod.controller('pacienteCtrl', ['$scope', 'pacienteService', 'citaService',
        function ($scope, svc, citasvc) {
            $scope.currentRecord = {};
            $scope.citas = [];
            $scope.records = [];

            //Variables para el controlador
            this.readOnly = false;
            this.editarPerfilVar = false;
            this.verPerfilVar = true;
            this.verCitasVar = false;
            this.verAgendar = false;
            
            this.verPerfil = function () {
                this.editarPerfilVar = false;
                this.verPerfilVar = true;
                this.verCitasVar = false;
                this.verAgendar = false;
            };

            this.editarPerfil = function () {
                return svc.fetchPaciente($scope.currentRecord).then(function (response) {
                    debugger;
                    this.editarPerfilVar = true;
                    this.verPerfilVar = false;
                    this.verCitasVar = false;
                    this.verAgendar = false;
                    return response;
                });
            };

            this.verCitas = function () {
                return svc.fetchCitas($scope.currentRecord).then(function (response) {
                    $scope.records = response.data;
                    this.editarPerfilVar = false;
                    this.verPerfilVar = false;
                    this.verCitasVar = true;
                    this.verAgendar = false;
                    return response;
                });
            };
            
            this.verAgendarCita = function() {
                return citasvc.fetchCitasLibres().then(function (response) {
                    $scope.citas = response.data;
                    this.editarPerfilVar = false;
                    this.verPerfilVar = false;
                    this.verCitasVar = false;
                    this.verAgendar = true;
                    return response;
                });
                
            };
            
            this.cargarPerfil = function () {
                return svc.fetchPaciente(1).then(function (response) {
                    $scope.currentRecord = response.data;
                });
            };

            this.guardarPerfil = function () {
                return svc.savePaciente($scope.currentRecord).then(function () {
                    this.cargarPerfil();
                });
            };
            
            this.cargarCitas = function () {
                return svc.fetchCitas($scope.currentRecord).then(function (response) {
                    $scope.records = response.data;
                });
            };
            
            this.cargarPerfil();
        }]);
})(window.angular);


