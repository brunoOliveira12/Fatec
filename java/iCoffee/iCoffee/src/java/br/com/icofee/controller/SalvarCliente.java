package br.com.icofee.controller;

import br.com.icoffee.util.DAO.ClienteDAO;
import br.com.icoffee.util.DAO.FuncionarioDAO;
import br.com.icoffee.util.DAO.GenericDAO;
import br.com.icoffee.util.model.Cliente;
import br.com.icoffee.util.model.Funcionario;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Mariana
 */
@WebServlet(name = "SalvarCliente", urlPatterns = {"/SalvarCliente"})
public class SalvarCliente extends HttpServlet {

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
            throws ServletException, IOException, FileUploadException {
        Cliente cliente = new Cliente();
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            upload.setSizeMax(50 * 1024 * 1024);
            List items = upload.parseRequest(request);            
            Iterator it = items.iterator();
            InputStream is=null;

            while (it.hasNext()) {
                FileItem fileItem = (FileItem) it.next();
                if (!fileItem.isFormField()) {
                    is = fileItem.getInputStream();
                   cliente.setFotoCliente(is);
                   cliente.setFileItem((int) fileItem.getSize());
                }else {
                    String dados = fileItem.getFieldName();
                    if (dados.equals("nomepessoa")) {
                        cliente.setNomePessoa(fileItem.getString());
                    } else if (dados.equals("emailpessoa")) {
                        cliente.setEmailPessoa(fileItem.getString());
                        } else if (dados.equals("senhapessoa")) {
                        cliente.setSenhaPessoa(fileItem.getString());
                       } else if (dados.equals("datanascimentocliente")) {
                        cliente.setDataNascimentoCliente(fileItem.getString());                 
                    }
                }
        }
            
        String mensagem = null;
        cliente.setTipoPessoa("C");

        try {
            GenericDAO dao = new ClienteDAO();
            if (dao.cadastrar(cliente)) {
                mensagem = "Cliente cadastrado com sucesso!";
            } else {
                mensagem = "Problema ao cadastrar Cliente!";
            }

            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("Cliente/salvar.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao Cadastrar Cliente! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
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
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(SalvarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(SalvarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
