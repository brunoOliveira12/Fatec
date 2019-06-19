package br.com.icoffee.util.DAO;

import br.com.icoffee.util.ConnectionFactory;
import br.com.icoffee.util.model.Funcionario;
import br.com.icoffee.util.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    
     private Connection conn;

    public PessoaDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    public Integer cadastrar(Pessoa pessoa) throws Exception{
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idPessoa = null;
        String sql="Insert into pessoa (nome_pessoa, email_pessoa, senha_pessoa, tipo_pessoa)values(?,?,md5(?),?) returning id_pessoa;";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getEmailPessoa());
            stmt.setString(3, pessoa.getSenhaPessoa());
            stmt.setString(4, pessoa.getTipoPessoa());
            rs=stmt.executeQuery();
            if(rs.next()){
                idPessoa=rs.getInt("id_pessoa");
            }
            }catch(SQLException ex){
                System.out.println("Problemas ao cadastrar Pessoa!Erro:"+ex.getMessage());
                ConnectionFactory.closeConnection(conn,stmt,rs);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar conexao!Erro:"+ex.getMessage());
                ex.printStackTrace();
        }
    
    return idPessoa;
            }
    
     public Pessoa logarPessoa(String email, String senha) {

        Pessoa pessoa = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT id_pessoa, nome_pessoa, tipo_pessoa "
                + "FROM pessoa WHERE email_pessoa = ? and senha_pessoa = md5(?);";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                pessoa = new Pessoa() {};
                pessoa.setIdPessoa(rs.getInt("id_pessoa"));
                pessoa.setNomePessoa(rs.getString("nome_pessoa"));
                pessoa.setTipoPessoa(rs.getString("tipo_pessoa"));
            }

        } catch (SQLException ex) {
            System.out.println("Problemas ao logar pessoa! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conex?o! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        
        return pessoa;
    }
}
    

