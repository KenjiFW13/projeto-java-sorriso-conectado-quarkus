package br.com.fiap.conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    public Connection conexao() throws ClassNotFoundException, SQLException {
    // Método de conexão

        Class.forName("oracle.jdbc.driver.OracleDriver");
        // Driver Oracle

        return DriverManager.getConnection("oracle data base", "user", "password");
        // Retornar conexão
    }
}
