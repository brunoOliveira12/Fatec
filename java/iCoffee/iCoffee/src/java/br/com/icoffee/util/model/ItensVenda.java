/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.icoffee.util.model;

/**
 *
 * @author Mariana
 */
public class ItensVenda {
   private Venda venda;
    private Produto produto;
    private int quantidade;
    private Double valorVendaProduto;

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorVendaProduto() {
        return valorVendaProduto;
    }

    public void setValorVendaProduto(Double valorVendaProduto) {
        this.valorVendaProduto = valorVendaProduto;
    }
    
}
