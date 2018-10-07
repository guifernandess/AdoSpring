/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web.ado.spring2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import br.web.ado.spring2.model.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class DaoProduto {

    public static void cadastrar(Produto produto) throws Exception {
        try {
            Connection conn = Conectar.getConexao();
            String sql = "insert into produtobd.produto(nome, descricao, preco_compra, preco_venda, quantidade, disponivel, dt_cadastro)"
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPrecoCompra());
            stmt.setDouble(4, produto.getPrecoVenda());
            stmt.setInt(5, produto.getQuantidade());
            stmt.setInt(6, produto.getDisponivel());
            stmt.setDate(7, produto.getDtCadastro());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public void alterar(Produto produto) throws Exception, SQLException {
        try {
            Connection conn = Conectar.getConexao();
            String sql = "update produtobd.produto set"
                    + "nome = ?, descricao = ?, preco_compra = ?, preco_venda = ?, quantidade = ?, disponivel = ?, dt_cadastro = ?"
                    + "where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPrecoCompra());
            stmt.setDouble(4, produto.getPrecoVenda());
            stmt.setInt(5, produto.getQuantidade());
            stmt.setInt(6, produto.getDisponivel());
            stmt.setDate(7, produto.getDtCadastro());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }

    //ajustar para mostrar categoria (inner join categora)
    public Produto obter(Long id) throws Exception {
        try {
            Produto produto = new Produto();
            Connection conn = Conectar.getConexao();
            String sql = "select id ,nome, descricao, preco_compra, preco_venda, quantidade, disponivel, dt_cadastro"
                    + "PRODUTOBD.PRODUTO p"
                    + "WHERE p.id = " + id;

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produto = new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDouble("preco_compra"),
                        rs.getDouble("preco_venda"),
                        rs.getInt("quantidade"),
                        rs.getInt("disponivel"),
                        rs.getDate("dt_cadastro"));
            }
            stmt.close();
            conn.close();

            return produto;
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    
    public void deletar(Long id ) throws Exception {
        try {
            Connection conn = Conectar.getConexao();
            String sql = "delete PRODUTOBD.PRODUTO  where id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public ArrayList<Produto> obterList() throws Exception {
        try {
            ArrayList<Produto> produtos = new ArrayList<Produto>();
            Connection conn = Conectar.getConexao();
            String sql = "select id ,nome, descricao, preco_compra, preco_venda, quantidade, disponivel, dt_cadastro"
                    + "PRODUTOBD.PRODUTO p";
            
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                produtos.add( new Produto(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getString("descricao"),
                        rs.getDouble("preco_compra"),
                        rs.getDouble("preco_venda"),
                        rs.getInt("quantidade"),
                        rs.getInt("disponivel"),
                        rs.getDate("dt_cadastro")));
            }
            
            stmt.close();
            conn.close();

            return produtos;
        } catch (Exception e) {
            throw e;
        }
    }

}
