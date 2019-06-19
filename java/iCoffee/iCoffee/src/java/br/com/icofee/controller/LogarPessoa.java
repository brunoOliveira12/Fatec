package br.com.icofee.controller;

import br.com.icoffee.util.DAO.ClienteDAO;
import br.com.icoffee.util.DAO.GenericDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.icoffee.util.DAO.PessoaDAO;
import br.com.icoffee.util.model.Cliente;
import br.com.icoffee.util.model.Pessoa;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bruno
 */
@WebServlet(name = "LogarPessoa", urlPatterns = {"/LogarPessoa"})
public class LogarPessoa extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if (request.getParameter("acao").equals("logar")) {

            if (!request.getParameter("emailpessoa").equals("") && !request.getParameter("senhapessoa").equals("")) {

                try {
                    PessoaDAO dao = new PessoaDAO();
                    Pessoa pessoa = dao.logarPessoa(request.getParameter("emailpessoa"), request.getParameter("senhapessoa"));

                    if (pessoa != null) {
                        HttpSession session = request.getSession(true);
                        session.setAttribute("pessoa", pessoa);
                        session.setAttribute("mensagem", "Seja bem-vindo Sr(a). " + pessoa.getNomePessoa() + "!");

                        if (pessoa.getTipoPessoa().equalsIgnoreCase("F")) {
                            request.getRequestDispatcher("Funcionario/index.jsp").forward(request, response);
                        } else if (pessoa.getTipoPessoa().equalsIgnoreCase("c")) {
                            
                            try{
                                
                                GenericDAO daoCliente = new ClienteDAO();
                                session.setAttribute("cliente", (Cliente) daoCliente.carregar(pessoa.getIdPessoa()));
                                request.getRequestDispatcher("ListarProduto").forward(request, response);
                                
                            } catch(Exception ex){
                                System.out.println("Problemas ao carregar cliente! Erro: " + ex.getMessage());
                                ex.printStackTrace();
                            }                                                        
                        } else {
                            response.sendRedirect("index.jsp");
                        }
                    } else {
                        erroLogar(request, response);
                    }

                } catch (Exception ex) {
                    System.out.println("Problemas ao logar Pessoa! Erro: " + ex.getMessage());
                    ex.printStackTrace();
                }

            } else {
                erroLogar(request, response);
            }

        } else if (request.getParameter("acao").equals("logout")) {
            HttpSession session = request.getSession(true);
            session.invalidate();
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
    
    public void erroLogar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("erro", "Usuario/Senha invalidos!");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
