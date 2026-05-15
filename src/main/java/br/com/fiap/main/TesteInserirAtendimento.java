package br.com.fiap.main;

import br.com.fiap.dao.AtendimentoDao;
import br.com.fiap.entities.Atendimento;
import br.com.fiap.entities.Beneficiario;
import br.com.fiap.entities.ClinicaEmpresa;
import br.com.fiap.entities.Dentista;
import br.com.fiap.services.AtendimentoService;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TesteInserirAtendimento {

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

    static double real(String j) {
        while (true) {
            try {
                String input = textoObrigatorio(j).replace(",", "."); // Aceita vírgula e troca por ponto
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido! Digite um número decimal (Ex: 150.50)");
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

        // Instanciar objetos
        Atendimento objAtendimento = new Atendimento();
        ClinicaEmpresa objClinicaEmpresa = new ClinicaEmpresa();
        Dentista objDentista = new Dentista();
        Beneficiario objBeneficiario = new Beneficiario();

        AtendimentoDao dao = new AtendimentoDao();

        objAtendimento.setIdAtendimento(inteiro("Id do atendimento"));
        objAtendimento.setDataAgendamento(data("Digite a data do agendamento (dd/mm/aaaa)"));
        objAtendimento.setPrioridade(textoObrigatorio("Prioridade (Não Urgente / Pouco Urgente / Urgente / Muito Urgente / Urgência)"));
        objAtendimento.setStatusAgendamento(textoObrigatorio("Status do Agendamento (Novo / Atendimento Iniciado / Atendimento Pausado / Atendimento Finalizado)"));
        objAtendimento.setCustoAgendamento(real("Custo dos procedimentos"));
        objAtendimento.setObservacoes(textoOpcional("Observações"));
        objClinicaEmpresa.setIdEmpresa(inteiro("Id da empresa"));
        objDentista.setIdDentista(inteiro("Id do dentista"));
        objBeneficiario.setIdBeneficiario(inteiro("Id do Beneficiário"));

        String iniciarAtendimento = AtendimentoService.iniciarAtendimento(objAtendimento, objClinicaEmpresa, objDentista, objBeneficiario);
        JOptionPane.showMessageDialog(null, iniciarAtendimento);
    }
}
