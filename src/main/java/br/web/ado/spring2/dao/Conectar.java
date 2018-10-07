/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web.ado.spring2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class Conectar {
    private static String user = "root";
    private static String senha = "";
    private static String database = "jdbc:mysql://localhost";
    private static String driver = "com.mysql.jdbc.Driver";
    
    public static Connection getConexao() throws Exception {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(database, user, senha);
        } catch (Exception e) {
            throw new Exception("Erro ao fazer conexao com banco de dados: " + e.getMessage());
        }
    }
}
