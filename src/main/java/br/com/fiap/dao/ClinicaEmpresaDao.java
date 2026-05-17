package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.ClinicaEmpresa;

import java.sql.*;
import java.util.ArrayList;

public class ClinicaEmpresaDao {

    public Connection minhaConexao;

    public ClinicaEmpresaDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Inserir
    public String inserir(ClinicaEmpresa clinicaEmpresa) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Insert Into T_TDB_EMPRESA values (?,?,?,?,?,?,?)");
        stmt.setInt(1, clinicaEmpresa.getIdEmpresa());
        stmt.setString(2, clinicaEmpresa.getNome());
        stmt.setString(3, clinicaEmpresa.getCnpj());
        stmt.setString(4, clinicaEmpresa.getDescricao());
        stmt.setString(5, clinicaEmpresa.getTelefone());
        stmt.setString(6, clinicaEmpresa.getEmail());
        stmt.setString(7, clinicaEmpresa.getEndereco());

        stmt.execute();
        stmt.close();

        return "Clínica/Empresa Cadastrada com Sucesso!!!";
    }

    // Deletar
    public String deletar(int codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From T_TDB_EMPRESA where ID_EMPRESA =?");
        stmt.setInt(1, codigo);

        stmt.execute();
        stmt.close();

        return "Clínica/Empresa Deletada com Sucesso!!!";
    }

    // UpDate
    public String atualizar(ClinicaEmpresa clinicaEmpresa) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update T_TDB_EMPRESA set NOME_EMPRESA =?, CNPJ_EMPRESA =?, DESC_EMPRESA =?, FONE_EMPRESA =?, EMAIL_EMPRESA =?, END_EMPRESA =? where ID_EMPRESA =?");
        stmt.setString(1, clinicaEmpresa.getNome());
        stmt.setString(2, clinicaEmpresa.getCnpj());
        stmt.setString(3, clinicaEmpresa.getDescricao());
        stmt.setString(4, clinicaEmpresa.getTelefone());
        stmt.setString(5, clinicaEmpresa.getEmail());
        stmt.setString(6, clinicaEmpresa.getEndereco());
        stmt.setInt(7, clinicaEmpresa.getIdEmpresa());

        stmt.executeUpdate();
        stmt.close();

        return "Clínica/Empresa Atualizado com Sucesso!!!";
    }

    // Select
    public ArrayList<ClinicaEmpresa> selecionar() throws SQLException {
        ArrayList<ClinicaEmpresa> listaClinicaEmpresa = new ArrayList<ClinicaEmpresa>();
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_TDB_EMPRESA");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            ClinicaEmpresa objClinicaEmpresa = new ClinicaEmpresa();
            objClinicaEmpresa.setIdEmpresa(rs.getInt(1));
            objClinicaEmpresa.setNome(rs.getString(2));
            objClinicaEmpresa.setCnpj(rs.getString(3));
            objClinicaEmpresa.setDescricao(rs.getString(4));
            objClinicaEmpresa.setTelefone(rs.getString(5));
            objClinicaEmpresa.setEmail(rs.getString(6));
            objClinicaEmpresa.setEndereco(rs.getString(7));

            listaClinicaEmpresa.add(objClinicaEmpresa);
        }
        return listaClinicaEmpresa;
    }

    // Select / Código
    public ClinicaEmpresa selecionarPorCodigo(int codigo) throws SQLException {
        ClinicaEmpresa objClinicaEmpresa = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_TDB_EMPRESA where ID_EMPRESA = ?");
        stmt.setInt(1, codigo);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            objClinicaEmpresa = new ClinicaEmpresa();
            objClinicaEmpresa.setIdEmpresa(rs.getInt(1));
            objClinicaEmpresa.setNome(rs.getString(2));
            objClinicaEmpresa.setCnpj(rs.getString(3));
            objClinicaEmpresa.setDescricao(rs.getString(4));
            objClinicaEmpresa.setTelefone(rs.getString(5));
            objClinicaEmpresa.setEmail(rs.getString(6));
            objClinicaEmpresa.setEndereco(rs.getString(7));
        }

        rs.close();
        stmt.close();

        return objClinicaEmpresa;
    }
}
