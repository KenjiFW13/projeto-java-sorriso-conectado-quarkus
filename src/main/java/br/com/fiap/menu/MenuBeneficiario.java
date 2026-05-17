package br.com.fiap.menu;

import br.com.fiap.entities.Beneficiario;
import br.com.fiap.services.BeneficiarioService;
import br.com.fiap.utils.InputUtil;

import javax.swing.*;
import java.sql.SQLException;

public class MenuBeneficiario {

    public void exibir() throws SQLException {
        String opcao = "";

        do {
            opcao = JOptionPane.showInputDialog(
                    "=== GESTÃO DE BENEFICIÁRIOS ===\n\n" +
                            "1. Cadastrar Novo Beneficiário\n" +
                            "2. Atualizar Dados (por ID)\n" +
                            "3. Deletar Beneficiário\n" +
                            "4. Consultar por ID\n" +
                            "5. Listar Todos os Beneficiários\n" +
                            "6. Voltar ao Menu Principal\n\n" +
                            "Escolha uma opção:"
            );

            if (opcao == null) opcao = "6";

            switch (opcao) {
                case "1":
                    cadastrar();
                    break;
                case "2":
                    atualizar();
                    break;
                case "3":
                    deletar();
                    break;
                case "4":
                    consultarPorId();
                    break;
                case "5":
                    listarTodos();
                    break;
                case "6":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (!opcao.equals("6"));
    }

    // --- MÉTODOS PRIVADOS PARA ORGANIZAR O SWITCH ---

    private void cadastrar() throws SQLException {
        Beneficiario b = new Beneficiario();

        b.setIdBeneficiario(InputUtil.inteiro("ID do Beneficiário"));
        b.setNome(InputUtil.textoObrigatorio("Nome Completo"));

        String cpf;
        do {
            cpf = InputUtil.textoObrigatorio("CPF (11 dígitos)");
            if (!b.validarCpf(cpf)) {
                JOptionPane.showMessageDialog(null, "CPF inválido! Tente novamente.");
            }
        } while (!b.validarCpf(cpf));
        b.setCpf(cpf);

        b.setEmail(InputUtil.textoObrigatorio("E-mail"));
        b.setTelefone(InputUtil.textoObrigatorio("Telefone"));
        b.setEndereco(InputUtil.textoObrigatorio("Endereço"));
        b.setDataNasc(InputUtil.data("Data de Nascimento (dd/mm/aaaa)"));
        b.setTratamentoSolicitado(InputUtil.textoObrigatorio("Tratamento Solicitado"));
        b.setStatusVulnerabilidade(InputUtil.textoObrigatorio("Status de Vulnerabilidade"));
        b.setHistoria(InputUtil.textoOpcional("História/Observações"));

        String resultado = BeneficiarioService.cadastrar(b);
        JOptionPane.showMessageDialog(null, resultado);
    }

    private void atualizar() throws SQLException {
        Beneficiario b = new Beneficiario();
        b.setIdBeneficiario(InputUtil.inteiro("ID do Beneficiário que deseja ATUALIZAR"));

        b.setNome(InputUtil.textoObrigatorio("Novo Nome"));
        b.setCpf(InputUtil.textoObrigatorio("Novo CPF"));
        b.setEmail(InputUtil.textoObrigatorio("Novo E-mail"));
        b.setTelefone(InputUtil.textoObrigatorio("Novo Telefone"));
        b.setEndereco(InputUtil.textoObrigatorio("Novo Endereço"));
        b.setDataNasc(InputUtil.data("Nova Data de Nascimento (dd/mm/aaaa)"));
        b.setTratamentoSolicitado(InputUtil.textoObrigatorio("Novo Tratamento"));
        b.setStatusVulnerabilidade(InputUtil.textoObrigatorio("Novo Status"));
        b.setHistoria(InputUtil.textoObrigatorio("Nova História"));

        String resultado = BeneficiarioService.atualizar(b);
        JOptionPane.showMessageDialog(null, resultado);
    }

    private void deletar() throws SQLException {
        int id = InputUtil.inteiro("ID do Beneficiário que deseja EXCLUIR");

        int confirmacao = JOptionPane.showConfirmDialog(null,
                "Tem certeza que deseja excluir o beneficiário ID " + id + "?",
                "Confirmação", JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            String resultado = BeneficiarioService.deletar(id);
            JOptionPane.showMessageDialog(null, resultado);
        }
    }

    private void consultarPorId() throws SQLException {
        int id = InputUtil.inteiro("Digite o ID para consulta");
        String dados = BeneficiarioService.selecionarPorId(id);
        JOptionPane.showMessageDialog(null, dados);
    }

    private void listarTodos() throws SQLException {
        String lista = BeneficiarioService.listarTodos();

        JTextArea textArea = new JTextArea(lista);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(500, 300));

        JOptionPane.showMessageDialog(null, scrollPane, "Relatório de Beneficiários", JOptionPane.INFORMATION_MESSAGE);
    }
}