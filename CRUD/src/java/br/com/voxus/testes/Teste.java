/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package br.com.voxus.testes;

import br.com.voxus.dao.TarefaDAO;
import br.com.voxus.tarefa.Tarefa;
import br.com.voxus.utill.ConnectionFactory;
import br.com.voxus.utill.DAOFactory;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Yanick
 * utilizei esse .java main para rodar alguns testes no início da construção da aplicação 
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        try {
//            ConnectionFactory.getConnection();
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//            JOptionPane.showMessageDialog(null, ex.getCause());
//        }

//        Inserir   Inserir   Inserir   Inserir   Inserir   
//        Tarefa tarefa = new Tarefa();
//        tarefa.setNome("T4");
//        tarefa.setDescricao("Adicionar novos métodos");
//        tarefa.setPrioridade(2);
//        tarefa.getUsuario().setNome("Tateco");
//        tarefa.getUsuario().setSobreNome("Rossi");
//        tarefa.getUsuario().setEmail("tateco@hotmail.com");
//        tarefa.getUsuario().setId(004);
//        
//        TarefaDAO td = DAOFactory.createTarefaDAO();
//        td.inserir(tarefa);
//       
//       
//        Listar   Listar   Listar   Listar   Listar   Listar   Listar   Listar   
//        TarefaDAO td = DAOFactory.createTarefaDAO();
//        List<Tarefa> tarefas = td.listar();
//        for (Tarefa tarefa : tarefas) {
//            System.out.println("=======================================");
//            System.out.println("Nome: " + tarefa.getNome());
//            System.out.println("Descricao: " + tarefa.getDescricao());
//            System.out.println("Prioridade: " + tarefa.getPrioridade());
//            System.out.println("Usuario:" + tarefa.getUsuario().getNome());
//            System.out.println("=======================================");
//        }
//
//
//        Remover   Remover   Remover   Remover   Remover   Remover   
//        String remover = "T1";
//        TarefaDAO td = DAOFactory.createTarefaDAO();
//        td.remover(remover);
//        
//        Editar  Editar  Editar  Editar  Editar  Editar  Editar  Editar  
//        public void editar(Tarefa tarefa);
//        Tarefa tarefa = new Tarefa();
//        String nomeEditar = "T2";
//        tarefa.setNome("T01");
//        tarefa.setDescricao("Nova descricao T01");
//        tarefa.setPrioridade(5);
//        tarefa.getUsuario().setNome("NewName");
//        
//        TarefaDAO td = DAOFactory.createTarefaDAO();
//        td.editar(nomeEditar, tarefa);
//        Buscar      Buscar      Buscar      Buscar      Buscar      Buscar      Buscar      Buscar      
        String buscar = "T3";
        TarefaDAO td = DAOFactory.createTarefaDAO();
        Tarefa tarefa = new Tarefa();
        tarefa = td.buscar(buscar);
        System.out.println("Nome: " + tarefa.getNome());
        System.out.println("Descricao: " + tarefa.getDescricao());
        System.out.println("Prioridade: " + tarefa.getPrioridade());
        System.out.println("Usuario:" + tarefa.getUsuario().getNome());

//    public Tarefa buscar(String nome);
    }

}
