
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    public static Connection getConnect() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        Connection Conexao=DriverManager.getConnection("jdbc:postgresql://localhost:5432/matsunoki","postgres","123Fatec");
        
        return Conexao;
    }
}
