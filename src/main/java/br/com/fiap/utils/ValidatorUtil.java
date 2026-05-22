package br.com.fiap.utils;

import java.util.regex.Pattern;

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

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

    public static boolean validarEmail(String email) {
        if (email == null || email.isEmpty()) return false;
        return PATTERN.matcher(email).matches();
    }
}
