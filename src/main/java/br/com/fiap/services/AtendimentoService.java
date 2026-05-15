package br.com.fiap.services;

import br.com.fiap.dao.AtendimentoDao;
import br.com.fiap.entities.Atendimento;
import br.com.fiap.entities.Beneficiario;
import br.com.fiap.entities.ClinicaEmpresa;
import br.com.fiap.entities.Dentista;

import java.sql.SQLException;

public class AtendimentoService {

    private static AtendimentoDao dao;

    static {
        try {
            dao = new AtendimentoDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public AtendimentoService() throws SQLException, ClassNotFoundException {
    }

    public static String iniciarAtendimento(Atendimento atendimento, ClinicaEmpresa clinicaEmpresa, Dentista dentista, Beneficiario beneficiario) throws SQLException {
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
            return dao.inserir(atendimento, clinicaEmpresa, dentista, beneficiario);
    }

    // 2. Definir Prioridade
    public static String definirPrioridade(Atendimento atendimento) throws SQLException {
        if (atendimento.getPrioridade() == null || atendimento.getPrioridade().isEmpty()) {
            return "Erro: A prioridade não pode ser vazia!";
        }
        return dao.definirPrioridade(atendimento);
    }

    // 3. Atualizar Observações
    public static String atualizarObservacoes(Atendimento atendimento) throws SQLException {
        return dao.atualizarObservacoes(atendimento);
    }

    // 4. Selecionar Atendimento
    public static String selecionarAtendimento(int idAtendimento) throws SQLException {
        if (idAtendimento <= 0) {
            return "Erro: ID de atendimento inválido!";
        }
        // Supondo que seu DAO retorna uma String formatada ou o objeto Atendimento
        return String.valueOf(dao.selecionarPorCodigo(idAtendimento));
    }
}
