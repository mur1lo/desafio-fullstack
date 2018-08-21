package com.involves.selecao.domain;

import org.springframework.data.annotation.Id;

public class Alerta {

    @Id
    private int id;
    private String pontoDeVenda;
    private String descricao;
    private String produto;
    private String categoria;
    private Integer flTipo;
    private Integer margem;
    private String rotulo;
    private String notificante;

    public Alerta(String pontoDeVenda, String descricao, String produto, Integer flTipo) {
        this.pontoDeVenda = pontoDeVenda;
        this.descricao = descricao;
        this.produto = produto;
        this.flTipo = flTipo;
    }

    public Alerta() {

    }

    public String getPontoDeVenda() {
        return pontoDeVenda;
    }

    public void setPontoDeVenda(String pontoDeVenda) {
        this.pontoDeVenda = pontoDeVenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getFlTipo() {
        return flTipo;
    }

    public void setFlTipo(Integer flTipo) {
        this.flTipo = flTipo;
    }

    public Integer getMargem() {
        return margem;
    }

    public void setMargem(Integer margem) {
        this.margem = margem;
    }
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getRotulo() {
        return rotulo;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }

    public String getNotificante() {
        return notificante;
    }

    public void setNotificante(String notificante) {
        this.notificante = notificante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


