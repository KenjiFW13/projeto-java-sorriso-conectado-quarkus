package br.com.fiap.entities;

import java.time.LocalDate;

public class Pessoa {
    private String nome, cpf, telefone, email, endereco;
    private LocalDate dataNasc;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String telefone, String email, String endereco, LocalDate dataNasc) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.dataNasc = dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.replaceAll("\\D", "");
        // O "\\D" significa: "Tudo o que NÃO for dígito"
    }

    public String getTelefone() {
        return telefone = telefone.replaceAll("\\D", "");
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataNasc=" + dataNasc +
                '}';
    }

//    public boolean validarCpf(String cpf){
//        if (cpf == null) return false;
//        // Se o cpf for vazio, retorna false
//        String apenasNumeros = cpf.replace(".", "").replace("-", "");
//        // Retira pontos e traços
//        return apenasNumeros.length() == 11;
//        // Só aceita tamanho = 11
//    }
}
