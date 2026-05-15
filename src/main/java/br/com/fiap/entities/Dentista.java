package br.com.fiap.entities;

import java.time.LocalDate;

public class Dentista extends Pessoa{
    private int idDentista;
    private String cro, especialidade;

    public Dentista() {
    }

    public Dentista(String nome, String cpf, String telefone, String email, String endereco, LocalDate dataNasc, int idDentista, String cro, String especialidade) {
        super(nome, cpf, telefone, email, endereco, dataNasc);
        this.idDentista = idDentista;
        this.cro = cro;
        this.especialidade = especialidade;
    }

    public int getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(int idDentista) {
        this.idDentista = idDentista;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro.replace(".", "").replace("-", "");
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Dentista{" +
                "idDentista=" + idDentista +
                ", cro='" + cro + '\'' +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }

    public boolean validarCro(String cro){
        if (cro == null) return false;
        // Se o campo tiver vazio, retorna false
        String apenasNumeros = cro.replace(".", "").replace("-", "");
        // Retira pontos e traços
        return apenasNumeros.length() == 7;
        // Apenas tamanho 7
    }
}
