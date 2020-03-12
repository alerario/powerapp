/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author alexandrelerario
 */
@Named(value = "jsfCidade")
@SessionScoped
public class JsfCidade implements Serializable {

    /**
     * Creates a new instance of JsfCidade
     */
    public JsfCidade() {
    }
    
    private int codigo;
    private String nome;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void persist(){
        com.data.entity.Cidade cid = new com.data.entity.Cidade();
        cid.setCodigo(codigo);
        cid.setNome(nome);
        new com.data.crud.CrudCidade().persist(cid);
    }
    
    public java.util.Collection<com.data.entity.Cidade> getAll(){
        return new com.data.crud.CrudCidade().getAll();
    }
}
