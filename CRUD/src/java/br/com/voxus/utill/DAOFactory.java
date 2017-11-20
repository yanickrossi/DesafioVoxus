/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.voxus.utill;

import br.com.voxus.dao.JDBCTarefaDAO;
import br.com.voxus.dao.TarefaDAO;

/**
 *
 * @author Yanick
 */
public class DAOFactory {
    public static TarefaDAO createTarefaDAO(){
        return new JDBCTarefaDAO();
    }
}
