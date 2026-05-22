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
    public String inserirBo(Atendimento atendimento, ClinicaEmpresa clinicaEmpresa, Dentista dentista, Beneficiario beneficiario) throws SQLException, ClassNotFoundException {
        AtendimentoDao atendimentoDAO = new AtendimentoDao();

        if (atendimento.getCustoAgendamento() < 0) {
            return "Erro: O custo do agendamento não pode ser negativo!";
        }

        if (clinicaEmpresa.getIdEmpresa() < 0) {
            return "Erro: Id da Empresa inválido ou não informado!";
        }

        if (dentista.getIdDentista() < 0) {
            return "Erro: Id do Dentista inválido ou não informado!";
        }

        if (beneficiario.getIdBeneficiario() < 0) {
            return "Erro: Id do Beneficiário inválido ou não informado!";
        }

        if (atendimento.getStatusAgendamento() == null ||
                atendimento.getStatusAgendamento().isEmpty()) {
            atendimento.setStatusAgendamento("Novo");
        }

        return atendimentoDao.inserir(atendimento, clinicaEmpresa, dentista, beneficiario);
    }

    // DefinirPrioridade
    public String DefinirPrioridadeBo(Atendimento atendimento) throws SQLException, ClassNotFoundException {
        AtendimentoDao atendimentoDAO = new AtendimentoDao();

        if (atendimento.getPrioridade() == null || atendimento.getPrioridade().isEmpty()) {
            return "Erro: A prioridade não pode ser vazia!";
        }

        return atendimentoDao.definirPrioridade(atendimento);
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
