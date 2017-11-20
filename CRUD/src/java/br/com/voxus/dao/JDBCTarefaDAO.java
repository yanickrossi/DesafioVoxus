/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.voxus.dao;

import br.com.voxus.tarefa.Tarefa;
import br.com.voxus.tarefa.Usuario;
import br.com.voxus.utill.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yanick
 *
 * Arquivo com as implementaçoes das consultas para interagir com o Banco MySQL
 *Try catchs inseridos em todos os métodos para tratar eventuais erros
 */
public class JDBCTarefaDAO implements TarefaDAO {

    Connection connection;

    public JDBCTarefaDAO() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void inserir(Tarefa tarefa) {
//          Função para inserir uma nova tarefa no banco de dados
//          Não verifica se a tarefa ja existe, porém, captura exceção caso ja exista
//          Pois a chave primária está sendo o nome da tarega, então não é permitido duplicação de tarefas
        try {
            String SQL = "INSERT INTO tarefa (nome,descricao,prioridade,usuario) VALUES"
                    + "(?,?,?,?)";
//          Cria a query SQL para realizar a inserção
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, tarefa.getNome());
            ps.setString(2, tarefa.getDescricao());
            ps.setInt(3, tarefa.getPrioridade());
            ps.setObject(4, tarefa.getUsuario().getNome());
            ps.executeUpdate();

            ps.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(JDBCTarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao Inserir Tarefa"  +  tarefa.getNome() + " em JDBCTarefaDAO", ex);

        }
    }

    @Override
    public void remover(String nome) {

        try {
            String SQL = "DELETE FROM tarefa where nome = " + "(?)";
//            Query criada para deletar um registro da tabela tarefa
//            A busca é feita pela chave primária nome, então apenas um row vai ser afetada
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, nome);
            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao REMOVER Tarefa" + nome + " em JDBCTarefaDAO", ex);
        }
    }

    @Override
    public List<Tarefa> listar() {
        List<Tarefa> tarefas = new ArrayList<Tarefa>();
        String SQL = "Select * FROM tarefa";
//        Query para que serve para lostar as tarefas -- Funcionalidade implementada mas não está na aplicação
        try {
            PreparedStatement ps = connection.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setNome(rs.getString("nome"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setPrioridade(rs.getInt("prioridade"));
                tarefa.getUsuario().setNome(rs.getString("usuario"));
                tarefas.add(tarefa);

            }
            ps.close();
            rs.close();
            connection.close();

            return tarefas;

        } catch (SQLException ex) {
            Logger.getLogger(JDBCTarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao listar Tarefas em JDBCTarefaDAO", ex);
        }

    }

    @Override
    public Tarefa buscar(String nome) {
        Tarefa tarefa = new Tarefa();
        try {
            String SQL = "SELECT * FROM tarefa WHERE nome = ?";
//            Query feita para buscar determinada tarefa pelo nome(PK)
            
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            rs.next();
            tarefa.setNome(rs.getString("nome"));
            tarefa.setDescricao(rs.getString("descricao"));
            tarefa.setPrioridade(rs.getInt("prioridade"));
            tarefa.getUsuario().setNome(rs.getString("usuario"));
            connection.close();
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao buscar Registro de tarefa " + tarefa.getNome() + " em JDBCTarefaDAO", ex);
        }

        return tarefa;

    }

    @Override
    public void editar(String nome, Tarefa tarefa
    ) {

        String SQL = "UPDATE tarefa"
                + " SET "
                + "nome = (?), descricao = (?), prioridade = (?), usuario = (?) "
                + "WHERE nome = (?)";
//          Query feita para editar uma tarefa, substituindo todos os campos da anterior pelos campos novos inderidos
        try {
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, nome);//T11
            ps.setString(2, tarefa.getDescricao());
            ps.setInt(3, tarefa.getPrioridade());
            ps.setObject(4, tarefa.getUsuario().getNome());
            ps.setObject(5, tarefa.getNome());//T10
            ps.executeUpdate();
            connection.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Falha ao Editar Tarefa" + tarefa.getNome() + " em JDBCTarefaDAO", ex);
        }

    }

    @Override
    public int cadastrarUsuario(Usuario usuario, String senha) {
//      Método utilizado para o usuário se cadastrar, caso não possua um cadastro
//      A chave primária da tabela validacao é o email inserido
//      O mesmo email não pode ser cadastrado mais de uma vez
        
        try {
            String SQL = "select email from validacao WHERE email = (?)";
//            Query preparada para verificar se o email informado ja existe
            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setString(1, usuario.getEmail());
            ResultSet rs = ps.executeQuery();

            String validaEmail = null;

            if (rs.next()) {

                validaEmail = rs.getString("email");
            }

            if (validaEmail != null && validaEmail.equals(usuario.getEmail())) {
                return -1;//cadastro não realizado
            } else {
                try {
                    
                    String SQL1 = "INSERT INTO validacao (email,senha) VALUES"
                            + "(?,?)";
//                    Query preparada para inserir um novo email
                    PreparedStatement ps1 = connection.prepareStatement(SQL1);
                    ps1.setString(1, usuario.getEmail());
                    ps1.setString(2, senha);

                    ps1.executeUpdate();

                    ps1.close();
                    connection.close();
                    rs.close();
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCTarefaDAO.class.getName()).log(Level.SEVERE, null, ex);
                    throw new RuntimeException("Erro ao cadastrar usuario " + usuario.getNome() + " em JDBCTarefaDAO", ex);
                }

            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao Buscar o usuario para validar cadastro " + usuario.getNome() + " em JDBCTarefaDAO", ex);

        }

        return 0;
    }

    @Override
    public int AutenticarUsuario(String email, String senha) {
//        Método criado para autenticar o login do usuário
        
        String SQL = "select count(*) as x from validacao WHERE email = (?) and senha = (?)";
//      Query criada afim de verificar se existe o email cadastrado
//        caso a contagem seja 1, é porque existe um registro com a senha e com o email passado
//         Se o resultado da query for ZERO, Alguma coisa não bate      
        try {
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            int autentica = 0;

            if (rs.next()) {
                connection.close();
                rs.close();
                ps.close();
                //caso de certo a autenticação, vai retornar 1 e é tratado no servlet Autenticacao.java
                return autentica = rs.getInt(1);

            } else {
                connection.close();
                rs.close();
                ps.close();
                return 0;
            }

//      int prioridadeTarefa = Integer.parseInt(request.getParameter("prioridade"));
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao efetuar login ocm email: " + email + " em JDBCTarefaDAO", ex);

        }
    }

}
