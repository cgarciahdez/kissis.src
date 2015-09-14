(function (ng) {
    var mod = ng.module('pacienteModule');

    mod.controller('pacienteCtrl', ['$scope', 'pacienteService', function ($scope, svc) {
            $scope.currentRecord = {};
            $scope.records = [];

            //Variables para el controlador
            this.readOnly = false;
            this.editMode = false;
            this.verPerfilPaciente = true;
            this.verCitas = false;
            this.agregarCita = false;

            var self = this;
            
            this.perfil = function () {
                self.editMode = false;
                self.verPerfilPaciente = true;
                self.verCitas = false;
                self.agregarCita = false;
                $scope.currentRecord = {};
            };
            
            this.createRecord = function () {
                self.editMode = true;
                self.verPerfilPaciente = false;
                self.verCitas = false;
                self.agregarCita = false;
                $scope.currentRecord = {};
            };

            this.editRecord = function (record) {
                return svc.fetchRecord(record.id).then(function (response) {
                    $scope.currentRecord = response.data;
                    self.editMode = true;
                    self.verPerfilPaciente = false;
                    self.verCitas = false;
                    this.agregarCita = false;
                    return response;
                });
            };

            this.fetchRecords = function () {
                return svc.fetchRecords().then(function (response) {
                    $scope.records = response.data;
                    $scope.currentRecord = {};
                    self.editMode = false;
                    self.verPerfilPaciente = false;
                    self.verCitas = true;
                    this.agregarCita = false;
                    return response;
                });
            };

            this.createRecord = function (record) {
                return svc.fetchRecord(record.id).then(function (response) {
                    $scope.currentRecord = response.data;
                    self.editMode = false;
                    self.verPerfilPaciente = false;
                    self.verCitas = false;
                    self.agregarCita = true;
                    return response;
                });
            };

            this.saveRecord = function () {
                return svc.saveRecord($scope.currentRecord).then(function () {
                    self.fetchRecords();
                });
            };
            this.deleteRecord = function (record) {
                return svc.deleteRecord(record.id).then(function () {
                    self.fetchRecords();
                });
            };
        }]);
})(window.angular);


