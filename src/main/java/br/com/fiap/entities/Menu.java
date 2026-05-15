package br.com.fiap.entities;

import br.com.fiap.menu.MenuAtendimento;
import br.com.fiap.menu.MenuBeneficiario;

import javax.swing.JOptionPane;
import java.sql.SQLException;

public class Menu {

    public void exibir() throws SQLException {
        String opcao = "";

        do {
            opcao = JOptionPane.showInputDialog(
                    "=== SISTEMA SORRISO CONECTADO ===\n\n" +
                            "1. Gestão de Atendimentos\n" +
                            "2. Gestão de Beneficiários\n" +
                            "3. Gestão de Dentistas\n" +
                            "4. Gestão de Clínicas/Empresas\n" +
                            "5. Gestão de Voluntários\n" +
                            "6. Gestão de Funcionários TDB\n" +
                            "7. Sair do Sistema\n\n" +
                            "Escolha um módulo:"
            );

            if (opcao == null) opcao = "7";

            switch (opcao) {
                case "1":
                    new MenuAtendimento().exibir();
                    break;
                case "2":
                    new MenuBeneficiario().exibir();
                    break;
                case "3":
                    // new MenuDentista().exibir();
                    JOptionPane.showMessageDialog(null, "Módulo Dentista em construção.");
                    break;
                case "4":
                    // new MenuClinicaEmpresa().exibir();
                    JOptionPane.showMessageDialog(null, "Módulo Clínicas/Empresas em construção.");
                case "5":
                    // new MenuVoluntario().exibir();
                    JOptionPane.showMessageDialog(null, "Módulo Voluntários em construção.");
                case "6":
                    // new MenuFuncionario().exibir();
                    JOptionPane.showMessageDialog(null, "Módulo Funcionários em construção.");
                case "7":
                    JOptionPane.showMessageDialog(null, "Saindo... Até logo!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (!opcao.equals("7"));
    }
}