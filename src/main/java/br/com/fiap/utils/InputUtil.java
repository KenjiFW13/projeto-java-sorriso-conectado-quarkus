package br.com.fiap.utils;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InputUtil {

    public static String textoObrigatorio(String j) {
        String input;
        do {
            input = JOptionPane.showInputDialog(j);
            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Erro: O campo é obrigatório!");
            }
        } while (input == null || input.trim().isEmpty());
        return input;
    }

    public static String textoOpcional(String j) {
        String input = JOptionPane.showInputDialog(j);
        return (input == null) ? "" : input.trim();
    }

    public static int inteiro(String j) {
        while (true) {
            try {
                return Integer.parseInt(textoObrigatorio(j));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite apenas números inteiros!");
            }
        }
    }

    public static double real(String j) {
        while (true) {
            try {
                return Double.parseDouble(textoObrigatorio(j).replace(",", "."));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido! Digite um número.");
            }
        }
    }

    public static LocalDate data(String j) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                return LocalDate.parse(textoObrigatorio(j), formato);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data inválida! Use dd/mm/aaaa");
            }
        }
    }
}