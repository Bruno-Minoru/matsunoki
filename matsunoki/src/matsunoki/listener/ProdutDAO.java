/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matsunoki.listener;

import java.sql.Connection;
import DAO.DBHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import matsunoki.Produto;

/**
 *
 * @author FATEC
 */
class ProdutDAO {

    void salvar(Produto produto){
        
        Connection conexao;
        try {
            conexao = DBHelper.getConnect();
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO produto(descricao, preco) VALUES (?,?)");
            PreparedStatement stmt = conexao.prepareStatement(sql.toString());
            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPreco());
            stmt.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
