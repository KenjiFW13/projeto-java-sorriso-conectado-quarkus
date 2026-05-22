package br.com.fiap.main;

import br.com.fiap.dao.BeneficiarioDao;
import br.com.fiap.entities.Beneficiario;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TesteInserirBeneficiario {

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
                return LocalDate.parse(textoObrigatorio(j), formato);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data inválida! Use dd/mm/aaaa");
            }
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Beneficiario objBeneficiario = new Beneficiario();

        BeneficiarioDao dao = new BeneficiarioDao();

        objBeneficiario.setIdBeneficiario(inteiro("Id do Beneficiário"));
        objBeneficiario.setNome(textoObrigatorio("Nome do Beneficiário"));

        String cpfDigitado;

        do {
            // 1. Pega o CPF (o textoObrigatorio já garante que não é vazio)
            cpfDigitado = textoObrigatorio("Cpf do Voluntário (Apenas números)");

            // 2. Valida a regra de negócio (11 dígitos)
            if (!objBeneficiario.validarCpf(cpfDigitado)) {
                JOptionPane.showMessageDialog(null, "CPF inválido! O CPF deve conter exatamente 11 números.");
            }

            // 3. Repete enquanto o CPF for inválido
        } while (!objBeneficiario.validarCpf(cpfDigitado));

        // 4. Só chega aqui se o CPF for válido
        objBeneficiario.setCpf(cpfDigitado);

        objBeneficiario.setDataNasc(data("Data de nascimento (dd/mm/aaaa)"));
        objBeneficiario.setTelefone(textoObrigatorio("Telefone do Beneficiário"));
        objBeneficiario.setEmail(textoOpcional("Email do Beneficiário"));
        objBeneficiario.setEndereco(textoObrigatorio("Endereço do Beneficiário"));
        objBeneficiario.setTratamentoSolicitado(textoObrigatorio("Tratamento Solicitado"));
        objBeneficiario.setStatusVulnerabilidade(textoObrigatorio("Status de Vulnerabilidade"));
        objBeneficiario.setHistoria(textoOpcional("História do Beneficiário"));

        System.out.println(dao.inserir(objBeneficiario));
    }
}
