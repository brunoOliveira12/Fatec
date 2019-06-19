/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.icofee.controller;

import br.com.icoffee.util.DAO.CategoriaDAO;
import br.com.icoffee.util.DAO.GenericDAO;
import br.com.icoffee.util.model.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Franciele
 */
public class SalvarCategoria extends HttpServlet {

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
        String mensagem = null;
        Categoria categoria = new Categoria();
        categoria.setNomeCategoria(request.getParameter("nomecategoria"));
        categoria.setDescricaoCategoria(request.getParameter("descricaocategoria"));
        System.out.println(request.getParameter("idcategoria"));
        
        try {
            GenericDAO dao = new CategoriaDAO();
            if (request.getParameter("idcategoria").equals("")) {
                if (dao.cadastrar(categoria)) {
                    mensagem = "Categoria cadastrada com sucesso!";
                } else {
                    mensagem = "Problemas ao cadastrar Categoria";
                }
            } else {
                categoria.setIdCategoria(Integer.parseInt(request.getParameter("idcategoria")));
                if(dao.alterar(categoria)){
                    mensagem = "Categoria alterada com sucesso!";
                }else{
                    mensagem = "Problemas ao alterar Categoria!";
                }

            }
            request.setAttribute(mensagem, mensagem);
            request.getRequestDispatcher("Categoria/salvar.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar Categoria! Erro: " + ex.getMessage());
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
