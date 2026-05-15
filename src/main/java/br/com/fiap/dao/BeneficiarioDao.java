package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Beneficiario;

import java.sql.*;
import java.util.ArrayList;

public class BeneficiarioDao {

    public Connection minhaConexao;

    public BeneficiarioDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public String inserir(Beneficiario beneficiario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Insert Into T_TDB_BENEFICIARIO values (?,?,?,?,?,?,?,?,?,?)");
        stmt.setInt(1, beneficiario.getIdBeneficiario());
        stmt.setString(2, beneficiario.getNome());
        stmt.setString(3, beneficiario.getCpf());
        stmt.setDate(4, Date.valueOf(beneficiario.getDataNasc()));
        stmt.setString(5, beneficiario.getTelefone());
        stmt.setString(6, beneficiario.getEmail());
        stmt.setString(7, beneficiario.getEndereco());
        stmt.setString(8, beneficiario.getTratamentoSolicitado());
        stmt.setString(9, beneficiario.getStatusVulnerabilidade());
        stmt.setString(10, beneficiario.getHistoria());

        stmt.execute();
        stmt.close();

        return "Beneficiário Cadastrado com Sucesso!!!";
    }

    public String deletar(int codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From T_TDB_BENEFICIARIO where ID_BENEFICIARIO =?");
        stmt.setInt(1, codigo);

        stmt.execute();
        stmt.close();

        return "Beneficiário Deletado com Sucesso!!!";
    }

    // UpDate
    public String atualizar(Beneficiario beneficiario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update T_TDB_BENEFICIARIO set NOME_BENEFICIARIO =?, CPF_BENEFICIARIO =?, NASC_BENEFICIARIO =?, EMAIL_BENEFICIARIO =?, END_BENEFICIARIO =?, TRAT_BENEFICIARIO =?, STT_BENEFICIARIO =?, HIST_BENEFICIARIO =? where ID_BENEFICIARIO =?");
        stmt.setString(1, beneficiario.getNome());
        stmt.setString(2, beneficiario.getCpf());
        stmt.setDate(3, Date.valueOf(beneficiario.getDataNasc()));
        stmt.setString(4, beneficiario.getEmail());
        stmt.setString(5, beneficiario.getEndereco());
        stmt.setString(6, beneficiario.getTratamentoSolicitado());
        stmt.setString(7, beneficiario.getStatusVulnerabilidade());
        stmt.setString(8, beneficiario.getHistoria());

        stmt.executeUpdate();
        stmt.close();

        return "Beneficiário Atualizado com Sucesso!!!";
    }

    // Select
    public ArrayList<Beneficiario> selecionar() throws SQLException {
        ArrayList<Beneficiario> listaBeneficiario = new ArrayList<Beneficiario>();
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_TDB_BENEFICIARIO");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Beneficiario objBeneficiario = new Beneficiario();
            objBeneficiario.setIdBeneficiario(rs.getInt(1));
            objBeneficiario.setNome(rs.getString(2));
            objBeneficiario.setCpf(rs.getString(3));
            objBeneficiario.setDataNasc(rs.getDate(4).toLocalDate());
            objBeneficiario.setEmail(rs.getString(5));
            objBeneficiario.setEndereco(rs.getString(6));
            objBeneficiario.setTratamentoSolicitado(rs.getString(7));
            objBeneficiario.setStatusVulnerabilidade(rs.getString(8));
            objBeneficiario.setHistoria(rs.getString(9));

            listaBeneficiario.add(objBeneficiario);
        }
        return listaBeneficiario;
    }

    // Select / Código
    public Beneficiario selecionarPorCodigo(int codigo) throws SQLException {
        Beneficiario objBeneficiario = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_TDB_BENEFICIARIO where ID_BENEFICIARIO = ?");
        stmt.setInt(1, codigo);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            objBeneficiario = new Beneficiario();
            objBeneficiario.setIdBeneficiario(rs.getInt(1));
            objBeneficiario.setNome(rs.getString(2));
            objBeneficiario.setCpf(rs.getString(3));
            objBeneficiario.setDataNasc(rs.getDate(4).toLocalDate());
            objBeneficiario.setEmail(rs.getString(5));
            objBeneficiario.setEndereco(rs.getString(6));
            objBeneficiario.setTratamentoSolicitado(rs.getString(7));
            objBeneficiario.setStatusVulnerabilidade(rs.getString(8));
            objBeneficiario.setHistoria(rs.getString(9));
        }
        return objBeneficiario;
    }
}
