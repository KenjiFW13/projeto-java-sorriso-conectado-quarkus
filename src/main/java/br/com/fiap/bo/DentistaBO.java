package br.com.fiap.bo;

import br.com.fiap.dao.DentistaDao;
import br.com.fiap.entities.Dentista;

import java.sql.SQLException;

public class DentistaBO {

    DentistaDao dentistaDao;

    // Inserir
    public void InserirBO(Dentista dentista) throws SQLException, ClassNotFoundException {
        DentistaDao dentistaDAO = new DentistaDao();
        dentistaDAO.inserir(dentista);
    }
}
