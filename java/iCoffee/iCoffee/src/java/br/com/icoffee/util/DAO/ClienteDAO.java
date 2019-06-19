package br.com.icoffee.util.DAO;

import br.com.icoffee.util.ConnectionFactory;
import br.com.icoffee.util.model.Cliente;
import br.com.icoffee.util.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements GenericDAO {

    private Connection conn;

    public ClienteDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Cliente cliente = (Cliente) object;
        PreparedStatement stmt = null;
        String sql = "Insert into cliente(data_nascimento , foto_cliente,id_pessoa) values(?,?,?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getDataNascimentoCliente());
            stmt.setBinaryStream(2, cliente.getFotoCliente(), cliente.getFileItem());
            stmt.setInt(3, new PessoaDAO().cadastrar(cliente));
            stmt.executeQuery();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Cliente!Erro:" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {

                System.out.println("Problemas ao fechar conex√o!Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.*, c.* from pessoa p, cliente c where p.id_pessoa = c.id_pessoa order by p.nome_pessoa;";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdPessoa(rs.getInt("id_pessoa"));
                cliente.setNomePessoa(rs.getString("nome_pessoa"));
                cliente.setEmailPessoa(rs.getString("email_pessoa"));
                cliente.setSenhaPessoa(rs.getString("senha_pessoa"));
                cliente.setTipoPessoa(rs.getString("tipo_pessoa"));
                cliente.setDataNascimentoCliente(rs.getString("datanascimentocliente"));
//                funcionario.setSalarioFuncionario(Double.NEGATIVE_INFINITY);;
                resultado.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Cliente****! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conex„o! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return resultado;
    }

    @Override
    public void excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int idObject) {

        Cliente cliente = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select p.*, c.* from pessoa p, cliente c where p.id_pessoa = c.id_pessoa and p.id_pessoa = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setIdPessoa(rs.getInt("id_pessoa"));
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNomePessoa(rs.getString("nome_pessoa"));
                cliente.setEmailPessoa(rs.getString("email_pessoa"));
                cliente.setSenhaPessoa(rs.getString("senha_pessoa"));
                cliente.setTipoPessoa(rs.getString("tipo_pessoa"));
                cliente.setDataNascimentoCliente(rs.getString("datanascimentocliente"));
//                funcionario.setSalarioFuncionario(Double.NEGATIVE_INFINITY);;                
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Cliente****! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conex„o! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return cliente;

    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
