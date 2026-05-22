package br.com.fiap.main;

import br.com.fiap.dao.ClinicaEmpresaDao;
import br.com.fiap.entities.ClinicaEmpresa;

import javax.swing.*;
import java.sql.SQLException;

public class TesteInserirClinicaEmpresa {

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

        ClinicaEmpresa objClinicaEmpresa = new ClinicaEmpresa();

        ClinicaEmpresaDao dao = new ClinicaEmpresaDao();

        objClinicaEmpresa.setIdEmpresa(inteiro("Id da Clínica/Empresa"));
        objClinicaEmpresa.setNome(textoObrigatorio("Nome do Clínica/Empresa"));
        objClinicaEmpresa.setCnpj(textoObrigatorio("CNPJ da Empresa"));
        objClinicaEmpresa.setDescricao(textoOpcional("Descrição da Clínica/Empresa"));
        objClinicaEmpresa.setTelefone(textoObrigatorio("Telefone do Clínica/Empresa"));
        objClinicaEmpresa.setEmail(textoOpcional("Email do Clínica/Empresa"));
        objClinicaEmpresa.setEndereco(textoObrigatorio("Endereço do Clínica/Empresa"));

        System.out.println(dao.inserir(objClinicaEmpresa));
    }
}
