package br.com.fiap.utils;

public class ValidatorUtil {

    public static boolean validarCpf(String cpf) {
        if (cpf == null) return false;
        String apenasNumeros = cpf.replace(".", "").replace("-", "");
        return apenasNumeros.length() == 11;
    }

    public static boolean validarCro(String cro){
        if (cro == null) return false;
        String apenasNumeros = cro.replace(".", "").replace("-", "");
        return apenasNumeros.length() == 7;
    }
}
