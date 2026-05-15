package br.com.fiap.entities;

import java.time.LocalDate;

public class Voluntario extends Pessoa{
    private int idVoluntario;
    private String areaDeAtuacao;

    public Voluntario() {
    }

    public Voluntario(String nome, String cpf, String telefone, String email, String endereco, LocalDate dataNasc, int idVoluntario, String areaDeAtuacao) {
        super(nome, cpf, telefone, email, endereco, dataNasc);
        this.idVoluntario = idVoluntario;
        this.areaDeAtuacao = areaDeAtuacao;
    }

    public int getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(int idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public String getAreaDeAtuacao() {
        return areaDeAtuacao;
    }

    public void setAreaDeAtuacao(String areaDeAtuacao) {
        this.areaDeAtuacao = areaDeAtuacao;
    }

    @Override
    public String toString() {
        return "Voluntario{" +
                "idVoluntario=" + idVoluntario +
                ", areaDeAtuacao='" + areaDeAtuacao + '\'' +
                '}';
    }
}
