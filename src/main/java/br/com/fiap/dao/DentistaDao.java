package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Dentista;

import java.sql.*;
import java.util.ArrayList;

public class DentistaDao {

    public Connection minhaConexao;

    public DentistaDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Inserir
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

    // Deletar
    public String deletar(int codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From T_TDB_DENTISTA where ID_DENTISTA =?");
        stmt.setInt(1, codigo);

        stmt.execute();
        stmt.close();

        return "Dentista Deletado com Sucesso!!!";
    }

    // Update
    public String atualizar(Dentista dentista) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update T_TDB_DENTISTA set NOME_DENTISTA =?, CPF_DENTISTA =?, NASC_DENTISTA =?, FONE_DENTISTA =?, EMAIL_DENTISTA =?, END_DENTISTA =?, CRO_DENTISTA =?, ESP_DENTISTA =? where ID_DENTISTA =?");
        stmt.setString(1, dentista.getNome());
        stmt.setString(2, dentista.getCpf());
        stmt.setDate(3, Date.valueOf(dentista.getDataNasc()));
        stmt.setString(4, dentista.getTelefone());
        stmt.setString(5, dentista.getEmail());
        stmt.setString(6, dentista.getEndereco());
        stmt.setString(7, dentista.getCro());
        stmt.setString(8, dentista.getEspecialidade());
        stmt.setInt(9, dentista.getIdDentista());

        stmt.executeUpdate();
        stmt.close();

        return "Dentista Atualizado com Sucesso!!!";
    }

    // Select
    public ArrayList<Dentista> selecionar() throws SQLException {
        ArrayList<Dentista> listaDentista = new ArrayList<Dentista>();
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_TDB_DENTISTA");

        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Dentista objDentista = new Dentista();
            objDentista.setIdDentista(rs.getInt(1));
            objDentista.setNome(rs.getString(2));
            objDentista.setCpf(rs.getString(3));
            objDentista.setDataNasc(rs.getDate(4).toLocalDate());
            objDentista.setTelefone(rs.getString(5));
            objDentista.setEmail(rs.getString(6));
            objDentista.setEndereco(rs.getString(7));
            objDentista.setCro(rs.getString(8));
            objDentista.setEspecialidade(rs.getString(9));

            listaDentista.add(objDentista);
        }
        return listaDentista;
    }

    // Select / Código
    public Dentista selecionarPorCodigo(int codigo) throws SQLException {
        Dentista objDentista = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_TDB_DENTISTA where ID_DENTISTA = ?");
        stmt.setInt(1, codigo);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            objDentista = new Dentista();
            objDentista.setIdDentista(rs.getInt(1));
            objDentista.setNome(rs.getString(2));
            objDentista.setCpf(rs.getString(3));
            objDentista.setDataNasc(rs.getDate(4).toLocalDate());
            objDentista.setTelefone(rs.getString(5));
            objDentista.setEmail(rs.getString(6));
            objDentista.setEndereco(rs.getString(7));
            objDentista.setCro(rs.getString(8));
            objDentista.setEspecialidade(rs.getString(9));
        }

        rs.close();
        stmt.close();

        return objDentista;
    }
}
