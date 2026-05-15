package br.com.fiap.entities;

import java.time.LocalDate;

public class Atendimento {
    private int idAtendimento, idBeneficiario, idDentista, idClinicaEmpresa;
    private String prioridade, statusAgendamento, observacoes;
    private LocalDate dataAgendamento;
    private Double custoAgendamento;

    public Atendimento() {
    }

    public Atendimento(int idAtendimento, int idBeneficiario, int idDentista, int idClinicaEmpresa, String prioridade, String statusAgendamento, String observacoes, LocalDate dataAgendamento, Double custoAgendamento) {
        this.idAtendimento = idAtendimento;
        this.idBeneficiario = idBeneficiario;
        this.idDentista = idDentista;
        this.idClinicaEmpresa = idClinicaEmpresa;
        this.prioridade = prioridade;
        this.statusAgendamento = statusAgendamento;
        this.observacoes = observacoes;
        this.dataAgendamento = dataAgendamento;
        this.custoAgendamento = custoAgendamento;
    }

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public int getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(int idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public int getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(int idDentista) {
        this.idDentista = idDentista;
    }

    public int getIdClinicaEmpresa() {
        return idClinicaEmpresa;
    }

    public void setIdClinicaEmpresa(int idClinicaEmpresa) {
        this.idClinicaEmpresa = idClinicaEmpresa;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(String statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Double getCustoAgendamento() {
        return custoAgendamento;
    }

    public void setCustoAgendamento(Double custoAgendamento) {
        this.custoAgendamento = custoAgendamento;
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "ID do Atendimento=" + idAtendimento +
                ", ID do Beneficiário='" + idDentista + '\'' +
                ", ID do Dentista='" + idDentista + '\'' +
                ", ID da Empresa='" + idClinicaEmpresa + '\'' +
                ", Prioridade='" + prioridade + '\'' +
                ", Status de Agendamento='" + statusAgendamento + '\'' +
                ", Observações='" + observacoes + '\'' +
                ", Data de Agendamento=" + dataAgendamento +
                ", Custo do Agendamento=" + custoAgendamento +
                '}';
    }
}
