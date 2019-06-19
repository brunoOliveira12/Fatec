/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.icoffee.util.model;

/**
 *
 * @author Franciele
 */
public class Funcionario extends Pessoa {
    private int idFuncionario;
    private Double salarioFuncionario;
    private String curriculoFuncionario;

    public Funcionario() {
    }   
    
    public Funcionario(int idFuncionario, Double salarioFuncionario, String curriculoFuncionario) {
        this.idFuncionario = idFuncionario;
        this.salarioFuncionario = salarioFuncionario;
        this.curriculoFuncionario = curriculoFuncionario;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Double getSalarioFuncionario() {
        return salarioFuncionario;
    }

    public void setSalarioFuncionario(Double salarioFuncionario) {
        this.salarioFuncionario = salarioFuncionario;
    }

    public String getCurriculoFuncionario() {
        return curriculoFuncionario;
    }

    public void setCurriculoFuncionario(String curriculoFuncionario) {
        this.curriculoFuncionario = curriculoFuncionario;
    }



   
    
}
