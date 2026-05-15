package br.com.fiap.main;

import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    // Chamando método para conexão com o banco de dados
    static void main() throws SQLException, ClassNotFoundException {
        Connection cn = new ConexaoFactory().conexao();

        System.out.println("Conectado com o banco de dados");

        cn.close();
    }
}
