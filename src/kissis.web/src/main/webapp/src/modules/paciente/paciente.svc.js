(function (ng) {
    var mod = ng.module('pacienteModule');

    mod.service('pacienteService', ['$http', 'pacienteContext', function ($http, context) {
            this.fetchPaciente = function (id) {
                return $http.get(context + "/" + id);
            };
            
            this.savePaciente = function (currentRecord) {
                return $http.put(context + "/" + currentRecord.id, currentRecord);
            };
            
            this.fetchCitas = function (currentRecord) {
                return $http.get(context + "/" + currentRecord.id + "/citas/");
            };
            
            this.deleteCita = function (currentRecord, id) {
                return $http.delete(context + "/" + currentRecord.id + "/citas/" + id);
            };
        }]);
})(window.angular);