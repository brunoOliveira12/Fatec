/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.icoffee.util.DAO;

import br.com.icoffee.util.ConnectionFactory;
import br.com.icoffee.util.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class CategoriaDAO implements GenericDAO {

    private Connection conn;

    public CategoriaDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Categoria categoria = (Categoria) object;
        PreparedStatement stmt = null;
        String sql = "Insert into categoria(nome_categoria, descricao_categoria) values(?,?);";
        System.out.println("Parada 1");
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, categoria.getNomeCategoria());
            System.out.println("Parada 2");
            stmt.setString(2, categoria.getDescricaoCategoria());
            System.out.println("Parada 3");
            stmt.execute();
            System.out.println("Parada 4");
            return true;
        } catch (SQLException ex) {
            System.out.println("Problemas ao Cadastrar! Erro" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão! Erro" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select c.* from categoria c order by c.nome_categoria;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNomeCategoria(rs.getString("nome_categoria"));
                categoria.setDescricaoCategoria(rs.getString("descricao_categoria"));
                resultado.add(categoria);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Categoria!Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fecha conexão!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return resultado;
    }

    @Override
    public void excluir(int idObject) {
        PreparedStatement stmt = null;
        String sql = "Delete from categoria where id_categoria=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Problemas ao excluir Categoria! Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexao! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Object carregar(int idObject) {
        Categoria categoria = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select c.* from categoria c where c.id_categoria=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            if (rs.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNomeCategoria(rs.getString("nome_categoria"));
                categoria.setDescricaoCategoria(rs.getString("descricao_categoria"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Categoria! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Poblemas ao fechar canexao! " + ex.getMessage());
                ex.printStackTrace();
            }

        }
        return categoria;
    }

    @Override
    public Boolean alterar(Object object) {
        Categoria categoria = (Categoria) object;
        PreparedStatement stmt = null;
        String sql = "update categoria set nome_categoria=?,descricao_categoria=? where id_categoria=?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, categoria.getNomeCategoria());
            stmt.setString(2, categoria.getDescricaoCategoria());
            stmt.setInt(3, categoria.getIdCategoria());
            stmt.executeUpdate();
            return true;
        }catch(SQLException ex){
            System.out.println("Problemas ao alterar Categoria! "+ex.getMessage());
            ex.printStackTrace();
            return false;
        }finally{
            try{
                ConnectionFactory.closeConnection(conn,stmt);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar conexao com o BD! "+ex.getMessage());
                ex.printStackTrace();
            }
        }
        
         
}
}