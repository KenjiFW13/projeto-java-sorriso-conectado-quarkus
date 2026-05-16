package br.com.fiap.bo;

import br.com.fiap.dao.FuncionarioTdbDao;
import br.com.fiap.entities.FuncionarioTdb;

import java.sql.SQLException;

public class FuncionarioTdbBO {

    FuncionarioTdbDao funcionarioTdbDao;

    // Inserir
    public void inserirBO(FuncionarioTdb funcionarioTdb) throws SQLException, ClassNotFoundException {
        FuncionarioTdbDao funcionarioTdbDAO = new FuncionarioTdbDao();
        funcionarioTdbDAO.inserir(funcionarioTdb);
    }
}
