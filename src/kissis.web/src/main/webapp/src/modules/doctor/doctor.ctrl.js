(function (ng) {
    var mod = ng.module('doctorModule');

    mod.controller('doctorCtrl', ['$scope','$filter', 'doctorService', 'citaService', 'consultorioService', function ($scope,$filter, svc, citasvc,consvc) {
            $scope.currentRecord = {};
            $scope.records = [];

            var horas = [{"horaInicio": 7}, {"horaInicio": 8}, {"horaInicio": 9},
                {"horaInicio": 10}, {"horaInicio": 11}, {"horaInicio": 12}, {"horaInicio": 13},
                {"horaInicio": 14}, {"horaInicio": 15}, {"horaInicio": 16}, {"horaInicio": 17},
                {"horaInicio": 18}];

            $scope.times = horas;

            //Variables para el controlador
            this.readOnly = false;
            this.editMode = false;
            this.verPerfil = false;
            this.createMode = true;
            this.seleccionarHorarios = false;
            var self = this;

            this.verHorarios = function ()
            {
                self.createMode = false;
                self.readOnly = false;
                self.editMode = false;
                self.verPerfil = false;
                self.seleccionarHorarios = true;
            };

            this.saveCitas = function ()
            {
                
                angular.forEach($scope.times,function(value){
                if (value.selected)
                    {
                        var cita = {};
                        return svc.fetchRecord(1).then(function(response){
                            
                            cita.doctor = response.data;
                            return consvc.fetchRecord(1).then(function(respons){
                                cita.consultorio = respons.data;
                                cita.fecha= $filter('date')($scope.dt, $scope.format);
                                cita.hora = value.horaInicio;
                                cita.paciente = null;
                                citasvc.saveRecord(cita);
                                
                                
                            });
                        });
                        
                        
                        
                    }
            });
            };

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


            $scope.today = function () {
                $scope.dt = new Date();
            };
            $scope.today();

            $scope.clear = function () {
                $scope.dt = null;
            };

            // Disable weekend selection
            $scope.disabled = function (date, mode) {
                return (mode === 'day' && (date.getDay() === 0 || date.getDay() === 6));
            };

            $scope.toggleMin = function () {
                $scope.minDate = $scope.minDate ? null : new Date();
            };
            $scope.toggleMin();

            $scope.open = function () {
                $scope.status.opened = true;
            };

            $scope.variable = false;
            $scope.mostrar = 0;

            $scope.$watch('dt', function () {
                if ($scope.mostrar === 0)
                {
                    $scope.mostrar = 1;
                }
                else {
                    $scope.variable = true;
                    var days = ["Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"];
                    $scope.nomDia = days[$scope.dt.getDay()] + " " + $scope.dt.getDate();
                }
            });

            $scope.mostrarDia = function () {
                $scope.variable = true;
                var days = ["Domingo", "Lunes", "Martes", "MiÃ©rcoles", "Jueves", "Viernes", "SÃ¡bado"];
                $scope.nomDia = days[$scope.dt.getDay()] + " " + $scope.dt.getDate();
            };

            $scope.dateOptions = {
                formatYear: 'yy',
                startingDay: 1
            };

            $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
            $scope.format = $scope.formats[0];

            $scope.status = {
                opened: false
            };


            $scope.getDayClass = function (date, mode) {
                if (mode === 'day') {
                    var dayToCheck = new Date(date).setHours(0, 0, 0, 0);

                    for (var i = 0; i < $scope.events.length; i++) {
                        var currentDay = new Date($scope.events[i].date).setHours(0, 0, 0, 0);

                        if (dayToCheck === currentDay) {
                            return $scope.events[i].status;
                        }
                    }
                }

                return '';
            };
        }]);


})(window.angular);