package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.FuncionarioTdb;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioTdbDao {

    public Connection minhaConexao;

    public FuncionarioTdbDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(FuncionarioTdb funcionarioTdb) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Insert Into T_TDB_FUNCIONARIOTDB values (?,?,?,?,?,?,?,?)");
        stmt.setInt(1, funcionarioTdb.getIdFuncionarioTdb());
        stmt.setString(2, funcionarioTdb.getNome());
        stmt.setString(3, funcionarioTdb.getCpf());
        stmt.setDate(4, Date.valueOf(funcionarioTdb.getDataNasc()));
        stmt.setString(5, funcionarioTdb.getTelefone());
        stmt.setString(6, funcionarioTdb.getEmail());
        stmt.setString(7, funcionarioTdb.getEndereco());
        stmt.setString(8, funcionarioTdb.getCargo());

        stmt.execute();
        stmt.close();

        return "Funcionário Cadastrado com Sucesso!!!";
    }
}

