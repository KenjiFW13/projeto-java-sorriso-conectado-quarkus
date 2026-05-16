package br.com.fiap.bo;

import br.com.fiap.dao.ClinicaEmpresaDao;
import br.com.fiap.entities.ClinicaEmpresa;

import java.sql.SQLException;

public class ClinicaEmpresaBO {

    ClinicaEmpresaDao clinicaEmpresaDao;

    // Inserir
    public void InserirBo(ClinicaEmpresa clinicaEmpresa) throws SQLException, ClassNotFoundException {
        ClinicaEmpresaDao clinicaEmpresaDAO = new ClinicaEmpresaDao();
        clinicaEmpresaDAO.inserir(clinicaEmpresa);
    }
}
