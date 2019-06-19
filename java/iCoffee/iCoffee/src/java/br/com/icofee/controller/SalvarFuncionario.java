package br.com.icofee.controller;

import br.com.icoffee.util.DAO.FuncionarioDAO;
import br.com.icoffee.util.DAO.GenericDAO;
import br.com.icoffee.util.model.Funcionario;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Franciele
 */
@WebServlet(name = "SalvarFuncionario", urlPatterns = {"/SalvarFuncionario"})
public class SalvarFuncionario extends HttpServlet {

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
                Funcionario funcionario = new Funcionario();
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        String caminhoImagem = null;
        if (isMultipart) {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            upload.setSizeMax(50 * 1024 * 1024);

            List items = upload.parseRequest(request);

            
            Iterator it = items.iterator();

            while (it.hasNext()) {

                FileItem fileItem = (FileItem) it.next();

                if (!fileItem.isFormField()) {
                    try{
                    fileItem.write(new File("C:\\Users\\Mariana\\Documents\\NetBeansProjects\\iCoffee\\web\\Curriculos/" + (new File(fileItem.getName()).getName())));
                }catch(Exception ex){
                        System.out.println("Problemas ao criar arquivo no servidor!Erro:"+ ex.getMessage());
                        ex.printStackTrace();
                        }
                caminhoImagem = "C:\\Users\\Mariana\\Documents\\NetBeansProjects\\iCoffee\\web\\Curriculos/" + fileItem.getName();
            }else {
                    String dados = fileItem.getFieldName();
                    if (dados.equals("nomepessoa")) {
                        funcionario.setNomePessoa(fileItem.getString());
                    } else if (dados.equals("emailpessoa")) {
                        funcionario.setEmailPessoa(fileItem.getString());
                        } else if (dados.equals("senhapessoa")) {
                        funcionario.setSenhaPessoa(fileItem.getString());
                       } else if (dados.equals("salariopessoa")) {
                        funcionario.setSalarioFuncionario(Double.parseDouble(fileItem.getString()));
                 
                }
                }

        }
            

        String mensagem = null;
        funcionario.setTipoPessoa("F");
        funcionario.setCurriculoFuncionario(caminhoImagem);

        try {
            GenericDAO dao = new FuncionarioDAO();
            if (dao.cadastrar(funcionario)) {
                mensagem = "Funcionario cadastrado com sucesso!";
            } else {
                mensagem = "Problema ao cadastrar Funcionario!";
            }

            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("Funcionario/salvar.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao Cadastrar Funcionário! Erro: " + ex.getMessage());
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
            Logger.getLogger(SalvarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SalvarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
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
