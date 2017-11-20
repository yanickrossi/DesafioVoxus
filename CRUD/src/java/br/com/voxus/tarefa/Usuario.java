/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.voxus.tarefa;

import java.io.Serializable;

/**
 *
 * @author Yanick
 * 
 * Classe usuário Padraozinha
 */
public class Usuario implements Serializable {

    private String nome;
    private String sobreNome;
    private String Email;
    private int Id;//não estou usando o ID 

    public Usuario() {
        nome = "";
        sobreNome = "";
        Email = "";
        Id = -1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

}
