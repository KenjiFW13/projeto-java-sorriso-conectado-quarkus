package br.com.fiap.main;

import br.com.fiap.entities.Menu;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Menu menu = new Menu();
        menu.exibir();
    }
}