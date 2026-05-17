package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Voluntario;

import java.sql.*;
import java.util.ArrayList;

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

    // Deletar
    public String deletar(int codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From T_TDB_VOLUNTARIO where ID_VOLUNTARIO =?");
        stmt.setInt(1, codigo);

        stmt.execute();
        stmt.close();

        return "Voluntario Deletado com Sucesso!!!";
    }

    // UpDate
    public String atualizar(Voluntario voluntario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update T_TDB_VOLUNTARIO set NOME_VOLUNTARIO =?, CPF_VOLUNTARIO =?, NASC_VOLUNTARIO =?, FONE_VOLUNTARIO =?, EMAIL_VOLUNTARIO =?, END_VOLUNTARIO =?, AREA_VOLUNTARIO =? where ID_VOLUNTARIO =?");
        stmt.setString(1, voluntario.getNome());
        stmt.setString(2, voluntario.getCpf());
        stmt.setDate(3, Date.valueOf(voluntario.getDataNasc()));
        stmt.setString(4, voluntario.getTelefone());
        stmt.setString(5, voluntario.getEmail());
        stmt.setString(6, voluntario.getEndereco());
        stmt.setString(7, voluntario.getAreaDeAtuacao());
        stmt.setInt(8, voluntario.getIdVoluntario());

        stmt.executeUpdate();
        stmt.close();

        return "Voluntario Atualizado com Sucesso!!!";
    }

    // Select
    public ArrayList<Voluntario> selecionar() throws SQLException {
        ArrayList<Voluntario> listaVoluntario = new ArrayList<Voluntario>();
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_TDB_VOLUNTARIO");

        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Voluntario objVoluntario = new Voluntario();
            objVoluntario.setIdVoluntario(rs.getInt(1));
            objVoluntario.setNome(rs.getString(2));
            objVoluntario.setCpf(rs.getString(3));
            objVoluntario.setDataNasc(rs.getDate(4).toLocalDate());
            objVoluntario.setTelefone(rs.getString(5));
            objVoluntario.setEmail(rs.getString(6));
            objVoluntario.setEndereco(rs.getString(7));
            objVoluntario.setAreaDeAtuacao(rs.getString(8));

            listaVoluntario.add(objVoluntario);
        }
        return listaVoluntario;
    }

    // Select / Código
    public Voluntario selecionarPorCodigo(int codigo) throws SQLException {
        Voluntario objVoluntario = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_TDB_VOLUNTARIO where ID_VOLUNTARIO = ?");
        stmt.setInt(1, codigo);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            objVoluntario = new Voluntario();
            objVoluntario.setIdVoluntario(rs.getInt(1));
            objVoluntario.setNome(rs.getString(2));
            objVoluntario.setCpf(rs.getString(3));
            objVoluntario.setDataNasc(rs.getDate(4).toLocalDate());
            objVoluntario.setTelefone(rs.getString(5));
            objVoluntario.setEmail(rs.getString(6));
            objVoluntario.setEndereco(rs.getString(7));
            objVoluntario.setAreaDeAtuacao(rs.getString(8));
        }

        rs.close();
        stmt.close();

        return objVoluntario;
    }
}
