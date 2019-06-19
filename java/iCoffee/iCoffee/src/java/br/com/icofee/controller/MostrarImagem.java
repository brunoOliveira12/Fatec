/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.icofee.controller;

import br.com.icoffee.util.DAO.ProdutoDAO;
import br.com.icoffee.util.model.Produto;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mariana
 */
@WebServlet(name = "MostrarImagem", urlPatterns = {"/MostrarImagem"})
public class MostrarImagem extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final int BYTES_DOWNLOAD = 1024;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idProduto = Integer.parseInt(request.getParameter("idproduto"));

        try {
            ProdutoDAO dao = new ProdutoDAO();
            Produto produto = dao.getFoto(idProduto);

            InputStream inputstream = produto.getFotoProduto();
            OutputStream outputstream = response.getOutputStream();

            response.setHeader("Content-Disposition", "attachment; filename = " + produto.getNomeProduto() + ".jpg");

            int read = 0;
            final byte[] bytes = new byte[BYTES_DOWNLOAD];

            while ((read = inputstream.read(bytes)) != -1) {
                outputstream.write(bytes, 0, read);
                outputstream.flush();
            }
        } catch (Exception ex) {
            System.out.println("Problema ao carregar imagem do produto em MostrarImagem! Erro: " + ex.getMessage());
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