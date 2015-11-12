(function (ng) {
    var mod = ng.module('pacienteModule');

    mod.controller('pacienteCtrl', ['$scope', 'pacienteService', 
        function ($scope, svc) {
            $scope.currentRecord = {};
            $scope.records = [];

            //Variables para el controlador
            this.readOnly = false;
            this.editarPerfilVar = false;
            this.verPerfilVar = true;
            this.verCitasVar = false;
            this.agregarCitaVar = false;
            
            var self = this;
            
            this.verPerfil = function () {
                self.cargarPerfil();
                self.editarPerfilVar = false;
                self.verPerfilVar = true;
                self.verCitasVar = false;
                self.agregarCitaVar = false;
            };

            this.editarPerfil = function (record) {
                return svc.fetchPaciente(record.id).then(function (response) {
                    self.editarPerfilVar = true;
                    self.verPerfilVar = false;
                    self.verCitasVar = false;
                    self.agregarCitaVar = false;
                    return response;
                });
            };

            this.verCitas = function () {
                return svc.fetchCitas($scope.currentRecord).then(function (response) {
                    $scope.records = response.data;
                    self.editarPerfilVar = false;
                    self.verPerfilVar = false;
                    self.verCitasVar = true;
                    self.agregarCitaVar = false;
                    return response;
                });
            };
            
            this.cargarPerfil = function () {
                return svc.fetchPaciente(1).then(function (response) {
                    $scope.currentRecord = response.data;
                });
            };

            this.guardarPerfil = function (record) {
                return svc.savePaciente(record).then(function () {
                   self.verPerfil();
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


