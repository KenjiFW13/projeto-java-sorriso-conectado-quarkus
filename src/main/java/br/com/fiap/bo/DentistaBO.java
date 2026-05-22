package br.com.fiap.bo;

import br.com.fiap.dao.DentistaDao;
import br.com.fiap.entities.Dentista;
import br.com.fiap.utils.ValidatorUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class DentistaBO {

    static DentistaDao dentistaDao;

    // Inserir
    public String inserirBO(Dentista dentista) throws SQLException, ClassNotFoundException {
        DentistaDao dentistaDAO = new DentistaDao();

        if (!ValidatorUtil.validarCro(dentista.getCro())){
            return "CRO inválido!";
        }

        if (!ValidatorUtil.validarCpf(dentista.getCpf())){
            return "CPF inválido!";
        }

        return dentistaDAO.inserir(dentista);
    }

    // Deletar
    public static void deletarBO(int codigo) throws SQLException, ClassNotFoundException {
        DentistaDao dentistaDAO = new DentistaDao();
        dentistaDao.deletar(codigo);
    }

    // Update
    public static String atualizarBO(Dentista dentista) throws SQLException, ClassNotFoundException {
        DentistaDao dentistaDAO = new DentistaDao();

        if (!ValidatorUtil.validarCro(dentista.getCro())){
            return "CRO inválido!";
        }

        if (!ValidatorUtil.validarCpf(dentista.getCpf())){
            return "CPF inválido!";
        }

        return dentistaDao.atualizar(dentista);
    }

    // Select
    public static ArrayList<Dentista> selecionarBO() throws SQLException, ClassNotFoundException {
        dentistaDao = new DentistaDao();
        return (ArrayList<Dentista>) dentistaDao.selecionar();
    }

    // Select / Código
    public static Dentista selecionarPorCodigoBo(int codigo) throws SQLException, ClassNotFoundException {
        DentistaDao dentistaDAO = new DentistaDao();
        return dentistaDao.selecionarPorCodigo(codigo);
    }
}
