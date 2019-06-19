package br.com.icoffee.util.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import br.com.icoffee.util.ConnectionFactory;
import br.com.icoffee.util.model.ItensVenda;


public class ItensVendaDAO implements GenericDAO {

    private Connection conn;

    public ItensVendaDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (Exception ex) {
            throw new Exception("Erro ao conectar ao banco de dados na classe ItensVendaDAOImpl: " + ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        //id produto, venda qtd unitaria e valor venda

        ItensVenda iv = (ItensVenda) object;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO itens_venda (id_venda, id_produto, valor_venda_produto, quantidade) VALUES (?, ?, ?, ?);";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, iv.getVenda().getIdVenda());
            stmt.setInt(2, iv.getProduto().getIdProduto());
            stmt.setDouble(3, iv.getValorVendaProduto());
            stmt.setInt(4, iv.getQuantidade());
            stmt.execute();
            return true;            
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar produto: " + ex.getMessage());
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parâmetros da conexão! Erro: " + ex.getMessage());
            }
        }
       
    }

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void excluir(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object carregar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
