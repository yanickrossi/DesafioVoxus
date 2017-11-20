/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.voxus.servlet;

import br.com.voxus.dao.TarefaDAO;
import br.com.voxus.utill.DAOFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yanick
 * 
 * servlet que comunica com a Autenticação de login do usuario
 */
public class Autenticacao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String erroMsg = null;//mensagem padrão de erro
        TarefaDAO td = DAOFactory.createTarefaDAO();
        int valida = td.AutenticarUsuario(email, senha);//chama o método para autenticar email e senha
        
        if (valida == 1) {
            request.setAttribute("user", email);
            //retorna a pagina para manipular as tarefas
            request.getRequestDispatcher("ManipulaTarefa.jsp").forward(request, response);
        } else if (valida == 0) {
            erroMsg = "Email ou senha não foi autenticado, tente novamente! ";
            request.setAttribute("erroMsg", erroMsg);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        } else {
            erroMsg = "Erro desconhecido ao efetuar login, tente novamente! ";
            request.setAttribute("erroMsg", erroMsg);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
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
