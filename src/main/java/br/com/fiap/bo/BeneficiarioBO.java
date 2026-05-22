package br.com.fiap.bo;

import br.com.fiap.dao.BeneficiarioDao;
import br.com.fiap.entities.Beneficiario;
import br.com.fiap.utils.ValidatorUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class BeneficiarioBO {

    BeneficiarioDao beneficiarioDao;

    // Inserir
    public String inserirBO(Beneficiario beneficiario) throws SQLException, ClassNotFoundException {
        BeneficiarioDao beneficiarioDAO = new BeneficiarioDao();

        if (!ValidatorUtil.validarCpf(beneficiario.getCpf())){
            return "Erro: Cpf inválido!";
        }

        if (beneficiario.getIdBeneficiario() <= 0) {
            return "Erro: O ID do beneficiário deve ser maior que zero!";
        }

        if (beneficiario.getTratamentoSolicitado() == null || beneficiario.getTratamentoSolicitado().isEmpty()) {
            return "Erro: O tratamento solicitado precisa ser informado!";
        }

        if (!ValidatorUtil.validarEmail(beneficiario.getEmail())){
            return "E-mail inválido!";
        }

        return beneficiarioDAO.inserir(beneficiario);
    }

    // Deletar
    public void deletarBO(int codigo) throws SQLException, ClassNotFoundException {
        BeneficiarioDao beneficiarioDAO = new BeneficiarioDao();
        beneficiarioDAO.deletar(codigo);
    }

    // Update
    public String atualizarBO(Beneficiario beneficiario) throws SQLException, ClassNotFoundException {
        BeneficiarioDao beneficiarioDAO = new BeneficiarioDao();

        if (!ValidatorUtil.validarCpf(beneficiario.getCpf())){
            return "Erro: Cpf inválido!";
        }

        if (!ValidatorUtil.validarEmail(beneficiario.getEmail())){
            return "E-mail inválido!";
        }

        return beneficiarioDAO.atualizar(beneficiario);
    }

    // Select
    public ArrayList<Beneficiario> selecionarBO() throws SQLException, ClassNotFoundException {
        beneficiarioDao = new BeneficiarioDao();
        return (ArrayList<Beneficiario>) beneficiarioDao.selecionar();
    }

    // Select / Código
    public Beneficiario selecionarPorCodigoBo(int codigo) throws SQLException, ClassNotFoundException {
        beneficiarioDao = new BeneficiarioDao();
        return beneficiarioDao.selecionarPorCodigo(codigo);
    }
}
