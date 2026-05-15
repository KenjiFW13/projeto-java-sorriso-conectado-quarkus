package br.com.fiap.menu;

import br.com.fiap.entities.*;
import br.com.fiap.services.AtendimentoService;
import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenuAtendimento {

    // --- SEUS MÉTODOS AUXILIARES ---
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

    static String textoOpcional(String j) {
        String input = JOptionPane.showInputDialog(j);
        if (input == null) return "";
        return input.trim();
    }

    static int inteiro(String j) {
        while (true) {
            try {
                return Integer.parseInt(textoObrigatorio(j));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite apenas números inteiros!");
            }
        }
    }

    static double real(String j) {
        while (true) {
            try {
                String input = textoObrigatorio(j).replace(",", ".");
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido! Digite um número decimal.");
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

    // --- MÉTODO PRINCIPAL DO MENU ---
    public void exibir() throws SQLException {
        String opcao = "";

        do {
            opcao = JOptionPane.showInputDialog(
                    "=== MENU DE ATENDIMENTO ===\n\n" +
                            "1. Iniciar Novo Atendimento\n" +
                            "2. Definir Prioridade\n" +
                            "3. Atualizar Observações\n" +
                            "4. Selecionar Atendimento\n" +
                            "5. Sair\n\n" +
                            "Escolha uma opção:"
            );

            if (opcao == null) opcao = "5"; // Se cancelar, sai do sistema

            switch (opcao) {
                case "1":
                    Atendimento objAtendimento = new Atendimento();
                    ClinicaEmpresa objClinicaEmpresa = new ClinicaEmpresa();
                    Dentista objDentista = new Dentista();
                    Beneficiario objBeneficiario = new Beneficiario();

                    objAtendimento.setIdAtendimento(inteiro("Id do atendimento"));
                    objAtendimento.setDataAgendamento(data("Digite a data do agendamento (dd/mm/aaaa)"));
                    objAtendimento.setPrioridade(textoObrigatorio("Prioridade (Não Urgente / Pouco Urgente / Urgente / Muito Urgente / Urgência)"));
                    objAtendimento.setStatusAgendamento(textoObrigatorio("Status do Agendamento"));
                    objAtendimento.setCustoAgendamento(real("Custo dos procedimentos"));
                    objAtendimento.setObservacoes(textoOpcional("Observações"));
                    objClinicaEmpresa.setIdEmpresa(inteiro("Id da empresa"));
                    objDentista.setIdDentista(inteiro("Id do dentista"));
                    objBeneficiario.setIdBeneficiario(inteiro("Id do Beneficiário"));

                    String msgInserir = AtendimentoService.iniciarAtendimento(objAtendimento, objClinicaEmpresa, objDentista, objBeneficiario);
                    JOptionPane.showMessageDialog(null, msgInserir);
                    break;

                case "2":
                    Atendimento atPri = new Atendimento();
                    atPri.setIdAtendimento(inteiro("Informe o ID do Atendimento"));
                    atPri.setPrioridade(textoObrigatorio("Definir nova prioridade"));

                    String msgPri = AtendimentoService.definirPrioridade(atPri);
                    JOptionPane.showMessageDialog(null, msgPri);
                    break;

                case "3":
                    Atendimento atObs = new Atendimento();
                    atObs.setIdAtendimento(inteiro("Informe o ID do Atendimento"));
                    atObs.setObservacoes(textoOpcional("Escreva as novas observações"));

                    String msgObs = AtendimentoService.atualizarObservacoes(atObs);
                    JOptionPane.showMessageDialog(null, msgObs);
                    break;

                case "4":
                    int idBusca = inteiro("Informe o ID do Atendimento");
                    String msgBusca = AtendimentoService.selecionarAtendimento(idBusca);
                    JOptionPane.showMessageDialog(null, msgBusca);
                    break;

                case "5":
                    JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Tente novamente.");
            }
        } while (!opcao.equals("5"));
    }
}