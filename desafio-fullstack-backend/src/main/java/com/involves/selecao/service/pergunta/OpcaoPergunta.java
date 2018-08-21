package com.involves.selecao.service.pergunta;

import java.util.Arrays;

public enum OpcaoPergunta {

    SITUACAO_PRODUTO("Qual a situação do produto?") {
        @Override
        public IPergunta obterPergunta() {
            return new ProdutoAusente();
        }
    },

    PRECO_PRODUTO("Qual o preço do produto?") {
        @Override
        public IPergunta obterPergunta() {
            return new PrecoProduto();
        }
    },

    PARTICIPACAO_PRODUTO("%SHARE") {
        @Override
        public IPergunta obterPergunta() {
            return new ParticipacaoProduto();
        }
    };


    public abstract IPergunta obterPergunta();


    private String value;

    OpcaoPergunta(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return this.value;
    }

    public static OpcaoPergunta fromString(String pergunta) {
        return Arrays.stream(values())
                .filter(opcaoPergunta -> opcaoPergunta.value.equalsIgnoreCase(pergunta))
                .findFirst()
                .orElse(null);
    }
}
