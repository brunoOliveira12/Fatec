/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.icofee.controller;

import br.com.icoffee.util.DAO.GenericDAO;
import br.com.icoffee.util.DAO.ItensVendaDAO;
import br.com.icoffee.util.DAO.VendaDAO;
import br.com.icoffee.util.model.Cliente;
import br.com.icoffee.util.model.ItensVenda;
import br.com.icoffee.util.model.Venda;
import java.io.IOException;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "SalvarCarrinho", urlPatterns = {"/SalvarCarrinho"})
public class SalvarCarrinho extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        List<ItensVenda> carrinho = (List<ItensVenda>) session.getAttribute("carrinho");
        Double valorTotalVenda = 0.0;
        for (int i = 0; i < carrinho.size(); i++) {
            ItensVenda itensVenda = carrinho.get(i);
            valorTotalVenda = valorTotalVenda + (itensVenda.getQuantidade() * itensVenda.getValorVendaProduto());
            
        }
        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setDataVenda(new Date());
        venda.setValorTotalVenda(valorTotalVenda);

        try {
            VendaDAO vendaDAO = new VendaDAO();
            Integer idVenda = vendaDAO.cadastrar(venda);
            if (idVenda != null && idVenda > 0) {
                GenericDAO ivDAO = null;
                for (int i = 0; i < carrinho.size(); i++) {
                    ivDAO = new ItensVendaDAO();
                    ItensVenda itensVenda = carrinho.get(i);
                    itensVenda.setVenda(new Venda(idVenda));
                    if (ivDAO.cadastrar(itensVenda)) {
                        mensagem = "Venda cadastrada com sucesso!";
                    } else {
                        mensagem = "Problemas ao cadastrar venda!";
                    }
//            
                }
            }
        } catch (Exception ex) {
            mensagem = "Problemas ao cadastrar venda!";
            System.out.println("Erro ao gravar venda ");
            ex.printStackTrace();
        }
        
        request.setAttribute("mensagem", mensagem);
        request.getRequestDispatcher("Cliente/sucessovenda.jsp").forward(request, response);

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
