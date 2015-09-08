(function (ng) {
    var mod = ng.module('consultorioModule');

    mod.controller('consultorioCtrl', ['$scope', 'consultorioService', function ($scope, svc) {
            $scope.currentRecord = {};
            $scope.records = [];

            //Variables para el controlador
            this.readOnly = false;
            this.editMode = false;
            this.verPerfil = false;
            this.verConsultorios = true;

            var self = this;
            this.createRecord = function () {
                self.editMode = true;
                self.verPerfil = false;
                self.verConsultorios = false;
                $scope.currentRecord = {};
            };

            this.editRecord = function (record) {
                return svc.fetchRecord(record.id).then(function (response) {
                    $scope.currentRecord = response.data;
                    self.editMode = true;
                    self.verPerfil = false;
                    self.verConsultorios = false;
                    return response;
                });
            };

            this.fetchRecords = function () {
                return svc.fetchRecords().then(function (response) {
                    $scope.records = response.data;
                    $scope.currentRecord = {};
                    self.editMode = false;
                    self.verPerfil = false;
                    self.verConsultorios = true;
                    return response;
                });
            };

            this.fetchRecord = function (record) {
                return svc.fetchRecord(record.id).then(function (response) {
                    $scope.currentRecord = response.data;
                    self.editMode = false;
                    self.verPerfil = true;
                    self.verConsultorios = false;
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
