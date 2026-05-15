package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.ClinicaEmpresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClinicaEmpresaDao {

    public Connection minhaConexao;

    public ClinicaEmpresaDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

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
}
