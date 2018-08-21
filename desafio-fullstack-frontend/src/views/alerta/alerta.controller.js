angular.module('appDesafioFullStack')
    .controller('AlertaController', ['$scope', 'AlertaService', 'reCAPTCHA', AlertaController]);


function AlertaController($scope, _alertaService) {
    $scope.listaMsg = [];

    function init() {
      //  $scope.findAllAlertas();
    }


    $scope.user = {};
    // or you can also set key here
    reCAPTCHA.setPublicKey('6LcOB2AUAAAAAOcSAPmPoFxkzNOwkKChtUhKASjB');
    $scope.register = function () {
        if($scope.registerForm.$valid) {
            $scope.showdialog = true;
            console.log('Form is valid');
        }
    }


    $scope.findAllAlertas = () => {
        _alertaService.findAll().then(function (data) {
            $scope.listaMsg = data;
        })
    }

    $scope.processarAlertas = () => {
        _alertaService.processarAlertas().then(function (data) {
            $scope.findAllAlertas();
        })
    }


    $scope.showModal = (alerta) => {
        $scope.alertaSelected = alerta;
        $('#alertaModal').modal('show')
    }

    init();
}