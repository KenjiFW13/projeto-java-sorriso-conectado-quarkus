package br.com.fiap.entities;

import java.time.LocalDate;

public class Beneficiario extends Pessoa{
    private int idBeneficiario;
    private String tratamentoSolicitado, statusVulnerabilidade, historia;

    public Beneficiario() {
    }

    public Beneficiario(String nome, String cpf, String telefone, String email, String endereco, LocalDate dataNasc, int idBeneficiario, String tratamentoSolicitado, String statusVulnerabilidade, String historia) {
        super(nome, cpf, telefone, email, endereco, dataNasc);
        this.idBeneficiario = idBeneficiario;
        this.tratamentoSolicitado = tratamentoSolicitado;
        this.statusVulnerabilidade = statusVulnerabilidade;
        this.historia = historia;
    }

    public int getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(int idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public String getTratamentoSolicitado() {
        return tratamentoSolicitado;
    }

    public void setTratamentoSolicitado(String tratamentoSolicitado) {
        this.tratamentoSolicitado = tratamentoSolicitado;
    }

    public String getStatusVulnerabilidade() {
        return statusVulnerabilidade;
    }

    public void setStatusVulnerabilidade(String statusVulnerabilidade) {
        this.statusVulnerabilidade = statusVulnerabilidade;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    @Override
    public String toString() {
        return "Beneficiario{" +
                "idBeneficiario=" + idBeneficiario +
                ", tratamentoSolicitado='" + tratamentoSolicitado + '\'' +
                ", statusVulnerabilidade='" + statusVulnerabilidade + '\'' +
                ", historia='" + historia + '\'' +
                '}';
    }
}
