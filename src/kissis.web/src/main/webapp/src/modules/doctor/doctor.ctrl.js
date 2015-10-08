(function (ng) {
    var mod = ng.module('doctorModule');

    mod.controller('doctorCtrl', ['$scope', 'doctorService', 'citaService', function ($scope, svc) {
            $scope.currentRecord = {};
            $scope.records = [];

            //Variables para el controlador
            this.readOnly = true;
            this.editMode = false;
            this.verPerfil = false;
            this.createMode = true;
            var self = this;
            
            this.mostrarDoctores = function ()
            {
               self.createMode = false;
               self.readOnly = true;
               self.editMode = false;
               self.verPerfil = false;
            };
            
            
            this.createRecord = function () {
                self.editMode = true;
                self.verPerfil = true;
                self.createMode = true;
                self.readOnly = true;
                $scope.currentRecord = {};
            };

            this.editRecord = function (record) {
                return svc.fetchRecord(record.id).then(function (response) {
                    $scope.currentRecord = response.data;
                    self.editMode = true;
                    self.verPerfil = false;
                    self.createMode = true;
                    return response;
                });
            };

            this.fetchRecords = function () {
                return svc.fetchRecords().then(function (response) {
                    $scope.records = response.data;
                    $scope.currentRecord = {};
                    self.editMode = false;
                    self.verPerfil = false;
                    return response;
                });
            };

            this.fetchRecord = function (record) {
                return svc.fetchRecord(record.id).then(function (response) {
                    $scope.currentRecord = response.data;
                    self.editMode = false;
                    self.verPerfil = true;
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

            this.fetchRecords();
        }]);
})(window.angular);