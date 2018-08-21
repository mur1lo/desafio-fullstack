angular.module("appDesafioFullStack")
    .service('AlertaService', ['$http', '$rootScope', 'BASE_REST_URL', AlertaService]);

function AlertaService($http, $rootScope, BASE_REST_URL) {

    var _findAll = function () {
        return $http.get(BASE_REST_URL + 'alertas').then(responder).catch(getErro);
    }


    var _processarAlertas = function () {
        return $http.get(BASE_REST_URL + 'alertas/processar').then(responder).catch(getErro);
    }

    return {
        findAll: _findAll,
        processarAlertas: _processarAlertas
    }

    //----------- /Funções de uso geral ---------//

    //Função que retorna a resposta para o controller
    function responder(response) {
        return response.data;
    };

    //Função que exibe a mensagem de erro no console
    function getErro(response) {
        console.log('Erro', response);
    };
    //---------— /Funções de uso geral —-------//
}
