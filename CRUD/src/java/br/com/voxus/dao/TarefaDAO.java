 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.voxus.dao;

import br.com.voxus.tarefa.Tarefa;
import br.com.voxus.tarefa.Usuario;
import java.util.List;

/**
 *
 * @author Yanick
 */
public interface TarefaDAO {

    public void inserir(Tarefa tarefa);

    public void remover(String nome);

    public List<Tarefa> listar();

    public Tarefa buscar(String nome);

    public void editar(String nome, Tarefa tarefa);
    
    public int cadastrarUsuario(Usuario usuario, String senha);
    
    public int AutenticarUsuario(String email, String senha);
}

