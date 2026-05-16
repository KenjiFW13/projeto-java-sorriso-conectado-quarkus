package br.com.fiap.bo;

import br.com.fiap.dao.BeneficiarioDao;
import br.com.fiap.entities.Beneficiario;

import java.sql.SQLException;
import java.util.ArrayList;

public class BeneficiarioBO {

    BeneficiarioDao beneficiarioDao;

    // Inserir
    public void inserirBO(Beneficiario beneficiario) throws SQLException, ClassNotFoundException {
        BeneficiarioDao beneficiarioDAO = new BeneficiarioDao();
        beneficiarioDao.inserir(beneficiario);
    }

    // Deletar
    public void deletarBO(int codigo) throws SQLException, ClassNotFoundException {
        BeneficiarioDao beneficiarioDAO = new BeneficiarioDao();
        beneficiarioDao.deletar(codigo);
    }

    // Update
    public void atualizarBO(Beneficiario beneficiario) throws SQLException, ClassNotFoundException {
        BeneficiarioDao beneficiarioDAO = new BeneficiarioDao();
        beneficiarioDao.atualizar(beneficiario);
    }

    // Select
    public ArrayList<Beneficiario> selecionarBO() throws SQLException, ClassNotFoundException {
        beneficiarioDao = new BeneficiarioDao();
        return (ArrayList<Beneficiario>) beneficiarioDao.selecionar();
    }

    // Select / Código
    public Beneficiario selecionarPorCodigoBo(int codigo) throws SQLException, ClassNotFoundException {
        BeneficiarioDao beneficiarioDAO = new BeneficiarioDao();
        return beneficiarioDao.selecionarPorCodigo(codigo);
    }
}
