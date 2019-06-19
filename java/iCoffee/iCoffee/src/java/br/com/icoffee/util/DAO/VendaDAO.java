package br.com.icoffee.util.DAO;

import br.com.icoffee.util.ConnectionFactory;
import br.com.icoffee.util.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class VendaDAO {
   private Connection conn;

    public VendaDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (Exception ex) {
            throw new Exception("Erro ao conectar ao banco de dados na classe VendaDAO: " + ex.getMessage());
        }
    }
    
    public Integer cadastrar(Venda venda){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idVenda = null;
        String sql = "INSERT INTO venda (data_venda, valor_venda, id_cliente) values (?,?,?) RETURNING id_venda;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(venda.getDataVenda().getTime()));
            stmt.setDouble(2, venda.getValorTotalVenda());
            stmt.setInt(3, venda.getCliente().getIdCliente());
            rs = stmt.executeQuery();
            
            if(rs.next()){
                idVenda = rs.getInt("id_venda");
            }
            
          } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar produto: " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar parâmetros da conexão! Erro: " + ex.getMessage());
            }
        }
            
        return idVenda;
    }

}
