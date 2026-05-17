package br.com.fiap.bo;

import br.com.fiap.dao.ClinicaEmpresaDao;
import br.com.fiap.entities.ClinicaEmpresa;

import java.sql.SQLException;
import java.util.ArrayList;

public class ClinicaEmpresaBO {

    ClinicaEmpresaDao clinicaEmpresaDao;

    // Inserir
    public void inserirBo(ClinicaEmpresa clinicaEmpresa) throws SQLException, ClassNotFoundException {
        ClinicaEmpresaDao clinicaEmpresaDAO = new ClinicaEmpresaDao();
        clinicaEmpresaDAO.inserir(clinicaEmpresa);
    }

    // Deletar
    public void deletarBO(int codigo) throws SQLException, ClassNotFoundException {
        ClinicaEmpresaDao clinicaEmpresaDAO = new ClinicaEmpresaDao();
        clinicaEmpresaDao.deletar(codigo);
    }

    // Update
    public void atualizarBO(ClinicaEmpresa clinicaEmpresa) throws SQLException, ClassNotFoundException {
        ClinicaEmpresaDao clinicaEmpresaDAO = new ClinicaEmpresaDao();
        clinicaEmpresaDao.atualizar(clinicaEmpresa);
    }

    // Select
    public ArrayList<ClinicaEmpresa> selecionarBO() throws SQLException, ClassNotFoundException {
        clinicaEmpresaDao = new ClinicaEmpresaDao();
        return (ArrayList<ClinicaEmpresa>) clinicaEmpresaDao.selecionar();
    }

    // Select / Código
    public ClinicaEmpresa selecionarPorCodigoBo(int codigo) throws SQLException, ClassNotFoundException {
        ClinicaEmpresaDao clinicaEmpresaDAO = new ClinicaEmpresaDao();
        return clinicaEmpresaDao.selecionarPorCodigo(codigo);
    }
}
