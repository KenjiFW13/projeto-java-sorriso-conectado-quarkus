package br.com.fiap.bo;

import br.com.fiap.dao.VoluntarioDao;
import br.com.fiap.entities.Beneficiario;
import br.com.fiap.entities.Voluntario;

import java.sql.SQLException;
import java.util.ArrayList;

public class VoluntarioBO {

    VoluntarioDao voluntarioDao;

    // Inserir
    public void inserirBO(Voluntario voluntario) throws SQLException, ClassNotFoundException {
        VoluntarioDao voluntarioDAO = new VoluntarioDao();
        voluntarioDAO.inserir(voluntario);
    }

    // Deletar
    public void deletarBO(int codigo) throws SQLException, ClassNotFoundException {
        VoluntarioDao voluntarioDAO = new VoluntarioDao();
        voluntarioDao.deletar(codigo);
    }

    // Update
    public void atualizarBO(Voluntario voluntario) throws SQLException, ClassNotFoundException {
        VoluntarioDao voluntarioDAO = new VoluntarioDao();
        voluntarioDao.atualizar(voluntario);
    }

    // Select
    public ArrayList<Voluntario> selecionarBO() throws SQLException, ClassNotFoundException {
        voluntarioDao = new VoluntarioDao();
        return (ArrayList<Voluntario>) voluntarioDao.selecionar();
    }

    // Select / Código
    public Voluntario selecionarPorCodigoBo(int codigo) throws SQLException, ClassNotFoundException {
        VoluntarioDao voluntarioDAO = new VoluntarioDao();
        return voluntarioDao.selecionarPorCodigo(codigo);
    }
}
