package br.com.fiap.main;

import br.com.fiap.dao.AtendimentoDao;
import br.com.fiap.entities.Atendimento;

import javax.swing.*;
import java.sql.SQLException;

public class TesteSelecionarAtendimento {

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

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Atendimento objAtendimento = new Atendimento();

        AtendimentoDao dao = new AtendimentoDao();

        objAtendimento.setIdAtendimento(inteiro("Informe o ID do Atendimento"));
        System.out.println(dao.selecionarPorCodigo(objAtendimento.getIdAtendimento()));
    }
}
