package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.Atendimento;
import br.com.fiap.entities.Beneficiario;
import br.com.fiap.entities.ClinicaEmpresa;
import br.com.fiap.entities.Dentista;

import java.sql.*;

public class AtendimentoDao {

    public Connection minhaConexao;

    public AtendimentoDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Inserir
    public String inserir(Atendimento atendimento, ClinicaEmpresa clinicaEmpresa, Dentista dentista, Beneficiario beneficiario) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Insert Into T_TDB_ATENDIMENTO values (?,?,?,?,?,?,?,?,?)");
        stmt.setInt(1, atendimento.getIdAtendimento());
        stmt.setDate(2, Date.valueOf(atendimento.getDataAgendamento()));
        stmt.setString(3, atendimento.getPrioridade());
        stmt.setString(4, atendimento.getStatusAgendamento());
        stmt.setDouble(5, atendimento.getCustoAgendamento());
        stmt.setString(6, atendimento.getObservacoes());
        stmt.setInt(7, clinicaEmpresa.getIdEmpresa());
        stmt.setInt(8, dentista.getIdDentista());
        stmt.setInt(9, beneficiario.getIdBeneficiario());

        stmt.execute();
        stmt.close();

        return "Atendimento Cadastrado com Sucesso!!!";
    }

    // DefinirPrioridade
    public String definirPrioridade(Atendimento atendimento) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update T_TDB_ATENDIMENTO set PRI_ATENDIMENTO = ? WHERE ID_ATENDIMENTO = ?");
        stmt.setString(1, atendimento.getPrioridade());
        stmt.setInt(2, atendimento.getIdAtendimento());

        stmt.executeUpdate();
        stmt.close();

        return "Prioridade Alterada!";
    }

    // AtualizarObservacoes
    public String atualizarObservacoes(Atendimento atendimento) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update T_TDB_ATENDIMENTO set OBS_ATENDIMENTO = ? WHERE ID_ATENDIMENTO = ?");
        stmt.setString(1, atendimento.getObservacoes());
        stmt.setInt(2, atendimento.getIdAtendimento());

        stmt.executeUpdate();
        stmt.close();

        return "Observações colocadas!";
    }

    // Select / Código
    public Atendimento selecionarPorCodigo(int IdAtendimento) throws SQLException {
        Atendimento objAtendimento = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_TDB_ATENDIMENTO where ID_ATENDIMENTO = ?");
        stmt.setInt(1, IdAtendimento);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            objAtendimento = new Atendimento();
            objAtendimento.setIdAtendimento(rs.getInt(1));
            objAtendimento.setDataAgendamento(rs.getDate(2).toLocalDate());
            objAtendimento.setPrioridade(rs.getString(3));
            objAtendimento.setStatusAgendamento(rs.getString(4));
            objAtendimento.setCustoAgendamento(rs.getDouble(5));
            objAtendimento.setObservacoes(rs.getString(6));
            objAtendimento.setIdDentista(rs.getInt(7));
            objAtendimento.setIdBeneficiario(rs.getInt(8));
            objAtendimento.setIdClinicaEmpresa(rs.getInt(9));
        }
        return objAtendimento;
    }
}
