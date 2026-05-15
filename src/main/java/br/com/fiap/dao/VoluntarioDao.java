package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Voluntario;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VoluntarioDao {

    public Connection minhaConexao;

    public VoluntarioDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Voluntario voluntario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO T_TDB_VOLUNTARIO VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setInt(1, voluntario.getIdVoluntario());
        stmt.setString(2, voluntario.getNome());
        stmt.setString(3, voluntario.getCpf());
        stmt.setDate(4, Date.valueOf(voluntario.getDataNasc()));
        stmt.setString(5, voluntario.getTelefone());
        stmt.setString(6, voluntario.getEmail());
        stmt.setString(7, voluntario.getEndereco());
        stmt.setString(8, voluntario.getAreaDeAtuacao());

        stmt.execute();
        stmt.close();

        return "Voluntario Cadastrado com sucesso!";
    }
}
