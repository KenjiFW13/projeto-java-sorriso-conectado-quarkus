package br.com.fiap.dao;

import br.com.fiap.conexoes.ConexaoFactory;
import br.com.fiap.entities.FuncionarioTdb;

import java.sql.*;
import java.util.ArrayList;

public class FuncionarioTdbDao {

    public Connection minhaConexao;

    public FuncionarioTdbDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Inserir
    public String inserir(FuncionarioTdb funcionarioTdb) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Insert Into T_TDB_FUNCIONARIOTDB values (?,?,?,?,?,?,?,?)");
        stmt.setInt(1, funcionarioTdb.getIdFuncionarioTdb());
        stmt.setString(2, funcionarioTdb.getNome());
        stmt.setString(3, funcionarioTdb.getCpf());
        stmt.setDate(4, Date.valueOf(funcionarioTdb.getDataNasc()));
        stmt.setString(5, funcionarioTdb.getTelefone());
        stmt.setString(6, funcionarioTdb.getEmail());
        stmt.setString(7, funcionarioTdb.getEndereco());
        stmt.setString(8, funcionarioTdb.getCargo());

        stmt.execute();
        stmt.close();

        return "Funcionário Cadastrado com Sucesso!!!";
    }

    // Deletar
    public String deletar(int codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From T_TDB_FUNCIONARIOTDB where ID_FUNCIONARIOTDB =?");
        stmt.setInt(1, codigo);

        stmt.execute();
        stmt.close();

        return "Funcionário Deletado com Sucesso!!!";
    }

    // UpDate
    public String atualizar(FuncionarioTdb funcionarioTdb) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update T_TDB_FUNCIONARIOTDB set NOME_FUNCIONARIOTDB =?, CPF_FUNCIONARIOTDB =?, NASC_FUNCIONARIOTDB =?, FONE_FUNCIONARIOTDB =?, EMAIL_FUNCIONARIOTDB =?, END_FUNCIONARIOTDB =?, CAR_FUNCIONARIOTDB =? where ID_FUNCIONARIOTDB =?");
        stmt.setString(1, funcionarioTdb.getNome());
        stmt.setString(2, funcionarioTdb.getCpf());
        stmt.setDate(3, Date.valueOf(funcionarioTdb.getDataNasc()));
        stmt.setString(4, funcionarioTdb.getTelefone());
        stmt.setString(5, funcionarioTdb.getEmail());
        stmt.setString(6, funcionarioTdb.getEndereco());
        stmt.setString(7, funcionarioTdb.getCargo());
        stmt.setInt(8, funcionarioTdb.getIdFuncionarioTdb());

        stmt.executeUpdate();
        stmt.close();

        return "Funcionário Atualizado com Sucesso!!!";
    }

    // Select
    public ArrayList<FuncionarioTdb> selecionar() throws SQLException {
        ArrayList<FuncionarioTdb> listaFuncionario = new ArrayList<FuncionarioTdb>();
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_TDB_FUNCIONARIOTDB");

        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            FuncionarioTdb objFuncionario = new FuncionarioTdb();
            objFuncionario.setIdFuncionarioTdb(rs.getInt(1));
            objFuncionario.setNome(rs.getString(2));
            objFuncionario.setCpf(rs.getString(3));
            objFuncionario.setDataNasc(rs.getDate(4).toLocalDate());
            objFuncionario.setTelefone(rs.getString(5));
            objFuncionario.setEmail(rs.getString(6));
            objFuncionario.setEndereco(rs.getString(7));
            objFuncionario.setCargo(rs.getString(8));

            listaFuncionario.add(objFuncionario);
        }
        return listaFuncionario;
    }

    // Select / Código
    public FuncionarioTdb selecionarPorCodigo(int codigo) throws SQLException {
        FuncionarioTdb objFuncionario = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_TDB_FUNCIONARIOTDB where ID_FUNCIONARIOTDB = ?");
        stmt.setInt(1, codigo);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            objFuncionario = new FuncionarioTdb();
            objFuncionario.setIdFuncionarioTdb(rs.getInt(1));
            objFuncionario.setNome(rs.getString(2));
            objFuncionario.setCpf(rs.getString(3));
            objFuncionario.setDataNasc(rs.getDate(4).toLocalDate());
            objFuncionario.setTelefone(rs.getString(5));
            objFuncionario.setEmail(rs.getString(6));
            objFuncionario.setEndereco(rs.getString(7));
            objFuncionario.setCargo(rs.getString(8));
        }

        rs.close();
        stmt.close();

        return objFuncionario;
    }
}

