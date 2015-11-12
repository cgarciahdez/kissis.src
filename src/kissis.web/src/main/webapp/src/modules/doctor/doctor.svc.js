(function (ng) {
    var mod = ng.module('doctorModule');

    mod.service('doctorService', ['$http', 'doctorContext', function ($http, context) {
            this.fetchRecords = function () {
                return $http.get(context);
            };

            this.fetchRecord = function (id) {
                return $http.get(context + "/" + id);
            };
            this.saveRecord = function (currentRecord) {
                if (currentRecord.id) {
                    return $http.put(context + "/" + currentRecord.id, currentRecord);
                } else {
                    return $http.post(context, currentRecord);
                }
            };
            this.deleteRecord = function (id) {
                return $http.delete(context + "/" + id);
            };
            
             this.fetchCitas = function (currentRecord) {
                return $http.get(context + "/" + currentRecord.id + "/citas/");
            };
            
            this.deleteCita = function (currentRecord, id) {
                return $http.delete(context + "/" + currentRecord.id + "/citas/" + id);
            };

            
        }]);
})(window.angular);