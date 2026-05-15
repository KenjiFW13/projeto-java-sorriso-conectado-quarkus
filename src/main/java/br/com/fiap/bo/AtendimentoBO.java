package br.com.fiap.bo;

import br.com.fiap.dao.AtendimentoDao;
import br.com.fiap.entities.Atendimento;
import br.com.fiap.entities.Beneficiario;
import br.com.fiap.entities.ClinicaEmpresa;
import br.com.fiap.entities.Dentista;

import java.sql.SQLException;

public class AtendimentoBO {

    AtendimentoDao atendimentoDao;

    // Inserir
    public void inserirBo(Atendimento atendimento, ClinicaEmpresa clinicaEmpresa, Dentista dentista, Beneficiario beneficiario) throws SQLException, ClassNotFoundException {
        AtendimentoDao atendimentoDAO = new AtendimentoDao();
        atendimentoDao.inserir(atendimento, clinicaEmpresa, dentista, beneficiario);
    }

    // DefinirPrioridade
    public void DefinirPrioridadeBo(Atendimento atendimento) throws SQLException, ClassNotFoundException {
        AtendimentoDao atendimentoDAO = new AtendimentoDao();
        atendimentoDao.definirPrioridade(atendimento);
    }

    // AtualizarObservacoes
    public void AtualizarObservacoesBo(Atendimento atendimento) throws SQLException, ClassNotFoundException {
        AtendimentoDao atendimentoDAO = new AtendimentoDao();
        atendimentoDao.atualizarObservacoes(atendimento);
    }

    // Select / Código
    public Atendimento selecionarPorCodigo(int IdAtendimento) throws SQLException, ClassNotFoundException {
        AtendimentoDao atendimentoDAO = new AtendimentoDao();
        return atendimentoDAO.selecionarPorCodigo(IdAtendimento);
    }
}
