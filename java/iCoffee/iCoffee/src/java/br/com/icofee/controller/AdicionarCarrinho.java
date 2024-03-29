/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.icofee.controller;

import br.com.icoffee.util.DAO.ProdutoDAO;
import br.com.icoffee.util.model.ItensVenda;
import br.com.icoffee.util.model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mariana
 */
@WebServlet(name = "AdicionarCarrinho", urlPatterns = {"/AdicionarCarrinho"})
public class AdicionarCarrinho extends HttpServlet {

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
            throws ServletException, IOException, Exception {
       HttpSession session = request.getSession(true);
        List <ItensVenda> carrinho = (List<ItensVenda>) session.getAttribute("carrinho");
        if(carrinho == null){
            carrinho = new ArrayList<>();
        }
        ItensVenda itensVenda = new ItensVenda();
        itensVenda.setProduto(new Produto(Integer.parseInt(request.getParameter("idproduto"))));
        itensVenda.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        itensVenda.setValorVendaProduto(new ProdutoDAO().carregarValorVendaProduto(Integer.parseInt(request.getParameter("idproduto"))));
        carrinho.add(itensVenda);
        System.out.println("Items:  " + carrinho.size());
        session.setAttribute("carrinho", carrinho);
        request.getRequestDispatcher("ListarProduto").forward(request, response);
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
        } catch (Exception ex) {
            Logger.getLogger(AdicionarCarrinho.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(AdicionarCarrinho.class.getName()).log(Level.SEVERE, null, ex);
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
