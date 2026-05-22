package br.com.fiap.main;

import br.com.fiap.dao.AtendimentoDao;
import br.com.fiap.entities.Atendimento;

import javax.swing.*;
import java.sql.SQLException;

public class TesteAtualizarObservacoes {

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

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // Instanciar objetos
        Atendimento objAtendimento = new Atendimento();

        AtendimentoDao dao = new AtendimentoDao();

        objAtendimento.setIdAtendimento(inteiro("Informe o ID do Atendimento que será atualizado"));
        objAtendimento.setObservacoes(textoOpcional("Escreva as observações"));

        System.out.println(dao.atualizarObservacoes(objAtendimento));
    }
}
