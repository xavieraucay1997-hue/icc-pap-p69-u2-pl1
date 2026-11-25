package edu.ups.pap.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/** E06: Palabras dentro de un texto. Contrato completo en README.md. */
public class Ejercicio06 {
    private static final Pattern PALABRA_VALIDA = Pattern.compile("[A-Za-z]+");

    public static List<String> buscar(String texto, String palabra) {
        List<String> resultados = new ArrayList<>();
        if (texto == null || palabra == null || !PALABRA_VALIDA.matcher(palabra).matches()) {
            return resultados;
        }

        Pattern patron = Pattern.compile(
            "(?<![A-Za-z0-9_])" + palabra + "(?![A-Za-z0-9_])",
            Pattern.CASE_INSENSITIVE
        );
        Matcher matcher = patron.matcher(texto);

        while (matcher.find()) {
            resultados.add(matcher.group());
        }
        return resultados;
    }
}
