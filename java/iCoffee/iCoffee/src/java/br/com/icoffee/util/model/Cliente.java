/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.icoffee.util.model;

import java.io.InputStream;
import java.sql.Date;

/**
 *
 * @author Franciele
 */
public class Cliente extends Pessoa {
    private int idCliente;
    private String dataNascimentoCliente;
    private InputStream fotoCliente;
    private int fileItem;
        
    public Cliente() {
    }

    public Cliente(int idCliente, String dataNascimentoCliente, InputStream fotoCliente, int fileItem) {
        this.idCliente = idCliente;
        this.dataNascimentoCliente = dataNascimentoCliente;
        this.fotoCliente = fotoCliente;
        this.fileItem = fileItem;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDataNascimentoCliente() {
        return dataNascimentoCliente;
    }

    public void setDataNascimentoCliente(String dataNascimentoCliente) {
        this.dataNascimentoCliente = dataNascimentoCliente;
    }

    public InputStream getFotoCliente() {
        return fotoCliente;
    }

    public void setFotoCliente(InputStream fotoCliente) {
        this.fotoCliente = fotoCliente;
    }

    public int getFileItem() {
        return fileItem;
    }

    public void setFileItem(int fileItem) {
        this.fileItem = fileItem;
    }




    
}
