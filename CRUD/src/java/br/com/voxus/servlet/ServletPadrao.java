package br.com.voxus.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.voxus.dao.TarefaDAO;
import br.com.voxus.tarefa.Tarefa;
import br.com.voxus.utill.DAOFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.List;

/**
 *
 * Primeiro servlet que crie, por isso deixei como ServletPadrao Serve para as
 * manipulações das tarefas
 *
 */
public class ServletPadrao extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //botoes para realizar ação
        String inserir = request.getParameter("inserirTarefa");
        String deletar = request.getParameter("deletarTarefa");
        String editar = request.getParameter("editarTarefa");
        String buscar = request.getParameter("buscarTarefa");
        String listar = request.getParameter("listarTarefa");

        //input de valor para realizar ação de deletar editar e buscar
        String acaoDeletar = request.getParameter("deletar");
        String nomeNovo = request.getParameter("nomeNovo");
        String acaoBuscar = request.getParameter("buscar");

        //input do nome da tarefa
        String nomeTarefa = request.getParameter("nome");
        String descricaoTarefa = request.getParameter("descricao");
        int prioridadeTarefa = Integer.parseInt(request.getParameter("prioridade"));
        String usuario = request.getParameter("usuario");

        String returnMsg = null;//msg para retornar quando finaliza uma ação

        //tarefa padrao para executar as ações
        TarefaDAO td = DAOFactory.createTarefaDAO();
        Tarefa tarefa = new Tarefa();

        if (inserir != null) { //se for o botao inserir
            System.out.println(inserir);
            tarefa.setNome(nomeTarefa);
            tarefa.setDescricao(descricaoTarefa);
            tarefa.setPrioridade(prioridadeTarefa);
            tarefa.getUsuario().setNome(usuario);
            tarefa.getUsuario().setSobreNome("Rossi");
            tarefa.getUsuario().setEmail("teste");
            tarefa.getUsuario().setId(004);
            td.inserir(tarefa);

            returnMsg = "Acao Inserir foi finalizada";
            request.setAttribute("returnMsg", returnMsg);
            request.getRequestDispatcher("ManipulaTarefa.jsp").forward(request, response);
        }
        if (deletar != null) {//se for o botao deletar
            System.out.println(deletar);
            String remover = acaoDeletar;
            td.remover(remover);

            returnMsg = "Acao Deletar foi finalizada";
            request.setAttribute("returnMsg", returnMsg);
            request.getRequestDispatcher("ManipulaTarefa.jsp").forward(request, response);

        }
        if (editar != null) {//se for o botao editar
            System.out.println(editar);
            String nomeEditar = nomeNovo;
            tarefa.setNome(nomeTarefa);
            tarefa.setDescricao(descricaoTarefa);
            tarefa.setPrioridade(5);
            tarefa.getUsuario().setNome(usuario);
            td.editar(nomeEditar, tarefa);

            returnMsg = "Acao Editar foi finalizada";
            request.setAttribute("returnMsg", returnMsg);
            request.getRequestDispatcher("ManipulaTarefa.jsp").forward(request, response);

        }
        if (buscar != null) { //se for o botao buscar
            System.out.println(buscar);
            tarefa = td.buscar(acaoBuscar);
            request.setAttribute("nome", tarefa.getNome());
            request.setAttribute("descricao", tarefa.getDescricao());
            request.setAttribute("prioridade", tarefa.getPrioridade());
            request.setAttribute("usuario", tarefa.getUsuario().getNome());

            returnMsg = "Acao Buscar foi finalizada";
            request.setAttribute("returnMsg", returnMsg);
            request.getRequestDispatcher("ExibeTarefa.jsp").forward(request, response);

        }
        if (listar != null) {// se for o botao listar(não ta habilitado no jsp)
            List<Tarefa> tarefas = td.listar();
            for (Tarefa tarefa1 : tarefas) {
                System.out.println("=======================================");
                System.out.println("Nome: " + tarefa1.getNome());
                System.out.println("Descricao: " + tarefa1.getDescricao());
                System.out.println("Prioridade: " + tarefa1.getPrioridade());
                System.out.println("Usuario:" + tarefa1.getUsuario().getNome());
                System.out.println("=======================================");

            }

        }

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
