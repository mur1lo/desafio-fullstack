package com.involves.selecao.domain.enumeration;

public enum TipoAlerta {
    RUPTURA(1), PRECO_SUPERIOR(2), PRECO_INFERIOR(3), PARTICIPACAO_SUPERIOR(4), PARTICIPACAO_INFERIOR(5);

    private final Integer valor;
    TipoAlerta(Integer valorOpcao){
        valor = valorOpcao;
    }
    public Integer getValor(){
        return valor;
    }

}
