package br.com.icoffee.util.DAO;

import br.com.icoffee.util.ConnectionFactory;
import br.com.icoffee.util.model.Categoria;

import br.com.icoffee.util.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements GenericDAO {

    private Connection conn;

    public ProdutoDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Produto produto = (Produto) object;
        PreparedStatement stmt = null;
        String sql = "Insert into produto(nome_produto, valor_venda_produto, valor_compra_produto, \n" +
"            quantidade_estoque_produto, id_categoria, foto_produto)\n" +
"    VALUES (?, ?, ?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setDouble(2, produto.getValorCompraProduto());
            stmt.setDouble(3, produto.getValorVendaProduto());
            stmt.setInt(4, produto.getQuantidadeEstoqueProduto());
            stmt.setInt(5, produto.getCategoria().getIdCategoria());
            stmt.setBinaryStream(6, produto.getFotoProduto(), produto.getFileItem());
            stmt.execute();
            return true;

        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Produto!Erro:" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conex√£o!Erro:" + ex.getMessage());
                ex.printStackTrace();

            }
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.*, c.nome_categoria from produto p, categoria c where p.id_categoria = c.id_categoria order by p.nome_produto;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNomeProduto(rs.getString("nome_produto"));
                produto.setValorCompraProduto(rs.getDouble("valor_compra_produto"));
                produto.setValorVendaProduto(rs.getDouble("valor_venda_produto"));
                produto.setQuantidadeEstoqueProduto(rs.getInt("quantidade_estoque_produto"));
                produto.setCategoria(new Categoria(rs.getInt("id_categoria"), rs.getString("nome_categoria"), null));
                resultado.add(produto);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Produto! Erro:" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexao!Erro" + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return resultado;
    }

    @Override
    public void excluir(int idObject) {
    PreparedStatement stmt = null;
    String sql = "delete from produto where id_produto=?;";
    try{
        stmt=conn.prepareStatement(sql);
        stmt.setInt(1, idObject);
        stmt.executeUpdate();
    }catch(SQLException ex){
        System.out.println("Problema ao excluir Produto!Erro" +ex.getMessage());
        ex.printStackTrace();
    }finally{
        try{
            ConnectionFactory.closeConnection(conn,stmt);
        }catch(Exception ex){
            System.out.println("Problemas ao fechar conexao!Erro:" +ex.getMessage());
            ex.printStackTrace();
        }
    }
    }

    @Override
    public Object carregar(int idObject) {
             Produto produto = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.*, c.nome_categoria from produto p, categoria c where p.id_categoria = c.id_categoria and p.id_produto=?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            if (rs.next()) {
                produto = new Produto();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNomeProduto(rs.getString("nome_produto"));
                produto.setValorCompraProduto(rs.getDouble("valor_compra_produto"));
                produto.setValorVendaProduto(rs.getDouble("valor_venda_produto"));
                produto.setQuantidadeEstoqueProduto(rs.getInt("quantidade_estoque_produto"));
                produto.setCategoria(new Categoria(rs.getInt("id_categoria"),rs.getString("nome_categoria")));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao carregar Produto! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Poblemas ao fechar canexao! " + ex.getMessage());
                ex.printStackTrace();
            }

        }
        return produto;
    }

    @Override
    public Boolean alterar(Object object) {
        Produto produto = (Produto) object;
        PreparedStatement stmt = null;
        String sql = "update produto set nome_produto=?,valor_compra_produto=?, valor_venda_produto=?, quantidade_estoque_produto=?, "
                + "id_categoria = ? where id_produto=?;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setDouble(2, produto.getValorCompraProduto());
            stmt.setDouble(3, produto.getValorVendaProduto());
            stmt.setInt(4, produto.getQuantidadeEstoqueProduto());
            stmt.setInt(5, produto.getCategoria().getIdCategoria());
            stmt.setInt(6, produto.getIdProduto());
            stmt.executeUpdate();
            return true;
        }catch(SQLException ex){
            System.out.println("Problemas ao alterar Produto! "+ex.getMessage());
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

    public Produto getFoto(int idProduto){
        
        Produto produto = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.nome_produto, p.foto_produto from produto p where p.id_produto = ?;";
        try{
            stmt=conn.prepareStatement(sql);
            stmt.setInt(1,idProduto);
            rs=stmt.executeQuery();
            if(rs.next()){
                produto = new Produto();
                produto.setFotoProduto(rs.getBinaryStream("foto_produto"));
                produto.setNomeProduto(rs.getString("nome_produto"));
            }
        }catch(SQLException ex){
            System.out.println("Problemas ao carregar imagem! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
        return produto;
    }
    
    public Double carregarValorVendaProduto(int idProduto) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Double valorVenda = null;
        String sql = "select p.* from produto p where p.id_produto = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idProduto);
            rs = stmt.executeQuery();
            if (rs.next()) {
                    valorVenda = rs.getDouble("valor_venda_produto");
            } 
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Categoria! Erro: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conex„o! Erro: " + ex.getMessage());
            }
        }
        return valorVenda;
    }
}
