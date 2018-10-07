/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web.ado.spring2.model;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Guilherme
 */
public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private Double precoCompra;
    private Double precoVenda;
    private int quantidade;
    private int disponivel;
    private Date dtCadastro;

    public Produto() {
    }

    public Produto(Long id, String nome, String descricao, Double precoCompra, Double precoVenda, int quantidade, int disponivel, Date dtCadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.quantidade = quantidade;
        this.disponivel = disponivel;
        this.dtCadastro = dtCadastro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(int disponivel) {
        this.disponivel = disponivel;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public boolean isValido() {
        boolean nomeValido = nome != null && nome.trim().length() > 0;
        boolean precoCompra = getPrecoCompra() > 0;
        return nomeValido && precoCompra;
    }
    
     @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome+ '}';
    }
}
