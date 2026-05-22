package br.com.fiap.main;

import br.com.fiap.dao.VoluntarioDao;
import br.com.fiap.entities.Voluntario;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TesteInserirVoluntario {

    // Método para campos OBRIGATÓRIOS (Not Null)
    static String textoObrigatorio(String j) {
        String input;
        do {
            input = JOptionPane.showInputDialog(j);
            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Erro: O campo " + j + " é obrigatório!");
            }
        } while (input == null || input.trim().isEmpty());
        return input;
    }

    // Método para campos OPCIONAIS (Aceita vazio)
    static String textoOpcional(String j) {
        String input = JOptionPane.showInputDialog(j);
        if (input == null) return ""; // Se cancelar, retorna vazio para não dar erro
        return input.trim();
    }

    static int inteiro(String j) {
        while (true) {
            try {
                // IDs são sempre obrigatórios
                return Integer.parseInt(textoObrigatorio(j));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite apenas números inteiros!");
            }
        }
    }

    static LocalDate data(String j) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                // DataNasc é Not Null, então usamos o obrigatório
                return LocalDate.parse(textoObrigatorio(j), formato);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data inválida! Use dd/mm/aaaa");
            }
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Voluntario objVoluntario = new Voluntario();

        VoluntarioDao dao = new VoluntarioDao();

        objVoluntario.setIdVoluntario(inteiro("Id do Voluntário"));
        objVoluntario.setNome(textoObrigatorio("Nome do Voluntário"));

        String cpfDigitado;

        do {
            // 1. Pega o CPF (o textoObrigatorio já garante que não é vazio)
            cpfDigitado = textoObrigatorio("Cpf do Voluntário (Apenas números)");

            // 2. Valida a regra de negócio (11 dígitos)
            if (!objVoluntario.validarCpf(cpfDigitado)) {
                JOptionPane.showMessageDialog(null, "CPF inválido! O CPF deve conter exatamente 11 números.");
            }

        // 3. Repete enquanto o CPF for inválido
        } while (!objVoluntario.validarCpf(cpfDigitado));

        // 4. Só chega aqui se o CPF for válido
        objVoluntario.setCpf(cpfDigitado);

        objVoluntario.setDataNasc(data("Data de nascimento (dd/mm/aaaa)"));
        objVoluntario.setTelefone(textoObrigatorio("Telefone do Voluntário"));
        objVoluntario.setEmail(textoOpcional("Email do Voluntário"));
        objVoluntario.setEndereco(textoObrigatorio("Endereço do Voluntário"));
        objVoluntario.setAreaDeAtuacao(textoObrigatorio("Área de atuação do Voluntário"));

        System.out.println(dao.inserir(objVoluntario));
    }
}
