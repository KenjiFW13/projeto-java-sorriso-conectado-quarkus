package br.com.fiap.bo;

import br.com.fiap.dao.VoluntarioDao;
import br.com.fiap.entities.Voluntario;

import java.sql.SQLException;

public class VoluntarioBO {

    VoluntarioDao voluntarioDao;

    // Inserir
    public void inserirBO(Voluntario voluntario) throws SQLException, ClassNotFoundException {
        VoluntarioDao voluntarioDAO = new VoluntarioDao();
        voluntarioDAO.inserir(voluntario);
    }
}
