package br.com.fiap.services;

import br.com.fiap.dao.BeneficiarioDao;
import br.com.fiap.entities.Beneficiario;

import java.sql.SQLException;
import java.util.ArrayList;

public class BeneficiarioService {

    private static BeneficiarioDao dao;

    static {
        try {
            dao = new BeneficiarioDao();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Erro ao iniciar conexão no BeneficiarioService: " + e.getMessage());
        }
    }

    // 1. Cadastrar Beneficiário
    public static String cadastrar(Beneficiario beneficiario) throws SQLException {
        if (beneficiario.getIdBeneficiario() <= 0) {
            return "Erro: O ID do beneficiário deve ser maior que zero!";
        }
        if (beneficiario.getCpf() == null || beneficiario.getCpf().isEmpty()) {
            return "Erro: CPF inválido ou não informado!";
        }
        if (beneficiario.getTratamentoSolicitado() == null || beneficiario.getTratamentoSolicitado().isEmpty()) {
            return "Erro: O tratamento solicitado precisa ser informado!";
        }

        return dao.inserir(beneficiario);
    }

    // 2. Atualizar Beneficiário
    public static String atualizar(Beneficiario beneficiario) throws SQLException {
        if (beneficiario.getIdBeneficiario() <= 0) {
            return "Erro: Informe um ID válido para atualizar.";
        }
        return dao.atualizar(beneficiario);
    }

    // 3. Deletar Beneficiário
    public static String deletar(int id) throws SQLException {
        if (id <= 0) {
            return "Erro: ID inválido para exclusão.";
        }
        return dao.deletar(id); // O seu DAO deve estar esperando apenas o ID
    }

    // 4. Selecionar por ID
    public static String selecionarPorId(int id) throws SQLException {
        if (id <= 0) {
            return "Erro: ID inválido para busca.";
        }

        Beneficiario b = dao.selecionarPorCodigo(id);

        if (b == null) {
            return "Nenhum beneficiário encontrado com o ID: " + id;
        }

        // Retorna os dados formatados (o método toString() da sua classe faz isso lindamente)
        return "=== Dados do Beneficiário ===\n" + b.toString();
    }

    // 5. Listar Todos
    public static String listarTodos() throws SQLException {
        ArrayList<Beneficiario> lista = dao.selecionar();

        if (lista.isEmpty()) {
            return "Nenhum beneficiário cadastrado no banco de dados.";
        }

        StringBuilder relatorio = new StringBuilder("=== Lista de Beneficiários ===\n");
        for (Beneficiario b : lista) {
            relatorio.append("ID: ").append(b.getIdBeneficiario())
                    .append(" | Nome: ").append(b.getNome())
                    .append(" | Tratamento: ").append(b.getTratamentoSolicitado())
                    .append("\n");
        }

        return relatorio.toString();
    }
}