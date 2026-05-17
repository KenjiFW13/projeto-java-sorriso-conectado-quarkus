package br.com.fiap.bo;

import br.com.fiap.dao.DentistaDao;
import br.com.fiap.entities.Dentista;

import java.sql.SQLException;
import java.util.ArrayList;

public class DentistaBO {

    DentistaDao dentistaDao;

    // Inserir
    public void inserirBO(Dentista dentista) throws SQLException, ClassNotFoundException {
        DentistaDao dentistaDAO = new DentistaDao();
        dentistaDAO.inserir(dentista);
    }

    // Deletar
    public void deletarBO(int codigo) throws SQLException, ClassNotFoundException {
        DentistaDao dentistaDAO = new DentistaDao();
        dentistaDao.deletar(codigo);
    }

    // Update
    public void atualizarBO(Dentista dentista) throws SQLException, ClassNotFoundException {
        DentistaDao dentistaDAO = new DentistaDao();
        dentistaDao.atualizar(dentista);
    }

    // Select
    public ArrayList<Dentista> selecionarBO() throws SQLException, ClassNotFoundException {
        dentistaDao = new DentistaDao();
        return (ArrayList<Dentista>) dentistaDao.selecionar();
    }

    // Select / Código
    public Dentista selecionarPorCodigoBo(int codigo) throws SQLException, ClassNotFoundException {
        DentistaDao dentistaDAO = new DentistaDao();
        return dentistaDao.selecionarPorCodigo(codigo);
    }
}
