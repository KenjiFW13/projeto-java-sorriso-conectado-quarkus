package br.com.fiap.bo;

import br.com.fiap.dao.FuncionarioTdbDao;
import br.com.fiap.entities.FuncionarioTdb;
import br.com.fiap.utils.ValidatorUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioTdbBO {

    FuncionarioTdbDao funcionarioTdbDao;

    // Inserir
    public String inserirBO(FuncionarioTdb funcionarioTdb) throws SQLException, ClassNotFoundException {
        FuncionarioTdbDao funcionarioTdbDAO = new FuncionarioTdbDao();

        if (!ValidatorUtil.validarEmail(funcionarioTdb.getEmail())){
            return "E-mail inválido!";
        }

        if (!ValidatorUtil.validarCpf(funcionarioTdb.getCpf())){
            return "Erro: Cpf inválido!";
        }

        return funcionarioTdbDAO.inserir(funcionarioTdb);
    }

    // Deletar
    public void deletarBO(int codigo) throws SQLException, ClassNotFoundException {
        FuncionarioTdbDao funcionarioTdbDAO = new FuncionarioTdbDao();
        funcionarioTdbDao.deletar(codigo);
    }

    // Update
    public String atualizarBO(FuncionarioTdb funcionarioTdb) throws SQLException, ClassNotFoundException {
        FuncionarioTdbDao funcionarioTdbDAO = new FuncionarioTdbDao();

        if (!ValidatorUtil.validarEmail(funcionarioTdb.getEmail())){
            return "E-mail inválido!";
        }

        if (!ValidatorUtil.validarCpf(funcionarioTdb.getCpf())){
            return "Erro: Cpf inválido!";
        }

        return funcionarioTdbDao.atualizar(funcionarioTdb);
    }

    // Select
    public ArrayList<FuncionarioTdb> selecionarBO() throws SQLException, ClassNotFoundException {
        funcionarioTdbDao = new FuncionarioTdbDao();
        return (ArrayList<FuncionarioTdb>) funcionarioTdbDao.selecionar();
    }

    // Select / Código
    public FuncionarioTdb selecionarPorCodigoBo(int codigo) throws SQLException, ClassNotFoundException {
        FuncionarioTdbDao funcionarioTdbDAO = new FuncionarioTdbDao();
        return funcionarioTdbDao.selecionarPorCodigo(codigo);
    }
}
