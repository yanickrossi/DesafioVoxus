/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.voxus.servlet;

import br.com.voxus.dao.TarefaDAO;
import br.com.voxus.tarefa.Usuario;
import br.com.voxus.utill.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yanick
 * Servlet para fazer o cadastro do usuário
 */
public class Cadastrar extends HttpServlet {

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

        String nome = request.getParameter("nome");
        String sobreNome = request.getParameter("sobreNome");
        String email = request.getParameter("email");
        String senha1 = request.getParameter("senha1");
        String senha2 = request.getParameter("senha2");
        
        TarefaDAO td = DAOFactory.createTarefaDAO();
        String erroMsg = null;
        
        //para conferir se a senha tem pelo menos 4 caracteres
        if(senha1.length() < 4){
            erroMsg = "Senha muito curta";
            request.setAttribute("erroMsg", erroMsg);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }else if (senha1.equals(senha2) && senha1.length() > 3 ) {
            //confere se as duas senhas são iguais
            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setNome(nome);
            usuario.setSobreNome(sobreNome);
            int valida = td.cadastrarUsuario(usuario, senha1);
            //verifica o retorno da tentativa de cadastro
            if (valida == -1) {
                erroMsg = "Email já cadastrado";
                request.setAttribute("erroMsg", erroMsg);
                request.getRequestDispatcher("Error.jsp").forward(request, response);
            }
            //cadastro foi realizado
            request.setAttribute("user", email);
            request.getRequestDispatcher("ManipulaTarefa.jsp").forward(request,response);
        } else {
            request.setAttribute("email", email);
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
