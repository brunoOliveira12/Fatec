package br.com.icoffee.util.model;

import java.io.InputStream;

public class Produto {
    private int idProduto;
    private String nomeProduto;
    private double valorCompraProduto;
    private double valorVendaProduto;
    private int quantidadeEstoqueProduto;
    private Categoria categoria;
    private InputStream fotoProduto;
    private int fileItem;

    public Produto(int idProduto) {
        this.idProduto = idProduto;
    }

    public Produto() {
    }

    
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorCompraProduto() {
        return valorCompraProduto;
    }

    public void setValorCompraProduto(double valorCompraProduto) {
        this.valorCompraProduto = valorCompraProduto;
    }

    public double getValorVendaProduto() {
        return valorVendaProduto;
    }

    public void setValorVendaProduto(double valorVendaProduto) {
        this.valorVendaProduto = valorVendaProduto;
    }

    public int getQuantidadeEstoqueProduto() {
        return quantidadeEstoqueProduto;
    }

    public void setQuantidadeEstoqueProduto(int quantidadeEstoqueProduto) {
        this.quantidadeEstoqueProduto = quantidadeEstoqueProduto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public InputStream getFotoProduto() {
        return fotoProduto;
    }

    public void setFotoProduto(InputStream fotoProduto) {
        this.fotoProduto = fotoProduto;
    }

    public int getFileItem() {
        return fileItem;
    }

    public void setFileItem(int fileItem) {
        this.fileItem = fileItem;
    }
}
