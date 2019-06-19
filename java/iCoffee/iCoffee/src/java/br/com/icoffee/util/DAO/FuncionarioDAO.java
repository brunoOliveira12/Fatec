package br.com.icoffee.util.DAO;

import br.com.icoffee.util.ConnectionFactory;
import br.com.icoffee.util.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO implements GenericDAO {

    private Connection conn;

    public FuncionarioDAO() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        Funcionario funcionario = (Funcionario) object;
        PreparedStatement stmt = null;
        String sql = "Insert into funcionario(salario_funcionario, curriculo_funcionario,id_pessoa) values(?,?,?);";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, funcionario.getSalarioFuncionario());
            stmt.setString(2, funcionario.getCurriculoFuncionario());
            stmt.setInt(3, new PessoaDAO().cadastrar(funcionario));
            stmt.executeQuery();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Funcionario!Erro:" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            }catch(Exception ex) {
                              
                    
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
        String sql="select p.*, f.* from pessoa p, funcionario f where p.id_pessoa = f.id_pessoa order by p.nome_pessoa;";
        try{
            stmt=conn.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setIdPessoa(rs.getInt("id_pessoa"));
                funcionario.setNomePessoa(rs.getString("nome_pessoa"));
                funcionario.setEmailPessoa(rs.getString("email_pessoa"));
                funcionario.setSenhaPessoa(rs.getString("senha_pessoa"));
                funcionario.setTipoPessoa(rs.getString("tipo_pessoa"));
                funcionario.setSalarioFuncionario(rs.getDouble("salario_funcionario"));
//                funcionario.setSalarioFuncionario(Double.NEGATIVE_INFINITY);;
                resultado.add(funcionario);
            }
        }catch (SQLException ex){
            System.out.println("Problemas ao listar Funcion·rio! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }finally{
        try{
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }catch (Exception ex){
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
