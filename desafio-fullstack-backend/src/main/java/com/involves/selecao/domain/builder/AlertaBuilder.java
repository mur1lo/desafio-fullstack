package com.involves.selecao.domain.builder;

import com.involves.selecao.domain.Alerta;

public class AlertaBuilder {

    private Alerta instancia;

    public AlertaBuilder() {
        this.instancia = new Alerta();
    }

    public AlertaBuilder margem(int magem) {
        instancia.setMargem(magem);
        return this;
    }


    public AlertaBuilder flTipo(Integer flTipo) {
        instancia.setFlTipo(flTipo);
        return this;
    }

    public AlertaBuilder descricao(String descricao) {
        instancia.setDescricao(descricao);
        return this;
    }

    public AlertaBuilder produto(String produto) {
        instancia.setProduto(produto);
        return this;
    }

    public AlertaBuilder pontoVenda(String produtoVenda) {
        instancia.setPontoDeVenda(produtoVenda);
        return this;
    }

    public AlertaBuilder rotulo(String rotulo) {
        instancia.setRotulo(rotulo);
        return this;
    }

    public AlertaBuilder notificante(String notificante) {
        instancia.setNotificante(notificante);
        return this;
    }

    public AlertaBuilder id(int id) {
        instancia.setId(id);
        return this;
    }

    public Alerta criar() {
        return this.instancia;
    }

}
