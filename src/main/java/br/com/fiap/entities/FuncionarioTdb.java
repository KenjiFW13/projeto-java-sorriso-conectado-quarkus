package br.com.fiap.entities;

import java.time.LocalDate;

public class FuncionarioTdb extends Pessoa {
    private int idFuncionarioTdb;
    private String cargo;

    public FuncionarioTdb() {
    }

    public FuncionarioTdb(String nome, String cpf, String telefone, String email, String endereco, LocalDate dataNasc, int idFuncionarioTdb, String cargo) {
        super(nome, cpf, telefone, email, endereco, dataNasc);
        this.idFuncionarioTdb = idFuncionarioTdb;
        this.cargo = cargo;
    }

    public int getIdFuncionarioTdb() {
        return idFuncionarioTdb;
    }

    public void setIdFuncionarioTdb(int idFuncionarioTdb) {
        this.idFuncionarioTdb = idFuncionarioTdb;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "FuncionarioTdb{" +
                "idFuncionarioTdb=" + idFuncionarioTdb +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
