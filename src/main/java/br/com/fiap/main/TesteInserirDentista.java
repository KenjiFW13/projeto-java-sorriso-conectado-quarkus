package br.com.fiap.main;

import br.com.fiap.dao.DentistaDao;
import br.com.fiap.entities.Dentista;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TesteInserirDentista {

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

        Dentista objDentista = new Dentista();

        DentistaDao dao = new DentistaDao();

        objDentista.setIdDentista(inteiro("Id do Dentista"));
        objDentista.setNome(textoObrigatorio("Nome do Dentista"));

        String cpfDigitado;

        do {
            // 1. Pega o CPF (o textoObrigatorio já garante que não é vazio)
            cpfDigitado = textoObrigatorio("Cpf do Dentista (Apenas números)");

            // 2. Valida a regra de negócio (11 dígitos)
            if (!objDentista.validarCpf(cpfDigitado)) {
                JOptionPane.showMessageDialog(null, "CPF inválido! O CPF deve conter exatamente 11 números.");
            }

            // 3. Repete enquanto o CPF for inválido
        } while (!objDentista.validarCpf(cpfDigitado));

        // 4. Só chega aqui se o CPF for válido
        objDentista.setCpf(cpfDigitado);

        objDentista.setDataNasc(data("Data de nascimento (dd/mm/aaaa)"));
        objDentista.setTelefone(textoObrigatorio("Telefone do Dentista"));
        objDentista.setEmail(textoOpcional("Email do Dentista"));
        objDentista.setEndereco(textoObrigatorio("Endereço do Dentista"));

        String croDigitado;
        do {
            croDigitado = textoObrigatorio("CRO do Dentista (Ex: SP12345)");

            if (!objDentista.validarCro(croDigitado)) {
                JOptionPane.showMessageDialog(null, "CRO inválido! Deve conter 7 caracteres (incluindo a sigla do estado se houver).");
            }

        } while (!objDentista.validarCro(croDigitado));

        // Salva a versão que será limpa pelo setCro
        objDentista.setCro(croDigitado);

        objDentista.setEspecialidade(textoObrigatorio("Especialidade do Dentista"));

        System.out.println(dao.inserir(objDentista));
    }
}
