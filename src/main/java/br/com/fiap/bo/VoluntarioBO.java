package br.com.fiap.bo;

import br.com.fiap.dao.VoluntarioDao;
import br.com.fiap.entities.Voluntario;
import br.com.fiap.utils.ValidatorUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class VoluntarioBO {

    VoluntarioDao voluntarioDao;

    // Inserir
    public String inserirBO(Voluntario voluntario) throws SQLException, ClassNotFoundException {
        VoluntarioDao voluntarioDAO = new VoluntarioDao();

        if (!ValidatorUtil.validarCpf(voluntario.getCpf())){
            return "Erro: Cpf inválido!";
        }

        if (!ValidatorUtil.validarEmail(voluntario.getEmail())){
            return "E-mail inválido!";
        }

        return voluntarioDAO.inserir(voluntario);
    }

    // Deletar
    public void deletarBO(int codigo) throws SQLException, ClassNotFoundException {
        VoluntarioDao voluntarioDAO = new VoluntarioDao();
        voluntarioDao.deletar(codigo);
    }

    // Update
    public String atualizarBO(Voluntario voluntario) throws SQLException, ClassNotFoundException {
        VoluntarioDao voluntarioDAO = new VoluntarioDao();

        if (!ValidatorUtil.validarCpf(voluntario.getCpf())){
            return "Erro: Cpf inválido!";
        }

        if (!ValidatorUtil.validarEmail(voluntario.getEmail())){
            return "E-mail inválido!";
        }

        return voluntarioDao.atualizar(voluntario);
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
