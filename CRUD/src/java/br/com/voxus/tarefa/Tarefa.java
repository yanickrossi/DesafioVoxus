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
 * Classe Tarefa basiquinha
 */
public class Tarefa implements Serializable{
    private String nome;
    private String descricao;
    private int prioridade;   
    private Usuario usuario;
    
    public Tarefa(){
        nome = "";
        descricao = "";
        prioridade = 6;
        usuario = new Usuario(); 
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
