/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.icofee.controller;

import br.com.icoffee.util.DAO.GenericDAO;
import br.com.icoffee.util.DAO.ProdutoDAO;
import br.com.icoffee.util.model.Categoria;
import br.com.icoffee.util.model.Produto;
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

@WebServlet(name = "SalvarProduto", urlPatterns = {"/SalvarProduto"})
public class SalvarProduto extends HttpServlet {

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
        Produto produto = new Produto();
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);            
            upload.setSizeMax(50 * 1024 * 1024);
            List items = upload.parseRequest(request);
            Iterator it = items.iterator();
            InputStream is = null;

            while (it.hasNext()) {

                FileItem fileItem = (FileItem) it.next();

                if (!fileItem.isFormField()) {
                    is = fileItem.getInputStream();
                    produto.setFotoProduto(is);
                    produto.setFileItem((int) fileItem.getSize());
                } else {
                    String dados = fileItem.getFieldName();
                    if (dados.equals("nomeproduto")) {
                        produto.setNomeProduto(fileItem.getString());
                    } else if (dados.equals("quantidadeestoqueproduto")) {
                        produto.setQuantidadeEstoqueProduto(Integer.parseInt(fileItem.getString()));
                    } else if (dados.equals("valorcompraproduto")) {
                        produto.setValorCompraProduto(Double.parseDouble(fileItem.getString()));
                    } else if (dados.equals("valorvendaproduto")) {
                        produto.setValorVendaProduto(Double.parseDouble(fileItem.getString()));
                    } else if (dados.equals("idcategoria")) {
                        produto.setCategoria(new Categoria(Integer.parseInt(fileItem.getString())));
                    }
                }
            }            
        }

        String mensagem = null;

        try {

            GenericDAO dao = new ProdutoDAO();
            if (Integer.parseInt(request.getParameter("idproduto")) > 0) {
                dao.alterar(produto);
            } else {
                if (dao.cadastrar(produto)) {
                    mensagem = "Produto cadastrado com sucesso!";
                } else {
                    mensagem = "`Problemas ao cadastrar Produto!";
                }
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("DadosProduto").forward(request, response);

        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar produto! Erro: " + ex.getMessage());
            ex.printStackTrace();
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
            Logger.getLogger(SalvarProduto.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SalvarProduto.class.getName()).log(Level.SEVERE, null, ex);
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
