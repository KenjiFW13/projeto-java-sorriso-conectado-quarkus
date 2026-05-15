package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Dentista;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DentistaDao {

    public Connection minhaConexao;

    public DentistaDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Dentista dentista) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Insert Into T_TDB_DENTISTA values (?,?,?,?,?,?,?,?,?)");
        stmt.setInt(1, dentista.getIdDentista());
        stmt.setString(2, dentista.getNome());
        stmt.setString(3, dentista.getCpf());
        stmt.setDate(4, Date.valueOf(dentista.getDataNasc()));
        stmt.setString(5, dentista.getTelefone());
        stmt.setString(6, dentista.getEmail());
        stmt.setString(7, dentista.getEndereco());
        stmt.setString(8, dentista.getCro());
        stmt.setString(9, dentista.getEspecialidade());

        stmt.execute();
        stmt.close();

        return "Dentista Cadastrado com Sucesso!!!";
    }
}
